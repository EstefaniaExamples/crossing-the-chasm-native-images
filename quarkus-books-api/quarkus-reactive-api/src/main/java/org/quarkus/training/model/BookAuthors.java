package org.quarkus.training.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonArray;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RegisterForReflection
public class BookAuthors {
    private static final Logger LOG = LoggerFactory.getLogger(BookAuthors.class);

    @JsonProperty
    private Long id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String description;
    @JsonProperty
    private List<Author> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public BookAuthors(final Long id, final String title, final String description, final List<Author> authors) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authors = authors;
    }





    // The from method converts a Row instance to a Fruit instance.
    // It is extracted as a convenience for the implementation of the other data management methods:
    private static BookAuthors from(final Row row) {
        final ObjectMapper objectMapper = new ObjectMapper();
        final List<Author> authors = new ArrayList<>();
        final JsonArray array = (JsonArray) row.getValue("authors");
        array.forEach(item -> {
                    try {
                        authors.add(objectMapper.readValue(item.toString(), Author.class));
                    } catch (JsonProcessingException e) {
                        authors.add(new Author());
                    }
                }
        );

        return new BookAuthors(row.getLong("id"),
                row.getString("title"),
                row.getString("description"),
                authors);
    }

    public static Multi<BookAuthors> findAll(final PgPool client) {
        final String query = "SELECT b.id, b.title, b.description, " +
                "( SELECT json_agg(json_build_object('id', a.id, 'name', a.name, 'surname', a.surname)) " +
                "  FROM authors a JOIN books_authors ba ON a.id=ba.author_id " +
                "  WHERE b.id=ba.book_id ) as authors" +
                "  FROM books b;";
        LOG.info("Query to find all books: {}", query);
        return client.query(query)
                .execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(BookAuthors::from);
    }

    public static Uni<BookAuthors> findById(final PgPool client, final Long id) {
        final String query = "SELECT b.id, b.title, b.description, " +
                "( SELECT json_agg(json_build_object('id', a.id, 'name', a.name, 'surname', a.surname)) " +
                "  FROM authors a JOIN books_authors ba ON a.id=ba.author_id " +
                "  WHERE b.id=ba.book_id ) as authors" +
                "  FROM books b " +
                "  WHERE b.id=$1";
        LOG.info("Query to find all books: {}", query);
        return client.preparedQuery(query)
                .execute(Tuple.of(id))
                .onItem().transform(RowSet::iterator)
                .onItem().transform(iterator -> iterator.hasNext() ? from(iterator.next()) : null);
    }
}
