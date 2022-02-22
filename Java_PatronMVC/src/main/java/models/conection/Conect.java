package models.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conect {

	static String dataB = "CLIENTES";
	static String log = "remote";
	static String pass = "Taquito20.";
	static String url = "jdbc:mysql://192.168.1.168:3306?useTimezone=true&serverTimezone=UTC";
	
	private Connection conect = null;
	
	public Conect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conect = DriverManager.getConnection(url, log, pass);
			
			if(conect != null) {
				System.out.println("Completed");
			}
		}catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }
	}
	
	public void crearDataBase() {
		try {
			String query = "CREATE DATABASE " + dataB;
			Statement st = conect.createStatement();
			st.executeUpdate(query);
			System.out.println("Data exitosa");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en el cierre");
		}
	}
	
	public Connection getConnection(){
	      return conect;
	   }

	   public void desconectar(){
	      conect = null;
	   }

}
