package swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculadora extends JFrame implements ActionListener{
	private JLabel n1, n2, resultado;
	private JButton soma, subtracao, multiplicacao, divisao;
	private JTextField num1, num2, resp;
	
	public Calculadora(){
		super("Calculadora");
		JPanel painel = new JPanel(new GridLayout(5, 2, 2, 5));
		
		n1 = new JLabel("N1");
		n1.setForeground(Color.BLUE);
		n2 = new JLabel("N2");
		n2.setForeground(Color.BLUE);
		resultado = new JLabel("Resultado");
		resultado.setForeground(Color.BLUE);
		
		soma = new JButton(new ImageIcon("src/imgs/add.png"));
		soma.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
		subtracao = new JButton(new ImageIcon("src/imgs/substract.png"));
		subtracao.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
		multiplicacao = new JButton(new ImageIcon("src/imgs/multiply.png"));
		multiplicacao.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
		divisao = new JButton(new ImageIcon("src/imgs/division.png"));
		divisao.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
		
		soma.addActionListener(this);
		subtracao.addActionListener(this);
		multiplicacao.addActionListener(this);
		divisao.addActionListener(this);
		
		num1 = new JTextField(5);
		num2 = new JTextField(5);
		resp = new JTextField(5);
		resp.setEditable(false);
		
		painel.add(n1);
		painel.add(num1);
		painel.add(n2);
		painel.add(num2);
		painel.add(soma);
		painel.add(subtracao);
		painel.add(multiplicacao);
		painel.add(divisao);
		painel.add(resultado);
		painel.add(resp);
		
		setContentPane(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(100,215);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Calculadora();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(null, "ok");
		double n1 = Double.parseDouble(num1.getText());
		double n2 = Double.parseDouble(num2.getText());
		double res = 0;
		if (e.getSource() == soma) 
			res = n1+n2;
		if (e.getSource() == subtracao) 
			res = n1-n2;
		if (e.getSource() == multiplicacao) 
			res = n1*n2;
		if (e.getSource() == divisao) 
			res = n1/n2;
		resp.setText(res+"");
	}

}
