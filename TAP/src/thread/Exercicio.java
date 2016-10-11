package thread;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercicio extends Thread{
	private int temp, alrm;
	private JTextField amarelo, alr;
	protected JPanel panel, p2, p3;
	public static boolean button = false;

	
	public Exercicio(int tempo, int alarme, JTextField yellow,JTextField alm, JPanel painel, JPanel pa2, JPanel pa3){
		this.temp = tempo;
		this.alrm = alarme;
		this.alr = alm;
		this.amarelo = yellow;
		this.panel = painel;
		this.p2 = pa2;
		this.p3 = pa3;
		
	}
	@Override
	public void run(){
		while(!JanelaExercicio.pare){
			if(temp>0){
				temp--;
				try{
					sleep(1000);
					amarelo.setText(""+temp);
					if(temp<=alrm){
						amarelo.setBackground(Color.YELLOW);
					}
					if(temp==0){
						panel.setBackground(Color.RED);
						p2.setBackground(Color.RED);
						p3.setBackground(Color.RED);
						sleep(1000);
						resetaJanela(amarelo, alr);
					}
				}catch(InterruptedException e){
					e.printStackTrace();;
				}
			}
		}
		resetaJanela(amarelo, alr);
	}
	
	public void resetaJanela(JTextField tempo, JTextField alarme){
		tempo.setText("");
		alarme.setText("");
		tempo.setBackground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
	}
	

}


