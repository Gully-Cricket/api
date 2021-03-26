package com.bopsi.gullycricket.api.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    public Page<Team> findAllPaginated(int page, int perPage, String sortBy) {
        return teamRepo.findAll(PageRequest.of(page, perPage, Sort.by(sortBy)));
    }

    public Long save(Team team){
        Team newTeam = teamRepo.save(team);
        return newTeam.getId();
    }

    public Optional<Team> find(long teamId) {
        return teamRepo.findById(teamId);
    }
}
