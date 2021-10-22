/*
 * BatchInfrastructureConfig
 *  
 * GSI - Integración
 * Creado el: 20/11/2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.bsn.config;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.DatabaseType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Configuración spring batch con persistencia en base de datos.
 * 
 * @author Mauricio Tascon
 * @version 1.0 28/09/2017
 * @since 1.0
 */
@Configuration
public class BatchInfrastructureConfig implements BatchConfigurer {
    
	@Resource
	public PlatformTransactionManager transactionManager;
	
	@Resource
	private DataSource dataSource;
	
	/**
	 * 
	 */
	@Override
	public JobExplorer getJobExplorer() throws Exception{
		JobExplorerFactoryBean factory = new JobExplorerFactoryBean();
		//usa el datasource creado específicamente para spring batch PSEConfig.java
		factory.setDataSource(dataSource);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	/**
	 * 
	 */
	@Override
	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	/**
	 * 
	 */
	@Override
	public JobRepository getJobRepository() throws Exception  {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource);
		//factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
		factory.setIsolationLevelForCreate("ISOLATION_DEFAULT");
		factory.setTransactionManager(getTransactionManager());
		factory.setDatabaseType(DatabaseType.ORACLE.toString());
		factory.setTablePrefix("BATCH_");
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	/**
	 * 
	 */
	@Override
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
        
}
