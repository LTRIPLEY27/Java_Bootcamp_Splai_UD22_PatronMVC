package models.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import models.conection.Conect;
import models.dto.Cliente;

public class ClienteRegister {

	private Conect conn;
	
	//Cliente client;
	
	// MÉTODO REGISTRO CLIENTE
	
	public void regCliente(Cliente client) {
		conn = new Conect();
		
		try {
			String queryDB = "USE CLIENTES; ";
			Statement stDb = conn.getConnection().createStatement();
			stDb.executeUpdate(queryDB);
			
			Statement st = conn.getConnection().createStatement();
			String sql = "INSERT INTO CLIENTES (nombre, apellido, direccion, dni, fecha) VALUES ('" +  client.getName() + "', '" 
							+ client.getLastname() + "', '" + client.getAddress() + "', '" + client.getDni() + "', '" +
								client.getDate() + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Registrado");
			st.close();
			conn.desconectar();
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
			
			String queryTab = "CREATE TABLE CLIENTES (id int (11) NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (250), apellido nvarchar (250), direccion nvarchar (250), dni int(11) DEFAULT NULL, fecha date DEFAULT NULL );";
			
			Statement st = conn.getConnection().createStatement();
			st.executeUpdate(queryTab);
			System.out.println("Corrected");
		} catch (SQLException ex){
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");	
		}
	}
	
	//MÉTODO VER REGISTROS, RECIBE COMO PARÁMETRO EL ID
	public Cliente verRegistros(int codigo) {
		conn = new Conect();
		Cliente client = new Cliente();
		boolean isExist = false;
		
		try {
			String sql = "SELECT * FROM CLIENTES WHERE id = ? ";
			PreparedStatement request = conn.getConnection().prepareStatement(sql);
			request.setInt(1, codigo);
			ResultSet response = request.executeQuery();
			while(response.next()) {
				isExist = true;//RECIBE RESPUESTA, ERGO, EXISTE
				response.getString("id");
				client.setName(response.getString("nombre"));
				client.setLastname(response.getString("apellido"));
				client.setAddress(response.getString("direccion"));
				client.setDni(response.getString("dni"));
				client.setDate(response.getString("fecha"));
			}
			response.close();
			System.out.println(sql); //AL LLAMRLA FUERA DEL WHILE NOS LA DEVUELVE POR CÓNSOLA
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, en conexion");
			System.out.println(e);

		}
		//FUERA DEL TRY NOS RESOLVERA SI OBTIENE RESPUESTA
			if(isExist) {
				return client;
			}
			else {
				return null;
			}
	}
	
	public void eliminarCliente(int codigo){
		conn = new Conect();
		try {
			String sql= "DELETE FROM CLIENTES WHERE id= ? ";
			PreparedStatement consulta = conn.getConnection().prepareStatement(sql);
			consulta.setInt(1,codigo);
			int error=consulta.executeUpdate();
			if(error!=0) {
	            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
	            System.out.println(sql);
			}else JOptionPane.showMessageDialog(null, "El codigo no existe para ningun cliente."); 
			conn.desconectar();
			
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

	
}
