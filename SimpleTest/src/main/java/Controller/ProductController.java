/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectionSQL;
import Model.ListWarehouseModel;
import Model.ProductModel;
import Model.WarehouseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nazareth
 */
public class ProductController {
    public boolean addProduct(ProductModel product) throws SQLException {
        
        boolean valido = false;
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        
        try {
            String consulta = "INSERT INTO products (idwarehouse, idlegend, name, total_qty, remaining_qty, status) VALUES (?,?,?,?,?,1)";
            PreparedStatement pst = cin.prepareStatement(consulta);
            System.out.println(consulta);
            pst.setInt(1, product.getIdwarehouse());
            pst.setInt(2, product.getIdlegend());
            pst.setString(3, product.getName());
            pst.setInt(4, product.getTotal_qty());
            pst.setInt(5, product.getRemaining_qty());
            int resultado = pst.executeUpdate();
            if(resultado == 1){
                valido = true;
            }else{
                System.out.println(":c");
                valido = false;
            }
            
        } catch (SQLException e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }

        return valido;
    }
    
    public void showTableLegend(JTable Table){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        Table.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel model = new DefaultTableModel(){public boolean isCellEditable(int row, int column){return false;}};
        JButton update = new JButton("Update");
        update.setName("update");
        JButton remove = new JButton("Remove");
        remove.setName("remove");
        model.setColumnIdentifiers(new Object[]{"name", "total_qty", "remaining_qty", "warehouse", "update", "remove"});
        try {
            st = cin.createStatement();
            rs = st.executeQuery("SELECT products.name, total_qty, remaining_qty, warehouse.name FROM products INNER JOIN warehouse ON products.idwarehouse = warehouse.id WHERE products.status = 1");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("products.name"), rs.getInt("total_qty"), rs.getInt("remaining_qty"), rs.getString("warehouse.name"), update, remove});
            }
            Table.setModel(model);
            Table.setRowHeight(30);
        } catch (SQLException e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }
    }
    
    public void warehousesName(JComboBox cbox){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        ArrayList<WarehouseModel> lista = new ArrayList();
        
        try {
            st = cin.createStatement();
            rs = st.executeQuery("SELECT name FROM warehouse");
            cbox.addItem("Seleccione una opción");
            while(rs.next()){
                cbox.addItem(rs.getString("name"));
            }
        } catch (SQLException e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }
    }
    
    public int getColor(int id){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        int value = 0;
        try {
            st = cin.createStatement();
            rs = st.executeQuery("SELECT product_max FROM warehouse WHERE id = "+ id +"");
            while(rs.next()){
                value = rs.getInt("product_max");
            }
        } catch (SQLException e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }
        return value;
    }
    
    public ArrayList addWarehouse() {
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        ArrayList<ListWarehouseModel> lista = new ArrayList();
        
        try {
            st = cin.createStatement();
            rs = st.executeQuery("SELECT id, name FROM warehouse");
            while(rs.next()){
                lista.add(new ListWarehouseModel(rs.getString("name"), rs.getInt("id")));
            }
        } catch (SQLException e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(LegendController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }
        return lista;
    }
    
    public boolean drop(String name){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        boolean valido = false;
        try {
            st = cin.createStatement();
            int result  = st.executeUpdate("UPDATE products SET status = 0 WHERE name = '" + name +"'");
                if (result > -1) {
                    valido = true;
                }
        } catch (SQLException e) {
            Logger.getLogger(WarehouseController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(WarehouseController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }
        return valido;
    }
    
    public boolean update(int idwarehouse, int idlegend, String name, int total, int remaining, String nameProduct){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        boolean valido = false;
        try {
            st = cin.createStatement();
            int result  = st.executeUpdate("UPDATE products SET idwarehouse = " + idwarehouse +", idlegend = " + idlegend + ", name = '" + name + "', total_qty = "+ total +", remaining_qty = "+ remaining +" WHERE name = '"+ nameProduct +"'");
                if (result > -1) {
                    valido = true;
                }
        } catch (SQLException e) {
            Logger.getLogger(WarehouseController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(WarehouseController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }
        return valido;
    }
    
}
