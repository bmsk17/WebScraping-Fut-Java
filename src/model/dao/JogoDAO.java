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

/**
 *
 * @author Bernardo
 */
public class JogoDAO {
    
    public void create(Jogo j) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO jogo(aposta,timeA,data,timeB,odds,retorno,codtip,status,afavor) VALUES(?,?,?,?,?,?,?,'EM ANDAMENTO',?)");
            stmt.setDouble(1, j.getAposta());
            stmt.setString(2, j.getTimeA());
            stmt.setString(3, j.getData());
            stmt.setString(4, j.getTimeB());
            stmt.setDouble(5, j.getOdds());
            stmt.setDouble(6, j.getRetorno());
            stmt.setInt(7, j.getCoddtip());
            stmt.setString(8, j.getAfavor());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<Jogo> read(int codtip){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<Jogo> jogo = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM jogo WHERE codtip=?");
            stmt.setInt(1, codtip);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Jogo jog = new Jogo();
                
                jog.setCodjog(rs.getInt("codjog"));
                jog.setAposta(rs.getDouble("aposta"));
                jog.setTimeA(rs.getString("timeA"));
                jog.setData(rs.getString("data"));
                jog.setTimeB(rs.getString("timeB"));
                jog.setOdds(rs.getDouble("odds"));
                jog.setRetorno(rs.getDouble("retorno"));
                jog.setStatus(rs.getString("status"));
                jog.setAfavor(rs.getString("afavor"));
                
                jogo.add(jog);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return jogo;
    }
    
    
    public int selecionarCodTip(Jogo j){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        Jogo jog = new Jogo();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM jogo WHERE codjog=?");
            stmt.setInt(1, j.getCodjog());
            rs = stmt.executeQuery();
            rs.next();

                
                jog.setCodjog(rs.getInt("codjog"));
                jog.setAposta(rs.getDouble("aposta"));
                jog.setTimeA(rs.getString("timeA"));
                jog.setData(rs.getString("data"));
                jog.setTimeB(rs.getString("timeB"));
                jog.setOdds(rs.getDouble("odds"));
                jog.setRetorno(rs.getDouble("retorno"));
                jog.setStatus(rs.getString("status"));
                jog.setAfavor(rs.getString("afavor"));   
                jog.setCoddtip(rs.getInt("codtip"));
            JOptionPane.showMessageDialog(null,"BILAADA __ "+ jog.getCoddtip());
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return jog.getCoddtip();
    }
        
    
    public void update(Jogo j) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE jogo SET aposta=?,timeA=?,data=?,timeB=?,odds=?,afavor=?, retorno=? WHERE codjog=?");
            stmt.setDouble(1, j.getAposta());
            stmt.setString(2, j.getTimeA());
            stmt.setString(3, j.getData());
            stmt.setString(4, j.getTimeB());
            stmt.setDouble(5, j.getOdds());
            stmt.setString(6, j.getAfavor());
            stmt.setDouble(7, j.getRetorno());
            stmt.setInt(8, j.getCodjog());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void updateStatus(Jogo j) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE jogo SET status=? WHERE codjog=?");            
            stmt.setString(1, j.getStatus());
            stmt.setInt(2, j.getCodjog());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aposta Finalizada!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void excluir(Jogo j) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM jogo WHERE codjog=?");
            stmt.setInt(1, j.getCodjog());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}
