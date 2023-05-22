/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROL;

import CONEXIONES.GenerarSerie;
import MODELO.dao.ClienteDAO;
import MODELO.dao.DetallesVenDAO;
import MODELO.dao.EmpleadoDAO;
import MODELO.dao.ProductoDAO;
import MODELO.dao.VentasDAO;
import MODELO.dto.ClienteDTO;
import MODELO.dto.DetallesVenDTO;
import MODELO.dto.EmpleadoDTO;
import MODELO.dto.ProductoDTO;
import MODELO.dto.VentasDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EmpleadoDTO emdto = new EmpleadoDTO();
    EmpleadoDAO emdao = new EmpleadoDAO();
    EmpleadoDTO emllega = new EmpleadoDTO();
    ClienteDTO cldto = new ClienteDTO();
    ClienteDAO cldao = new ClienteDAO();
    ClienteDTO cllega = new ClienteDTO();
    ProductoDTO prdto = new ProductoDTO();
    ProductoDAO prdao = new ProductoDAO();
    ProductoDTO prllega = new ProductoDTO();
    VentasDTO vdto = new VentasDTO();
    VentasDAO vdao = new VentasDAO();
    DetallesVenDTO dvdto = new DetallesVenDTO();
    DetallesVenDAO dvdao = new DetallesVenDAO();
        
    List<VentasDTO> lista_v = new ArrayList<>();
    int item_v, id_venta, cantidad_prod_v, id_producto, id_empleado=0;
    String descripcion_prod_v, numero_serie;
    double precio_prod_v, subtotal_v, total_pagar_v;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu = request.getParameter("menu");
            String accion  = request.getParameter("btn_enviar");
            
            if(menu.equals("Principal")){
                id_empleado = Integer.parseInt(request.getParameter("id"));
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if(menu.equals("Principal_Iframe")){
                request.getRequestDispatcher("Principal_Iframe.jsp").forward(request, response);
            }
            if(menu.equals("Empleado")){
                switch (accion) {
                    case "Listar":
                        List<EmpleadoDTO> list = emdao.readAll();
                        request.setAttribute("empleados", list);
                        break;
                    case "Agregar":
                        int id = Integer.parseInt(request.getParameter("txt_id_empleado"));
                        String contra = request.getParameter("txt_contrasena_empleado");
                        String nombre = request.getParameter("txt_nombre_empleado");
                        String correo = request.getParameter("txt_correo_empleado");
                        String telefono = request.getParameter("txt_telefono_empleado");
                        int estado = Integer.parseInt(request.getParameter("txt_estado_empleado"));
                        String usuario = request.getParameter("txt_usuario_empleado");
                        emdto.setId(id);
                        emdto.setContrasena(contra);
                        emdto.setNombre(nombre);
                        emdto.setCorreo(correo);
                        emdto.setTel(telefono);
                        emdto.setEstado(estado);
                        emdto.setUser(usuario);
                        if (emdao.create(emdto)){
                            request.getRequestDispatcher("Controlador?menu=Empleado&btn_enviar=Listar").forward(request, response);
                        } else {
                            
                        }
                        break;
                    case "Editar":
                        id = Integer.parseInt(request.getParameter("id"));
                        emdto.setId(id);
                        emllega = emdao.read(emdto);
                        request.setAttribute("empleado", emllega);
                        request.getRequestDispatcher("Controlador?menu=Empleado&btn_enviar=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        id = Integer.parseInt(request.getParameter("txt_id_empleado"));
                        contra = request.getParameter("txt_contrasena_empleado");
                        nombre = request.getParameter("txt_nombre_empleado");
                        correo = request.getParameter("txt_correo_empleado");
                        telefono = request.getParameter("txt_telefono_empleado");
                        estado = Integer.parseInt(request.getParameter("txt_estado_empleado"));
                        usuario = request.getParameter("txt_usuario_empleado");
                        emdto.setId(id);
                        emdto.setContrasena(contra);
                        emdto.setNombre(nombre);
                        emdto.setCorreo(correo);
                        emdto.setTel(telefono);
                        emdto.setEstado(estado);
                        emdto.setUser(usuario);
                        if (emdao.update(emdto)){
                            request.getRequestDispatcher("Controlador?menu=Empleado&btn_enviar=Listar").forward(request, response);
                        }
                        break;
                    case "Delete":
                        int id_d = Integer.parseInt(request.getParameter("id"));
                        emdto.setId(id_d);
                        if (emdao.delete(emdto)){
                            request.getRequestDispatcher("Controlador?menu=Empleado&btn_enviar=Listar").forward(request, response);
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
            if(menu.equals("Cliente")){
                switch (accion) {
                    case "Listar":
                            List<ClienteDTO> list = cldao.readAll();
                            request.setAttribute("clientes", list);
                        break;
                    case "Agregar":
                        int id = Integer.parseInt(request.getParameter("txt_id_cliente"));
                        String nombre = request.getParameter("txt_nombre_cliente");
                        String correo = request.getParameter("txt_correo_cliente");
                        String direccion = request.getParameter("txt_direccion_cliente");
                        int estado = Integer.parseInt(request.getParameter("txt_estado_cliente"));
                        cldto.setId_c(id);
                        cldto.setNombre(nombre);
                        cldto.setCorreo(correo);
                        cldto.setDireccion(direccion);
                        cldto.setEstado(estado);
                        if (cldao.create(cldto)){
                            request.getRequestDispatcher("Controlador?menu=Cliente&btn_enviar=Listar").forward(request, response);
                        } else {
                            
                        }
                        break;
                    case "Editar":
                        id = Integer.parseInt(request.getParameter("id"));
                        cldto.setId_c(id);
                        cllega = cldao.read(cldto);
                        request.setAttribute("cliente", cllega);
                        request.getRequestDispatcher("Controlador?menu=Cliente&btn_enviar=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        id = Integer.parseInt(request.getParameter("txt_id_cliente"));
                        nombre = request.getParameter("txt_nombre_cliente");
                        correo = request.getParameter("txt_correo_cliente");
                        direccion = request.getParameter("txt_direccion_cliente");
                        estado = Integer.parseInt(request.getParameter("txt_estado_cliente"));
                        cldto.setId_c(id);
                        cldto.setNombre(nombre);
                        cldto.setCorreo(correo);
                        cldto.setDireccion(direccion);
                        cldto.setEstado(estado);
                        if (cldao.update(cldto)){
                            request.getRequestDispatcher("Controlador?menu=Cliente&btn_enviar=Listar").forward(request, response);
                        }
                        break;
                    case "Delete":
                        int id_d = Integer.parseInt(request.getParameter("id"));
                        cldto.setId_c(id_d);
                        if (cldao.delete(cldto)){
                            request.getRequestDispatcher("Controlador?menu=Cliente&btn_enviar=Listar").forward(request, response);
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Cliente.jsp").forward(request, response);
            }
            if(menu.equals("RegistrarVenta")){
                switch (accion) {
                    case "Buscar Cliente":
                            lista_v = new ArrayList<>();
                            int id = Integer.parseInt(request.getParameter("txt_id_cliente_v"));
                            cldto.setId_c(id);
                            cllega = cldao.read(cldto);
                            request.setAttribute("cliente", cllega);
                            request.setAttribute("numero_serie", numero_serie);
                            request.setAttribute("lista", lista_v);
                        break;
                    case "Buscar Producto":
                            int id_p = Integer.parseInt(request.getParameter("txt_id_producto_v"));
                            prdto.setId_producto(id_p);
                            prllega = prdao.read(prdto);
                            if (prllega.getStock() > 0){
                                request.setAttribute("producto", prllega);
                            }
                            request.setAttribute("cliente", cllega);
                            request.setAttribute("lista", lista_v);
                            request.setAttribute("total_pagar", total_pagar_v);
                            request.setAttribute("numero_serie", numero_serie);
                            request.setAttribute("lista", lista_v);
                        break;
                    case "Agregar":
                            request.setAttribute("cliente", cllega);
                            total_pagar_v = 0.0;
                            item_v = item_v + 1;
                            id_producto = vdto.getId_producto();
                            descripcion_prod_v = request.getParameter("txt_nombre_producto_v");
                            precio_prod_v = Double.parseDouble(request.getParameter("txt_precio_v"));
                            cantidad_prod_v = Integer.parseInt(request.getParameter("txt_cantidad_v"));
                            id_producto = Integer.parseInt(request.getParameter("txt_id_producto_v"));
                            subtotal_v = precio_prod_v*cantidad_prod_v;
                            vdto = new VentasDTO();
                            vdto.setItem(item_v);
                            vdto.setId(id_venta);
                            vdto.setDescripcion_p(descripcion_prod_v);
                            vdto.setPrecio(precio_prod_v);
                            vdto.setCantidad(cantidad_prod_v);
                            vdto.setId_producto(id_producto);
                            vdto.setSubtotal(subtotal_v);
                            lista_v.add(vdto);
                            for(int i = 0; i < lista_v.size(); i++){
                                total_pagar_v = total_pagar_v + lista_v.get(i).getSubtotal();
                            }
                            request.setAttribute("total_pagar", total_pagar_v);
                            request.setAttribute("lista", lista_v);
                            request.setAttribute("numero_serie", numero_serie);
                        break;
                    case "GenerarVenta":
                            // Actualizar Stock
                            for (int i = 0; i < lista_v.size(); i++){
                                int cantidad, id_pr;
                                cantidad = lista_v.get(i).getCantidad();
                                id_pr = lista_v.get(i).getId_producto();
                                prllega = prdao.buscar(id_pr);
                                int sac = prllega.getStock() - cantidad;
                                prdao.updateStock(sac, id_pr);
                            }
                            //Guardar venta
                            vdto.setId_cliente(cldto.getId_c());
                            vdto.setId_empleado(id_empleado);
                            vdto.setNum_serie(numero_serie);
                            vdto.setMonto(total_pagar_v);
                            vdto.setEstado(1);
                            vdao.create(vdto);
                            //Guardar detalles venta
                            int id_v = Integer.parseInt(vdao.read());
                            for (int i = 0; i < lista_v.size(); i++){
                                dvdto = new DetallesVenDTO();
                                dvdto.setId_ventas(id_v);
                                dvdto.setId_prodcuto(lista_v.get(i).getId_producto());
                                dvdto.setCantidad(lista_v.get(i).getCantidad());
                                dvdto.setPrecio(lista_v.get(i).getPrecio());
                                dvdao.create(dvdto);
                            }
                            request.getRequestDispatcher("Controlador?menu=RegistrarVenta&btn_enviar=default").forward(request, response);
                            lista_v = new ArrayList<>();
                        break;
                    case "Cancelar":
                            lista_v = new ArrayList<>();
                            request.setAttribute("lista", lista_v);
                            request.setAttribute("numero_serie", numero_serie);
                            request.setAttribute("cliente", cllega);
                            total_pagar_v = 0.0;
                            request.setAttribute("total_pagar", total_pagar_v);
                        break;
                    case "Delete":
                            total_pagar_v = 0.0;
                            int index = Integer.parseInt(request.getParameter("index"));
                            lista_v.remove(index);
                            for(int i = 0; i < lista_v.size(); i++){
                                total_pagar_v = total_pagar_v + lista_v.get(i).getSubtotal();
                            }
                            request.setAttribute("lista", lista_v);
                            request.setAttribute("numero_serie", numero_serie);
                            request.setAttribute("cliente", cllega);
                            request.setAttribute("total_pagar", total_pagar_v);
                        break;
                    default:
                        total_pagar_v = 0.0;
                        numero_serie = vdao.generar_serie();
                        if (numero_serie == null){
                            numero_serie = "00000001";
                            request.setAttribute("numero_serie", numero_serie);
                        } else {
                            int incrementar = Integer.parseInt(numero_serie);
                            GenerarSerie gs = new GenerarSerie();
                            numero_serie = gs.numeroSerie(incrementar);
                            request.setAttribute("numero_serie", numero_serie);
                        }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            if(menu.equals("Producto")){
                switch (accion) {
                    case "Listar":
                        List<ProductoDTO> list = prdao.readAll();
                        request.setAttribute("productos", list);
                        break;
                    case "Agregar":
                        int id = Integer.parseInt(request.getParameter("txt_id_producto"));
                        String nombre = request.getParameter("txt_nombre_producto");
                        Double precio = Double.parseDouble(request.getParameter("txt_precio_producto"));
                        int stock = Integer.parseInt(request.getParameter("txt_stock_producto"));
                        int estado = Integer.parseInt(request.getParameter("txt_estado_producto"));
                        prdto.setId_producto(id);
                        prdto.setNombre(nombre);
                        prdto.setPrecio(precio);
                        prdto.setStock(stock);
                        prdto.setEstado(estado);
                        if (prdao.create(prdto)){
                            request.getRequestDispatcher("Controlador?menu=Producto&btn_enviar=Listar").forward(request, response);
                        } else {
                            
                        }
                        break;
                    case "Editar":
                        id = Integer.parseInt(request.getParameter("id"));
                        prdto.setId_producto(id);
                        prllega = prdao.read(prdto);
                        request.setAttribute("producto", prllega);
                        request.getRequestDispatcher("Controlador?menu=Producto&btn_enviar=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        id = Integer.parseInt(request.getParameter("txt_id_producto"));
                        nombre = request.getParameter("txt_nombre_producto");
                        precio = Double.parseDouble(request.getParameter("txt_precio_producto"));
                        stock = Integer.parseInt(request.getParameter("txt_stock_producto"));
                        estado = Integer.parseInt(request.getParameter("txt_estado_producto"));
                        prdto.setId_producto(id);
                        prdto.setNombre(nombre);
                        prdto.setPrecio(precio);
                        prdto.setStock(stock);
                        prdto.setEstado(estado);
                        if (prdao.update(prdto)){
                            request.getRequestDispatcher("Controlador?menu=Producto&btn_enviar=Listar").forward(request, response);
                        }
                        break;
                    case "Delete":
                        int id_d = Integer.parseInt(request.getParameter("id"));
                        prdto.setId_producto(id_d);
                            request.getRequestDispatcher("Controlador?menu=Producto&btn_enviar=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
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
