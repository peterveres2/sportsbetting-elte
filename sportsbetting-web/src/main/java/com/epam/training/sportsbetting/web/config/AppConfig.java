package com.epam.training.sportsbetting.web.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.epam.training.sportsbetting.domain.DelayAmount;
import com.epam.training.sportsbetting.service.DelayControlService;
import com.epam.training.sportsbetting.service.EventService;
import com.epam.training.sportsbetting.service.PlayerService;
import com.epam.training.sportsbetting.service.ResultEvaluator;
import com.epam.training.sportsbetting.service.TestDataMaker;
import com.epam.training.sportsbetting.web.transformers.BetModelTransformer;
import com.epam.training.sportsbetting.web.transformers.FullEventEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.OddEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.OutcomeEntityTranformer;
import com.epam.training.sportsbetting.web.transformers.OutcomeModelTransformer;
import com.epam.training.sportsbetting.web.transformers.PlayerEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.PlayerInfoModelTransformer;
import com.epam.training.sportsbetting.web.transformers.SportEventModelTransformer;
import com.epam.training.sportsbetting.web.transformers.UserEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.WagerEntityTransformer;
import com.epam.training.sportsbetting.web.transformers.WagerModelTransformer;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.epam.training.sportsbetting.repositories")
@EnableAspectJAutoProxy
public class AppConfig {
	
    @Bean
    public EventService eventService() {
        return new EventService();
    }
    
    @Bean
    public PlayerService playerService() {
        return new PlayerService();
    }

    @Bean
    public TestDataMaker dataGenerator() {
        return new TestDataMaker();
    }

    @Bean
    public ResultEvaluator resultEvaluator() {
        return new ResultEvaluator();
    }

    @Bean
    WagerModelTransformer wagerModelTransformer() {
        return new WagerModelTransformer();
    }

    @Bean
    SportEventModelTransformer sportEventModelTransformer() {
        return new SportEventModelTransformer();
    }

    @Bean
    BetModelTransformer betModelTransformer() {
        return new BetModelTransformer();
    }

    @Bean
    OutcomeModelTransformer outcomeModelTransformer() {
        return new OutcomeModelTransformer();
    }

    @Bean
    WagerEntityTransformer wagerEntityTransformer() {
        return new WagerEntityTransformer();
    }

    @Bean
    PlayerEntityTransformer playerEntityTransformer() {
        return new PlayerEntityTransformer();
    }

    @Bean
    UserEntityTransformer userEntityTransformer() {
        return new UserEntityTransformer();
    }

    @Bean
    OddEntityTransformer oddEntityTransformer() {
        return new OddEntityTransformer();
    }

    @Bean
    FullEventEntityTransformer fullEventEntityTransformer() {
        return new FullEventEntityTransformer();
    }

    @Bean
    OutcomeEntityTranformer outcomeEntityTranformer() {
        return new OutcomeEntityTranformer();
    }

    @Bean
    PlayerInfoModelTransformer playerInfoModelTransformer() {
        return new PlayerInfoModelTransformer();
    }
       
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter vendorAdapter) throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("com.epam.training.sportsbetting.domain");
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(vendorAdapter);        
        return em;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
        		.generateUniqueName(false)
        		.setName("sports_betting")
        		.setType(EmbeddedDatabaseType.H2)
        		.setScriptEncoding("UTF-8")
                .build();

    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    } 

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.hbm2ddl.import_files", "/import.sql");
        return properties;
    }
    
    @Bean
    @DependsOn(value={"entityManagerFactory"})
    public DatabaseCreator databasePopulator(DataSource dataSource){
    	DatabaseCreator databaseCreatorBean = new DatabaseCreator(dataSource);
    	databaseCreatorBean.createAndPopulateDatabase();
    	return new DatabaseCreator(dataSource);
    }
    
    
    @Bean
    @Scope(value="singleton")
    public DelayAmount delayAmount(){
    	DelayAmount delay = new DelayAmount();
    	delay.setDelay(0);
    	return delay;
    }
    
    @Bean
    public DelayControlService delayControlService(){
    	return new DelayControlService();
    }
    
    
}
    
