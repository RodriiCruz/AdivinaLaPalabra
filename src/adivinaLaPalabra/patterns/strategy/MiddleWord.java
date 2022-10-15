package adivinaLaPalabra.patterns.strategy;

import java.util.List;

import javax.swing.JLabel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class MiddleWord implements IPositioningStrategy {

	@Override
	public void positioningLetters(List<JLabel> letras) {
		letras.get(0).setBounds(57, 0, 23, 59);

		letras.get(1).setBounds(137, 0, 23, 59);

		letras.get(2).setBounds(217, 0, 23, 59);

		letras.get(3).setBounds(297, 0, 23, 59);

		letras.get(4).setBounds(377, 0, 23, 59);

		letras.get(5).setBounds(457, 0, 23, 59);
		letras.get(5).setVisible(true);
		
		letras.get(6).setVisible(false);
	}

}
