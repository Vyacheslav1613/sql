package ru.netology.sql.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(schema = "netology", name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "amount")
    private double amount;

    public Orders() {}

    public Orders(Date date, int customerId, String productName, double amount) {
        this.date = date;
        this.customerId = customerId;
        this.productName = productName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
