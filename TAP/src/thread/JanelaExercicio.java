package thread;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class JanelaExercicio extends JFrame implements ActionListener {
	private JTextField tempo, alarme;
	private JButton iniciar, parar;
	private JPanel painel, painelN, painelS;
	protected static boolean pare;
	
	public JanelaExercicio(){
		super("Exercício Thread");
		
		painel = new JPanel(new BorderLayout());
		painelN = new JPanel(new GridLayout(2, 2, 2 , 10));
		painelS = new JPanel(new GridLayout(1, 4, 5, 0));
		
		JLabel time = new JLabel("Tempo (segundos)");
		JLabel alarm = new JLabel("Início Alarme");
		JLabel b1 = new JLabel("   ");
		JLabel b2 = new JLabel("   ");
		
		tempo = new JTextField(10);
		alarme = new JTextField(10);
		
		iniciar = new JButton("Iniciar");
		iniciar.addActionListener(this);
		parar = new JButton("Parar");
		parar.addActionListener(this);
		
		painelN.add(time);
		painelN.add(tempo);
		painelN.add(alarm);
		painelN.add(alarme);
		painelS.add(b1);
		painelS.add(b2);
		painelS.add(iniciar);
		painelS.add(parar);
		
		painel.add(painelN, BorderLayout.NORTH);
		painel.add(painelS, BorderLayout.SOUTH);
		painel.setOpaque(true);

		setContentPane(painel);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JanelaExercicio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int tmp = Integer.parseInt(tempo.getText());
		int alr = Integer.parseInt(alarme.getText());
		Exercicio timer = new Exercicio(tmp, alr, tempo, alarme, painel, painelN, painelS);
			if(e.getSource()==iniciar){
				pare = false;
				timer.start();
			}if(e.getSource()==parar){
				pare = true;
			}
	}
}
