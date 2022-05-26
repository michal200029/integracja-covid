package tm.integracja.Projekt.integracja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages={"tm.integracja.Projekt.integracja"})
//@EnableJpaRepositories(basePackages="tm.integracja.Projekt.integracja.repository")
//@EnableTransactionManagement
//@EntityScan(basePackages="tm.integracja.Projekt.integracja.entity")
public class ProjektIntegracjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektIntegracjaApplication.class, args);
	}


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//@Bean(name="entityManagerFactory")
	//public LocalSessionFactoryBean sessionFactory() {
	//	return new LocalSessionFactoryBean();
	//}

}
