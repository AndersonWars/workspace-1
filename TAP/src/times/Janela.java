package times;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {
	protected JTextField nome, camisa, gols;
	protected JButton cadastrar, limpar;
	protected JComboBox<String> box;
	protected JLabel output;
	
	public Janela(){
		super("Cadastro de jogadores");
		
		JPanel painel = new JPanel(new BorderLayout());
		JPanel painel1 = new JPanel(new GridLayout(3, 2));
		JPanel painel2 = new JPanel(new GridLayout(1, 4));
		
		JLabel name = new JLabel("Nome");
		JLabel time = new JLabel("Time");
		JLabel shirt = new JLabel("Camisa");
		JLabel goals = new JLabel("Gols");
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(this);
		limpar = new JButton("Limpar");
		limpar.addActionListener(this);
		
		nome = new JTextField(15);
		camisa = new JTextField(5);
		gols = new JTextField(5);
		
		box = new JComboBox<String>(new String[]{"","FC Barcelona", "Bayern Munchen","Borussia Dortmund"});
		
		output = new JLabel("\n\n\n\n\n\n");
		output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output.setBackground(Color.GRAY);
		output.setFont(new Font("arial", Font.BOLD, 20));
		
		painel1.add(name);
		painel1.add(nome);
		painel1.add(time);
		painel1.add(box);
		painel1.add(shirt);
		painel1.add(camisa);
		painel2.add(goals);
		painel2.add(gols);
		painel2.add(cadastrar);
		painel2.add(limpar);
		
		painel.add(painel1, BorderLayout.NORTH);
		painel.add(painel2, BorderLayout.CENTER);
		painel.add(output, BorderLayout.SOUTH);
		
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
		String n;
		int cam, g;
		if (e.getSource() == cadastrar){
			try{
				cam = Integer.parseInt(camisa.getText());
				g = Integer.parseInt(gols.getText());
				n = nome.getText();
				if(n.trim().indexOf(" ")==-1){
					throw new ArrayIndexOutOfBoundsException();
				}
				else if(box.getSelectedItem().equals("")){
					throw new NullPointerException();
				}
				if(cam<0 || g<0){
					throw new NumberFormatException();
				}else {
					output.setText("Cadastro concluído");
				}
			}catch(ArrayIndexOutOfBoundsException err){
				output.setText("Nome não é composto");
			}catch(NullPointerException err){
				output.setText("Não selecionou time");
			}catch(NumberFormatException err){
				output.setText("Número de camisa ou número de gols inválido");
			}catch(Exception err){
				output.setText("Erro não identificado");
			}
		}
		
		if (e.getSource() == limpar){
			nome.setText("");
			box.setSelectedIndex(0);
			camisa.setText("");
			gols.setText("");
			output.setText("Limpo");
		}
	}
	
}


