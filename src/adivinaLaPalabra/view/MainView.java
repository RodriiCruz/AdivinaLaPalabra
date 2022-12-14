package adivinaLaPalabra.view;

import static adivinaLaPalabra.util.Constant.DEFINICION;
import static adivinaLaPalabra.util.Constant.DEFINICIONES;
import static adivinaLaPalabra.util.Constant.ESPACIO_VACIO;
import static adivinaLaPalabra.util.Constant.FUENTE;
import static adivinaLaPalabra.util.Constant.GANASTE;
import static adivinaLaPalabra.util.Constant.INTENTOS;
import static adivinaLaPalabra.util.Constant.PERDISTE;
import static adivinaLaPalabra.util.Constant.PUNTAJE;
import static adivinaLaPalabra.util.Constant.REINICIAR;
import static adivinaLaPalabra.util.Constant.SALIR;
import static adivinaLaPalabra.util.Constant.TITULO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import adivinaLaPalabra.model.Game;
import adivinaLaPalabra.patterns.strategy.Context;
import adivinaLaPalabra.patterns.strategy.IPositioningStrategy;
import adivinaLaPalabra.patterns.strategy.LongWord;
import adivinaLaPalabra.patterns.strategy.MiddleWord;
import adivinaLaPalabra.patterns.strategy.ShortWord;

