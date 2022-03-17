/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectionSQL;
import Model.WarehouseModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nazareth
 */
public class WarehouseController {
    
    public boolean addWarehouse(WarehouseModel warehouse) throws SQLException {
        
        boolean valido = false;
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        
        try {
            String consulta = "INSERT INTO warehouse (name, product_min, product_max, status) VALUES (?,?,?,1)";
            PreparedStatement pst = cin.prepareStatement(consulta);
            pst.setString(1, warehouse.getName());
            pst.setInt(2, warehouse.getProduct_min());
            pst.setInt(3, warehouse.getProduct_max());
            int resultado = pst.executeUpdate();
            if(resultado == 1){
                System.out.println("Controller.LegendController.addLegend()");
                valido = true;
            }else{
                System.out.println(":c");
                valido = false;
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
        model.setColumnIdentifiers(new Object[]{"name", "product_min", "product_max", "update", "remove"});
        try {
            st = cin.createStatement();
            rs = st.executeQuery("SELECT name, product_min, product_max FROM warehouse WHERE status = 1");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("name"), rs.getInt("product_min"), rs.getInt("product_max"), update, remove});
            }
            Table.setModel(model);
            Table.setRowHeight(30);
        } catch (SQLException e) {
            Logger.getLogger(WarehouseController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } catch (Exception e) {
            Logger.getLogger(WarehouseController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        } finally {
            cc.Exit(cin);
        }
    }
    
    public boolean drop(String name){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        boolean valido = false;
        try {
            st = cin.createStatement();
            int result  = st.executeUpdate("UPDATE warehouse SET status = 0 WHERE name = '" + name +"'");
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
    
    public boolean update(String name, int min, int max, String namePlant){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        boolean valido = false;
        try {
            st = cin.createStatement();
            int result  = st.executeUpdate("UPDATE warehouse SET name = '" + name +"', product_min = " + min + ", product_max = " + max + " WHERE name = '"+ namePlant +"'");
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
