package com.bopsi.gullycricket.api.team;

import com.bopsi.gullycricket.api.player.Player;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Member implements Serializable {

    Member() {
    }

    Member(long teamId, MemberDTO memberDTO) {
        Team team = new Team();
        team.setId(teamId);
        Player player = new Player();
        player.setId(memberDTO.getPlayerId());
        this.id = memberDTO.getId();
        this.team = team;
        this.player = player;
        this.startDate = memberDTO.getStartDate();
        this.endDate = memberDTO.getEndDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    private Team team;

    @OneToOne
    private Player player;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
