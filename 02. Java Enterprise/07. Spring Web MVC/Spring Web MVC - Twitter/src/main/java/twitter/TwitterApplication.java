package twitter;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import twitter.presentation.TwitterPresenter;

@SpringBootApplication
public class TwitterApplication implements CommandLineRunner, ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	public static void main(String []args) {

		SpringApplication.run(TwitterApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		
		applicationContext = arg0;
	}

	@Override
	public void run(String... arg0) throws Exception {

		applicationContext.getBean(TwitterPresenter.class).run();
	}
}