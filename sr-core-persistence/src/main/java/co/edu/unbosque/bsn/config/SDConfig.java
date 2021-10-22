package co.edu.unbosque.bsn.config;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.edu.unbosque.bundles.i18n.PropertiesResourceBundleManager;
import co.edu.unbosque.bundles.i18n.ResourceBundleManager;

/**
 * Configuración de IoC de la aplicación<br/>
 * Esta clase reemplaza los contextos de Spring en archios XML.
 *
 * @author Mauricio Tascon
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource(value = "file:F:/sr-core-config/sr-config.properties")
@EnableBatchProcessing
@Import(BatchInfrastructureConfig.class)
@EnableScheduling
@ComponentScan(
        basePackages = {
        	"co.edu.unbosque.batch.notification.email",	
        	"co.edu.unbosque.bundles.i18n",
    		"co.edu.unbosque.bsn.ctrl", 
    		"co.edu.unbosque.bsn.ctrl.impl",  
        	"co.edu.unbosque.bsn.services.impl",
        	"co.edu.unbosque.mail",
        	"co.edu.unbosque.mail.alert",
        	"co.edu.unbosque.mail.impl",
        	"co.edu.unbosque.util",
        	"co.edu.unbosque.ws.client.funcionarios.impl",    
        	"co.edu.unbosque.persistence.dao.impl",
            "co.edu.unbosque.persistence.model"       
        })

public class SDConfig {

	static Logger LOGGER = LoggerFactory.getLogger(SDConfig.class);

		
	@Bean
	public ResourceBundleManager resourceBundleManager() {
		return new PropertiesResourceBundleManager();
	}

	/**
	 * Se usa solo para el uso de spring batch
	 *
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		// Se obtiene el datasource mediante el Jndi.
		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setJndiName("jdbc/sdrDS");// la configurada en WebLogic
		try {
			LOGGER.info("Conexion a la BD ");
			factory.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
//			LOGGER.error("Error creando el Datasource de base de datos para spring batch: ",
//					e.getMessage());
		} catch (NamingException e) {
//			LOGGER.error("Error creando el Datasource de base de datos para spring batch:",
//					e.getMessage());
		}
		return (DataSource) factory.getObject();
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPersistenceUnitName("sdrPersistentUnit");
		factory.setPersistenceXmlLocation("classpath:META-INF/sdr-persistence.xml");
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}