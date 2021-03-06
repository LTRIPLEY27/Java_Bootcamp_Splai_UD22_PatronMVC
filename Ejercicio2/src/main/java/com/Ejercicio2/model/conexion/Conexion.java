package com.Ejercicio2.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conexion {
 
   static String bd = "SALA_VIDEOJUEGOS";
   static String login = "remote";
   static String password = "root123";
   static String ip="192.168.1.168";
   static String url = "jdbc:mysql://"+ip+":3306/"+bd+"?useTimezone=true&serverTimezone=UTC";

   Connection conn = null;


   public Conexion() {
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.print("Conexión a base de datos "+bd+"_SUCCESS at");
            fecha();
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }


   //MÉTODOS DE ACCESO
   
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
   
 //METODO QUE MUESTRA FECHA
 	public static void fecha() {
 		Date date = new Date();
 		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
 		System.out.println(" - " + hourdateFormat.format(date));
 		}

}

