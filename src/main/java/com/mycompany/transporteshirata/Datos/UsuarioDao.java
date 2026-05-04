/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transporteshirata.Datos;

import com.mycompany.transporteshirata.Logica.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author danie
 */
public class UsuarioDao {

    private Connection conexion;

    public UsuarioDao() {
        this.conexion = Conexion.getConexion();
    }

    public Usuario validarUsuario(String rut, String clave) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE rut = ? AND clave = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, rut);
            ps.setString(2, clave);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setRut(rs.getString("rut"));
                usuario.setClave(rs.getString("clave"));
                usuario.setCargo(rs.getString("cargo"));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

}
