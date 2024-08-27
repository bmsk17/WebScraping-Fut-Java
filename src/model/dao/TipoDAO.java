/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Tipo;

public class TipoDAO {
    
    
    public void create(Tipo t) {
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tipo(nome,porcentagem,investido,retorno) VALUES (?,0,0,0)");
            stmt.setString(1, t.getNome());


            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    public Tipo readRetorno(Tipo t){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        Tipo tipPRINCIPAL = new Tipo();
        
        try {
            
            stmt= con.prepareStatement("SELECT SUM(retorno) soma FROM jogo WHERE codtip=? and status = 'VITORIA' ");
            stmt.setInt(1,t.getCodtip());
            rs = stmt.executeQuery();
            rs.next();
  
            Tipo tip = new Tipo();
            tip.setRetorno(rs.getDouble("soma"));
            
            
            
            stmt= con.prepareStatement("SELECT SUM(retorno) soma FROM jogo WHERE codtip=? and status = 'DERROTA'");
            stmt.setInt(1,t.getCodtip());
            rs = stmt.executeQuery();
            rs.next();

            
            Tipo tipB = new Tipo();
            tipB.setRetorno(rs.getDouble("soma"));
            
            stmt= con.prepareStatement("SELECT count(*) FROM jogo WHERE codtip=? and status!='EM ANDAMENTO'");
            stmt.setInt(1,t.getCodtip());
            rs = stmt.executeQuery();
            rs.next();
            
            double contador=rs.getInt("count(*)");
            
            stmt= con.prepareStatement("SELECT count(*) FROM jogo WHERE codtip=? and status = 'VITORIA'");
            stmt.setInt(1,t.getCodtip());
            rs = stmt.executeQuery();
            rs.next();
            
            contador=(rs.getInt("count(*)")*100)/contador;
            
            stmt= con.prepareStatement("SELECT SUM(aposta) FROM jogo WHERE codtip=? and status!='EM ANDAMENTO'");
            stmt.setInt(1,t.getCodtip());
            rs = stmt.executeQuery();
            rs.next();
            
            tipPRINCIPAL.setCodtip(t.getCodtip());
            tipPRINCIPAL.setInvestido(rs.getDouble("SUM(aposta)"));
            tipPRINCIPAL.setRetorno(tip.getRetorno()-tipB.getRetorno());
            tipPRINCIPAL.setPorcentagem(contador);
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipPRINCIPAL;
    }
    
    
    public List<Tipo> read(){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<Tipo> tipo = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM tipo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Tipo tip = new Tipo();
                
                tip.setCodtip(rs.getInt("codtip"));
                tip.setNome(rs.getString("nome"));
                tip.setInvestido(rs.getDouble("investido"));
                tip.setPorcentagem(rs.getDouble("porcentagem"));
                tip.setRetorno(rs.getDouble("retorno"));
                tipo.add(tip);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipo;
    }
    
    public List<Tipo> readNome(){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<Tipo> tipo = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM tipo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Tipo tip = new Tipo();
                
                tip.setCodtip(rs.getInt("codtip"));
                tip.setNome(rs.getString("nome"));
                tipo.add(tip);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tipo;
    }
    
    
    
    public void update(Tipo t) {
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tipo SET nome = ? WHERE codtip = ? ");
            stmt.setString(1, t.getNome());
            stmt.setInt(2,t.getCodtip());


            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    public void updateTipo(Tipo t) {
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tipo SET investido = ?, retorno = ?, porcentagem = ? WHERE codtip = ? ");
            stmt.setDouble(1, t.getInvestido());
            stmt.setDouble(2, t.getRetorno());
            stmt.setDouble(3, t.getPorcentagem());
            stmt.setInt(4,t.getCodtip());


            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    public void excluir(Tipo t) {
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tipo WHERE codtip=? ");
            stmt.setInt(1,t.getCodtip());


            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
}
