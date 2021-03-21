package com.bopsi.gullycricket.api.player;

import com.bopsi.gullycricket.api.common.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    @OneToOne
    private Address placeOfBirth;

    @Enumerated(EnumType.STRING)
    private PlayerRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        if(this.dateOfBirth == null){
            return null;
        }
        LocalDate today = LocalDate.now();
        LocalDate birthday = this.dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period p = Period.between(birthday, today);
        return p.getYears();
    }

    public Address getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Address placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public PlayerRole getRole() {
        return role;
    }

    public void setRole(PlayerRole role) {
        this.role = role;
    }
}
