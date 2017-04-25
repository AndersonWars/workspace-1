package br.com.renan.andrade.bean;

import java.io.Serializable;

import javax.annotation.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.*;
import org.omnifaces.util.Messages.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
	
	private Cliente cliente;
	
	@PostConstruct
	public void novo() {
		cliente = new Cliente();
	}
	
	public void salvar() {
		ClienteDao dao = new ClienteDao();
		try {
			dao.merge(getCliente());
			Messages.addGlobalInfo("Cliente "+getCliente().getNomeCliente()+" cadastrado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
