package org.larp.a3;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;

public class SalesWindow extends JFrame {
	
	private JButton btn1,btn2, btn3;
	private JLabel l1,l2,l3,l4, l5;
	private JFrame f1;
	private JTextField edt1, edt2, edt3, edt4;
	private JPanel panel;

	
	public SalesWindow() {
		components();
		actions();
	}

	public void components() {
		this.setTitle("Compra-venta");
		this.setBounds(200,200,800,900);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.add(this.panel);
		this.l1 = new JLabel("Ingrese cédula de cliente");
		this.l1.setBounds(30, 30, 300, 30);
		this.panel.add(this.l1);
		this.edt1 = new JTextField();
		this.edt1.setBounds(30, 60, 300, 30);
		this.panel.add(this.edt1);
		
		this.l2 = new JLabel("Ingrese nombre del cliente");
		this.l2.setBounds(30, 90, 300, 30);
		this.panel.add(this.l2);
		this.edt2 = new JTextField();
		this.edt2.setBounds(30, 120, 300, 30);
		this.panel.add(this.edt2);
		
		this.l3 = new JLabel("Ingrese numero del cliente");
		this.l3.setBounds(30, 150, 300, 30);
		this.panel.add(this.l3);
		this.edt3 = new JTextField();
		this.edt3.setBounds(30, 180, 300, 30);
		this.panel.add(this.edt3);
		
		this.l4 = new JLabel("===========================================");
		this.l4.setBounds(30, 210, 300, 30);
		this.panel.add(this.l4);
		
		this.l5 = new JLabel("Ingrese codigo del producto");
		this.l5.setBounds(30, 230, 300, 30);
		this.panel.add(this.l5);
		this.edt4 = new JTextField();
		this.edt4.setBounds(30, 260, 300, 30);
		this.panel.add(this.edt4);
		
		this.setVisible(true);
	}
	
	public void actions(){
		
	}
	

}
