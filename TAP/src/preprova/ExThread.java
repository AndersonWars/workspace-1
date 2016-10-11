package preprova;

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
public class ExThread extends JFrame implements ActionListener {
	JProgressBar trab1, trab2;
	JTextField qt1, qt2, tempo1, tempo2;
	JButton bt;
	
	public ExThread() {
		JPanel painel = new JPanel(new GridLayout(7,2,5,5));
		
		JLabel tr1 = new JLabel("Trabalhador 1");
		JLabel tr2 = new JLabel("Trabalhador 2");
		JLabel tm1 = new JLabel("Tempo");
		JLabel tm2 = new JLabel("Tempo");
		JLabel qtI = new JLabel("Qt");
		JLabel qtII = new JLabel("Qt");
		
		qt1 = new JTextField();
		qt2 = new JTextField();
		tempo1 = new JTextField();
		tempo2 = new JTextField();
		
		bt = new JButton("Inicio");
		bt.addActionListener(this);
		
		trab1 = new JProgressBar();
		trab2 = new JProgressBar();
		
		painel.add(tr1);
		painel.add(trab1);
		painel.add(tm1);
		painel.add(tempo1);
		painel.add(qtI);
		painel.add(qt1);
		painel.add(tr2);
		painel.add(trab2);
		painel.add(tm2);
		painel.add(tempo2);
		painel.add(qtII);
		painel.add(qt2);
		painel.add(bt);
		
		setContentPane(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new ExThread();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		TrabThread tr1 = new TrabThread(qt1.getText(), tempo1.getText(), trab1);
		TrabThread tr2 = new TrabThread(qt2.getText(), tempo2.getText(), trab2);
		if(e.getSource().equals(bt)){
			tr1.start();
			tr2.start();
		}
	}
	
	
}
