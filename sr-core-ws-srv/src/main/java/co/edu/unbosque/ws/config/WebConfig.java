package co.edu.unbosque.ws.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import co.edu.unbosque.beans.CiudadanoBeans;
import co.edu.unbosque.beans.LoginBean;
import co.edu.unbosque.beans.ReportesAntecedentesBean;
import co.edu.unbosque.bsn.config.SDConfig;

@Configuration
@ComponentScan(
	basePackages = {"co.edu.unbosque.beans",
			"co.edu.unbosque.bundles.i18n",
			"co.edu.unbosque.bsn.ctrl",
			"co.edu.unbosque.reportes"
	
	}
)
@Import(SDConfig.class)
public class WebConfig   {
	
	
	
	@Bean(name = "CiudadanoBeans")
	public CiudadanoBeans adminBean() {
		CiudadanoBeans admin = new CiudadanoBeans();
		return admin;
	}
	
	
	@Bean(name = "ReportesAntecedentesBean")
	public ReportesAntecedentesBean reportesAntecedentesBean() {
		ReportesAntecedentesBean admin = new ReportesAntecedentesBean();
		return admin;
	}
	
	
	@Bean(name = "LoginBean")
	public LoginBean loginBeanBean() {
		LoginBean admin = new LoginBean();
		return admin;
	}
	
	
	

    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        sc.addListener(new ContextLoaderListener(context));
    }
	
	
	
	
}