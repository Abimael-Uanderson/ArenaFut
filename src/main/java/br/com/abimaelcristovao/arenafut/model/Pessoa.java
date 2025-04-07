/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.abimaelcristovao.arenafut.model;

import br.com.abimaelcristovao.arenafut.enums.TipoJogador;

/**
 *
 * @author abima
 */
public class Pessoa {
    private int idPessoa;
    private String nome;
    private String email;
    private String senha;
    private TipoJogador posicao;
    private int nivel;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoJogador getPosicao() {
        return posicao;
    }

    public void setPosicao(TipoJogador posicao) {
        this.posicao = posicao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
