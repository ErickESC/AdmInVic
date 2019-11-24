package mx.uam.ayd.proyecto.presentacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import mx.uam.ayd.proyecto.negocio.dominio.Articulo;
import mx.uam.ayd.proyecto.negocio.dominio.ArticuloEnAlmacen;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class VistaRezago extends javax.swing.JFrame {
    
    private javax.swing.JButton jButton1=null;
    private javax.swing.JButton jButton2=null;
    private javax.swing.JButton jButton3=null;
    private javax.swing.JButton jButton4=null;
    private javax.swing.JButton jButton5=null;
    private javax.swing.JLabel jLabel1=null;
    private javax.swing.JLabel jLabel2=null;
    private javax.swing.JPanel jPanel2=null;
    private javax.swing.JScrollPane jScrollPane1=null;
    private javax.swing.JTable tabla=null;
    private javax.swing.JTextField txtFechaI=null;
    private javax.swing.JTextField txtFechaF=null;
    
    int codigo = 0;
    
    String id;
    String precio;
    
    ArrayList<String> articulos=new ArrayList<String>();
    
    //union con el control
    ControlRezago control=null;
    
    public VistaRezago(ControlRezago control) {
        
    	super();
    	this.control=control;
    	initComponents();
        //t.visualizar_ProductoVO(tabla);
    }
    
    public void limpiar(){
    	
        txtFechaI.setText("");
        txtFechaF.setText("");

        codigo = 0;
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFechaF = new javax.swing.JTextField();
        txtFechaI = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REZAGO");

        tabla.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
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

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("ESTAS BUSCANDO");
              // tabla.setModel(control.muestraTabla());
            	control.generaPrueba(tabla);
            }
        });

        jLabel2.setText("Fecha Final:");

        jLabel1.setText("Fecha Inicio:");
        jButton5 = new javax.swing.JButton();
        
                jButton5.setText("Limpiar");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		limpiar();
                	}
                });
        jButton4 = new javax.swing.JButton();
        
                jButton4.setText("Eliminar de la Lista");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                    
                	public void actionPerformed(ActionEvent e) {
                		
                		control.eliminaDeLista(id, precio);
                		
                	}
                });
        jButton2 = new javax.swing.JButton();
        
                jButton2.setText("Agregar a lista para Aplicar Descuento  ");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    
                	public void actionPerformed(ActionEvent e) {
                		
                		control.agregaALista(id, precio);
                		
                	}
                });
        jButton3 = new javax.swing.JButton();
        
                jButton3.setText("Aplicar Descuento");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                	
                	public void actionPerformed(ActionEvent e) {
                		
                		
                		
                	}
                });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(27)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        					.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jLabel2)))
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtFechaF)
        						.addComponent(txtFechaI, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(41)
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(53)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
        					.addGap(26)
        					.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 86, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        					.addGap(186))))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(26)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtFechaI, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(txtFechaF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton5)
        						.addComponent(jButton1))
        					.addContainerGap())
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        				.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }

    public void mostrar() {
    	
    	
    	System.out.println("asigna");
    	//this.articulos=control.manda();
    	//String matriz[][]=new String[articulos.size()][7];
		//ArrayList<String> lista =new ArrayList<String>();
		//lista.add("M");
		/*lista.set(0, "M");
		lista.set(1, "A");
		lista.set(2, "P");
		lista.set(3, "A");
		lista.set(4, "C");
		lista.set(5, "H");
		lista.set(6, "E");*/
		
		//articulos=lista;
		
    	System.out.println("crea matriz");
    	String matriz[][]=new String[1][7];
    	
    	//for(int i=0; i<articulos.size(); i++) {
    	/*int i=0;	
    	
    		matriz[i][0]="x";
        	matriz[i][1]="x";
        	matriz[i][2]="x";
        	matriz[i][3]="x";
        	matriz[i][4]="x";
        	matriz[i][5]="x";
        	matriz[i][6]="x";*/
    		
    		
    	//}
    	int i=0;
    	
    	
    	System.out.println("guarda en matriz");
    	matriz[i][0]=this.articulos.get(i);
    	matriz[i][1]="A";
    	matriz[i][2]="P";
    	matriz[i][3]="A";
    	matriz[i][4]="C";
    	matriz[i][5]="H";
    	matriz[i][6]="E";
    	
    	System.out.println("guarda en tabla");
        tabla.setModel(new DefaultTableModel(
            	matriz,
            	new String[] {
            		"ID", "DESCRIP", "CANT", "F.REG", "P.VENTA", "DESC(%)", "P.DESC"
            	}));
    	
    	
    }
    
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
       
    	int clic = tabla.rowAtPoint(evt.getPoint());
        
        String id = (String) tabla.getValueAt(clic, 0);
        String precio = (String)tabla.getValueAt(clic, 6);
        this.id=id;
        this.precio=precio;
        
        
    }
    
	public void muestraMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}

    /*
    public static void main(String args[]) {
    	
    	ControlRezago control = null;
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaRezago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRezago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRezago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRezago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRezago(control).setVisible(true);
            }
        });
    }*/

}
