package javaClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class methodsSQL {   
    
    private static classUsuarios user;

    public static classUsuarios getUser() {
        return user;
    }

    public static void setUser(classUsuarios user) {
        methodsSQL.user = user;
    }

    static void prepare(PreparedStatement cmd, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++)
            cmd.setObject(i + 1, values[i]);
    }
    
    public static boolean execute(String query, Object... values){
        try (Connection con = connection.getConnection();
            PreparedStatement command = con.prepareStatement(query)) {
            prepare(command, values);
            command.execute();
            return true;
        } catch(SQLException e) { 
            System.out.println(e.getMessage());
            user.setError(e.getMessage());
            return false; 
        }
    }

    public static ResultSet getExecute(String query, Object... values){
        ResultSet rs = null;
        try {
            Connection con = connection.getConnection();
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepare(prepStmt,values);
            rs = prepStmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            user.setError(ex.getMessage());
        }
        return rs;
    }
    
    public static Integer getExecuteInt(String query, Object... values){
        ResultSet rs;
        Integer i = -1;
        try {
            Connection con = connection.getConnection();
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepare(prepStmt,values);
            rs = prepStmt.executeQuery();
            if(rs.next())
                i=rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            user.setError(ex.getMessage());
        }
        return i;
    }

    public static boolean exists(String query, Object... values){
        Object cod = null;
        try {            
            ResultSet rs = getExecute(query,values);
            if(rs.next())
                cod = rs.getObject(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            user.setError(ex.getMessage());
        }
        if(cod == null)
            return false;
        else
            return true;
    }
    

    public static DefaultTableModel getTableModel(String query, Object... values){
        DefaultTableModel modelo = new DefaultTableModel();
        for (Object value : values)
            modelo.addColumn(value);
        ResultSet rs = methodsSQL.getExecute(query);
        
        try {
            while(rs.next())
            {
                Object [] fila = new Object[values.length];
                for(int i = 0; i<values.length; i++)
                    fila[i] = rs.getObject(i+1);
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            user.setError(ex.getMessage());
        }        
        return modelo;
    }
    
}
