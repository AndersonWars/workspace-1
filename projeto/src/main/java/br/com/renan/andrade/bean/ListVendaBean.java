package br.com.renan.andrade.bean;

import java.io.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;

import org.omnifaces.util.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ListVendaBean implements Serializable {
	
	public List<Venda> vendas;
	public List<ItemVenda> itensVenda;
	
	@PostConstruct
	public void list() {
		try {
			vendas = new VendaDao().buscaPorCliente(SessionContext.getInstance().getClienteSessao());
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao carregar lista de vendas");
		}
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
}
