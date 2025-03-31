
import br.com.abimaelcristovao.futarena.dao.PartidaDAO;
import br.com.abimaelcristovao.futarena.dao.PessoaDAO;
import br.com.abimaelcristovao.futarena.enums.TipoJogador;
import br.com.abimaelcristovao.futarena.model.Pessoa;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
private int idPessoa;
    private String nome;
    private String email;
    private String senha;
    private TipoJogador posicao;
    private int nivel;
/**
 *
 * @author abima
 */
public class TesteDAO {
    public static void main(String[] args) throws SQLException {
        Pessoa p = new Pessoa();
        Pessoa pessoaEncontrada = new Pessoa();
        p.setNome("Abimael Cristovao");
        p.setEmail("abimaelcristovao@gmail.com");
        p.setSenha("SemSenha123");
        p.setPosicao(TipoJogador.defensor);
        p.setNivel(3);
        p.setIdPessoa(1);
        
        
        PessoaDAO dao = new PessoaDAO();
        pessoaEncontrada = dao.buscarPorEmail(p.getEmail());
        if (pessoaEncontrada != null) {
    System.out.println("Pessoa encontrada:");
    System.out.println("ID: " + pessoaEncontrada.getIdPessoa());
    System.out.println("Nome: " + pessoaEncontrada.getNome());
    System.out.println("Email: " + pessoaEncontrada.getEmail());
    System.out.println("Posição: " + pessoaEncontrada.getPosicao());
    System.out.println("Nível: " + pessoaEncontrada.getNivel());
} else {
    System.out.println("Nenhuma pessoa encontrada com esse e-mail.");
}
        
    }
}
