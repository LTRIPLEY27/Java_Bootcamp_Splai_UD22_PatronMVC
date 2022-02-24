package com.Ejercicio2;

import java.awt.EventQueue;

import com.Ejercicio2.view.Menu;


public class App 
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
