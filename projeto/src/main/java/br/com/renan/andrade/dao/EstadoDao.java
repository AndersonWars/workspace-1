package br.com.renan.andrade.dao;

import org.hibernate.*;
import org.hibernate.criterion.*;

import br.com.renan.andrade.domain.Estado;
import br.com.renan.andrade.util.*;

public class EstadoDao extends GenericDao<Estado>{
	
	public Estado buscaPorSigla(String uf) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Estado estado = null;
		try {
			Criteria criteria = sessao.createCriteria(Estado.class);
			criteria.add(Restrictions.eq("sigla", uf));
			estado = (Estado)criteria.uniqueResult();
			return estado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sessao.close();
		}
		
		
	}

}
