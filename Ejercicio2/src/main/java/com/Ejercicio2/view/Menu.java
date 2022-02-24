package com.Ejercicio2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Ejercicio2.controller.ControllerClient;
import com.Ejercicio2.controller.ControllerVideo;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Menu extends JFrame {
	
	private ControllerVideo videoController;
	private ControllerClient clienteController;
	private JPanel contentPane;

	
	public Menu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton menuCrear = new JButton("Crear cliente");
		menuCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuCrear.setBounds(51, 143, 166, 70);
		menuCrear.addActionListener(nuevaVentana);
		contentPane.add(menuCrear);
		
		JButton menuEliminar = new JButton("Eliminar cliente");
		menuEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuEliminar.setBounds(51, 338, 191, 70);
		menuEliminar.addActionListener(nuevaVentana);
		contentPane.add(menuEliminar);
		
		JLabel lblNewLabel = new JLabel("Selecciona una opción");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(239, 70, 229, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblGestinDeBd = new JLabel("GESTIÓN DE BD");
		lblGestinDeBd.setFont(new Font("Rockwell Condensed", Font.PLAIN, 22));
		lblGestinDeBd.setBounds(268, 11, 229, 25);
		contentPane.add(lblGestinDeBd);
		
		JButton menuBuscarActualizar = new JButton("Buscar y Actualizar cliente");
		menuBuscarActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuBuscarActualizar.setBounds(50, 236, 279, 70);
		menuBuscarActualizar.addActionListener(nuevaVentana);
		contentPane.add(menuBuscarActualizar);
		
		JButton menuCrearVideo = new JButton("Crear video");
		menuCrearVideo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuCrearVideo.setBounds(418, 143, 166, 70);
		menuCrearVideo.addActionListener(nuevaVentana);
		contentPane.add(menuCrearVideo);
		
		JButton menuBuscarActualizarVideo = new JButton("Buscar y Actualizar video");
		menuBuscarActualizarVideo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuBuscarActualizarVideo.setBounds(418, 236, 262, 70);
		menuBuscarActualizarVideo.addActionListener(nuevaVentana);
		contentPane.add(menuBuscarActualizarVideo);
		
		JButton menuEliminarVideo = new JButton("Eliminar video");
		menuEliminarVideo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		menuEliminarVideo.setBounds(418, 338, 214, 70);
		menuEliminarVideo.addActionListener(nuevaVentana);
		contentPane.add(menuEliminarVideo);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientes.setBounds(104, 107, 91, 25);	
		contentPane.add(lblClientes);
		
		JLabel lblVideos = new JLabel("Videos");
		lblVideos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVideos.setBounds(462, 106, 91, 25);
		contentPane.add(lblVideos);
	}

	ActionListener nuevaVentana = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			JButton aux = (JButton) e.getSource();
			
			switch(aux.getText()) {
				case "Crear cliente":
					dispose();
					clienteController.mostrarVentanaCreacion();
					break;				
				case "Eliminar cliente":
					dispose();
					clienteController.mostrarVentanaEliminar();
					break;				
				case "Buscar y Actualizar cliente":
					dispose();
					clienteController.mostrarVentanaBusActu();
					break;
				case "Crear video":
					dispose();
					videoController.mostrarVentanaCreacion();
					break;
				case "Eliminar video":
					dispose();
					videoController.mostrarVentanaEliminar();
					break;
				case "Buscar y Actualizar video":
					dispose();
					videoController.mostrarVentanaBusActu();
					break;
			}
		}
	};
	
	public void setClienteController(ControllerClient clienteController) {
		this.clienteController = clienteController;
	}


	public void setVideoController(ControllerVideo videoController) {
		this.videoController = videoController;
	}
	
}

