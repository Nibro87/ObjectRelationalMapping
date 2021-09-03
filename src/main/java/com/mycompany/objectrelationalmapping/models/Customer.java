package com.mycompany.objectrelationalmapping.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;



    public Customer() {

    }



    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @OneToMany(mappedBy = "Customer",  cascade = CascadeType.PERSIST)
    private List<Orders> Orders;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<com.mycompany.objectrelationalmapping.models.Orders> getOrder() {
        return Orders;
    }

    public void setOrder(final List<Orders> order) {
        Orders = order;
    }



    }

