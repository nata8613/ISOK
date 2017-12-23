package datacentar.dc;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
    basePackages = {"datacentar.dc.isok.repo"})

public class IsokDbConfig {
	
	@Primary
	@Bean(name = "isokdataSource")
	@ConfigurationProperties(prefix = "isok.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	  @Bean(name = "entityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	      EntityManagerFactoryBuilder builder, @Qualifier("isokdataSource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.physical_naming_strategy", "datacentar.dc.PhysicalNamingStrategyImpl");
	    return builder.dataSource(dataSource).packages("datacentar.dc.isok.model").persistenceUnit("isok")
	    	.properties(properties)
	        .build();
	  }

	 @Primary
	  @Bean(name = "transactionManager")
	  public PlatformTransactionManager transactionManager(
	      @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
	    return new JpaTransactionManager(entityManagerFactory);
	  }
}
