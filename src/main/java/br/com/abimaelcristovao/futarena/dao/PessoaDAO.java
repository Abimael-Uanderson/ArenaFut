/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.futarena.dao;

/**
 *
 * @author abima
 */



import br.com.abimaelcristovao.futarena.enums.TipoJogador;
import br.com.abimaelcristovao.futarena.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Conexao;

public class PessoaDAO {

    
    public void inserir(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoas (nome, email, senha, posicao, nivel) VALUES (?, ?, ?, ?, ?)";
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
        String sql = "UPDATE pessoas SET nome = ?, email = ?, senha = ?, posicao = ?, nivel = ? WHERE id_pessoa = ?";
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
        String sql = "DELETE FROM pessoas WHERE id_pessoa = ?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.executeUpdate();
        }
    }

   
    public Pessoa buscarPorId(int idPessoa) throws SQLException {
        String sql = "SELECT * FROM pessoas WHERE id_pessoa = ?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setPosicao(TipoJogador.valueOf(rs.getString("posicao")));
                pessoa.setNivel(rs.getInt("nivel"));
                return pessoa;
            }
        }
        return null; 
    }
}
