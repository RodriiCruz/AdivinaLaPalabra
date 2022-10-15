package adivinaLaPalabra.patterns.strategy;

import java.util.List;

import javax.swing.JLabel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class LongWord implements IPositioningStrategy{

	@Override
	public void positioningLetters(List<JLabel> letras) {
		letras.get(0).setBounds(47, 0, 23, 59);

		letras.get(1).setBounds(117, 0, 23, 59);

		letras.get(2).setBounds(187, 0, 23, 59);

		letras.get(3).setBounds(257, 0, 23, 59);

		letras.get(4).setBounds(327, 0, 23, 59);

		letras.get(5).setBounds(397, 0, 23, 59);
		letras.get(5).setVisible(true);

		letras.get(6).setBounds(467, 0, 23, 59);
		letras.get(6).setVisible(true);
	}

}
