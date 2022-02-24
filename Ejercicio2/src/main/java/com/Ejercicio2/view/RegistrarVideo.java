package com.Ejercicio2.view;

import com.Ejercicio2.controller.ControllerVideo;
import com.Ejercicio2.model.dto.Videos;

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


public class RegistrarVideo extends JFrame {

	private ControllerVideo videoController;

	private JPanel contentPane;
	private JTextField idTexto;
	private JTextField directorTexto;
	private JTextField titleTexto;
	private JTextField cliidTexto;
	/**
	 * Create the frame.
	 */
	public RegistrarVideo() {
		
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
		
		directorTexto = new JTextField();
		directorTexto.setColumns(10);
		directorTexto.setBounds(337, 82, 108, 20);
		contentPane.add(directorTexto);
		
		JLabel lblDireccin = new JLabel("Director");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(270, 84, 77, 13);
		contentPane.add(lblDireccin);
		
		titleTexto = new JTextField();
		titleTexto.setColumns(10);
		titleTexto.setBounds(87, 127, 109, 20);
		contentPane.add(titleTexto);
		
		JLabel lblFecha = new JLabel("Título");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(49, 126, 76, 19);
		contentPane.add(lblFecha);
		
		JButton crearButton = new JButton("Registar");
		crearButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crearButton.setBounds(210, 233, 180, 70);
		crearButton.addActionListener(crear);
		contentPane.add(crearButton);
		
		JButton btnNewButton_1 = new JButton("<---");
		btnNewButton_1.setBounds(12, 13, 76, 25);
		btnNewButton_1.addActionListener(crear);
		contentPane.add(btnNewButton_1);
		
		JLabel lblCliid = new JLabel("cli-id");
		lblCliid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliid.setBounds(270, 129, 77, 13);
		contentPane.add(lblCliid);
		
		cliidTexto = new JTextField();
		cliidTexto.setColumns(10);
		cliidTexto.setBounds(337, 127, 108, 20);
		contentPane.add(cliidTexto);
	}
	
ActionListener crear = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton aux = (JButton) e.getSource();
			if (aux.getText().equals("Crear"))
			{
				try {
					Videos miVideo = new Videos();
					miVideo.setId(Integer.parseInt(idTexto.getText()));
					miVideo.setTitle(titleTexto.getText());
					miVideo.setDirector(directorTexto.getText());
					miVideo.setCliente_id(Integer.parseInt(cliidTexto.getText()));

					
					videoController.registrarVideo(miVideo);	
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
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
