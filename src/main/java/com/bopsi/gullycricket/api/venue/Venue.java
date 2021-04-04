package com.bopsi.gullycricket.api.venue;

import com.bopsi.gullycricket.api.common.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table
public class Venue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Venue name is mandatory")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private int capacity;

    private String end1;

    private String end2;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEnd1() {
        return end1;
    }

    public void setEnd1(String end1) {
        this.end1 = end1;
    }

    public String getEnd2() {
        return end2;
    }

    public void setEnd2(String end2) {
        this.end2 = end2;
    }
}
