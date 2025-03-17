/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.futarena.dao;

/**
 *
 * @author abima
 */

import br.com.abimaelcristovao.futarena.enums.EstadoPartida;
import br.com.abimaelcristovao.futarena.enums.TipoPartida;
import br.com.abimaelcristovao.futarena.model.Partida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import utils.Conexao;




public class PartidaDAO {

    // Inserir nova partida
    public void inserir(Partida partida) throws SQLException {
        String sql = "INSERT INTO partidas (data_hora_partida, quant_jogadores, estado, tipo, codigo, localizacao) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(partida.getDataHoraPartida()));
            stmt.setInt(2, partida.getQuantJogadores());
            stmt.setString(3, partida.getEstado().toString());
            stmt.setString(4, partida.getTipo().toString());
            stmt.setInt(5, partida.getCodigo());
            stmt.setString(6, partida.getLocalizacao());
            stmt.executeUpdate();
        }
    }

    // Atualizar uma partida existente
    public void atualizar(Partida partida) throws SQLException {
        String sql = "UPDATE partidas SET data_hora_partida=?, quant_jogadores=?, estado=?, tipo=?, codigo=?, localizacao=? WHERE id_partida=?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(partida.getDataHoraPartida()));
            stmt.setInt(2, partida.getQuantJogadores());
            stmt.setString(3, partida.getEstado().toString());
            stmt.setString(4, partida.getTipo().toString());
            stmt.setInt(5, partida.getCodigo());
            stmt.setString(6, partida.getLocalizacao());
            stmt.setInt(7, partida.getIdPartida());
            stmt.executeUpdate();
        }
    }

    // Deletar uma partida pelo ID
    public void deletar(int idPartida) throws SQLException {
        String sql = "DELETE FROM partidas WHERE id_partida=?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPartida);
            stmt.executeUpdate();
        }
    }

    // Buscar uma partida pelo ID
    public Partida buscarPorId(int idPartida) throws SQLException {
        String sql = "SELECT * FROM partidas WHERE id_partida=?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPartida);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Partida(
                        rs.getInt("id_partida"),
                        rs.getTimestamp("data_hora_partida").toLocalDateTime(),
                        rs.getInt("quant_jogadores"),
                        EstadoPartida.valueOf(rs.getString("estado")),
                        TipoPartida.valueOf(rs.getString("tipo")),
                        rs.getInt("codigo"),
                        rs.getString("localizacao")
                );
            }
        }
        return null;
    }

    // Buscar todas as partidas
    public List<Partida> buscarTodas() throws SQLException {
        String sql = "SELECT * FROM partidas";
        List<Partida> lista = new ArrayList<>();
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Partida partida = new Partida(
                        rs.getInt("id_partida"),
                        rs.getTimestamp("data_hora_partida").toLocalDateTime(),
                        rs.getInt("quant_jogadores"),
                        EstadoPartida.valueOf(rs.getString("estado")),
                        TipoPartida.valueOf(rs.getString("tipo")),
                        rs.getInt("codigo"),
                        rs.getString("localizacao")
                );
                lista.add(partida);
            }
        }
        return lista;
    }
} 

