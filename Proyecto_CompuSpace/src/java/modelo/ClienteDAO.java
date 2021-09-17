package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    // OPERACIONES DEL CRUD
    public Cliente buscar(String dpi) {
        Cliente cl = new Cliente();
        String sql = "select * from Cliente where DPICliente =" + dpi;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setCodigoCliente(rs.getInt(1));
                cl.setDPICliente(rs.getString(2));
                cl.setNombresCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl;
    }
// METODO LISTAR
    
    public Cliente validar (String nombresCliente, String DPICliente){
        //instanciar el objeto de la entidad Empleado
        Cliente cliente = new Cliente();
        //Agregar una variable de tipo String que nos servira para nuestra consulta en mysql
        String sql = "Select * from cliente where nombresCliente = ? and DPICliente = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,nombresCliente);
            ps.setString(2,DPICliente);
            rs = ps.executeQuery();
            while (rs.next()){
                cliente.setCodigoCliente(rs.getInt("codigoCliente"));
                cliente.setDPICliente(rs.getString("DPICliente"));
                cliente.setNombresCliente(rs.getString("nombresCliente"));
                cliente.setDireccionCliente(rs.getString("direccionCliente"));
                cliente.setEstado(rs.getString("estado"));               
            }
        }catch(Exception e){
         e.printStackTrace();
        }
        return cliente; // Empleado Encontrado
    }
    
    public List listar(){
    String sql= "Select * from cliente";
    List<Cliente> listaCliente = new ArrayList<>();
    try{
        con = cn.Conexion();
        ps =  con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Cliente em =  new Cliente();
            em.setCodigoCliente(rs.getInt(1));
            em.setDPICliente(rs.getString(2));
            em.setNombresCliente(rs.getString(3));
            em.setDireccionCliente(rs.getString(4));
            em.setEstado(rs.getString(5));
            listaCliente.add(em); 
        }
}catch(Exception e){
    e.printStackTrace();
}
return listaCliente;
}
    
 // Metodo Agregar

public int agregar(Cliente emp){
    String sql =  "insert into Cliente(DPICliente, nombresCliente, direccionCliente, estado)\n" +
" values(?,?,?,?)";
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, emp.getDPICliente());
        ps.setString(2, emp.getNombresCliente());
        ps.setString(3, emp.getDireccionCliente());
        ps.setString(4, emp.getEstado());
        ps.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }
return resp;
}  

// Buscar Por Codigo

public Cliente listarCodigoCliente(int id){
    Cliente emp = new Cliente();
    String sql = "Select * from cliente where codigoCliente = " + id;
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            emp.setDPICliente(rs.getString(2));
            emp.setNombresCliente(rs.getString(3));
            emp.setDireccionCliente(rs.getString(4));
            emp.setEstado(rs.getString(5));    
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return emp;
}

// Metodo Editar

public int actualizar(Cliente emp){
    String sql = "update cliente set DPICliente = ?, nombresCliente = ?, DireccionCliente = ?, estado = ? where codigoCliente = ?";
    try{
        con =  cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, emp.getDPICliente());
        ps.setString(2, emp.getNombresCliente());
        ps.setString(3, emp.getDireccionCliente());
        ps.setString(4, emp.getEstado());
        ps.setInt(5, emp.getCodigoCliente());
        ps.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }
    return resp;
}

    public void eliminar(int id){
        String sql = "delete from cliente where codigoCliente =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
}