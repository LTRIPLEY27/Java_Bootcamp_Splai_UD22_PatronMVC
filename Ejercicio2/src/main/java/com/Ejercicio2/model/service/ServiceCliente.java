package com.Ejercicio2.model.service;

import javax.swing.JOptionPane;

import com.Ejercicio2.controller.ControllerClient;
import com.Ejercicio2.model.dao.ClienteDAO;
import com.Ejercicio2.model.dto.Cliente;

public class ServiceCliente {
	
	private ControllerClient clienteController;
	public static boolean consultaCliente = false;
	public static boolean modificaCliente = false;

	public void setControllerClient(ControllerClient clienteController) {
		this.clienteController = clienteController;
	}

	public ControllerClient getClienteController() {
		return clienteController;
	}
	
	public void validarRegistro(Cliente miCliente) {
		ClienteDAO miPersonaDao;
			miPersonaDao = new ClienteDAO();
			miPersonaDao.registrarCliente(miCliente);						
	}
	
	public Cliente validarConsulta(String codigoCliente) {
		ClienteDAO miClienteDao;
		
		try {
			int codigo=Integer.parseInt(codigoCliente);	
			if (codigo > 0) {
				miClienteDao = new ClienteDAO();
				consultaCliente = true;
				return miClienteDao.buscarCliente(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El codigo del cliente no puede estar vacio.","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaCliente=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCliente = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCliente = false;
		}			
		return null;
	}
	
	public void validarModificacion(Cliente miCliente) {
		ClienteDAO ClienteDao;
		if (miCliente.getNombre().length() > 0 && miCliente.getId() > 0) {
			ClienteDao = new ClienteDAO();
			ClienteDao.modificarCliente(miCliente);	
			modificaCliente = true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaCliente=false;
		}
	}
	
	public void validarEliminacion(String codigoCliente) {
		ClienteDAO ClienteDao=new ClienteDAO();
		try {
			int codigo=Integer.parseInt(codigoCliente);
			ClienteDao.eliminarCliente(codigo);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCliente=false;
		}		
	}

}
