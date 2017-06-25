package br.com.renan.andrade.dao;

import org.hibernate.*;
import org.hibernate.criterion.*;

import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

public class ClienteDao extends GenericDao<Cliente> {
	
	public Cliente buscaPorUsuario(Long cdUser) throws Exception{
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria criterio = sessao.createCriteria(Cliente.class);
		criterio.add(Restrictions.eq("user.cdUsuario", cdUser));
		return (Cliente)criterio.uniqueResult();
	}
	
	public boolean clienteExiste(Long cdCliente) {
		try {
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			Criteria criteria = sessao.createCriteria(Cliente.class);
			criteria.add(Restrictions.eq("codCliente", cdCliente));
			return criteria.uniqueResult() != null;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
