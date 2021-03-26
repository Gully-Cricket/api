package com.bopsi.gullycricket.api.team;

import com.bopsi.gullycricket.api.common.Address;
import com.bopsi.gullycricket.api.common.TeamLevel;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Team name is mandatory")
    private String name;

    @NotNull(message = "Team level is mandatory")
    @Enumerated(EnumType.STRING)
    private TeamLevel level;

    @OneToOne(cascade = CascadeType.ALL)
    private Address base;

    @NotNull(message = "Date of formation name is mandatory")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfFormation;

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

    public TeamLevel getLevel() {
        return level;
    }

    public void setLevel(TeamLevel level) {
        this.level = level;
    }

    public Address getBase() {
        return base;
    }

    public void setBase(Address base) {
        this.base = base;
    }
}
