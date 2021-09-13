package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;

/**
 *
 * @author hp
 */
public class Controlador extends HttpServlet {
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDao = new EmpleadoDAO();
    Cliente cliente = new Cliente();
    ClienteDAO clienteDao = new ClienteDAO();
    
    int codEmpleado;
    int codCliente;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }else if(menu.equals("Empleado")){
            switch(accion){
                case "Listar":
                    List listaEmpleados = empleadoDao.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    break;
                
                case "Agregar":
                    String DPI = request.getParameter("txtDPIEmpleado");
                    String nombres = request.getParameter("txtNombresEmpleado");
                    String telefono = request.getParameter("txtTelefonoEmpleado");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    empleado.setDPIEmpleado(DPI);
                    empleado.setNombresEmpleado(nombres);
                    empleado.setTelefonoEmpleado(telefono);
                    empleado.setEstado(estado);
                    empleado.setUsuario(user);
                    empleadoDao.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                
                case "Editar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    Empleado e = empleadoDao.listarCodigoEmpleado(codEmpleado);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                
                case "Actualizar":
                    String DPIEmp = request.getParameter("txtDPIEmpleado");
                    String nombresEmp = request.getParameter("txtNombresEmpleado");
                    String telefonoEmp = request.getParameter("txtTelefonoEmpleado");
                    String estadoEmp = request.getParameter("txtEstado");
                    String userEmp = request.getParameter("txtUsuario");
                    empleado.setDPIEmpleado(DPIEmp);
                    empleado.setNombresEmpleado(nombresEmp);
                    empleado.setTelefonoEmpleado(telefonoEmp);
                    empleado.setEstado(estadoEmp);
                    empleado.setUsuario(userEmp);
                    empleado.setCodigoEmpleado(codEmpleado);
                    empleadoDao.actualizar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    
                case "Eliminar":
                    codEmpleado =  Integer.parseInt(request.getParameter("codigoEmpleado"));
                    empleadoDao.eliminar(codEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            
            
            
            
            request.getRequestDispatcher("Empleado.jsp").forward(request,response);
        }else if(menu.equals("Cliente")){
            switch(accion){
                case "Listar":
                    List listaCliente = clienteDao.listar();
                    request.setAttribute("cliente", listaCliente);
                    break;
                
                case "Agregar":
                    String DPICliente = request.getParameter("txtDPICliente");
                    String nombresCliente = request.getParameter("txtNombresCliente");
                    String direccion = request.getParameter("txtDireccionCliente");
                    String estadoCliente = request.getParameter("txtEstado");
                    cliente.setDPICliente(DPICliente);
                    cliente.setNombresCliente(nombresCliente);
                    cliente.setDireccionCliente(direccion);
                    cliente.setEstado(estadoCliente);
                    clienteDao.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    
                    break;
                
                case "Editar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    Cliente e = clienteDao.listarCodigoCliente(codCliente);
                    request.setAttribute("clientes", e);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    
                    break;
                
                case "Actualizar":
                    String DPICli = request.getParameter("txtDPICliente");
                    String nombresCli = request.getParameter("txtNombresCliente");
                    String direccionCli = request.getParameter("txtDireccionCliente");
                    String estadoCli = request.getParameter("txtEstado");
                    cliente.setDPICliente(DPICli);
                    cliente.setNombresCliente(nombresCli);
                    cliente.setDireccionCliente(direccionCli);
                    cliente.setEstado(estadoCli);
                    cliente.setCodigoCliente(codCliente);
                    clienteDao.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    
                    break;
                    
                case "Eliminar":
                     codCliente =  Integer.parseInt(request.getParameter("codigoCliente"));
                    clienteDao.eliminar(codCliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    
                    break;
               
            } 
            request.getRequestDispatcher("Clientes.jsp").forward(request,response);
          } else if (menu.equals("Producto")) {
             switch (accion) {
                case "Listar":
                    List listaProducto = productoDao.listar();
                    request.setAttribute("productos", listaProducto);
                    break;
                case "Agregar":
                    String nombreProducto = request.getParameter("txtNombreProducto");
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado = request.getParameter("txtEstado");
                    producto.setNombreProducto(nombreProducto);
                    producto.setPrecio(precio);
                    producto.setStock(stock);
                    producto.setEstado(estado);
                    productoDao.agregar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    Producto p = productoDao.listarCodigoProducto(codProducto);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreProduc= request.getParameter("txtNombreProducto");
                    Double precioProduc = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stockProduc = Integer.parseInt(request.getParameter("txtStock"));
                    String estadoProduc = request.getParameter("txtEstado");
                    producto.setNombreProducto(nombreProduc);
                    producto.setPrecio(precioProduc);
                    producto.setStock(stockProduc);
                    producto.setEstado(estadoProduc);
                    productoDao.agregar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    productoDao.eliminar(codProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }else if(menu.equals("NuevaVenta")){
            request.getRequestDispatcher("NuevaVenta.jsp").forward(request,response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
