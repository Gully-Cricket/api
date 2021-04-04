package com.bopsi.gullycricket.api.match;

import com.bopsi.gullycricket.api.common.Address;
import com.bopsi.gullycricket.api.player.Player;
import com.bopsi.gullycricket.api.team.Team;
import com.bopsi.gullycricket.api.venue.Venue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Match implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull(message = "Venue is mandatory")
    private Venue venue;

    @OneToOne
    private Team team1;

    @OneToMany
    private List<Player> team1Squad;

    @OneToMany
    private List<Player> team1Playing11;

    @OneToOne
    private Team team2;

    @OneToMany
    private List<Player> team2Squad;

}
