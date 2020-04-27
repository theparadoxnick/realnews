package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
	
	static {
		try {
			System.out.println("Procurando o Driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado com sucesso!");
		} catch (ClassNotFoundException ex) {
			System.err.println("O driver n�o foi encontrado!");
		}
	}
	
	public static Connection conectar() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/portal_realnews"
					+ "?useTimezone=true&serverTimezone=UTC", 
					"root", "badwolf123=61a");
		} catch (SQLException ex) {
			System.err.println("N�o foi poss�vel conectar!");
			ex.printStackTrace();
			return null;
		}
		
	}

}
