package com.bopsi.gullycricket.api.player;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
}
