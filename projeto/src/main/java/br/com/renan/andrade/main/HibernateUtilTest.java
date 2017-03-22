package br.com.renan.andrade.main;

import org.hibernate.Session;

import br.com.renan.andrade.util.HibernateUtil;

public class HibernateUtilTest {
	
	public static void main(String[] args) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
