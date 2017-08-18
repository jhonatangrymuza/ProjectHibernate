package br.univel.dao;

import br.univel.dao.hb.ContatoDaoHibernate;
import br.univel.dao.jdbc.ContatoDaoJDBC;

public class ContatoDaoFactory {
	public static ContatoDaoIF criar() {
		
		String par = lerParametro();
		if(par.equals("hibernate")){
			return new ContatoDaoHibernate();
		}else{
			return new ContatoDaoJDBC();
		}
	}

	private static String lerParametro() {
		return "hibernet";
	}
}
