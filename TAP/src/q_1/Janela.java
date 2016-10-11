package q_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener{
	JTextField qtd, tempo, produzidos;
	JProgressBar barra;
	JButton inicia;
	
	public Janela() {
		super("Questão 1");
		
		JPanel painel = new JPanel(new BorderLayout());
		JPanel pNorte = new JPanel(new GridLayout(3, 2, 5, 15));
		JPanel pCentro = new JPanel(new GridLayout(1, 3));
		JPanel pSul = new JPanel(new GridLayout(2, 1, 2, 15));
		
		JLabel qt = new JLabel("Quantidade");
		JLabel time = new JLabel("Tempo(segundos)");
		JLabel branco = new JLabel("   ");
		JLabel blank = new JLabel("   ");
		
		qtd = new JTextField(5);
		tempo = new JTextField(5);
		produzidos = new JTextField(25);
		produzidos.setEditable(false);
		
		barra = new JProgressBar();
		
		inicia = new JButton("Inicia");
		inicia.addActionListener(this);
		
		pNorte.add(qt);
		pNorte.add(qtd);
		pNorte.add(time);
		pNorte.add(tempo);
		pNorte.add(inicia);
		pCentro.add(branco);
		pCentro.add(blank);
		pCentro.setPreferredSize(new Dimension(15, 15));
		pSul.add(barra);
		pSul.add(produzidos);
		painel.add(pNorte, BorderLayout.NORTH);
		painel.add(pCentro, BorderLayout.CENTER);
		painel.add(pSul, BorderLayout.SOUTH);
		
		setContentPane(painel);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Janela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ThreadDaJanela thrd = new ThreadDaJanela(Integer.parseInt(qtd.getText()), Integer.parseInt(tempo.getText()), barra, produzidos);
		if (e.getSource().equals(inicia)){
			thrd.start();
		}
	}
}
