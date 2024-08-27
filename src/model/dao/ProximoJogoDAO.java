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
import model.bean.Jogo;
import model.bean.ProximoJogo;

/**
 *
 * @author Bernardo
 */
public class ProximoJogoDAO {
    public void create(ProximoJogo pj) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO proximojogo(data,casa,visitante,status,previsao,t1,t2,liga,resultado) VALUES(?,?,?,'EM ANDAMENTO',?,?,?,?,?)");
            stmt.setString(1, pj.getData());
            stmt.setString(2, pj.getCasa());
            stmt.setString(3, pj.getVisitante());
            stmt.setString(4, pj.getPrevisao());
            stmt.setDouble(5,pj.getT1());
            stmt.setDouble(6,pj.getT2());
            stmt.setString(7,pj.getLiga());
            stmt.setDouble(8, pj.getResultado());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<ProximoJogo> read(){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<ProximoJogo> jogo = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM proximojogo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProximoJogo jog = new ProximoJogo();
                
                jog.setCodpro(rs.getInt("codpro"));
                jog.setData(rs.getString("data"));
                jog.setCasa(rs.getString("casa"));
                jog.setPrevisao(rs.getString("previsao"));
                jog.setVisitante(rs.getString("visitante"));
                jog.setStatus(rs.getString("status"));
                jog.setT1(rs.getDouble("t1"));
                jog.setT2(rs.getDouble("t2"));
                jog.setLiga(rs.getString("liga"));
                jog.setResultado(rs.getDouble("resultado"));
                
                jogo.add(jog);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return jogo;
    }
    
    public List<ProximoJogo> readStatus(){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<ProximoJogo> jogo = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM proximojogo WHERE status='EM ANDAMENTO'");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProximoJogo jog = new ProximoJogo();
                
                jog.setCodpro(rs.getInt("codpro"));
                jog.setData(rs.getString("data"));
                jog.setCasa(rs.getString("casa"));
                jog.setPrevisao(rs.getString("previsao"));
                jog.setVisitante(rs.getString("visitante"));
                jog.setStatus(rs.getString("status"));
                jog.setT1(rs.getDouble("t1"));
                jog.setT2(rs.getDouble("t2"));
                jog.setLiga(rs.getString("liga"));
                jog.setResultado(rs.getDouble("resultado"));
                
                jogo.add(jog);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return jogo;
    }
    
        public List<ProximoJogo> readFinalizados(){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<ProximoJogo> jogo = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM proximojogo WHERE status!='EM ANDAMENTO'");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProximoJogo jog = new ProximoJogo();
                
                jog.setCodpro(rs.getInt("codpro"));
                jog.setData(rs.getString("data"));
                jog.setCasa(rs.getString("casa"));
                jog.setPrevisao(rs.getString("previsao"));
                jog.setVisitante(rs.getString("visitante"));
                jog.setStatus(rs.getString("status"));
                jog.setT1(rs.getDouble("t1"));
                jog.setT2(rs.getDouble("t2"));
                jog.setLiga(rs.getString("liga"));
                jog.setResultado(rs.getDouble("resultado"));
                
                jogo.add(jog);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return jogo;
    }
    
    
    public void updateStatus(ProximoJogo j) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE proximojogo SET status=?, resultado=? WHERE codpro=?");            
            stmt.setString(1, j.getStatus());
            stmt.setDouble(2, j.getResultado());
            stmt.setInt(3, j.getCodpro());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aposta Finalizada!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}
