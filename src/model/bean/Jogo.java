/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Bernardo
 */
public class Jogo {
    private int codjog;
    private String timeA;
    private String timeB;
    private String data;
    private double aposta;
    private double odds;
    private double retorno;
    private int coddtip;
    private String status;
    private String afavor;

    public String getAfavor() {
        return afavor;
    }

    public void setAfavor(String afavor) {
        this.afavor = afavor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodjog() {
        return codjog;
    }

    public void setCodjog(int codjog) {
        this.codjog = codjog;
    }

    public String getTimeA() {
        return timeA;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;
    }

    public String getTimeB() {
        return timeB;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getAposta() {
        return aposta;
    }

    public void setAposta(double aposta) {
        this.aposta = aposta;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public double getRetorno() {
        return retorno;
    }

    public void setRetorno(double retorno) {
        this.retorno = retorno;
    }

    public int getCoddtip() {
        return coddtip;
    }

    public void setCoddtip(int coddtip) {
        this.coddtip = coddtip;
    }

    public void setData(Date data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
