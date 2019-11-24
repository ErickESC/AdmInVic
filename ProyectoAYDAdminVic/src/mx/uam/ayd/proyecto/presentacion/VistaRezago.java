package mx.uam.ayd.proyecto.presentacion;

import java.io.File;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 *
 * @author David
 */
public class VistaRezago extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private javax.swing.JButton jButton2=null;
    private javax.swing.JButton jButton3=null;
    private javax.swing.JButton jButton4=null;
    private javax.swing.JLabel jLabel1=null;
    private javax.swing.JLabel jLabel2=null;
    private javax.swing.JPanel jPanel2=null;
    private javax.swing.JScrollPane jScrollPane1=null;
    private javax.swing.JTable tabla=null;
    private JTextField textFieldID;
    private JTextField textFieldNP;
    
    int codigo = 0;
    
    //union con el control
    ControlRezago control;

    
    public VistaRezago(ControlRezago control) {
        
    	super();
    	this.control=control;
    	initComponents();
        //t.visualizar_ProductoVO(tabla);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JDateChooser fecha_inicial = new JDateChooser();
        
        fecha_inicial.setDateFormatString("yyyy/MM/dd");
        
        JDateChooser fecha_final = new JDateChooser();
        fecha_final.setDateFormatString("yyyy/MM/dd");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REZAGO");

        tabla.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"", null, null, null, null, null, ""},
        		{"", null, null, null, null, null, ""},
        		{"", null, null, null, null, null, ""},
        		{"", null, null, null, null, null, ""},
        		{"", null, null, null, null, null, ""}
        	},
        	new String[] {
        		"ID", "DESCRIP", "CANT", "F.REG", "P.VENTA", "DESC(%)", "P.DESC"
        	}
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Fecha Final:");

        jLabel1.setText("Fecha Inicio:");
        jButton4 = new javax.swing.JButton();
        
                jButton4.setText("Eliminar de la Lista");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                    
                	public void actionPerformed(ActionEvent e) {
                		
                		String id=textFieldID.getText();
                		String precio=textFieldNP.getText();
                		
                		control.eliminaDeLista(id, precio);
                		
                	}
                });
        jButton2 = new javax.swing.JButton();
        
                jButton2.setText("Agregar a lista para Aplicar Descuento  ");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    
                	public void actionPerformed(ActionEvent e) {
                		
                		String id=textFieldID.getText();
                		String precio=textFieldNP.getText();
                		control.agregaALista(id, precio);
                		
                	}
                });
        jButton3 = new javax.swing.JButton();
        
                jButton3.setText("Aplicar Descuento");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                	
                	public void actionPerformed(ActionEvent e) {
                		
                		System.out.println("taco");
                		
                		control.GeneraDescuentos();
                		
                	}
                });
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
            	java.sql.Date max;
            	java.sql.Date min;
            	
				max= new java.sql.Date(fecha_inicial.getDate().getYear(), fecha_inicial.getDate().getMonth(), fecha_inicial.getDate().getDay());
				min=new java.sql.Date(fecha_final.getDate().getYear(), fecha_final.getDate().getMonth(), fecha_final.getDate().getDay());
				
	            control.generaListaRezago(max, min, tabla);
        		
        	}
        });
        
        textFieldID = new JTextField();
        textFieldID.setColumns(10);
        
        JLabel lblId = new JLabel("ID:");
        
        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        
        textFieldNP = new JTextField();
        textFieldNP.setColumns(10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(92)
        					.addComponent(btnBuscar)
        					.addGap(95))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(32)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLabel2)
        						.addComponent(jLabel1))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(fecha_inicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(fecha_final, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        							.addGap(40)))))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(40)
        					.addComponent(lblNuevoPrecio)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textFieldNP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(301, Short.MAX_VALUE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
        					.addGap(39)
        					.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 328, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        					.addGap(257))))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblId)
        				.addComponent(lblNuevoPrecio)
        				.addComponent(textFieldNP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(fecha_inicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1))
        			.addGap(6)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(fecha_final, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2))
        					.addGap(16)
        					.addComponent(btnBuscar)
        					.addGap(23))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        					.addGap(33))))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
    
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
       
    	int clic = tabla.rowAtPoint(evt.getPoint());
        
        String id = ""+ tabla.getValueAt(clic, 0);
        String precio = ""+tabla.getValueAt(clic, 6);
        textFieldID.setText(id);
        textFieldNP.setText(precio);
        
        
    }
    
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
