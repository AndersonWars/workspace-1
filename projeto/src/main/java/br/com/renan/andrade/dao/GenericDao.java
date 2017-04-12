package br.com.renan.andrade.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade)consulta.uniqueResult();
			return resultado;
		} catch (Exception e) {
			throw(e);
		}finally{
			sessao.close();
		}
	}

	public void excluir(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;
		try {
			t = sessao.beginTransaction();
			sessao.delete(entidade);
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
	
	public void merge(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;
		try {
			t = sessao.beginTransaction();
			sessao.merge(entidade);
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

}
