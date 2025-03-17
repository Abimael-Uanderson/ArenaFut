/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.futarena.model;



import br.com.abimaelcristovao.futarena.enums.EstadoPartida;
import br.com.abimaelcristovao.futarena.enums.TipoPartida;
import java.time.LocalDateTime;

/**
 *
 * @author abima
 */
public class Partida {
    private int idPartida;
    private LocalDateTime dataHoraPartida;
    private Time horaPartida;
    private int quantJogadores;
    private EstadoPartida estado;
    private TipoPartida tipo;
    private int codigo;
    private String Localizacao;

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(LocalDateTime dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public Time getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Time horaPartida) {
        this.horaPartida = horaPartida;
    }

    public int getQuantJogadores() {
        return quantJogadores;
    }

    public void setQuantJogadores(int quantJogadores) {
        this.quantJogadores = quantJogadores;
    }

    public EstadoPartida getEstado() {
        return estado;
    }

    public void setEstado(EstadoPartida estado) {
        this.estado = estado;
    }

    public TipoPartida getTipo() {
        return tipo;
    }

    public void setTipo(TipoPartida tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLocalizacao() {
        return Localizacao;
    }

    public void setLocalizacao(String Localizacao) {
        this.Localizacao = Localizacao;
    }
}
