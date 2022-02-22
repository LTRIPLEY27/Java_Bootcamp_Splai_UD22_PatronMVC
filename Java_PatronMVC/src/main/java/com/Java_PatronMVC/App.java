package com.Java_PatronMVC;

import java.awt.EventQueue;

import models.conection.Conect;
import models.dao.ClienteRegister;
import models.dto.Cliente;
import views.PanelVista;

public class App 
{


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelVista frame = new PanelVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*Cliente client = new Cliente();
		client.setName("Ada");
		client.setLastname("Lovelace");
		client.setAddress("reus 123");
		client.setDni("123D");
		client.setDate("1789-04-12");
		Conect con = new Conect();
		//con.crearDataBase();
		ClienteRegister neo = new ClienteRegister();
		
		//neo.createTable();
		neo.regCliente(client);*/
	}
}
