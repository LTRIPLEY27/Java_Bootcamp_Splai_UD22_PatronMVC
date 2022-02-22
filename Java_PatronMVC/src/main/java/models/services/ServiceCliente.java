package models.services;

import javax.swing.JOptionPane;

import controllers.ControlerCliente;
import models.*;
import models.dao.ClienteRegister;
import models.dto.Cliente;
public class ServiceCliente {

	private ControlerCliente controlador;
	public static boolean consultaCli = false;
	public static boolean modificaCli = false;
	
	public void setControlerCliente(ControlerCliente controlador) {
		this.controlador = controlador;
	}
	
	public ControlerCliente getControladorCliente() {
		return controlador;
	}
	
	public void validateRegister(Cliente client) {
		ClienteRegister regCliente;
		regCliente = new ClienteRegister();
		regCliente.regCliente(client);
	}
	
	public void validateDelete(int codi) {
		ClienteRegister regCliente = new ClienteRegister();
		try {
			regCliente.eliminarCliente(codi);
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			
	}}
		
	
}
