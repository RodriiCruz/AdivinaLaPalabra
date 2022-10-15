package adivinaLaPalabra;

import java.awt.EventQueue;

import adivinaLaPalabra.view.MainView;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new MainView().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
