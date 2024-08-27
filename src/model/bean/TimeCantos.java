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
public class TimeCantos {
    private int codtimc;
    private String nome;
    private Double mCantosFeitos;
    private Double mCantosSofridos;
    private Double mCantosFeitosHT;
    private Double mCantosSofridosHT;
    private Double mCantosTotais;
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

    public Double getmCantosFeitos() {
        return mCantosFeitos;
    }

    public void setmCantosFeitos(Double mCantosFeitos) {
        this.mCantosFeitos = mCantosFeitos;
    }

    public Double getmCantosSofridos() {
        return mCantosSofridos;
    }

    public void setmCantosSofridos(Double mCantosSofridos) {
        this.mCantosSofridos = mCantosSofridos;
    }

    public Double getmCantosFeitosHT() {
        return mCantosFeitosHT;
    }

    public void setmCantosFeitosHT(Double mCantosFeitosHT) {
        this.mCantosFeitosHT = mCantosFeitosHT;
    }

    public Double getmCantosSofridosHT() {
        return mCantosSofridosHT;
    }

    public void setmCantosSofridosHT(Double mCantosSofridosHT) {
        this.mCantosSofridosHT = mCantosSofridosHT;
    }

    public Double getmCantosTotais() {
        return mCantosTotais;
    }

    public void setmCantosTotais(Double mCantosTotais) {
        this.mCantosTotais = mCantosTotais;
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
