package farmacia;

public class Perfumaria extends Produto {
	
	@Override
	public boolean venda(int qt, Cliente c) {
		if (qt <= getEstoque() && c.getDivida() < 100)
			return super.venda(qt, c);
		return false;
	}
}
