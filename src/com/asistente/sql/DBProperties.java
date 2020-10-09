package com.asistente.sql;

/**
 * Propiedades de la base de datos
 * @author victor
 *
 */
public class DBProperties {

	// Librería de MySQL
		public String driver;

		// Nombre de la base de datos
		public String database;

		// Host
		public String hostname;

		// Puerto
		public String port;


		// Ruta de nuestra base de datos (desactivamos el uso de SSL con
		// "?useSSL=false")
		//public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

		
		
		
		// Nombre de usuario
		public String username = "root";// root
		
		

		// Clave de usuario
		public String password = null;// "admin";//123456789
	
		
		
		public String getUrl() {
			return "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
		}

		public String getDriver() {
			return driver;
		}

		public void setDriver(String driver) {
			this.driver = driver;
		}

		public String getDatabase() {
			return database;
		}

		public void setDatabase(String database) {
			this.database = database;
		}

		public String getHostname() {
			return hostname;
		}

		public void setHostname(String hostname) {
			this.hostname = hostname;
		}

		public String getPort() {
			return port;
		}

		public void setPort(String port) {
			this.port = port;
		}

		

		

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
}
