package q_1;

import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ThreadDaJanela extends Thread{
	private int quant, tempo;
	JProgressBar barra;
	JTextField produz;
	
	public ThreadDaJanela(int qtd, int tempo, JProgressBar barra, JTextField prd) {
		this.quant = qtd;
		this.tempo = tempo*1000;
		this.barra = barra;
		barra.setMaximum(qtd);
		barra.setValue(0);
		this.produz = prd;
	}
	
	@Override
	public void run() {
		for(int i=0;i<=quant;i++){
			try{
				produz.setText(i+"");
				barra.setValue(i);
				sleep(tempo);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
