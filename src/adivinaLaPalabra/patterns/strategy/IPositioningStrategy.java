package adivinaLaPalabra.patterns.strategy;

import java.util.List;

import javax.swing.JLabel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public interface IPositioningStrategy {
	
	void positioningLetters(List<JLabel> letras);
	
}
