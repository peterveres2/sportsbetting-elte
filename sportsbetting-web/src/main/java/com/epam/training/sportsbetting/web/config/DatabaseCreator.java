package com.epam.training.sportsbetting.web.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.epam.training.sportsbetting.service.TestDataMaker;


public class DatabaseCreator {

	private final DataSource dataSource;
	public DatabaseCreator(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createAndPopulateDatabase() {
		try (Connection conn = dataSource.getConnection()) {
			ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
			rdp.setContinueOnError(false);
			rdp.addScript(new ClassPathResource("sql/populate_db_player.sql"));
			rdp.populate(conn);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		
	}

}
