package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;



public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<Contato> getLista() {
		String sql = "select * from contatos";
		try {
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Contato> contatos = new ArrayList<Contato>();
			while(rs.next()){
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setId(rs.getLong("id"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			rs.close();
			rs.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void adiciona(Contato cont) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, cont.getNome());
			ps.setString(2, cont.getEmail());
			ps.setString(3, cont.getEndereco());
			ps.setDate(4, new Date(cont.getDataNascimento().getTimeInMillis()));
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
