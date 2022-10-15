package adivinaLaPalabra.model;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Definition {
	
	private String palabra;
	private String definicion;
	
	public Definition(String palabra, String definicion) {
		this.palabra = palabra;
		this.definicion = definicion;
	}
	
	public String getPalabra() {
		return palabra;
	}
	
	public String getDefinicion() {
		return definicion;
	}
}
