package com.Ejercicio2.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Ejercicio2.controller.ControllerClient;
import com.Ejercicio2.model.dto.Cliente;

public class Actualizar extends JFrame {

	private ControllerClient clienteController;
	private JPanel contentPane;
	private JTextField idTexto;
	private JTextField nombreTexto;
	private JTextField apellidoTexto;
	private JTextField direcciontexto;
	private JTextField dniTexto;
	private JTextField fechaTexto;
	private JButton actualizarButton;
	

	public Actualizar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(216, 29, 28, 14);
		contentPane.add(lblNewLabel);
		
		idTexto = new JTextField();
		idTexto.setBounds(254, 28, 76, 20);
		contentPane.add(idTexto);
		idTexto.setColumns(10);
		
		nombreTexto = new JTextField();
		nombreTexto.setColumns(10);
		nombreTexto.setBounds(135, 104, 109, 20);
		nombreTexto.setEnabled(false);
		contentPane.add(nombreTexto);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(57, 105, 68, 14);
		contentPane.add(lblNombre);
		
		apellidoTexto = new JTextField();
		apellidoTexto.setColumns(10);
		apellidoTexto.setBounds(135, 154, 109, 20);
		apellidoTexto.setEnabled(false);
		contentPane.add(apellidoTexto);
		
		JLabel lblApellido = new JLabel("apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(57, 155, 68, 19);
		contentPane.add(lblApellido);
		
		direcciontexto = new JTextField();
		direcciontexto.setColumns(10);
		direcciontexto.setBounds(357, 82, 108, 20);
		direcciontexto.setEnabled(false);
		contentPane.add(direcciontexto);
		
		JLabel lblDireccin = new JLabel("dirección");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(270, 84, 77, 13);
		contentPane.add(lblDireccin);
		
		dniTexto = new JTextField();
		dniTexto.setColumns(10);
		dniTexto.setBounds(357, 127, 108, 20);
		dniTexto.setEnabled(false);
		contentPane.add(dniTexto);
		
		JLabel lblDni = new JLabel("dni");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(270, 128, 28, 14);
		contentPane.add(lblDni);
		
		fechaTexto = new JTextField();
		fechaTexto.setColumns(10);
		fechaTexto.setBounds(356, 177, 109, 20);
		fechaTexto.setEnabled(false);
		contentPane.add(fechaTexto);
		
		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(270, 178, 76, 19);
		contentPane.add(lblFecha);
		
		actualizarButton = new JButton("Actualizar");
		actualizarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		actualizarButton.setBounds(232, 234, 180, 70);
		actualizarButton.addActionListener(buscarReemplazar);
		actualizarButton.setEnabled(false);
		contentPane.add(actualizarButton);
		
		JButton buscarButton = new JButton("Buscar por Id");
		buscarButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buscarButton.setBounds(353, 29, 146, 20);
		buscarButton.addActionListener(buscarReemplazar);
		contentPane.add(buscarButton);
		
		JButton btnNewButton_1 = new JButton("<---");
		btnNewButton_1.setBounds(12, 13, 76, 25);
		btnNewButton_1.addActionListener(buscarReemplazar);
		contentPane.add(btnNewButton_1);
	}
	
	ActionListener buscarReemplazar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton aux = (JButton) e.getSource();
			switch (aux.getText()) {
			case "<---":
				clienteController.mostrarMenuPrincipal();
				dispose();
				break;
			case "Buscar por Id":
				buscarCliente();
				break;
				
			case "Actualizar":
				modificarCliente();
				break;
			}
			
		}
	};

	public void setClienteController(ControllerClient clienteController) {
		this.clienteController = clienteController;
	}
	
	
	private void buscarCliente() {
		Cliente miCliente = new Cliente();
			if(idTexto.getText().length()>0) {
				miCliente = clienteController.buscarCliente(idTexto.getText());
				if(miCliente != null) {
					idTexto.setEnabled(false);
					nombreTexto.setEnabled(true);
					nombreTexto.setText(miCliente.getNombre());
					apellidoTexto.setEnabled(true);
					apellidoTexto.setText(miCliente.getApellido());
					direcciontexto.setEnabled(true);
					direcciontexto.setText(miCliente.getDireccion());
					dniTexto.setEnabled(true);
					dniTexto.setText(String.valueOf(miCliente.getDni()));
					fechaTexto.setEnabled(true);
					fechaTexto.setText(miCliente.getFecha());
					actualizarButton.setEnabled(true);
				}else JOptionPane.showMessageDialog(this.contentPane, "Usuario no encontrado.");
			}
	}
	
	private void modificarCliente() {
		Cliente miCliente = new Cliente();
	
		miCliente.setId(Integer.valueOf(idTexto.getText()));
		miCliente.setNombre(nombreTexto.getText());
		miCliente.setApellido(apellidoTexto.getText());
		miCliente.setDireccion(direcciontexto.getText());
		miCliente.setDni(Integer.valueOf(dniTexto.getText()));
		miCliente.setFecha(fechaTexto.getText());

		clienteController.modificarCliente(miCliente);
		if(clienteController.getClienteServ().modificaCliente) {
			nombreTexto.setEnabled(false);
			nombreTexto.setText("");
			apellidoTexto.setEnabled(false);
			apellidoTexto.setText("");
			direcciontexto.setEnabled(false);
			direcciontexto.setText("");
			dniTexto.setEnabled(false);
			dniTexto.setText("");
			fechaTexto.setEnabled(false);
			fechaTexto.setText("");
			idTexto.setEnabled(true);
			actualizarButton.setEnabled(false);

		}
		
	}

}

