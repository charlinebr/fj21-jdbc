package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Caelum2");
		contato.setEmail("email@contato.com");
		contato.setEndereco("Rua qualquer");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.adiciona(contato);
		
		System.out.println("Gravou");
		
	}
}
