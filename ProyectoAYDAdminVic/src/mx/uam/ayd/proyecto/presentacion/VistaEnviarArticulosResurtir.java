package mx.uam.ayd.proyecto.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class VistaEnviarArticulosResurtir extends JFrame {

	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField txtIDArticulo;
	
	ControlEnviarProductoAResurtir control;

    public VistaEnviarArticulosResurtir(ControlEnviarProductoAResurtir control) {
        
    	super();
    	this.control=control;
    	initComponents();
        
    }

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTA DE PRODUCTO");
		
		JLabel lblId = new JLabel("ID Articulo:");
		lblId.setBounds(23, 149, 82, 23);
		contentPane.add(lblId);
		
		txtIDArticulo = new JTextField();
		txtIDArticulo.setBounds(112, 153, 114, 19);
		contentPane.add(txtIDArticulo);
		txtIDArticulo.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(42, 194, 70, 15);
		contentPane.add(lblCantidad);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(142, 189, 48, 34);
		contentPane.add(spinner);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(254, 148, 117, 25);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            
        	public void actionPerformed(ActionEvent e) {
        		String id=txtIDArticulo.getText();
        		String cantidad=spinner.getValue().toString();
        		control.agregaALista(id, cantidad);
        	}
        });
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(254, 189, 117, 25);
		contentPane.add(btnEliminar);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            
        	public void actionPerformed(ActionEvent e) {
        		String id=txtIDArticulo.getText();
        		control.eliminaDeLista(id);
        	}
        });
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(152, 226, 117, 25);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            
        	public void actionPerformed(ActionEvent e) {
        		control.enviarLista();
        	}
        });
	}
	
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
