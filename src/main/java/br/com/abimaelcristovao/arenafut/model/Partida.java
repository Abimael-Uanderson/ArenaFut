/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.arenafut.model;



import br.com.abimaelcristovao.arenafut.enums.EstadoPartida;
import br.com.abimaelcristovao.arenafut.enums.TipoPartida;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author abima
 */
public class Partida {
    private int idPartida;
    private LocalDate dataPartida;
    private LocalTime horaPartida;
    private EstadoPartida estado;
    private TipoPartida tipo;
    private int codigo;

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public LocalTime getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(LocalTime horaPartida) {
        this.horaPartida = horaPartida;
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
   

    

    
   
}
