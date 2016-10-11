package heranca;

import javax.swing.JOptionPane;

public class Perfumaria extends Produto {
	
	@Override
	public boolean vender(Cliente c, int qt) {
		if (c.getDivida() > 200){
			JOptionPane.showMessageDialog(null,"Venda não pode ser efetuada.\nDivida excede R$200,00");
			return false;
		}
		else
			return super.vender(c, qt);
	}
}
