package br.com.abimaelcristovao.arenafut.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abima
 */

public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost/arenafut";
    private static final String USUARIO = "root";
    private static final String SENHA = "senha";
    
   
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver do banco não encontrado!", ex);
        }
    }

    public static void main(String[] args) {
        try (Connection conexao = Conexao.getConnection()) {
            ResultSet rsPessoa = conexao.createStatement().executeQuery("SELECT * FROM PESSOAS");
            while (rsPessoa.next()) {
                System.out.println("Nome: " + rsPessoa.getString("nome"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            ex.printStackTrace(); 
        }
    }
}
