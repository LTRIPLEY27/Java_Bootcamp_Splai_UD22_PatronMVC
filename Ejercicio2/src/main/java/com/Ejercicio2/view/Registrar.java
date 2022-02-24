package com.Ejercicio2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Ejercicio2.controller.ControllerClient;
import com.Ejercicio2.model.dto.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;

public class Registrar extends JFrame {

	private ControllerClient clienteController;
	private JPanel contentPane;
	private JTextField idTexto;
	private JTextField nombreTexto;
	private JTextField apellidoTexto;
	private JTextField direcciontexto;
	private JTextField dniTexto;
	private JTextField fechaTexto;

	
	public Registrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 83, 28, 14);
		contentPane.add(lblNewLabel);
		
		idTexto = new JTextField();
		idTexto.setBounds(87, 82, 76, 20);
		contentPane.add(idTexto);
		idTexto.setColumns(10);
		
		nombreTexto = new JTextField();
		nombreTexto.setColumns(10);
		nombreTexto.setBounds(127, 127, 109, 20);
		contentPane.add(nombreTexto);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(49, 128, 68, 14);
		contentPane.add(lblNombre);
		
		apellidoTexto = new JTextField();
		apellidoTexto.setColumns(10);
		apellidoTexto.setBounds(127, 177, 109, 20);
		contentPane.add(apellidoTexto);
		
		JLabel lblApellido = new JLabel("apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(49, 178, 68, 19);
		contentPane.add(lblApellido);
		
		direcciontexto = new JTextField();
		direcciontexto.setColumns(10);
		direcciontexto.setBounds(357, 82, 108, 20);
		contentPane.add(direcciontexto);
		
		JLabel lblDireccin = new JLabel("dirección");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(270, 84, 77, 13);
		contentPane.add(lblDireccin);
		
		dniTexto = new JTextField();
		dniTexto.setColumns(10);
		dniTexto.setBounds(357, 127, 108, 20);
		contentPane.add(dniTexto);
		
		JLabel lblDni = new JLabel("dni");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(270, 128, 28, 14);
		contentPane.add(lblDni);
		
		fechaTexto = new JTextField();
		fechaTexto.setColumns(10);
		fechaTexto.setBounds(356, 177, 109, 20);
		contentPane.add(fechaTexto);
		
		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(270, 178, 76, 19);
		contentPane.add(lblFecha);
		
		JButton crearButton = new JButton("Crear");
		crearButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crearButton.setBounds(210, 233, 180, 70);
		crearButton.addActionListener(crear);
		contentPane.add(crearButton);
		
		JButton btnNewButton_1 = new JButton("<---");
		btnNewButton_1.setBounds(12, 13, 76, 25);
		btnNewButton_1.addActionListener(crear);
		contentPane.add(btnNewButton_1);
	}

	
	ActionListener crear = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JButton aux = (JButton) e.getSource();
			if (aux.getText().equals("Crear"))
			{
				try {
					Cliente miCliente=new Cliente();
					miCliente.setId(Integer.parseInt(idTexto.getText()));
					miCliente.setNombre(nombreTexto.getText());
					miCliente.setApellido(apellidoTexto.getText());
					miCliente.setDireccion(direcciontexto.getText());
					miCliente.setDni(Integer.parseInt(dniTexto.getText()));
					miCliente.setFecha(fechaTexto.getText());
					
					clienteController.registrarCliente(miCliente);	
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				}
			}
			if (aux.getText().equals("<---"))
			{
				clienteController.mostrarMenuPrincipal();
				dispose();
			} 
			
		}
	};
	

	public void setClienteController(ControllerClient clienteController) {
		this.clienteController = clienteController;
	}
	
	
}
