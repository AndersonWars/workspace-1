package br.com.renan.andrade.dao;

import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.*;

import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

public class VendaDao extends GenericDao<Venda> {
	
	@SuppressWarnings("unchecked")
	public List<Venda> buscaPorCliente(Cliente cliente) throws Exception{
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria criterio = sessao.createCriteria(Venda.class);
		criterio.add(Restrictions.eq("cod_cliente.codCliente", cliente.getCodCliente()));
		return criterio.list();
	}

}
