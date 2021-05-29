package org.springframework.aot;

import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import java.util.function.Supplier;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.config.ConfigDataLocationResolver;
import org.springframework.boot.context.config._FactoryProvider;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.util.ProxyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Class generated - do not edit this file
 */
public abstract class StaticSpringFactories {
  public static MultiValueMap<Class, Supplier<Object>> factories = new LinkedMultiValueMap();

  public static MultiValueMap<Class, String> names = new LinkedMultiValueMap();

  static {
    System.setProperty("spring.xml.ignore", "true");
    factories.add(org.springframework.boot.diagnostics.FailureAnalysisReporter.class, () -> new org.springframework.boot.diagnostics.LoggingFailureAnalysisReporter());
    factories.add(FailureAnalyzer.class, () -> _FactoryProvider.configDataNotFoundFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.context.properties._FactoryProvider.incompatibleConfigurationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.context.properties._FactoryProvider.notConstructorBoundInjectionFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.beanCurrentlyInCreationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.beanDefinitionOverrideFailureAnalyzer());
    factories.add(org.springframework.boot.diagnostics.FailureAnalyzer.class, () -> new org.springframework.boot.diagnostics.analyzer.BeanNotOfRequiredTypeFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.bindFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.bindValidationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.unboundConfigurationPropertyFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.connectorStartFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.noSuchMethodFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.noUniqueBeanDefinitionFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.portInUseFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.invalidConfigurationPropertyNameFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.invalidConfigurationPropertyValueFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.diagnostics.analyzer._FactoryProvider.patternParseFailureAnalyzer());
    names.add(SpringBootExceptionReporter.class, "org.springframework.boot.diagnostics.FailureAnalyzers");
    names.add(SpringApplicationRunListener.class, "org.springframework.boot.context.event.EventPublishingRunListener");
    factories.add(ApplicationListener.class, () -> org.springframework.boot._FactoryProvider.clearCachesApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.builder.ParentContextCloserApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.FileEncodingApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.config.AnsiOutputApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.config.DelegatingApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.context.logging.LoggingApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.env.EnvironmentPostProcessorApplicationListener());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.boot.liquibase.LiquibaseServiceLocatorApplicationListener());
    factories.add(org.springframework.boot.logging.LoggingSystemFactory.class, () -> new org.springframework.boot.logging.logback.LogbackLoggingSystem.Factory());
    factories.add(org.springframework.boot.logging.LoggingSystemFactory.class, () -> new org.springframework.boot.logging.log4j2.Log4J2LoggingSystem.Factory());
    factories.add(org.springframework.boot.logging.LoggingSystemFactory.class, () -> new org.springframework.boot.logging.java.JavaLoggingSystem.Factory());
    names.add(ConfigDataLocationResolver.class, "org.springframework.boot.context.config.ConfigTreeConfigDataLocationResolver");
    names.add(ConfigDataLocationResolver.class, "org.springframework.boot.context.config.StandardConfigDataLocationResolver");
    factories.add(org.springframework.boot.env.PropertySourceLoader.class, () -> new org.springframework.boot.env.PropertiesPropertySourceLoader());
    factories.add(org.springframework.boot.env.PropertySourceLoader.class, () -> new org.springframework.boot.env.YamlPropertySourceLoader());
    factories.add(org.springframework.boot.context.config.ConfigDataLoader.class, () -> new org.springframework.boot.context.config.ConfigTreeConfigDataLoader());
    factories.add(org.springframework.boot.context.config.ConfigDataLoader.class, () -> new org.springframework.boot.context.config.StandardConfigDataLoader());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.context.ContextIdApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.context.config.DelegatingApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer());
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.cloud.CloudFoundryVcapEnvironmentPostProcessor());
    names.add(EnvironmentPostProcessor.class, "org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor");
    names.add(EnvironmentPostProcessor.class, "org.springframework.boot.env.RandomValuePropertySourceEnvironmentPostProcessor");
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.env.SpringApplicationJsonEnvironmentPostProcessor());
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.env.SystemEnvironmentPropertySourceEnvironmentPostProcessor());
    factories.add(org.springframework.boot.env.EnvironmentPostProcessor.class, () -> new org.springframework.boot.reactor.DebugAgentEnvironmentPostProcessor());
    factories.add(AutoConfigurationImportListener.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.conditionEvaluationReportAutoConfigurationImportListener());
    factories.add(AutoConfigurationImportFilter.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.onBeanCondition());
    factories.add(AutoConfigurationImportFilter.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.onClassCondition());
    factories.add(AutoConfigurationImportFilter.class, () -> org.springframework.boot.autoconfigure.condition._FactoryProvider.onWebApplicationCondition());
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.JndiDataSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration");
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.data.redis._FactoryProvider.redisUrlSyntaxFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.diagnostics.analyzer._FactoryProvider.noSuchBeanDefinitionFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.flyway._FactoryProvider.flywayMigrationScriptMissingFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.jdbc._FactoryProvider.dataSourceBeanCreationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.jdbc._FactoryProvider.hikariDriverConfigurationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.r2dbc._FactoryProvider.connectionFactoryBeanCreationFailureAnalyzer());
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.autoconfigure.session._FactoryProvider.nonUniqueSessionRepositoryFailureAnalyzer());
    factories.add(ApplicationContextInitializer.class, () -> org.springframework.boot.autoconfigure._FactoryProvider.sharedMetadataReaderFactoryContextInitializer());
    factories.add(org.springframework.context.ApplicationContextInitializer.class, () -> new org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener());
    factories.add(org.springframework.beans.BeanInfoFactory.class, () -> new org.springframework.beans.ExtendedBeanInfoFactory());
    names.add(RepositoryFactorySupport.class, "org.springframework.data.jpa.repository.support.JpaRepositoryFactory");
    factories.add(ProxyUtils.ProxyDetector.class, () -> org.springframework.data.jpa.util._FactoryProvider.hibernateProxyDetector());
    factories.add(org.springframework.data.web.config.SpringDataJacksonModules.class, () -> new org.springframework.data.web.config.SpringDataJacksonConfiguration());
    factories.add(org.springframework.boot.diagnostics.FailureAnalyzer.class, () -> new org.springframework.nativex.GeneratedClassNotFoundExceptionFailureAnalyzer());
    factories.add(org.springframework.context.ApplicationListener.class, () -> new org.springframework.nativex.NativeListener());
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.audit.AuditAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.audit.AuditEventsEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.availability.AvailabilityProbesAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.beans.BeansEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.cache.CachesEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.cloudfoundry.servlet.CloudFoundryActuatorAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.context.properties.ConfigurationPropertiesReportEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.context.ShutdownEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.env.EnvironmentEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.info.InfoContributorAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.logging.LogFileWebEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.logging.LoggersEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.management.HeapDumpWebEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.management.ThreadDumpEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.JvmMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.LogbackMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.MetricsEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.cache.CacheMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.export.prometheus.PrometheusMetricsExportAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.integration.IntegrationMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.jdbc.DataSourcePoolMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.orm.jpa.HibernateMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.web.client.HttpClientMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.web.servlet.WebMvcMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.scheduling.ScheduledTasksEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.startup.StartupEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.trace.http.HttpTraceAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.trace.http.HttpTraceEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.web.mappings.MappingsEndpointAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration");
    names.add(EnableAutoConfiguration.class, "org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration");
    factories.add(FailureAnalyzer.class, () -> org.springframework.boot.actuate.autoconfigure.metrics._FactoryProvider.validationFailureAnalyzer());
    factories.add(org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration.class, () -> new org.springframework.boot.actuate.autoconfigure.endpoint.web.ServletEndpointManagementContextConfiguration());
    factories.add(org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration.class, () -> new org.springframework.boot.actuate.autoconfigure.endpoint.web.servlet.WebMvcEndpointManagementContextConfiguration());
    factories.add(ManagementContextConfiguration.class, () -> org.springframework.boot.actuate.autoconfigure.web.servlet._FactoryProvider.servletManagementChildContextConfiguration());
    factories.add(ManagementContextConfiguration.class, () -> org.springframework.boot.actuate.autoconfigure.web.servlet._FactoryProvider.webMvcEndpointChildContextConfiguration());
  }
}