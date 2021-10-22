package co.edu.unbosque.batch.notification.email;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import co.edu.unbosque.persistence.model.Usuario;


/**
 * Permite ejecutar la tarea de enviar un correo electronico al Funcionario
 * con sus datos de su usuario y password 
 * 
 * @author Mauricio Tascon
 *
 */
@Service
public class NotificationEmailBatch {

	private static Logger LOGGER = LoggerFactory.getLogger(NotificationEmailBatch.class);

	@Resource
	private JobLauncher jobLauncher;

	@Resource
	private JobBuilderFactory jobBuilderFactory;

	@Resource
	private StepBuilderFactory stepBuilderFactory;

	@Resource
	private NotificationEmailItemReader itemReader;

	@Resource
	private NotificationEmailItemProcessor itemProcessor;

	@Resource
	private NotificationEmailItemWriter itemWriter;

	public static final String JOB_NAME = "NOTIFICATION_TRANSACTION_STATE";

	private static final String JOB_STEP = JOB_NAME.concat("_STEP");

	private Job jobNotificationTransactions;

	
	@PostConstruct
	public void init() {
		this.jobNotificationTransactions = createJob();
	}
	
	@Scheduled(fixedRateString = "${sd.batch.scheduled.sendEmail.fixedRate}")
	public void automaticRun() {
		this.jobNotificationTransactions = createJob();
		execute();
	}

	private void execute() {
		
			JobParametersBuilder jobParams = new JobParametersBuilder();
			jobParams.addLong("time", System.currentTimeMillis());
			try {
				JobExecution jobExecution = jobLauncher.run(jobNotificationTransactions, jobParams.toJobParameters());
				LOGGER.info("Se lanza: {}", jobExecution.getJobInstance());
			} catch (Exception e) {
				LOGGER.error("Error ejecutando @" + JOB_NAME + ":\n{}", e.toString());
			}
		
	}

	private Job createJob() {
		Step confirmationStep = getConfirmationStep();
		return jobBuilderFactory.get(JOB_NAME)//
				.flow(confirmationStep).end()//
				.build();
	}

	private Step getConfirmationStep() {
		return stepBuilderFactory.get(JOB_STEP)
				.<Usuario, Usuario> chunk(10)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}

}
