package mx.uam.ayd.proyecto.presentacion;


import javax.swing.JPanel;
import javax.swing.JFrame;


import javax.swing.JLabel;

import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JButton jButtonAgregarLibro = null;

	private JButton jButtonAgregarRevista = null;

	private JButton jButtonBuscarTitulo = null;

	private JButton jButtonEliminarTitulo = null;

	private JButton jButtonListarCatalogo = null;

	private JButton jButtonSalir = null;
	
	private ControlPrincipal control;

	
	
	/**
	 * This is the default constructor
	 */
	public VentanaPrincipal(ControlPrincipal ctrl) {
		super();
		initialize();
		control = ctrl;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(445, 274);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(121, 26, 231, 49));
			jLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
			jLabel.setText("Libreria Virtual");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonAgregarLibro(), null);
			jContentPane.add(getJButtonAgregarRevista(), null);
			jContentPane.add(getJButtonBuscarTitulo(), null);
			jContentPane.add(getJButtonEliminarTitulo(), null);
			jContentPane.add(getJButtonListarCatalogo(), null);
			jContentPane.add(getJButtonSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonAgregarLibro	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarLibro() {
		if (jButtonAgregarLibro == null) {
			jButtonAgregarLibro = new JButton();
			jButtonAgregarLibro.setBounds(new Rectangle(30, 91, 180, 31));
			jButtonAgregarLibro.setText("Generar venta");
			jButtonAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Invoca al control principal
					//control.agregarLibro();
				}
			});
		}
		return jButtonAgregarLibro;
	}

	/**
	 * This method initializes jButtonAgregarRevista	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarRevista() {
		if (jButtonAgregarRevista == null) {
			jButtonAgregarRevista = new JButton();
			jButtonAgregarRevista.setBounds(new Rectangle(30, 135, 181, 30));
			jButtonAgregarRevista.setText("Historial");
		}
		return jButtonAgregarRevista;
	}

	/**
	 * This method initializes jButtonBuscarTitulo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBuscarTitulo() {
		if (jButtonBuscarTitulo == null) {
			jButtonBuscarTitulo = new JButton();
			jButtonBuscarTitulo.setBounds(new Rectangle(240, 90, 166, 31));
			jButtonBuscarTitulo.setText("Enviar Lista");
		}
		return jButtonBuscarTitulo;
	}

	/**
	 * This method initializes jButtonEliminarTitulo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonEliminarTitulo() {
		if (jButtonEliminarTitulo == null) {
			jButtonEliminarTitulo = new JButton();
			jButtonEliminarTitulo.setBounds(new Rectangle(240, 135, 166, 31));
			jButtonEliminarTitulo.setText("REZAGO");
			jButtonEliminarTitulo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.Rezago();
				}
			});
		}
		
		
		return jButtonEliminarTitulo;
	}

	/**
	 * This method initializes jButtonListarCatalogo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonListarCatalogo() {
		if (jButtonListarCatalogo == null) {
			jButtonListarCatalogo = new JButton();
			jButtonListarCatalogo.setBounds(new Rectangle(30, 180, 181, 30));
			jButtonListarCatalogo.setText("Modifcar");
			jButtonListarCatalogo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//control.listarCatalogo();
				}
			});
		}
		return jButtonListarCatalogo;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(240, 180, 167, 32));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					control.termina();
				}
			});
		}
		return jButtonSalir;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
