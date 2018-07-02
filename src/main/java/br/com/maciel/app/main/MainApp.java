package br.com.maciel.app.main;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

/**
 * The Class MainApp.
 */
public class MainApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		//
		staticFiles.location("/public");
		//
		port(Integer.parseInt(getEnviromentVariable("PORT", "4567")));
		//
		get("/api/", (req, res) -> "Rest API return String");
		//
		System.out.println("Server is online on:\r\nhttp://localhost:" + getEnviromentVariable("PORT", "4567"));
	}

	/**
	 * Gets the enviroment variable.
	 *
	 * @param key the key
	 * @param defaultValue the default value
	 * @return the enviroment variable
	 */
	private static String getEnviromentVariable(String key, String defaultValue) {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get(key) != null) {
			return processBuilder.environment().get(key);
		}
		return defaultValue;
	}
}