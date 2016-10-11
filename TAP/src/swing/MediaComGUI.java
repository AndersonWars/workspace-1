package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MediaComGUI extends JFrame implements ActionListener {
	private JTextField nome, n1, n2, n3, n4;
	private JTextArea lista;
	private JButton inserir;
	private String txt = "";
	
	public MediaComGUI(){
		super("Cálculo de Médias");
		
		JPanel painel = new JPanel(new BorderLayout());
		JPanel painelTop = new JPanel();
		JPanel painelMiddle = new JPanel(new GridLayout(5,3));
		JPanel painelBottom = new JPanel(new GridLayout(2, 1));
		
		JLabel name = new JLabel("Nome");
		JLabel nota1 = new JLabel("Nota 1");
		JLabel nota2 = new JLabel("Nota 2");
		JLabel nota3 = new JLabel("Nota 3");
		JLabel nota4 = new JLabel("Nota 4");
		JLabel p1 = new JLabel("30%");
		JLabel p3 = new JLabel("30%");
		JLabel p2 = new JLabel("30%");
		JLabel p4 = new JLabel("10%");
		
		nome = new JTextField(40);
		n1 = new JTextField(4);
		n2 = new JTextField(4);
		n3 = new JTextField(4);
		n4 =new JTextField(4);
		
		lista = new JTextArea(15, 15);
		lista.setEditable(true);
		
		inserir = new JButton("Inserir");
		inserir.addActionListener(this);
		
		JScrollPane rolamento = new JScrollPane(lista);
		rolamento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rolamento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		painelTop.add(name);
		painelTop.add(nome);
		painelMiddle.add(nota1);
		painelMiddle.add(n1);
		painelMiddle.add(p1);
		painelMiddle.add(nota2);
		painelMiddle.add(n2);
		painelMiddle.add(p2);
		painelMiddle.add(nota3);
		painelMiddle.add(n3);
		painelMiddle.add(p3);
		painelMiddle.add(nota4);
		painelMiddle.add(n4);
		painelMiddle.add(p4);
		painelMiddle.add(inserir);
		painelBottom.add(rolamento);
		
		painel.add(painelTop, BorderLayout.NORTH);
		painel.add(painelMiddle, BorderLayout.CENTER);
		painel.add(painelBottom, BorderLayout.SOUTH);
		
		
		setContentPane(painel);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MediaComGUI();
	}
	
	public String estado(double media){
		if (media>=7)
			return "Aprovado";
		else if (media>=3)
			return "Recuperação";
		return "Reprovado";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double media = ((Double.parseDouble(n1.getText())*30)+(Double.parseDouble(n2.getText())*30)+(Double.parseDouble(n3.getText())*30)+(Double.parseDouble(n4.getText())*10))/100;
		if (e.getSource() == inserir){
			txt += nome.getText()+" - "+media+" - "+estado(media)+"\n";
		}
		lista.setText(txt);
	}

}
