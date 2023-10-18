package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Product {
    private int productID;
    private String productName;
    private Double unitPrice;
    private int quantity;
    private LocalDate date;

    public Product(){
        this.productID = 104;
    }
    public Product(int productID, String productName, Double unitPrice, int quantity, LocalDate date) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.date = date;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
    public Product inputProduct(Scanner input){
        System.out.println("Input product ID   : "+(productID+1));
        System.out.print("Input Product Name : ");
        productName = input.nextLine();
        System.out.print("Input Product Unit Price : ");
        unitPrice = input.nextDouble();
        System.out.print("Input Product Quantity : ");
        quantity = input.nextInt();
        date = LocalDate.now();
        return this;
    }

}
