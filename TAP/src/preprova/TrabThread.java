package preprova;

import javax.swing.JProgressBar;

public class TrabThread extends Thread {
	JProgressBar barra;
	int qt, tempo;
	
	public TrabThread(String qt, String tempo, JProgressBar barra) {
		this.qt = Integer.parseInt(qt);
		this.tempo = Integer.parseInt(tempo);
		this.barra = barra;
		barra.setMaximum(this.qt);
		barra.setValue(0);
	}
	
	@Override
	public void run() {
		for(int i=0;i<qt;i++){
			barra.setValue(i+1);
			try{
				sleep(tempo);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
