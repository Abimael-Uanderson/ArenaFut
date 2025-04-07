/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.arenafut.dao;

/**
 *
 * @author abima
 */


import br.com.abimaelcristovao.arenafut.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaPartidaDAO {

    public void adicionarPessoaNaPartida(int idPessoa, int idPartida) throws SQLException {
        String sql = "INSERT INTO pessoa_partida (id_pessoa, id_partida) VALUES (?, ?)";
        
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, idPessoa);
            stmt.setInt(2, idPartida);
            stmt.executeUpdate();
        }
    }

    public void removerPessoaDaPartida(int idPessoa, int idPartida) throws SQLException {
        String sql = "DELETE FROM pessoa_partida WHERE id_pessoa = ? AND id_partida = ?";
        
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, idPessoa);
            stmt.setInt(2, idPartida);
            stmt.executeUpdate();
        }
    }

    public List<Integer> listarPessoasPorPartida(int idPartida) throws SQLException {
        String sql = "SELECT id_pessoa FROM pessoa_partida WHERE id_partida = ?";
        List<Integer> jogadores = new ArrayList<>();

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, idPartida);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                jogadores.add(rs.getInt("id_pessoa"));
            }
        }
        
        return jogadores;
    }

    public List<Integer> listarPartidasPorPessoa(int idPessoa) throws SQLException {
        String sql = "SELECT id_partida FROM pessoa_partida WHERE id_pessoa = ?";
        List<Integer> partidas = new ArrayList<>();

        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, idPessoa);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                partidas.add(rs.getInt("id_partida"));
            }
        }
        
        return partidas;
    }
}

