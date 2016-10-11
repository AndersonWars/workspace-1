package barbeiro;

public class Principal {
	public static void main(String[] args) {
		Barbeiro barberiro1 = new Barbeiro("João", 2, 5);
		Thread threadbarbeiro1 = new Thread(barberiro1);
		threadbarbeiro1.start();
	}
}
