package adivinaLaPalabra.model;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Game {

	private char[] palabra;
	private String definicion;
	private Integer intentos;
	private Integer aciertos;
	private Integer puntaje;

	public Game() {
		this.intentos = 5;
		this.aciertos = 0;
		this.puntaje = 0;
	}

	public char[] getPalabra() {
		return palabra;
	}

	public void setPalabra(char[] palabra) {
		this.palabra = palabra;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public Integer getAciertos() {
		return aciertos;
	}

	public void setAciertos(Integer aciertos) {
		this.aciertos = aciertos;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
}
