package com.Ejercicio2.controller;

import com.Ejercicio2.model.dto.Videos;
import com.Ejercicio2.model.service.ServiceVideo;
import com.Ejercicio2.view.ActualizarVideo;
import com.Ejercicio2.view.EliminarVideo;
import com.Ejercicio2.view.Menu;
import com.Ejercicio2.view.RegistrarVideo;

public class ControllerVideo {
	private ServiceVideo videoServ;
	private ActualizarVideo buscarActualizar;
	private RegistrarVideo crear;
	private EliminarVideo eliminar;
	private Menu menuPrincipal;

	public ServiceVideo getVideoServ() {
		return videoServ;
	}

	public void setVideoServ(ServiceVideo videoServ) {
		this.videoServ = videoServ;
	}

	public ActualizarVideo getBuscarActualizar() {
		return buscarActualizar;
	}

	public void setBuscarActualizar(ActualizarVideo buscarActualizar) {
		this.buscarActualizar = buscarActualizar;
	}

	public RegistrarVideo getCrear() {
		return crear;
	}

	public void setCrear(RegistrarVideo crear) {
		this.crear = crear;
	}

	public EliminarVideo getEliminar() {
		return eliminar;
	}

	public void setEliminar(EliminarVideo eliminar) {
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
		
		//SERVICES
		public void registrarVideo(Videos miVideo) {
			videoServ.validarRegistro(miVideo);
		}
			
		public Videos buscarVideo(String codigoCliente) {
			return videoServ.validarConsulta(codigoCliente);
		}
			
		public void modificarVideo(Videos miVideo) {
			videoServ.validarModificacion(miVideo);
		}
			
		public void eliminarVideo(String codigo) {
			videoServ.validarEliminacion(codigo);
		}

}
