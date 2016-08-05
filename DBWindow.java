package org.larp.a3;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class DBWindow extends JFrame {
	private JButton btn1, btn2, btn3, btn4, btn5;
	private JLabel l1;
	private JPanel panel;
	Statement smt = null;
	ResultSet rs = null;
	Connection conn = null;

	
	public DBWindow() {
		components();
		actions();
	}

	public void components() {
		this.setTitle("Base de datos");
		this.setBounds(200,200,400,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.add(this.panel);
		this.l1 = new JLabel("¿Qué tabla desea verificar?;");
		this.l1.setBounds(100, 110, 300, 30);
		this.panel.add(this.l1);
		this.btn1 = new JButton("Visualizar Clientes");
		this.btn1.setBounds(50, 170, 300, 30);
		this.panel.add(this.btn1);
		this.btn2 = new JButton("Visualizar Productos");
		this.btn2.setBounds(50, 220, 300, 30);
		this.panel.add(this.btn2);
		this.btn3 = new JButton("Visualizar Proveedores");
		this.btn3.setBounds(50, 270, 300, 30);
		this.panel.add(this.btn3);
		this.btn4 = new JButton("Visualizar facturas");
		this.btn4.setBounds(50, 320, 300, 30);
		this.panel.add(this.btn4);
		this.btn5 = new JButton("Atrás");
		this.btn5.setBounds(100, 400, 200, 30);
		this.panel.add(this.btn5);
		this.setVisible(true);
		
		this.setVisible(true);
	}
	
	public void actions(){
		btn1.addActionListener ((e)-> {
			try{
				Connection conn = null;
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/A4", 
						"luigi", "2612");
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery("SELECT * FROM client");
				JTable table = new JTable(buildTableModel(rs));
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
				rs.close();
				smt.close();
				conn.close();
			}catch(Exception err){
				err.printStackTrace();
			}
		});
		btn2.addActionListener ((e)-> {
			try{
				Connection conn = null;
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/A4", 
						"luigi", "2612");
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery("SELECT * FROM product");
				JTable table = new JTable(buildTableModel(rs));
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
				rs.close();
				smt.close();
				conn.close();
			}catch(Exception err){
				err.printStackTrace();
			}
		});
		btn3.addActionListener ((e)-> {
			try{
				Connection conn = null;
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/A4", 
						"luigi", "2612");
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery("SELECT * FROM proveedor");
				JTable table = new JTable(buildTableModel(rs));
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
				rs.close();
				smt.close();
				conn.close();
			}catch(Exception err){
				err.printStackTrace();
			}
		});
		btn4.addActionListener ((e)-> {
			try{
				Connection conn = null;
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/A4", 
						"luigi", "2612");
				Statement smt = conn.createStatement();
				ResultSet rs = smt.executeQuery("SELECT * FROM factura");
				JTable table = new JTable(buildTableModel(rs));
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
				rs.close();
				smt.close();
				conn.close();
			}catch(Exception err){
				err.printStackTrace();
			}
		});
		btn5.addActionListener((e)-> {
			new Window();
			dispose();
		});
		
		
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}


}
