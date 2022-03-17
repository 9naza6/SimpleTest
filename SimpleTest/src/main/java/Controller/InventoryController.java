/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connection.ConnectionSQL;
import java.sql.Connection;
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
public class InventoryController {
    public void showTableInventory(JTable Table){
        ConnectionSQL cc = new ConnectionSQL();
        Connection cin = cc.getConnection();
        Statement st;
        ResultSet rs = null;
        Table.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"productName", "onStock", "sold", "total", "warehouse"});
        try {
            st = cin.createStatement();
            rs = st.executeQuery("SELECT products.name, remaining_qty as onStock, (total_qty-remaining_qty) as sold, total_qty as Total, warehouse.name as Warehouse FROM products INNER JOIN warehouse ON products.idwarehouse = warehouse.id WHERE products.status = 1");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("products.name"), rs.getInt("onStock"), rs.getInt("sold"), rs.getInt("Total"), rs.getString("Warehouse")});
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
}
