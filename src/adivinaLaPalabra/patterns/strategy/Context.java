package adivinaLaPalabra.patterns.strategy;

import java.util.List;

import javax.swing.JLabel;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Context {

    private IPositioningStrategy positioningStrategy;

    public Context(IPositioningStrategy positioningStrategy){
        this.positioningStrategy = positioningStrategy;
    }

    public void executeStrategy(List<JLabel> letras){
        positioningStrategy.positioningLetters(letras);
    }
}