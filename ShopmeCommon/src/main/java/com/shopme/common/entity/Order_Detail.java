package com.shopme.common.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "orders_detail")
public class Order_Detail {
    
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "order_id") 
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "variant_id")  
    private Variant variant;
    
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

   
    @OneToMany(mappedBy = "order_detail") 
    private List<Review> reviews = new ArrayList<>();
}
