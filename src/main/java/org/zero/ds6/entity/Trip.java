package org.zero.ds6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "destination", nullable = false, length = Integer.MAX_VALUE)
    private String destination;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "seats_available", nullable = false)
    private Integer seatsAvailable;
}