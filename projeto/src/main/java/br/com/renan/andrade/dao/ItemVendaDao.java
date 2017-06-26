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
	
//	@Override
//	public void excluir(ItemVenda entidade) {
//		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
//		Transaction t = null;
//		try {
//			t = sessao.beginTransaction();
//			Criteria criteria = sessao.createCriteria(ItemVenda.class);
//			criteria.add(Restrictions.eq("cdItem", entidade.getCdItem()));
//			ItemVenda registro = (ItemVenda)criteria.uniqueResult();
//			sessao.delete(registro);
//			t.commit();
//		} catch (Exception e) {
//			if(t!=null){
//				t.rollback();
//			}
//			throw(e);
//		}finally{
//			sessao.close();
//		}
//	}

}
