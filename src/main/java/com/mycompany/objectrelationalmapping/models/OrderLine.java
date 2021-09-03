package com.mycompany.objectrelationalmapping.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderLine implements Serializable {

    private int Quantity;


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    private Orders orders;

    @ManyToOne
    private ItemType itemType;


}
