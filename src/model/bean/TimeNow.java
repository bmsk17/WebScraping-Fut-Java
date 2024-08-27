/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Bernardo
 */
public class TimeNow {
    private int codtimc;
    private String nome;
    private int codlig;

    public int getCodtimc() {
        return codtimc;
    }

    public void setCodtimc(int codtimc) {
        this.codtimc = codtimc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodlig() {
        return codlig;
    }

    public void setCodlig(int codlig) {
        this.codlig = codlig;
    }
    
    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
