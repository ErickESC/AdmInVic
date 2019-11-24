package mx.uam.ayd.proyecto.presentacion;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaAgregarLibro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JTextField jTextFieldNombre = null;

	private JLabel jLabel2 = null;

	private JTextField jTextFieldAutor = null;

	private JButton jButtonAceptar = null;

	private JButton jButtonCancelar = null;

	
	private ControlAgregarLibro control = null;

	public VentanaAgregarLibro(ControlAgregarLibro control) {
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
		this.setContentPane(getJContentPane());
		this.setTitle("Agregar Libro");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(49, 88, 56, 14));
			jLabel2.setText("Autor :");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(48, 20, 169, 31));
			jLabel1.setFont(new Font("Arial Black", Font.BOLD, 18));
			jLabel1.setText("Agregar libro");
			jLabel = new JLabel();
			jLabel.setText("Nombre :");
			jLabel.setBounds(new Rectangle(48, 61, 64, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextFieldNombreLibro(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJTextFieldAutor(), null);
			jContentPane.add(getJButtonAceptar(), null);
			jContentPane.add(getJButtonCancelar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldNombreLibro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNombreLibro() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.setBounds(new Rectangle(120, 62, 137, 18));
		}
		return jTextFieldNombre;
	}

	/**
	 * This method initializes jTextFieldAutor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAutor() {
		if (jTextFieldAutor == null) {
			jTextFieldAutor = new JTextField();
			jTextFieldAutor.setBounds(new Rectangle(120, 87, 138, 19));
		}
		return jTextFieldAutor;
	}

	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(30, 120, 106, 31));
			jButtonAceptar.setText("Aceptar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String nombre = jTextFieldNombre.getText();
					String titulo = jTextFieldAutor.getText();
						control.agregaLibro(nombre, titulo);
				}
			});
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setBounds(new Rectangle(149, 120, 107, 31));
			jButtonCancelar.setText("Cancelar");
		}
		return jButtonCancelar;
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
