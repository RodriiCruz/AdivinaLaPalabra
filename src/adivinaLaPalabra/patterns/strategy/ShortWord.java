package adivinaLaPalabra.patterns.strategy;

import java.util.List;

import javax.swing.JLabel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class ShortWord implements IPositioningStrategy {

	@Override
	public void positioningLetters(List<JLabel> letras) {
		letras.get(0).setBounds(70, 0, 23, 59);

		letras.get(1).setBounds(163, 0, 23, 59);

		letras.get(2).setBounds(256, 0, 23, 59);

		letras.get(3).setBounds(349, 0, 23, 59);

		letras.get(4).setBounds(442, 0, 23, 59);
		
		letras.get(5).setVisible(false);
		
		letras.get(6).setVisible(false);
	}

}
