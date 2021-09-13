package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
        // Crear el metodo del objeto tipo Empleado para validarlo.
        // Este metodo recibira dos parametros
    public Empleado validar (String usuario, String DPIEmpleado){
        //instanciar el objeto de la entidad Empleado
        Empleado empleado = new Empleado();
        //Agregar una variable de tipo String que nos servira para nuestra consulta en mysql
        String sql = "Select * from empleado where usuario = ? and DPIEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2,DPIEmpleado);
            rs = ps.executeQuery();
            while (rs.next()){
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setDPIEmpleado(rs.getString("DPIEmpleado"));
                empleado.setNombresEmpleado(rs.getString("nombresEmpleado"));
                empleado.setUsuario(rs.getString("usuario"));               
            }
        }catch(Exception e){
         e.printStackTrace();
        }
        return empleado; // Empleado Encontrado
    }
    
    // OPERACIONES DEL CRUD
// METODO LISTAR

public List listar(){
    String sql= "Select * from empleado";
    List<Empleado> listaEmpleado = new ArrayList<>();
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Empleado em = new Empleado();
            em.setCodigoEmpleado(rs.getInt(1));
            em.setDPIEmpleado(rs.getString(2));
            em.setNombresEmpleado(rs.getString(3));
            em.setTelefonoEmpleado(rs.getString(4));
            em.setEstado(rs.getString(5));
            em.setUsuario(rs.getString(6));
            listaEmpleado.add(em);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return listaEmpleado;
}

// metodo agregar

    public int agregar(Empleado emp){
        String sql = "insert into Empleado(DPIEmpleado, nombresEmpleado, telefonoEmpleado, estado, usuario) values(?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getDPIEmpleado());
            ps.setString(2, emp.getNombresEmpleado());
            ps.setString(3, emp.getTelefonoEmpleado());
            ps.setString(4, emp.getEstado());
            ps.setString(5, emp.getUsuario());
            ps.executeUpdate();
        }catch(Exception e){
          e.printStackTrace();
        }
                
        return resp;
    }
    
    //Buscar Por Codigo
    
    public Empleado listarCodigoEmpleado(int id){
        // instancia del objeto empleado
        Empleado emp = new Empleado();
        String sql = "select * from empleado where codigoEmpleado =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setDPIEmpleado(rs.getString(2));
                emp.setNombresEmpleado(rs.getString(3));
                emp.setTelefonoEmpleado(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUsuario(rs.getString(6));
                
            }
        
        }catch(Exception e){
           e.printStackTrace();
        }
        return emp;
    }
    
    // Metodo de editar.
    public int actualizar(Empleado emp){
        String sql = "update empleado set DPIEmpleado = ?, nombresEmpleado = ?, telefonoEmpleado = ?,"
                + " estado = ?, usuario = ? where codigoEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getDPIEmpleado());
            ps.setString(2, emp.getNombresEmpleado());
            ps.setString(3, emp.getTelefonoEmpleado());
            ps.setString(4, emp.getEstado());
            ps.setString(5, emp.getUsuario());
            ps.setInt(6, emp.getCodigoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
                return resp;
    }
    
    //metodo eliminar
    public void eliminar(int id){
        String sql= "delete from empleado where codigoEmpleado ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}