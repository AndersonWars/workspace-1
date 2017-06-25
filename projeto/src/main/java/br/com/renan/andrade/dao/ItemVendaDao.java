package br.com.renan.andrade.dao;

import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.*;

import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

public class ItemVendaDao extends GenericDao<ItemVenda> {
	
	@SuppressWarnings("unchecked")
	public List<ItemVenda> buscaPorVenda(Venda venda) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Criteria criteria = sessao.createCriteria(ItemVenda.class);
		criteria.add(Restrictions.eq("codVenda.codVenda", venda.getCodVenda()));
		return criteria.list();
	}

}
