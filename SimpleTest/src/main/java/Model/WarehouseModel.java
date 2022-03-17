/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nazareth
 */
public class WarehouseModel{
    private int id;
    private String name;
    private int product_min;
    private int product_max;
    private double status;

    

    public WarehouseModel(String name, int product_min, int product_max, double status) {
        this.name = name;
        this.product_min = product_min;
        this.product_max = product_max;
        this.status = status;
    }

    

    public String getName() {
        return name;
    }

    public int getProduct_min() {
        return product_min;
    }

    public int getProduct_max() {
        return product_max;
    }

    public double getStatus() {
        return status;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct_min(int product_min) {
        this.product_min = product_min;
    }

    public void setProduct_max(int product_max) {
        this.product_max = product_max;
    }

    public void setStatus(double status) {
        this.status = status;
    }
}
