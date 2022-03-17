/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nazareth
 */
public class ProductModel {
    private int idwarehouse;
    private int idlegend;
    private String name;
    private int total_qty;
    private int remaining_qty;
    private double status;

    public ProductModel(int idwarehouse, int idlegend, String name, int total_qty, int remaining_qty, double status) {
        this.idwarehouse = idwarehouse;
        this.idlegend = idlegend;
        this.name = name;
        this.total_qty = total_qty;
        this.remaining_qty = remaining_qty;
        this.status = status;
    }

   

    public String getName() {
        return name;
    }

    public int getTotal_qty() {
        return total_qty;
    }

    public int getRemaining_qty() {
        return remaining_qty;
    }

    public double getStatus() {
        return status;
    }

    public int getIdwarehouse() {
        return idwarehouse;
    }

    public int getIdlegend() {
        return idlegend;
    }

  
}
