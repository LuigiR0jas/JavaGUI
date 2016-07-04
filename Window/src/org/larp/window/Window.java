package org.larp.window;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;

public class Window extends JFrame {
	private JButton btn1,btn2;
	private JLabel l1,l2;
	private JTextField edt1;
	private JPanel panel;
	
	public Window() {
		components();
		actions();
	}

	public void components() {
		this.setTitle("My GUI");
		this.setBounds(200,200,400,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.add(this.panel);
		this.l1 = new JLabel("My GUI");
		this.l1.setFont(new Font("Serif", Font.BOLD, 24));
		this.l1.setBounds(160, 20, 300, 40);
		this.panel.add(this.l1);
		this.l2 = new JLabel("Haz click para mostrar un mensaje");
		this.l2.setBounds(30, 70, 300, 20);
		this.panel.add(this.l2);
		this.btn1 = new JButton("MOSTRAR");
		this.btn1.setBounds(30, 100, 150, 40);
		this.panel.add(this.btn1);
		this.edt1 = new JTextField();
		this.edt1.setBounds(30, 150, 300, 30);
		this.panel.add(this.edt1);
		this.btn2 = new JButton("Make Query");
		this.btn2.setBounds(30, 200, 300, 30);
		this.panel.add(this.btn2);
		this.setVisible(true);
	}//components

	public void actions() {
		this.btn1.addActionListener((e)-> {
			this.edt1.setText("Hello World!!!");
			
		});
		btn2.addActionListener ((e)-> {
			try{
				Connection conn = null;
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/people", 
						"postgres", "masterkey");
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery("SELECT * FROM person");
				System.out.println("ID \t NAME ");
				System.out.println("===============");
				while(rs.next()){
					int id = rs.getInt("person_id");
					String name = rs.getString("person_name");
					System.out.println(id + "\t" + name);
				}
			}catch(Exception err){
				err.printStackTrace();
			}
		});
	}
}//class Window
