package com.mycompany.objectrelationalmapping.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Orders implements Serializable {



    public Orders() {
    }



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Customer customer;



    @OneToMany(mappedBy = "Orders",  cascade = CascadeType.PERSIST)
    private List<OrderLine> OrderLine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<com.mycompany.objectrelationalmapping.models.OrderLine> getOrderLine() {
        return OrderLine;
    }

    public void setOrderLine(List<com.mycompany.objectrelationalmapping.models.OrderLine> orderLine) {
        OrderLine = orderLine;
    }
}
