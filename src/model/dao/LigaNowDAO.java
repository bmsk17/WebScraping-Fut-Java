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
import model.bean.LigaNow;

/**
 *
 * @author Bernardo
 */
public class LigaNowDAO {
    public void create(LigaNow l) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO liganow(nome,pais) VALUES(?,?)");

            stmt.setString(1, l.getNome());
            stmt.setString(2, l.getPais());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public int readNome(LigaNow l){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        int cod=0;
        
        try {
            stmt= con.prepareStatement("SELECT codlig FROM liganow WHERE nome=?");
            stmt.setString(1, l.getNome());
            rs = stmt.executeQuery();
            rs.next();
            cod=rs.getInt("codlig");
                      
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cod;
    }
    
    public List<LigaNow> read(){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<LigaNow> lCantos = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM liganow");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                LigaNow lcantos = new LigaNow();
                
                lcantos.setCodlig(rs.getInt("codlig"));
                lcantos.setNome(rs.getString("nome"));
                lcantos.setPais(rs.getString("pais"));
                lCantos.add(lcantos);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lCantos;
    }
    
}
