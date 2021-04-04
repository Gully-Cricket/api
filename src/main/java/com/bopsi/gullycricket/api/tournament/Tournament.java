package com.bopsi.gullycricket.api.tournament;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table
public class Tournament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tournament name is mandatory")
    private String name;

    @NotBlank(message = "Last name is mandatory")
    private String season;
}
