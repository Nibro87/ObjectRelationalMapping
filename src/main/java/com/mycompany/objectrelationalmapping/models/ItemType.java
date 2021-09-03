package com.mycompany.objectrelationalmapping.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ItemType implements Serializable {

    private String name;
    private String description;
    private double price;

    public ItemType() {
    }

    public ItemType(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }




    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "ItemType",  cascade = CascadeType.PERSIST)
    private List<OrderLine> OrderLine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<com.mycompany.objectrelationalmapping.models.OrderLine> getOrderLine() {
        return OrderLine;
    }

    public void setOrderLine(List<com.mycompany.objectrelationalmapping.models.OrderLine> orderLine) {
        OrderLine = orderLine;
    }
}
