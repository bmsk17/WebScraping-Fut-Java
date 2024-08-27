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
import model.bean.TimeCantos;
import model.bean.TimeNow;

/**
 *
 * @author Bernardo
 */
public class TimeNowDao {
    public void create(TimeNow t) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO timenow(nome,codlig) VALUES(?,?)");

            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getCodlig());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public List<TimeNow> read(int codlig){
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;        
        ResultSet rs = null;
        
        List<TimeNow> tCantos = new ArrayList<>();
        
        try {
            stmt= con.prepareStatement("SELECT * FROM timenow WHERE codlig=?");
            stmt.setInt(1, codlig);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                TimeNow jog = new TimeNow();
                jog.setNome(rs.getString("nome"));
                jog.setCodlig(rs.getInt("codlig"));
                tCantos.add(jog);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tCantos;
    }   
}
