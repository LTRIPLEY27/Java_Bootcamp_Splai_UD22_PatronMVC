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

import com.Ejercicio2.controller.ControllerVideo;
import com.Ejercicio2.model.dto.Videos;

public class ActualizarVideo extends JFrame{

	private ControllerVideo videoController;
	private JPanel contentPane;
	private JTextField idTexto;
	private JTextField titleTexto;
	private JTextField directorTexto;
	private JTextField cliidTexto;
	private JButton actualizarButton;

	public ActualizarVideo() {
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
		
		titleTexto = new JTextField();
		titleTexto.setColumns(10);
		titleTexto.setBounds(103, 104, 109, 20);
		titleTexto.setEnabled(false);
		contentPane.add(titleTexto);
		
		JLabel lblNombre = new JLabel("title");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(57, 105, 68, 14);
		contentPane.add(lblNombre);
		
		directorTexto = new JTextField();
		directorTexto.setColumns(10);
		directorTexto.setBounds(113, 156, 109, 20);
		directorTexto.setEnabled(false);
		contentPane.add(directorTexto);
		
		JLabel lblApellido = new JLabel("director");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(57, 155, 68, 19);
		contentPane.add(lblApellido);
		
		cliidTexto = new JTextField();
		cliidTexto.setColumns(10);
		cliidTexto.setBounds(306, 104, 109, 20);
		cliidTexto.setEnabled(false);
		contentPane.add(cliidTexto);
		
		JLabel lblFecha = new JLabel("cli-id");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(254, 103, 76, 19);
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
				videoController.mostrarMenuPrincipal();
				dispose();
				break;
			case "Buscar por Id":
				buscarVideo();
				break;
			case "Actualizar":
				modificarVideo();
				break;
			}
			
		}
	};
	
	private void buscarVideo() {
		Videos miVideo = new Videos();
			if(idTexto.getText().length()>0) {
				miVideo = videoController.buscarVideo(idTexto.getText());
				if(miVideo != null) {
					idTexto.setEnabled(false);
					titleTexto.setEnabled(true);
					titleTexto.setText(miVideo.getTitulo());
					directorTexto.setEnabled(true);
					directorTexto.setText(miVideo.getDirector());
					cliidTexto.setEnabled(true);
					cliidTexto.setText(Integer.toString(miVideo.getCliente_id()));
					actualizarButton.setEnabled(true);

				}else JOptionPane.showMessageDialog(this.contentPane, "Usuario no encontrado.");
			}
	}
	
	private void modificarVideo() {
		Videos miVideo = new Videos();

		miVideo.setId(Integer.valueOf(idTexto.getText()));
		miVideo.setTitle(titleTexto.getText());
		miVideo.setDirector(directorTexto.getText());
		miVideo.setCliente_id(Integer.parseInt(cliidTexto.getText()));

		videoController.modificarVideo(miVideo);
		if(videoController.getVideoServ().modificaVideo) {
			titleTexto.setEnabled(false);
			titleTexto.setText("");
			directorTexto.setEnabled(false);
			directorTexto.setText("");
			cliidTexto.setEnabled(false);
			cliidTexto.setText("");
			idTexto.setEnabled(true);
			actualizarButton.setEnabled(false);
		}

	}


	public void setVideoController(ControllerVideo videoController) {
		this.videoController = videoController;
	}
	

}
