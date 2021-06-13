package com.bopsi.gullycricket.api.match;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.bopsi.gullycricket.api.player.Player;
import com.bopsi.gullycricket.api.team.Team;
import com.bopsi.gullycricket.api.venue.Venue;

@Entity
@Table
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

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
