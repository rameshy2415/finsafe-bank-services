package com.techinsights.accounts.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class CustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;

    private String name;

    private String email;

    @Column(name="mobile_number")
    private String mobileNumber;
}
