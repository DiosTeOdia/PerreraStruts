/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author 1
 */
public class Perro {
    
    private int id;
    private String nome;
    private String duenio;
    
    public Perro(String nome, String duenio) {
        this.nome = nome;
        this.duenio = duenio;
    }
    
    public Perro(int id, String nome, String duenio) {
        this.id = id;
        this.nome = nome;
        this.duenio = duenio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nome;
    }

    public void setNombre(String nome) {
        this.nome = nome;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

  
    
}
