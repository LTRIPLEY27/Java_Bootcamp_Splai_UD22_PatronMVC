package models.conection;

import models.actionTables.ClienteRegister;
import models.clases.Cliente;

public class mainProva {

	public static void main(String[] args) {
		Cliente client = new Cliente("Ludwig", "Van Beethoven", "viena", "123A", "1832-06-12");
		Conect con = new Conect();
		//con.crearDataBase();
		ClienteRegister neo = new ClienteRegister();
		
		//neo.createTable();
		neo.regCliente();
	}

}
