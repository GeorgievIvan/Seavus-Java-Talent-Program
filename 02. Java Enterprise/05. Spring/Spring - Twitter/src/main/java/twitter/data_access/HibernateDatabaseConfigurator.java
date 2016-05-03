package twitter.data_access;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter.business.Message;

@Configuration
public class HibernateDatabaseConfigurator {

	private final SessionFactory sessionFactory;
	
	public HibernateDatabaseConfigurator() {
		
		final org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Message.class).buildSessionFactory(serviceRegistry);
	}
	
	@Bean
    public SessionFactory getSessionFactory() {
    	
		return sessionFactory;
    }
}