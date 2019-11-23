package mx.uam.ayd.proyecto.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class VistaRezago extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JTextField jTextFieldNombre = null;

	private JLabel jLabel2 = null;

	private JTextField jTextFieldAutor = null;

	private JButton jButtonAceptar = null;

	private JButton jButtonCancelar = null;

	private ControlRezago control = null;
	/**
	 * This is the default constructor
	 */
	public VistaRezago(ControlRezago control) {
		super();
		initialize();
		this.control = control;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getContentPane());
		this.setTitle("REZAGO");
	}
	
	
	
	
	public void abre() {
		setVisible(true);
	}
	
	public void cierra() {
		setVisible(false);
	}

	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
