package controllers;

import models.dao.ClienteRegister;
import models.dto.Cliente;
import models.services.ServiceCliente;
import views.*;
public class ControlerCliente {

	//DECLARAMOS CADA PANEL DE VISTA COMO ATRIBUTO DE LA CLASE PARA MANEJARLOS
	private ServiceCliente servCliente;
	private Registros registros;
	private Actualizar actualiza;
	private Registrar crea;
	private Eliminar elimina;
	private PanelVista menu;
	
	//DECLARAMOS LOS MÉTODOS DE ACCESO
	
	public ServiceCliente getservCliente() {
		return servCliente;
	}
	public void setRegistro(ServiceCliente servCliente) {
		this.servCliente = servCliente;
	}
	public Registros getRegistros() {
		return registros;
	}
	public void setRegistros(Registros registros) {
		this.registros = registros;
	}
	public Actualizar getActualiza() {
		return actualiza;
	}
	public void setActualiza(Actualizar actualiza) {
		this.actualiza = actualiza;
	}
	public Registrar getCrea() {
		return crea;
	}
	public void setCrea(Registrar crea) {
		this.crea = crea;
	}
	public Eliminar getElimina() {
		return elimina;
	}
	public void setElimina(Eliminar elimina) {
		this.elimina = elimina;
	}
	public PanelVista getMenu() {
		return menu;
	}
	public void setMenu(PanelVista menu) {
		this.menu = menu;
	}
	
	//eventos de los frames TODOS DECLARADOS ENABLE
	
	public void showPanelVista() {
		menu.setVisible(true);
	}
	
	public void showRegistro() {
		registros.setVisible(true);
	}
	
	public void showEliminar() {
		elimina.setVisible(true);
	}
	
	public void showActualiza() {
		actualiza.setVisible(true);
	}
	
	public void showRegistrar() {
		crea.setVisible(true);
	}
	
	//conexión a la capa service llamando a los métodos allí definidos
	
	public void registraClient(Cliente client) {
		servCliente.validateRegister(client);
	}
	
	/*public Cliente actualiza(int id) {
		return serCliente.v
	}*/
	
	public void validateDelete(int codi) {
		servCliente.validateDelete(codi);
	}
}
