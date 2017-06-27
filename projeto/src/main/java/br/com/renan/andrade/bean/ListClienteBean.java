package br.com.renan.andrade.bean;

import java.io.*;
import java.util.*;

import javax.annotation.*;
import javax.faces.bean.*;
import javax.faces.event.*;

import org.omnifaces.util.*;

import br.com.renan.andrade.dao.*;
import br.com.renan.andrade.domain.*;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ListClienteBean implements Serializable {
	
	private List<Cliente> clientes;
	
	@PostConstruct
	public void inic() {
		clientes = new ClienteDao().listarTodos();
	}
	
	public void excluir(ActionEvent event) {
		Cliente cliente = (Cliente)event.getComponent().getAttributes().get("cliE");
		try {
			new ClienteDao().excluir(cliente);
			new UsuarioDao().excluir(cliente.getUser());
			Messages.addGlobalInfo("Cliente excluído");
		} catch (Exception e) {
			e.printStackTrace();
			Messages.addGlobalError("Erro ao excluir cliente");
		}
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
