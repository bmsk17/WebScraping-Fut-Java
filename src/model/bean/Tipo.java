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
public class Tipo {
    private int codtip;
    private String nome;
    private double porcentagem ;
    private double investido;
    private double retorno;

    public int getCodtip() {
        return codtip;
    }

    public void setCodtip(int codtip) {
        this.codtip = codtip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public double getInvestido() {
        return investido;
    }

    public void setInvestido(double investido) {
        this.investido = investido;
    }

    public double getRetorno() {
        return retorno;
    }

    public void setRetorno(double retorno) {
        this.retorno = retorno;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
}
