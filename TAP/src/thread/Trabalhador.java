package thread;

import javax.swing.JProgressBar;

public class Trabalhador extends Thread {
	private int qt, tempo;
	private JProgressBar barra;
	
	public Trabalhador(int qt, int tempo, JProgressBar barra) {
		this.qt = qt;
		this.tempo = tempo;
		this.barra = barra;
		this.barra.setMaximum(qt);
		this.barra.setValue(0);
		
	}
	
	@Override
	public void run() {
		for(int i=0;i<qt;i++){
			barra.setValue(i+1);
			try{
				sleep(tempo);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
}
