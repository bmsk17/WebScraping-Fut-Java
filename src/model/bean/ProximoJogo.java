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
public class ProximoJogo {
    private int codpro;
    private String data;
    private String casa;
    private String visitante;
    private String previsao;
    private String status;
    private String liga;
    private double t1;
    private double t2;
    private double resultado;
    private double mCasaCantosFeitos;
    private double mCasaCantosSofridos;
    private double mCasaCantosTotal;    
    private double mVisitanteCantosFeitos;
    private double mVisitanteCantosSofridos;
    private double mVisitanteCantosTotal;
    private double mCantosTotais;

    public double getmCasaCantosTotal() {
        return mCasaCantosTotal;
    }

    public void setmCasaCantosTotal(double mCasaCantosTotal) {
        this.mCasaCantosTotal = mCasaCantosTotal;
    }

    public double getmVisitanteCantosTotal() {
        return mVisitanteCantosTotal;
    }

    public void setmVisitanteCantosTotal(double mVisitanteCantosTotal) {
        this.mVisitanteCantosTotal = mVisitanteCantosTotal;
    }

    

    public double getmCasaCantosFeitos() {
        return mCasaCantosFeitos;
    }

    public void setmCasaCantosFeitos(double mCasaCantosFeitos) {
        this.mCasaCantosFeitos = mCasaCantosFeitos;
    }

    public double getmCasaCantosSofridos() {
        return mCasaCantosSofridos;
    }

    public void setmCasaCantosSofridos(double mCasaCantosSofridos) {
        this.mCasaCantosSofridos = mCasaCantosSofridos;
    }

    public double getmVisitanteCantosFeitos() {
        return mVisitanteCantosFeitos;
    }

    public void setmVisitanteCantosFeitos(double mVisitanteCantosFeitos) {
        this.mVisitanteCantosFeitos = mVisitanteCantosFeitos;
    }

    public double getmVisitanteCantosSofridos() {
        return mVisitanteCantosSofridos;
    }

    public void setmVisitanteCantosSofridos(double mVisitanteCantosSofridos) {
        this.mVisitanteCantosSofridos = mVisitanteCantosSofridos;
    }
    
    
    

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    
    public double getT1() {
        return t1;
    }

    public void setT1(double t1) {
        this.t1 = t1;
    }

    public double getT2() {
        return t2;
    }

    public void setT2(double t2) {
        this.t2 = t2;
    }
    
    

    public int getCodpro() {
        return codpro;
    }

    public void setCodpro(int codpro) {
        this.codpro = codpro;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getPrevisao() {
        return previsao;
    }

    public void setPrevisao(String previsao) {
        this.previsao = previsao;
    }


    
    
    
}
