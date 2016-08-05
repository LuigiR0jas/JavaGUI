package org.larp.a3;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;


public class Window extends JFrame {
	
	private JButton btn1,btn2, btn3;
	private JLabel l1,l2,l3,l4;
	private JFrame f1;
	//private JTextField edt1, edt2;
	private JPanel panel;

	
	public Window() {
		components();
		actions();
	}

	public void components() {
		this.setTitle("A3 Software");
		this.setBounds(200,200,400,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.add(this.panel);
		this.l1 = new JLabel("Bienvenido, ¿qué desea hacer?");
		this.l1.setBounds(100, 110, 300, 30);
		this.panel.add(this.l1);
		this.btn1 = new JButton("Realizar proceso de compra-venta");
		this.btn1.setBounds(50, 170, 300, 30);
		this.panel.add(this.btn1);
		this.btn2 = new JButton("Procesar devolución");
		this.btn2.setBounds(50, 220, 300, 30);
		this.panel.add(this.btn2);
		this.btn3 = new JButton("Consultar base de datos");
		this.btn3.setBounds(50, 270, 300, 30);
		this.panel.add(this.btn3);
		
		this.setVisible(true);
	}
	
	
	public void actions() {
		 this.btn1.addActionListener((e)-> {
			 new SalesWindow();
			 setVisible(false);
			
		}); 
		 this.btn2.addActionListener((e)-> {
			 new RefundWindow();
			 setVisible(false);
				
			}); 
		 this.btn3.addActionListener((e)-> {
			 new DBWindow();
			 setVisible(false);
				
			}); 
		
	}

}
