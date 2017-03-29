package br.com.renan.andrade.main;

import java.util.ArrayList;

import org.hibernate.Session;

import br.com.renan.andrade.dao.EstadoDao;
import br.com.renan.andrade.domain.Estado;
import br.com.renan.andrade.util.HibernateUtil;

public class HibernateUtilTest {
	
	public static void main(String[] args) {
//		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
//		sessao.close();
//		HibernateUtil.getFabricaDeSessoes().close();
		
		EstadoDao dao = new EstadoDao();
		ArrayList<Estado> lista = (ArrayList<Estado>)dao.listarTodos();
		for (Estado e : lista) {
			System.out.println(e.getNome());
		}
	
	}
}
