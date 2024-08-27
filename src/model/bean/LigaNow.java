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
public class LigaNow {
    private int codlig;
    private String nome;
    private String link;    
    private String pais;

    public int getCodlig() {
        return codlig;
    }

    public void setCodlig(int codlig) {
        this.codlig = codlig;
    }
    
    

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
