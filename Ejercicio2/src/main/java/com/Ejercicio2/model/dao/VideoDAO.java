package com.Ejercicio2.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.Ejercicio2.model.conexion.Conexion;
import com.Ejercicio2.model.dto.Videos;

public class VideoDAO {
	
	public void registrarVideo(Videos vid) {
		Conexion conex= new Conexion();
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Videos VALUES ('" + vid.getId() + "', '"
					+ vid.getTitulo() + "', '" + vid.getDirector() + "', '"
					+ vid.getCliente_id() + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
	
	public Videos buscarVideo(int codigo) {
		
		Conexion conex = new Conexion();
		Videos video = new Videos();
		boolean existe = false;
		try {
			String sql= "SELECT * FROM Videos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				video.setId(Integer.parseInt(res.getString("id")));
				video.setTitle(res.getString("titulo"));
				video.setDirector(res.getString("director"));
				video.setCliente_id(Integer.parseInt(res.getString("clienteID")));
			 }
			
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				
				return video;
			}
			else return null;				
	}
	
	public void modificarVideo(Videos miVideo) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Videos SET id= ? ,title = ? , director = ?, cli_id = ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miVideo.getId());
            estatuto.setString(2, miVideo.getTitulo());
            estatuto.setString(3, miVideo.getDirector());
            estatuto.setInt(4, miVideo.getCliente_id());
            estatuto.setInt(5, miVideo.getId());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}
	
	public void eliminarVideo(int codigo) {
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Videos WHERE id= ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1,codigo);
			int error=consulta.executeUpdate();
			if(error!=0) {
	            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
	            System.out.println(sql);
			}else JOptionPane.showMessageDialog(null, "El codigo no existe para ningun video."); 
			conex.desconectar();
			
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}
}

