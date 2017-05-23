package br.com.renan.andrade.dao;

import org.hibernate.*;
import org.hibernate.criterion.*;

import br.com.renan.andrade.domain.*;
import br.com.renan.andrade.util.*;

public class UsuarioDao extends GenericDao<Usuario> {
	
	public Usuario procuraUsuario(Usuario usuario) throws Exception{
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		Usuario user = null;
		Criteria criterio = session.createCriteria(Usuario.class);
		criterio.add(Restrictions.eq("dsLogin", usuario.getDsLogin()));
		criterio.add(Restrictions.eq("dsSenha", usuario.getDsSenha()));
		user = (Usuario)criterio.uniqueResult();
		return user;
	}

}
