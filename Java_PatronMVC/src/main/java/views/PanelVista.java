package views;

import controllers.ControlerCliente;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControlerCliente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVista extends JFrame {

	private JPanel contentPane;
	private ControlerCliente cliente; // DECLARAMOS LA INSTANCIA DE TIPO CONTROLELER PARA HACER USO DE SUS MÉTODOS
	
	public PanelVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(192, 27, 136, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(26, 109, 89, 23);
		btnNewButton.addActionListener(principal);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar");
		btnNewButton_1.setBounds(125, 109, 89, 23);
		btnNewButton_1.addActionListener(principal);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setBounds(224, 109, 89, 23);
		btnNewButton_2.addActionListener(principal);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Datos");
		btnNewButton_3.setBounds(323, 109, 89, 23);
		btnNewButton_3.addActionListener(principal);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.setBounds(173, 166, 89, 23);
		btnNewButton_4.addActionListener(principal);
		contentPane.add(btnNewButton_4);
	}
	
	ActionListener principal = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			JButton opcion = (JButton) e.getSource(); // CASTEAMOS Y OBTENEMOS LA RESPUESTA DEL BUTTON
			
			switch(opcion.getText()) {//SWITCH DE LA OPCION ELEGIDA
			 	case "Registrar":
			 		dispose();//el método dispara los recursos de la ventana seleccionada
			 		cliente.showRegistrar();
			 		break;
			 	case "Actualizar":
			 		dispose();
			 		cliente.showActualiza();
			 		break;
			 	case "Eliminar":
			 		dispose();
			 		cliente.showEliminar();
			 		break;
			 	case "Datos":
			 		dispose();
			 		cliente.showRegistro();
			 		break;
			 	case "Salir":
			 		setVisible(false);
			 		break;
			 	default:
			 		JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR UNA OPCIÓN VÁLIDA");
			 		break;
			}
		}
	};
	
	public void setControlerCliente(ControlerCliente cliente) {
		this.cliente = cliente;
	}
}
