/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Controller.ProductController;
import Controller.WarehouseController;
import Model.ListWarehouseModel;
import Model.ProductModel;
import Model.WarehouseModel;
import static View.main.btnProduct;
import static View.main.btnWarehouse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Nazareth
 */
public class FrmProducts extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmProducts
     */
    ProductController product = new ProductController();
    ArrayList<ListWarehouseModel> lista = new ArrayList();
    String nameProduct = "";
    public FrmProducts() {
        initComponents();
        close();
        product.showTableLegend(tableProducts);
        product.warehousesName(itemWarehouse);
        lista = product.addWarehouse();
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    public void close() {
        try {
            addInternalFrameListener(
                    new InternalFrameAdapter() {
                public void internalFrameClosing(InternalFrameEvent e) {
                    btnProduct.setEnabled(true);
                }
            });
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtTotalQty = new javax.swing.JTextField();
        itemWarehouse = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtRemainingQty = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Products"));

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Total qty", "Remaining qty", "Warehouse", "Edit", "Delete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProducts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Total Qty:");

        jLabel3.setText("Remaining Qty:");

        itemWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemWarehouseActionPerformed(evt);
            }
        });

        jLabel4.setText("Warehouse:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnEdit)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnDelete))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTotalQty, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRemainingQty, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotalQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtRemainingQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(itemWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String Warehouse = (String) itemWarehouse.getSelectedItem();
        int idWarehouse = -1;
        int idLegend = 0;
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getName());
            if(lista.get(i).getName().equals(Warehouse)){
                idWarehouse = lista.get(i).getId();
            }
        }
        if(product.getColor(idWarehouse)>Integer.parseInt(txtRemainingQty.getText())){
            idLegend = 1;
        }else if (product.getColor(idWarehouse)<Integer.parseInt(txtRemainingQty.getText())){
            idLegend = 2;
        }else{
            idLegend = 3;
        }
        ProductModel modelProduct = new ProductModel(idWarehouse, idLegend, txtName.getText(), Integer.parseInt(txtTotalQty.getText()), Integer.parseInt(txtRemainingQty.getText()), 1);
        try {
            if(product.addProduct(modelProduct)){
                JOptionPane.showMessageDialog(this, "New product added.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                product.showTableLegend(tableProducts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmWarehouses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String Warehouse = (String) itemWarehouse.getSelectedItem();
        int idWarehouse = -1;
        int idLegend = 0;
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getName());
            if(lista.get(i).getName().equals(Warehouse)){
                idWarehouse = lista.get(i).getId();
            }
        }
        if(product.getColor(idWarehouse)>Integer.parseInt(txtRemainingQty.getText())){
            idLegend = 1;
        }else if (product.getColor(idWarehouse)<Integer.parseInt(txtRemainingQty.getText())){
            idLegend = 2;
        }else{
            idLegend = 3;
        }
        if (product.update(idWarehouse, idLegend, txtName.getText(), Integer.parseInt(txtTotalQty.getText()), Integer.parseInt(txtRemainingQty.getText()), nameProduct)) {
            JOptionPane.showMessageDialog(this, "Update warehouse.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            product.showTableLegend(tableProducts);
        }else{
            JOptionPane.showMessageDialog(this, "Could not update.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (product.drop(txtName.getText())) {
            JOptionPane.showMessageDialog(this, "Deleted product.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            product.showTableLegend(tableProducts);
        }else{
            JOptionPane.showMessageDialog(this, "Could not delete.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void itemWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemWarehouseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemWarehouseActionPerformed

    private void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductsMouseClicked
        // TODO add your handling code here:
        String Warehouse = (String) itemWarehouse.getSelectedItem();
        int column = tableProducts.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tableProducts.getRowHeight();
        if(row < tableProducts.getRowCount() && row >=0 && column < tableProducts.getColumnCount() && column >=0){
            Object value = tableProducts.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton button = (JButton) value;
                if(button.getName().equals("update")){
                    int clic_tabla = this.tableProducts.rowAtPoint(evt.getPoint());
                    String name = ""+tableProducts.getValueAt(clic_tabla, 0);
                    int totalQty = (int)tableProducts.getValueAt(clic_tabla, 1);
                    int remainingQty = (int)tableProducts.getValueAt(clic_tabla, 2);
                    String warehouse = "" + tableProducts.getValueAt(clic_tabla, 3);
                    nameProduct = name;
                    txtName.setText(name);
                    txtTotalQty.setText("" + totalQty);
                    txtRemainingQty.setText("" + remainingQty);
                    
                    btnEdit.setEnabled(true);
                    btnAdd.setEnabled(true);
                    btnDelete.setEnabled(false);
                }
                if(button.getName().equals("remove")){
                    int clic_tabla = this.tableProducts.rowAtPoint(evt.getPoint());
                    String name = ""+tableProducts.getValueAt(clic_tabla, 0);
                    int totalQty = (int)tableProducts.getValueAt(clic_tabla, 1);
                    int remainingQty = (int)tableProducts.getValueAt(clic_tabla, 2);
                    txtName.setText(name);
                    txtTotalQty.setText("" + totalQty);
                    txtRemainingQty.setText("" + remainingQty);
                    btnEdit.setEnabled(false);
                    btnAdd.setEnabled(true);
                    btnDelete.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_tableProductsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> itemWarehouse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRemainingQty;
    private javax.swing.JTextField txtTotalQty;
    // End of variables declaration//GEN-END:variables
}
