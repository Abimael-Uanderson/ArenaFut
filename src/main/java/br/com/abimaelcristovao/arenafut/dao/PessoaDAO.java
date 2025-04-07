/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.arenafut.dao;

/**
 *
 * @author abima
 */



import br.com.abimaelcristovao.arenafut.enums.TipoJogador;
import br.com.abimaelcristovao.arenafut.model.Pessoa;
import br.com.abimaelcristovao.arenafut.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    
    public void inserir(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoas (nome, email, senha, tipo_jogador, nivel) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getSenha());
            stmt.setString(4, pessoa.getPosicao().toString());
            stmt.setInt(5, pessoa.getNivel());
            stmt.executeUpdate();
        }
    }
    
    
 

   
   
    public void atualizar(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE pessoas SET nome = ?, email = ?, senha = ?, tipo_jogador = ?, nivel = ? WHERE pessoa_id = ?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getSenha());
            stmt.setString(4, pessoa.getPosicao().toString());
            stmt.setInt(5, pessoa.getNivel());
            stmt.setInt(6, pessoa.getIdPessoa());
            stmt.executeUpdate();
        }
    }

    
    public void deletar(int idPessoa) throws SQLException {
        String sql = "DELETE FROM pessoas WHERE pessoa_id = ?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
        }
    }

   
    public Pessoa buscarPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM pessoas WHERE email = ?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("pessoa_id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setPosicao(TipoJogador.valueOf(rs.getString("tipo_jogador")));
                pessoa.setNivel(rs.getInt("nivel"));
                return pessoa;
            }
        }
        return null; 
    }
}
