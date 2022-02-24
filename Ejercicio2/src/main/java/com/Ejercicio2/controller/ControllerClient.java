package com.Ejercicio2.controller;

import com.Ejercicio2.model.dto.Cliente;
import com.Ejercicio2.model.service.ServiceCliente;
import com.Ejercicio2.view.Actualizar;
import com.Ejercicio2.view.Eliminar;
import com.Ejercicio2.view.Menu;
import com.Ejercicio2.view.Registrar;

public class ControllerClient {
	
	private ServiceCliente clienteServ;
	private Actualizar buscarActualizar;
	private Registrar crear;
	private Eliminar eliminar;
	private Menu menuPrincipal;

	public ServiceCliente getClienteServ() {
		return clienteServ;
	}

	public void setClienteServ(ServiceCliente clienteServ) {
		this.clienteServ = clienteServ;
	}

	public Actualizar getBuscarActualizar() {
		return buscarActualizar;
	}

	public void setBuscarActualizar(Actualizar buscarActualizar) {
		this.buscarActualizar = buscarActualizar;
	}

	public Registrar getCrear() {
		return crear;
	}

	public void setCrear(Registrar crear) {
		this.crear = crear;
	}

	public Eliminar getEliminar() {
		return eliminar;
	}

	public void setEliminar(Eliminar eliminar) {
		this.eliminar = eliminar;
	}

	public Menu getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(Menu menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	
	public void mostrarMenuPrincipal() {
		menuPrincipal.setVisible(true);
	}
	
	public void mostrarVentanaCreacion() {
		crear.setVisible(true);
	}
	
	public void mostrarVentanaBusActu() {
		buscarActualizar.setVisible(true);
	}
	
	public void mostrarVentanaEliminar() {
		eliminar.setVisible(true);
	}
	
	
	//MÉTODOS DEL SERVICES
		public void registrarCliente(Cliente miCiente) {
			clienteServ.validarRegistro(miCiente);
		}
		
		public Cliente buscarCliente(String codigoCliente) {
			return clienteServ.validarConsulta(codigoCliente);
		}
		
		public void modificarCliente(Cliente miCliente) {
			clienteServ.validarModificacion(miCliente);
		}
		
		public void eliminarCliente(String codigo) {
			clienteServ.validarEliminacion(codigo);
		}

}
