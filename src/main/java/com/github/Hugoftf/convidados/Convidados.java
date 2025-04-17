package com.github.Hugoftf.convidados;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Convidados {

    @Id
    @Column
    private String cpf;
    @Column
    private String nome;
    

    public Convidados(String nome, String cpf){
        this.cpf = cpf;
        this.nome = nome;
    }

    public Convidados(){
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
}
