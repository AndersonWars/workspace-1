package thread;

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
public class JanelaThread extends JFrame implements ActionListener{
	private JLabel trb1, trb2;
	private JTextField qt1, qt2, tempo1, tempo2;
	private JProgressBar barra1, barra2;
	private JButton semT, comT;
	
	public JanelaThread(){
		super("Exemplo thread");
		JPanel painel = new JPanel(new GridLayout(7, 2, 0, 10));
		
		trb1 = new JLabel("Trabalhador 1");
		trb2 = new JLabel("Trabalhador 2");
		
		JLabel qtI = new JLabel("QT");
		JLabel qtII = new JLabel("QT");
		JLabel time1 = new JLabel("Tempo");
		JLabel time2 = new JLabel("Tempo");
		
		tempo1 = new JTextField(10);
		tempo2 = new JTextField(10);
		
		qt1 = new JTextField(10);
		qt2 = new JTextField(10);
		
		semT = new JButton("SEM Thread");
		semT.addActionListener(this);
		comT = new JButton("COM Thread");
		comT.addActionListener(this);
		
		barra1 = new JProgressBar();
		barra2 = new JProgressBar();
		
		painel.add(trb1);
		painel.add(barra1);
		painel.add(qtI);
		painel.add(qt1);
		painel.add(time1);
		painel.add(tempo1);
		painel.add(trb2);
		painel.add(barra2);
		painel.add(qtII);
		painel.add(qt2);
		painel.add(time2);
		painel.add(tempo2);
		painel.add(comT);
		painel.add(semT);
		
		setContentPane(painel);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JanelaThread();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int q1 = Integer.parseInt(qt1.getText());
		int q2 = Integer.parseInt(qt2.getText());
		int t1 = Integer.parseInt(tempo1.getText());
		int t2 = Integer.parseInt(tempo2.getText());
		
		Trabalhador trab1 = new Trabalhador(q1, t1, barra1);
		Trabalhador trab2 = new Trabalhador(q2, t2, barra2);
		
		if(e.getSource()==semT){
			trab1.run();
			trab2.run();
		}else{
			trab1.start();
			trab2.start();
		}
	}
}
