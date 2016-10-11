package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PrimeiraJanela extends JFrame{
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JTextField txt1, txt2;
	private JPasswordField txt3;
	private JButton bt1, bt2, bt3;
	private JComboBox<String> box;
	private JRadioButton rd1, rd2, rd3, rd4, rd5;
	private ButtonGroup gSexo, gTurno;
	private JCheckBox ck1, ck2, ck3;
	private JTextArea area;
	
	public PrimeiraJanela(){
		super("Exemplo janela");
		JPanel painel = new JPanel();
		lbl1 = new JLabel("Rótulo 1");
		lbl1.setForeground(Color.MAGENTA);
		lbl2 = new JLabel(new ImageIcon("src/imgs/info.png"));
		lbl3 = new JLabel("Sexo");
		lbl4 = new JLabel("Turno");
		
		txt1 = new JTextField(20);
		txt2 = new JTextField("English motherfucker");
		txt2.setBackground(Color.CYAN);
		txt2.setFont(new Font("arial", Font.BOLD, 10));
		txt2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		txt2.setEditable(false);
		txt3 = new JPasswordField(10);
		
		bt1 = new JButton("OK");
		bt2 = new JButton(new ImageIcon("src/imgs/database.png"));
		bt3 = new JButton("What", new ImageIcon("src/imgs/add.png"));
		
		box = new JComboBox<String>(new String[]{"a","b"});
		box.addItem("c");
		box.addItem("d");
		box.addItem("e");
		box.addItem("f");
		box.addItem("g");
		box.setMaximumRowCount(4);
		
		rd1 = new JRadioButton("Masc");
		rd2 = new JRadioButton("Fem");
		rd3 = new JRadioButton("Matutino");
		rd4 = new JRadioButton("Vespertino");
		rd5 = new JRadioButton("Noturno");
		
		gSexo = new ButtonGroup();
		gSexo.add(rd1);
		gSexo.add(rd2);
		
		gTurno = new ButtonGroup();
		gTurno.add(rd3);
		gTurno.add(rd4);
		gTurno.add(rd5);
		
		ck1 = new JCheckBox("Opção 1");
		ck2 = new JCheckBox("Opção 2");
		ck3 = new JCheckBox("Opção 3");
		
		area = new JTextArea(10,10);
		//area.setLineWrap(true);
		
		JScrollPane barra = new JScrollPane(area);
		barra.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//setResizable(false); Não pode aumentar ou diminuir tamanho
		//setAlwaysOnTop(true); Janela sempre no topo de outras aplicações
		painel.add(lbl1);
		painel.add(lbl2);
		painel.add(txt2);
		painel.add(txt1);
		painel.add(txt3);
		painel.add(bt1);
		painel.add(bt2);
		painel.add(bt3);
		painel.add(box);
		painel.add(lbl3);
		painel.add(rd1);
		painel.add(rd2);
		painel.add(lbl4);
		painel.add(rd3);
		painel.add(rd4);
		painel.add(rd5);
		painel.add(ck1);
		painel.add(ck2);
		painel.add(ck3);
		painel.add(barra);
		setContentPane(painel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new PrimeiraJanela();
	}
}
