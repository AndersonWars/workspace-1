package br.com.renan.andrade.util;

import javax.faces.context.*;

import br.com.renan.andrade.domain.*;

public class SessionContext {
	
	private static SessionContext instance;
	
	public static SessionContext getInstance(){
        if (instance == null){
            instance = new SessionContext();
        }
        return instance;
	}
	
	private ExternalContext currentExternalContext(){
        if (FacesContext.getCurrentInstance() == null){
            throw new RuntimeException("Falta uma requisição HTTP");
        }else{
            return FacesContext.getCurrentInstance().getExternalContext();
        }
	}
	
	 public Usuario getUsuarioLogado(){
         return (Usuario) getAttribute("usuarioLogado");
	 }
	 
	 public void setUsuarioLogado(Usuario usuario){
         setAttribute("usuarioLogado", usuario);
	 }
	 
	 public void encerrarSessao(){   
         currentExternalContext().invalidateSession();
	 }
	 
	 public Object getAttribute(String nome){
         return currentExternalContext().getSessionMap().get(nome);
	 }
	 
	 public void setAttribute(String nome, Object valor){
         currentExternalContext().getSessionMap().put(nome, valor);
	 }
	 
	 public Cliente getClienteSessao() {
		return (Cliente) getAttribute("clienteSessao");
	 }
	 
	 public void setClienteSessao(Cliente cliente) {
		 setAttribute("clienteSessao", cliente);
	 }
	
}
