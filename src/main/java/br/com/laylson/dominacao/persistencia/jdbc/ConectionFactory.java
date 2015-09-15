package br.com.laylson.dominacao.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

	public static Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/dominacao", "postgres", "postgres");
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}

}
