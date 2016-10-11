package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ExemploLayout extends JFrame {
	
	public ExemploLayout(){
		super("Exemplo Layouts");
		JPanel painelBase = new JPanel(new BorderLayout());
		JPanel painelNorte = new JPanel();
		JPanel painelOeste = new JPanel(new GridLayout(5, 1, 1, 2));
		JPanel painelLeste = new JPanel(new GridLayout(2, 2));
		
		JLabel lblnome = new JLabel("Nome");
		JTextField txtnome = new JTextField(20);
		painelNorte.add(lblnome);
		painelNorte.add(txtnome);
		
		JButton bt1 = new JButton("Opção 1");
		JButton bt2 = new JButton("Opção 2");
		JButton bt3 = new JButton("Opção 3");
		JButton bt4 = new JButton("Opção 4");
		JButton bt5 = new JButton("Opção 5");
		painelOeste.add(bt1);
		painelOeste.add(bt2);
		painelOeste.add(bt3);
		painelOeste.add(bt4);
		painelOeste.add(bt5);
		
		JCheckBox ck1 = new JCheckBox("OP1");
		JCheckBox ck2 = new JCheckBox("OP2");
		JCheckBox ck3 = new JCheckBox("OP3");
		JCheckBox ck4 = new JCheckBox("OP4");
		painelLeste.add(ck1);
		painelLeste.add(ck2);
		painelLeste.add(ck3);
		painelLeste.add(ck4);
		
		JLabel imgCentro = new JLabel(new ImageIcon("src/imgs/duck.png"));
		JLabel lblData = new JLabel("Tubarão, 12 de agosto de 2016");
		
		painelBase.add(painelNorte, BorderLayout.NORTH);
		painelBase.add(painelOeste, BorderLayout.WEST); 
		painelBase.add(painelLeste, BorderLayout.EAST);
		painelBase.add(imgCentro, BorderLayout.CENTER);
		painelBase.add(lblData, BorderLayout.SOUTH);
		setContentPane(painelBase);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ExemploLayout();
	}
}
