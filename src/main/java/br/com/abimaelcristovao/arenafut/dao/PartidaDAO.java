/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.arenafut.dao;

/**
 *
 * @author abima
 */


import br.com.abimaelcristovao.arenafut.enums.EstadoPartida;
import br.com.abimaelcristovao.arenafut.enums.TipoPartida;
import br.com.abimaelcristovao.arenafut.model.Partida;
import br.com.abimaelcristovao.arenafut.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class PartidaDAO {

   
    public void inserir(Partida partida) throws SQLException {
        String sql = "INSERT INTO partidas (data_partida, hora_partida, estado, tipo, codigo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(partida.getDataPartida()));
            stmt.setTime(2, java.sql.Time.valueOf(partida.getHoraPartida()));
            stmt.setString(3, partida.getEstado().toString());
            stmt.setString(4, partida.getTipo().toString());
            stmt.setInt(5, partida.getCodigo());
            
            stmt.executeUpdate();
        }
    }

    
    public void atualizar(Partida partida) throws SQLException {
        String sql = "UPDATE partidas SET data_partida = ?, hora_partida = ?, estado = ?, tipo = ?, codigo = ?, WHERE partida_id = ?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(partida.getDataPartida()));
            stmt.setTime(2, java.sql.Time.valueOf(partida.getHoraPartida()));
            stmt.setString(3, partida.getEstado().toString());
            stmt.setString(4, partida.getTipo().toString());
            stmt.setInt(5, partida.getCodigo());
            
            stmt.executeUpdate();
        }
    }

   
    public void deletar(int idPartida) throws SQLException {
        String sql = "DELETE FROM partidas WHERE partida_id = ?";
        try (Connection conexao = Conexao.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPartida);
            stmt.executeUpdate();
        }
    }

   
   
    public List<Partida> buscarPartidasAguardando() throws SQLException {
        String sql = "SELECT * FROM partidas  WHERE estado = 'aguardando'";
        List<Partida> lista = new ArrayList<>();
        try(Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql); 
            ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Partida partida = new Partida();
                partida.setIdPartida(rs.getInt("partida_id"));
                partida.setDataPartida(rs.getDate("data_partida").toLocalDate());
                partida.setHoraPartida(rs.getTime("hora_partida").toLocalTime());
                partida.setEstado(EstadoPartida.valueOf(rs.getString("estado")));
                partida.setTipo(TipoPartida.valueOf(rs.getString("tipo")));
                partida.setCodigo(rs.getInt("codigo"));
                
                lista.add(partida);
            }
            
        }
        return lista;
        
    };
    /*
    public List<Partida> buscarTodas() throws SQLException {;;;;;;
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
    } */
} 

