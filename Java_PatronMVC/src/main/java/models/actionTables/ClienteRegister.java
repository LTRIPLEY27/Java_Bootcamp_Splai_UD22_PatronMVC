package models.actionTables;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import models.clases.Cliente;
import models.conection.Conect;

public class ClienteRegister {

	private Conect conn;
	
	Cliente client;
	
	// MÉTODO REGISTRO CLIENTE
	
	public void regCliente() {
		conn = new Conect();
		
		try {
			Statement st = conn.getConnection().createStatement();
			String sql = "INSERT INTO CLIENTES (nombre, apellido, direccion, dni, fecha) VALUES ('" +  client.getName() + "', '" + client.getLastname() + "', '" + client.getAddress() + "', '" + client.getDni() + "', '" + client.getDate() + "') ;";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Registrado");
		}catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
	
	// tabla creada
	public void createTable() {
		// TABLA SIN FOREIGN KEY 
		try {
			String queryDB = "USE CLIENTES; ";
			Statement stDb = conn.getConnection().createStatement();
			stDb.executeUpdate(queryDB);
			
			String queryTab = "CREATE TABLE CLIENTES (id int (11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (250), apellido nvarchar (250), direccion nvarchar (250), dni varchar(11) DEFAULT NULL, fecha date DEFAULT NULL );";
			Statement st = conn.getConnection().createStatement();
			st.executeUpdate(queryTab);
			System.out.println("Corrected");
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");	
		}
	}
}
