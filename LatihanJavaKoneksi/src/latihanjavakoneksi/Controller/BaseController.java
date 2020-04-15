/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanjavakoneksi.Controller;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;
import java.util.Map;
import latihanjavakoneksi.Connection.DBConnection;

/**
 *
 * @author Asus
 */
public class BaseController {
    DBConnection koneksi = new  DBConnection();
    
    public boolean preparedStatement (Map<Integer, Object>map, String sql){
        try{
            Connection connection = koneksi.open();
            PreparedStatement ps = connection.prepareStatement(sql);
            
            for(Map.Entry<Integer, Object> entry : map.entrySet()){
                ps.setString(entry.getKey(), entry.getValue() .toString());
            }
            
            int rows = ps.executeUpdate();
            connection.close();
            return rows != 0;                                
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }        
    }
   
    public ResultSet get(String sql) {
        try{
            Connection connection = koneksi.open();
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs.populate(rs);
            
            connection.close();
            return crs;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ResultSet getWithParameter(Map<Integer, Object> map, String sql){
        try{
            Connection connection = koneksi.open();
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            for(Map.Entry<Integer, Object> entry : map.entrySet()){
                ps.setString(entry.getKey(), entry.getValue().toString());
            }
            
            ResultSet rs = ps.executeQuery();
            
            CachedRowSetImpl crs = new CachedRowSetImpl();
            crs.populate(rs);
            
            connection.close();
            
            return crs;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
