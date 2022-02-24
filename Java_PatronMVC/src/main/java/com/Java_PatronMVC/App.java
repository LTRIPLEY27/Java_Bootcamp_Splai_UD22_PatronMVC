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
		
	}
}
