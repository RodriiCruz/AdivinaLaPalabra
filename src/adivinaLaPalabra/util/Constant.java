package adivinaLaPalabra.util;

import java.util.Arrays;
import java.util.List;

import adivinaLaPalabra.model.Definition;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Constant {
	
	private static final Definition DEF_UNO = new Definition("RESPIRA", "Absorbe el aire y lo expira.");
	private static final Definition DEF_DOS = new Definition("OCTUPLO", "Que es exactamente ocho veces más grande que otro, que lo contiene ocho veces; que resulta de multiplicar por ocho un número o una cantidad.");
	private static final Definition DEF_TRES = new Definition("ARMENIA", "País ubicado entre Europa y Asia, en la región de Transcaucasia, al sur de la cordillera del Cáucaso, entre el mar Negro y el mar Caspio. Limita al oeste con Turquía, al norte con Georgia, al este con Azerbaiyán y al sur con Irán.");
	private static final Definition DEF_CUATRO = new Definition("OMICRON", "Letra quince del alfabeto griego moderno y antiguo. Corresponde a la o breve del alfabeto latino.");
	private static final Definition DEF_CINCO = new Definition("CAREAR", "Confrontar personas para conocer la verdad.");
	private static final Definition DEF_SEIS = new Definition("AMARAR", "Dicho de un hidroavión o de un vehículo espacial: Posarse en el agua.");
	private static final Definition DEF_SIETE = new Definition("CIZAÑA", "Planta gramínea que se cría espontáneamente entre los sembrados.");
	private static final Definition DEF_OCHO = new Definition("JUNGLA", "Sabana de vegetación espesa.");
	private static final Definition DEF_NUEVE = new Definition("AGAPE", "Banquete.");
	private static final Definition DEF_DIEZ = new Definition("TRAGO", "Porción de líquido que se bebe de una vez.");
	private static final Definition DEF_ONCE = new Definition("CORAL", "Producción marítima coralífera.");
	private static final Definition DEF_DOCE = new Definition("BIOMA", "Sistema biológico de una región.");
	
	public static final List<Definition> DEFINICIONES = Arrays.asList(DEF_UNO, DEF_DOS, DEF_TRES, DEF_CUATRO, DEF_CINCO,
			DEF_SEIS, DEF_SIETE, DEF_OCHO, DEF_NUEVE, DEF_DIEZ, DEF_ONCE, DEF_DOCE);
	
	public static final String TITULO = "Adivina la palabra!";
	public static final String FUENTE = "Tahoma";
	public static final String DEFINICION = "Definición: ";
	public static final String PUNTAJE = "Puntaje";
	public static final String INTENTOS = "Intentos";
	public static final String SALIR = "Salir";
	public static final String REINICIAR = "Reiniciar";
	public static final String GANASTE = "Ganaste!";
	public static final String PERDISTE = "Perdiste!";
	public static final String ESPACIO_VACIO = "_";

}
