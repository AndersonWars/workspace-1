package br.com.renan.andrade.bean;

import java.io.Serializable;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
	
	private Cliente cliente;
	private List<Estado> estados;
	
	@PostConstruct
	public void novo() {
		cliente = new Cliente();
		cliente.setEnderecoCliente(new Endereco());
		try {
			estados = new EstadoDao().listarTodos();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar UFs");
			e.printStackTrace();
		}
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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
}
