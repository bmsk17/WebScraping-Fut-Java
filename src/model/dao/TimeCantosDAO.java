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
import model.bean.TimeCantos;


/**
 *
 * @author Bernardo
 */
public class TimeCantosDAO {
    public void create(TimeCantos t) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO timecantos(nome,mCantosFeitos,mCantosSofridos,mCantosTotais,codlig,mCantosFeitosHT,mCantosSofridosHT) VALUES(?,?,?,?,?,?,?)");

            stmt.setString(1, t.getNome());
            stmt.setDouble(2, t.getmCantosFeitos());
            stmt.setDouble(3, t.getmCantosSofridos());
            stmt.setDouble(4, t.getmCantosTotais());
            stmt.setInt(5, t.getCodlig());
            stmt.setDouble(6, t.getmCantosFeitosHT());
            stmt.setDouble(7, t.getmCantosSofridosHT());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public List<TimeCantos> read(int codlig){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<TimeCantos> tCantos = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM timecantos WHERE codlig=? ORDER BY mCantosTotais DESC");
            stmt.setInt(1, codlig);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TimeCantos jog = new TimeCantos();
                
                jog.setNome(rs.getString("nome"));
                jog.setmCantosFeitos(rs.getDouble("mCantosFeitos"));
                jog.setmCantosSofridos(rs.getDouble("mCantosSofridos"));
                jog.setmCantosTotais(rs.getDouble("mCantosTotais"));
                jog.setCodlig(rs.getInt("codlig"));
                jog.setmCantosFeitosHT(rs.getDouble("mCantosFeitosHT"));
                jog.setmCantosSofridosHT(rs.getDouble("mCantosSofridosHT"));
           
                tCantos.add(jog);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tCantos;
    }
    
    public void update(TimeCantos t) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE timecantos SET mCantosFeitos=?,mCantosSofridos=?,mCantosTotais=? WHERE nome=?");
            stmt.setDouble(1, t.getmCantosFeitos());
            stmt.setDouble(2, t.getmCantosSofridos());
            stmt.setDouble(3, t.getmCantosTotais());
            stmt.setString(4, t.getNome());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void updateHT(TimeCantos t) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE timecantos SET mCantosFeitosHT=?,mCantosSofridosHT=? WHERE nome=?");
            stmt.setDouble(1, t.getmCantosFeitosHT());
            stmt.setDouble(2, t.getmCantosSofridosHT());
            stmt.setString(3, t.getNome());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
}
