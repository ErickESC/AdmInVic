/**
 * 
 */
package mx.uam.ayd.proyecto.negocio.dominio;

/**
 * @author erick
 *
 */
public class Articulo {
	
	private String idArticulo;
	private String descripcion;
	private byte[] imagen;
	private double precioVenta;
	private double precioMayoreo;
	private double precioAdquisicion;
	private int articulosTotal;
	
	/*
	 * Constructor
	 * 
	 */
	
	public Articulo( String idArticulo, String descripcion, byte[] imagen, float precioVenta, float precioMayoreo, float precioAdquisicion, int articulosTotal) {
		
		this.idArticulo=idArticulo;
		this.descripcion=descripcion;
		this.imagen=imagen;
		this.precioVenta=precioVenta;
		this.precioMayoreo=precioMayoreo;
		this.precioAdquisicion=precioAdquisicion;
		this.articulosTotal=articulosTotal;
		
	}
	
	/*
	 * set's y get's
	 */
	
	//ARTICULO
	
	public void setIdArticulo(String newIdArticulo) {
		
		this.idArticulo=newIdArticulo;
		
	}
	
	public String getIdArticulo() {
		
		return this.idArticulo;
		
	}
	
	//DESCRIPCION
	
	public void setDescripcion(String newDescripcion) {
		
		this.descripcion=newDescripcion;
		
	}
	
	public String getDescripcion() {
		
		return this.descripcion;
		
	}
	
	//IMAGEN
	
	public void setImagen(byte[] newImagen) {
		
		this.imagen=newImagen;
		
	}
	
	public byte[] getImagen() {
		
		return this.imagen;
		
	}
	
	//PRECIO_VENTA
	
	public void setPrecioVenta(double newPrecioVenta) {
		
		this.precioVenta=newPrecioVenta;
		
	}
	
	public double getPrecioVenta() {
		
		return this.precioVenta;
		
	}
	
	//PRECIO_MAYOREO
	
	
	public void setPrecioMayoreo(double newPrecioMayoreo) {
		
		this.precioMayoreo=newPrecioMayoreo;
		
	}
	
	public double getPrecioMayoreo() {
		
		return this.precioMayoreo;
		
	}
	
	//PRECIO_ADQUISICION
	
	
	public void setPrecioAdquisicion(double newPrecioAdquisicion) {
		
		this.precioAdquisicion=newPrecioAdquisicion;
		
	}
	
	public double getPrecioAdquisicion() {
		
		return this.precioAdquisicion;
		
	}
	
	//ARTICULOS_TOTAL
	
	
	public void setArticulosTotal(int newArticulosTotal) {
		
		this.articulosTotal=newArticulosTotal;
		
	}
	
	public int getArticulosTotal() {
		
		return this.articulosTotal;
		
	}

}