/**
 *
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class MainView extends JFrame {

	private Game juego;
	private JPanel contentPane;
	private JPanel panelDefiniciones;
	private JTextArea txtDefinicion;
	private JLabel lblValorPuntaje;
	private JLabel lblValorIntentos;
	private List<JButton> botonesPresionados;
	private List<JLabel> letras;
	private String palabra;

	public MainView() {
		botonesPresionados = new ArrayList<>();
		letras = new ArrayList<>();

		for (int i = 0; i < 7; i++) {
			letras.add(new JLabel());
		}

		inicializarPaneles();
		inicializarBotones();
		inicializarLetras();
		inicializarLabels();
		inicializarJuego();
	}

	private void inicializarPaneles() {
		setResizable(false);
		setTitle(TITULO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		panelDefiniciones = new JPanel();
		panelDefiniciones.setBackground(Color.WHITE);
		panelDefiniciones.setBounds(10, 11, 538, 135);
		getContentPane().add(panelDefiniciones);
		panelDefiniciones.setLayout(null);
	}

	private void inicializarLabels() {
		txtDefinicion = new JTextArea();
		txtDefinicion.setLineWrap(true);
		txtDefinicion.setWrapStyleWord(true);
		txtDefinicion.setEditable(false);
		txtDefinicion.setBounds(0, 73, 538, 59);
		panelDefiniciones.add(txtDefinicion);

		JLabel lblPuntaje = new JLabel(PUNTAJE);
		lblPuntaje.setFont(new Font(FUENTE, Font.PLAIN, 15));
		lblPuntaje.setBounds(31, 293, 100, 25);
		contentPane.add(lblPuntaje);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(10, 281, 538, 9);
		contentPane.add(separator2);

		JSeparator separator1 = new JSeparator();
		separator1.setBounds(10, 149, 538, 9);
		contentPane.add(separator1);

		JLabel lblIntentos = new JLabel(INTENTOS);
		lblIntentos.setFont(new Font(FUENTE, Font.PLAIN, 15));
		lblIntentos.setBounds(162, 293, 100, 25);
		contentPane.add(lblIntentos);

		lblValorPuntaje = new JLabel("0");
		lblValorPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorPuntaje.setHorizontalTextPosition(SwingConstants.CENTER);
		lblValorPuntaje.setFont(new Font(FUENTE, Font.PLAIN, 15));
		lblValorPuntaje.setBounds(82, 293, 49, 25);
		contentPane.add(lblValorPuntaje);

		lblValorIntentos = new JLabel("5");
		lblValorIntentos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblValorIntentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorIntentos.setFont(new Font(FUENTE, Font.PLAIN, 15));
		lblValorIntentos.setBounds(217, 293, 45, 25);
		contentPane.add(lblValorIntentos);
	}

	private IPositioningStrategy getStrategy(int longitud) {
		IPositioningStrategy estrategia = null;
		switch (juego.getPalabra().length) {
		case 5:
			estrategia = new ShortWord();
			break;
		case 6:
			estrategia = new MiddleWord();
			break;
		case 7:
			estrategia = new LongWord();
			break;
		}

		return estrategia;
	}

	private void inicializarJuego() {
		int indice = (int) (Math.random() * 12);
		palabra = DEFINICIONES.get(indice).getPalabra();

		juego = new Game();
		juego.setPalabra(palabra.toCharArray());
		juego.setDefinicion(DEFINICIONES.get(indice).getDefinicion());

		IPositioningStrategy posicionamientoLetras = getStrategy(juego.getPalabra().length);
		Context contexto = new Context(posicionamientoLetras);
		contexto.executeStrategy(letras);

		txtDefinicion.setText(DEFINICION + juego.getDefinicion());
	}

	private void inicializarBotones() {
		JButton btnReiniciar = new JButton(REINICIAR);
		btnReiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciarJuego();
			}
		});
		btnReiniciar.setBounds(293, 294, 100, 23);
		contentPane.add(btnReiniciar);

		JButton btnSalir = new JButton(SALIR);
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(424, 294, 100, 23);
		contentPane.add(btnSalir);

		JButton btnQ = new JButton("Q");
		btnQ.addActionListener(getActionListener('Q', btnQ));
		btnQ.setBounds(10, 157, 45, 30);
		contentPane.add(btnQ);

		JButton btnW = new JButton("W");
		btnW.addActionListener(getActionListener('W', btnW));
		btnW.setBounds(65, 157, 46, 30);
		contentPane.add(btnW);

		JButton btnE = new JButton("E");
		btnE.addActionListener(getActionListener('E', btnE));
		btnE.setBounds(120, 157, 45, 30);
		contentPane.add(btnE);

		JButton btnR = new JButton("R");
		btnR.addActionListener(getActionListener('R', btnR));
		btnR.setBounds(175, 157, 45, 30);
		contentPane.add(btnR);

		JButton btnT = new JButton("T");
		btnT.addActionListener(getActionListener('T', btnT));
		btnT.setBounds(230, 157, 45, 30);
		contentPane.add(btnT);

		JButton btnY = new JButton("Y");
		btnY.addActionListener(getActionListener('Y', btnY));
		btnY.setBounds(285, 157, 45, 30);
		contentPane.add(btnY);

		JButton btnU = new JButton("U");
		btnU.addActionListener(getActionListener('U', btnU));
		btnU.setBounds(340, 157, 45, 30);
		contentPane.add(btnU);

		JButton btnI = new JButton("I");
		btnI.addActionListener(getActionListener('I', btnI));
		btnI.setBounds(395, 157, 45, 30);
		contentPane.add(btnI);

		JButton btnO = new JButton("O");
		btnO.addActionListener(getActionListener('O', btnO));
		btnO.setBounds(450, 157, 45, 30);
		contentPane.add(btnO);

		JButton btnP = new JButton("P");
		btnP.addActionListener(getActionListener('P', btnP));
		btnP.setBounds(505, 157, 45, 30);
		contentPane.add(btnP);

		JButton btn?? = new JButton("??");
		btn??.addActionListener(getActionListener('??', btn??));
		btn??.setBounds(505, 198, 45, 30);
		contentPane.add(btn??);

		JButton btnL = new JButton("L");
		btnL.addActionListener(getActionListener('L', btnL));
		btnL.setBounds(450, 198, 45, 30);
		contentPane.add(btnL);

		JButton btnK = new JButton("K");
		btnK.addActionListener(getActionListener('K', btnK));
		btnK.setBounds(395, 198, 45, 30);
		contentPane.add(btnK);

		JButton btnJ = new JButton("J");
		btnJ.addActionListener(getActionListener('J', btnJ));
		btnJ.setBounds(340, 198, 45, 30);
		contentPane.add(btnJ);

		JButton btnH = new JButton("H");
		btnH.addActionListener(getActionListener('H', btnH));
		btnH.setBounds(285, 198, 45, 30);
		contentPane.add(btnH);

		JButton btnG = new JButton("G");
		btnG.addActionListener(getActionListener('G', btnG));
		btnG.setBounds(230, 198, 45, 30);
		contentPane.add(btnG);

		JButton btnF = new JButton("F");
		btnF.addActionListener(getActionListener('F', btnF));
		btnF.setBounds(175, 198, 45, 30);
		contentPane.add(btnF);

		JButton btnD = new JButton("D");
		btnD.addActionListener(getActionListener('D', btnD));
		btnD.setBounds(120, 198, 45, 30);
		contentPane.add(btnD);

		JButton btnS = new JButton("S");
		btnS.addActionListener(getActionListener('S', btnS));
		btnS.setBounds(65, 198, 45, 30);
		contentPane.add(btnS);

		JButton btnA = new JButton("A");
		btnA.addActionListener(getActionListener('A', btnA));
		btnA.setBounds(10, 198, 45, 30);
		contentPane.add(btnA);

		JButton btnZ = new JButton("Z");
		btnZ.addActionListener(getActionListener('Z', btnZ));
		btnZ.setBounds(93, 239, 45, 30);
		contentPane.add(btnZ);

		JButton btnX = new JButton("X");
		btnX.addActionListener(getActionListener('X', btnX));
		btnX.setBounds(148, 239, 45, 30);
		contentPane.add(btnX);

		JButton btnC = new JButton("C");
		btnC.addActionListener(getActionListener('C', btnC));
		btnC.setBounds(203, 239, 45, 30);
		contentPane.add(btnC);

		JButton btnV = new JButton("V");
		btnV.addActionListener(getActionListener('V', btnV));
		btnV.setBounds(258, 239, 45, 30);
		contentPane.add(btnV);

		JButton btnB = new JButton("B");
		btnB.addActionListener(getActionListener('B', btnB));
		btnB.setBounds(313, 239, 45, 30);
		contentPane.add(btnB);

		JButton btnN = new JButton("N");
		btnN.addActionListener(getActionListener('N', btnN));
		btnN.setBounds(368, 239, 45, 30);
		contentPane.add(btnN);

		JButton btnM = new JButton("M");
		btnM.addActionListener(getActionListener('M', btnM));
		btnM.setBounds(423, 239, 45, 30);
		contentPane.add(btnM);
	}

	private void inicializarLetras() {
		letras.stream().forEach(lbl -> {
			lbl.setText(ESPACIO_VACIO);
			lbl.setFont(new Font(FUENTE, Font.PLAIN, 20));
			panelDefiniciones.add(lbl);
		});
	}

	private ActionListener getActionListener(char letra, JButton boton) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean acierto = false;
				for (int i = 0; i < juego.getPalabra().length; i++) {
					if (juego.getPalabra()[i] == letra) {
						acierto = true;
						juego.setAciertos(juego.getAciertos() + 1);
						juego.setPuntaje(juego.getPuntaje() + 10);

						setLetraAcertada(i, letra);

						boton.setEnabled(false);
						botonesPresionados.add(boton);
					}
				}

				if (!acierto) {
					juego.setIntentos(juego.getIntentos() - 1);
					juego.setPuntaje(juego.getPuntaje() - 2);
					lblValorIntentos.setText(String.valueOf(juego.getIntentos()));
				}

				lblValorPuntaje.setText(String.valueOf(juego.getPuntaje()));
				comprobarPartida();
			}
		};
	}

	private void setLetraAcertada(int posicion, char letra) {
		letras.get(posicion).setText(String.valueOf(letra));
	}

	private void comprobarPartida() {
		if (juego.getAciertos() == juego.getPalabra().length) {
			JOptionPane.showMessageDialog(null, GANASTE);
			reiniciarJuego();
		}

		if (juego.getIntentos() == 0) {
			JOptionPane.showMessageDialog(null, PERDISTE + palabra);
			reiniciarJuego();
		}
	}

	private void reiniciarJuego() {
		inicializarJuego();

		letras.stream().forEach(letra -> letra.setText(ESPACIO_VACIO));
		botonesPresionados.stream().forEach(boton -> boton.setEnabled(true));

		lblValorIntentos.setText(String.valueOf(juego.getIntentos()));
		lblValorPuntaje.setText(String.valueOf(juego.getPuntaje()));
	}
}
