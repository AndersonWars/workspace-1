package br.com.renan.andrade.dao;

import org.hibernate.*;
import org.hibernate.criterion.*;

import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

public class UsuarioDao extends GenericDao<Usuario> {
	
	public Usuario procuraUsuario(String login, String senha) throws Exception{
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Usuario user = null;
		Criteria criterio = session.createCriteria(Usuario.class);
		criterio.add(Restrictions.eq("dsLogin", login));
		criterio.add(Restrictions.eq("dsSenha", senha));
		user = (Usuario)criterio.uniqueResult();
		return user;
	}

}
