package org.talentboost.spring.spring.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import org.talentboost.spring.spring.IRepository;
import org.talentboost.spring.spring.data.UserAccount;

//@Component
public class JdbcRepository implements IRepository {
	
	private Connection connection;
	
	
	// Task 0: Setup your database.
	//			- Create a local database.
	//			- Populate it using the provided script.
	//			- Put your specific values to the database.properties files.
	// Task 1: Take a short look at how currently data retrieval is done.
	// Task 2: Switch to using Spring's database support.
	//			- In the XML create a bean to serve as a data source.
	//			- (optional) Use the database.properties for your strings.
	//			- Add the data source as an argument to the constructor.
	//			- Use Spring's JdbcTemplate instead of Connection.
	//			- Re-factor the methods to work with this JdbcTemplate.
	
	public JdbcRepository() {
		
		try {
			Properties properties = new Properties();
			//FileInputStream fis = new FileInputStream("database.properties");
			ClassPathResource databasePropResource = new ClassPathResource("database.properties");
			properties.load(databasePropResource.getInputStream());
			String user = properties.getProperty("db.user");
			String pass = properties.getProperty("db.pass");
			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCapitalOf(String country) {
		String sql = "select capital from capitals where country like ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, country);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("capital");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> getCountries() {
		String sql = "select country from capitals";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<String> countries = new ArrayList<String>();
			while (rs.next()) {
				String country = rs.getString("country");
				countries.add(country);
			}
			return countries;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UserAccount> getAccounts() {
		String sql = "select name, role from users, roles where users.role_id=roles.id";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<UserAccount> accounts = new ArrayList<UserAccount>();
			while (rs.next()) {
				String username = rs.getString("name");
				String role = rs.getString("role");
				accounts.add(new UserAccount(username, role));
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
