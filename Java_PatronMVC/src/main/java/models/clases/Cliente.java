package models.clases;

import java.sql.Date;

//CLASE CLIENTE SOBRE LA QUE SE GESTIONAR{A LA VISTA Y CONEXIÓN
public class Cliente {
	//private int id;
	private String name;
	private String lastname;
	private String address;
	private String dni;
	private String date;
	
	///SOLO PARA PRUEBA
	public Cliente(String name, String lastname, String address, String dni, String date) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.dni = dni;
		this.date = date;
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
