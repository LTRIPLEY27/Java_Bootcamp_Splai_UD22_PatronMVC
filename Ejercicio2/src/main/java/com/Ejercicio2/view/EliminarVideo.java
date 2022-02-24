package com.Ejercicio2.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import com.Ejercicio2.controller.ControllerVideo;


public class EliminarVideo extends JFrame {
	private ControllerVideo videoController;
	private JPanel contentPane;
	private JTextField idTexto;



	public EliminarVideo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(253, 84, 30, 23);
		contentPane.add(lblNewLabel);
		
		idTexto = new JTextField();
		idTexto.setBounds(289, 84, 111, 27);
		contentPane.add(idTexto);
		idTexto.setColumns(10);
		
		JButton eliminarButton = new JButton("Eliminar");
		eliminarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminarButton.setBounds(242, 146, 180, 70);
		eliminarButton.addActionListener(eliminar);
		contentPane.add(eliminarButton);
		
		JButton btnNewButton_1 = new JButton("<---");
		btnNewButton_1.setBounds(12, 13, 76, 25);
		btnNewButton_1.addActionListener(eliminar);
		contentPane.add(btnNewButton_1);
	}
	
		ActionListener eliminar= new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton aux = (JButton) e.getSource();
			if (aux.getText().equals("Eliminar"))
			{
				if (!idTexto.getText().equals(""))
				{
					int respuesta = JOptionPane.showConfirmDialog(null,
							"Esta seguro de eliminar el video?", "Confirmación",
							JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_NO_OPTION)
					{
						videoController.eliminarVideo(idTexto.getText());
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Ingrese un codigo de video", "Información",JOptionPane.WARNING_MESSAGE);
				}
			}
			if (aux.getText().equals("<---"))
			{
				videoController.mostrarMenuPrincipal();
				dispose();
			} 
			
		}
			
	};

		public void setVideoController(ControllerVideo videoController) {
			this.videoController = videoController;
		}
}
