package br.com.renan.andrade.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.renan.andrade.util.HibernateUtil;

public class GenericDao <Entidade>{
		
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		classe = (Class<Entidade>)((ParameterizedType)getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void Salvar(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;
		try {
			t = sessao.beginTransaction();
			sessao.save(entidade);
			t.commit();
		} catch (Exception e) {
			if(t!=null){
				t.rollback();
			}
			throw(e);
		}finally{
			sessao.close();
		}
	}


	@SuppressWarnings("unchecked")
	public List<Entidade> listarTodos(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (Exception e) {
			throw(e);
		}finally{
			sessao.close();
		}
	}



}

