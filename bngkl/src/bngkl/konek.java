/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bngkl;
import java.sql.*;

/**
 *
 * @author Asus Gk
 */
public class konek {
    
    private final String DB_URL = "jdbc:mysql://localhost:3306/topup";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    public Connection make_connection() throws SQLException {
        
        Connection con = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return con;
    }
    
    public void register(String username, String password,  String alamat,  int nohp) {
        
        
        
        try (Connection con = this.make_connection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO pelanggan (username, password, alamat, nohp) VALUES (?, ?, ?, ?)");
                ) 
        {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, alamat);
            statement.setInt(4, nohp);
            
            int rowsAffected = statement.executeUpdate();
            System.out.println("Register berhasil");
            System.out.println("Rows affected : " + rowsAffected);
            
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
    
}
