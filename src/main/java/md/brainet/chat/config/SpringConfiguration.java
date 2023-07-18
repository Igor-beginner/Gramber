package md.brainet.chat.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("md.brainet.chat")
public class SpringConfiguration implements WebMvcConfigurer{
	
	@Bean
	public SessionFactory sessionFactory() {
		return new org.hibernate.cfg.Configuration().configure("hibernate.cgf.xml").buildSessionFactory();
	}
}
