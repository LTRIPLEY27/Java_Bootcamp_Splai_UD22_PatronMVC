package com.Ejercicio2.model.service;

import javax.swing.JOptionPane;

import com.Ejercicio2.controller.ControllerVideo;
import com.Ejercicio2.model.dao.VideoDAO;
import com.Ejercicio2.model.dto.Videos;

public class ServiceVideo {
	
	private ControllerVideo videoController;
	public static boolean consultaVideo = false;
	public static boolean modificaVideo = false;
	

	public void setVideoController(ControllerVideo videoController) {
		this.videoController = videoController;
	}

	public ControllerVideo getVideoController() {
		return videoController;
	}
	
	
	public void validarRegistro(Videos miVideo) {
		
		if(existeCliente(miVideo.getCliente_id())) {
			VideoDAO miVideoDao = new VideoDAO();
			miVideoDao.registrarVideo(miVideo);
		}else {
			JOptionPane.showMessageDialog(null,"No existe el cliente con id: "+miVideo.getCliente_id(),"Advertencia",JOptionPane.WARNING_MESSAGE);
		}					
	}
	
	private boolean existeCliente(int cliente_id) {
		
		ServiceCliente servClient = new ServiceCliente();
		
		if (servClient.validarConsulta(String.valueOf(cliente_id)) != null) {
			return true;
		}
		return false;
	}


	public Videos validarConsulta(String codigoVideo) {
		VideoDAO miVideoDao;
		
		try {
			int codigo=Integer.parseInt(codigoVideo);	
			if (codigo > 0) {
				miVideoDao = new VideoDAO();
				consultaVideo = true;			
				return miVideoDao.buscarVideo(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El codigo del video no puede estar vacio.","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaVideo=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaVideo=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaVideo=false;
		}
					
		return null;
	}
	

    public void validarModificacion(Videos miVideo) {
        VideoDAO miVideoDao;
        if (existeCliente(miVideo.getCliente_id())) {
            miVideoDao = new VideoDAO();
            miVideoDao.modificarVideo(miVideo);
            modificaVideo=true;
        }else{
            JOptionPane.showMessageDialog(null,"No existe el cliente con id: "+miVideo.getCliente_id(),"Advertencia",JOptionPane.WARNING_MESSAGE);
            modificaVideo=false;
        }
    }
	

	public void validarEliminacion(String codigoVideo) {
		VideoDAO miVideoDao=new VideoDAO();
		try {
			int codigo = Integer.parseInt(codigoVideo);
			miVideoDao.eliminarVideo(codigo);
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaVideo=false;
		}
		
	}
}
