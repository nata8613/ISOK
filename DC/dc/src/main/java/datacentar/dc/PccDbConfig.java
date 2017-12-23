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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "pccEntityManagerFactory",
    transactionManagerRef = "pccTransactionManager", basePackages = {"datacentar.dc.pcc.repo"})

public class PccDbConfig {


	@Bean(name = "pccDataSource")
	@ConfigurationProperties(prefix = "pcc.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "pccEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
	      //EntityManagerFactoryBuilder builder, @Qualifier("pccDataSource") DataSource dataSource) {
			  EntityManagerFactoryBuilder builder){  
		  Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("hibernate.physical_naming_strategy", "datacentar.dc.PhysicalNamingStrategyImpl");
			properties.put("jpa.hibernate.ddl-auto", "create");
			properties.put("hibernate.id.new_generator_mappings", false);
	    return builder.dataSource(dataSource()).packages("datacentar.dc.pcc.model").persistenceUnit("pcc")
	    	.properties(properties)
	        .build();
	  }

	@Bean(name = "pccTransactionManager")
	public PlatformTransactionManager barTransactionManager(
			@Qualifier("pccEntityManagerFactory") EntityManagerFactory barEntityManagerFactory)
			{
	    return new JpaTransactionManager(barEntityManagerFactory);
	  }

}
