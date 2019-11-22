package mx.uam.ayd.proyecto.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class VistaRezago extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRezago frame = new VistaRezago();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaRezago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("VISTA DE REZAGO");
		setBounds(100, 100, 540, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 55, 516, 183);
		contentPane.add(panel);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			
			new String[] {
				"ID", "DESCRIP", "CANT", "F/AGREG", "P/VENTA", "P/DESCUENTO", "DESC(%)"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Date.class, Double.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		panel.add(table);
	}
}
