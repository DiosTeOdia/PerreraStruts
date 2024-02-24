/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Perro;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class perroDao {
    
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost3306/perrera";
    
    private final String USUARIO = "root";
    private final String PASS = "root";
    
    private Connection conn;
    private Statement stmt;
    
    public perroDao() {
    conn = conectarDatos();
    }
    
    public ArrayList<Perro> obtenerPerros() {
        
        ArrayList<Perro> perros = new ArrayList<>();
        
        try {
            conn = conectarDatos();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM perro";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String duenio = rs.getString("duenio");
                perros.add(new Perro(id, nombre, duenio));
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(perroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return perros;
    }
    
    public int crearPerro(Perro perro) {
        
        int rs = 0;
        
        try {
            conn = conectarDatos();
            String sql = "INSERT INTO perro (nombre, duenio) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, perro.getNombre());
            pstmt.setString(2, perro.getDuenio());
            rs = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(perroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return rs;
    }

    public Perro obtenerPerro(int perroId) {
        
        Perro perro = null;
        
        try {
            conn = conectarDatos();
            String sql = "SELECT * FROM perro WHERE id = ? LIMIT 1";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, perroId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String duenio = rs.getString("duenio");
                perro = new Perro(id, nombre, duenio);
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(perroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return perro;
    }

    
    
    public int actualizarPerro(Perro perro) {
        
        int rs = 0;
        
        try {
            conn = conectarDatos();
            String sql = "UPDATE perro SET nombre = ?, duenio = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, perro.getNombre());
            pstmt.setString(2, perro.getDuenio());
            pstmt.setInt(3, perro.getId());
            rs = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(perroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return rs;
    }

    public int borrarPerro(int perroId) {
        int rs = 0;
        
        try {
            conn = conectarDatos();
            String sql = "DELETE FROM perro WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, perroId);
            rs = pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(perroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarConexion();
        }
        
        return rs;
    }
   
     private Connection conectarDatos() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conexion = DriverManager.getConnection(DB_URL, USUARIO, PASS);
            System.out.println("Conexión establecida con éxito.");
            return conexion;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(perroDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
            return null;
        }
    }
    
    private void cerrarConexion() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(perroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
