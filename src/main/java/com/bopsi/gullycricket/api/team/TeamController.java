package com.bopsi.gullycricket.api.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public Page<Team> getTeams(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer perPage, @RequestParam(defaultValue = "id") String sortBy) {
        return teamService.findAllPaginated(page, perPage, sortBy);
    }

    @PostMapping("")
    public Long saveTeam(@RequestBody Team team) {
        return teamService.save(team);
    }

    @GetMapping("/{teamId}")
    public Optional<Team> Team(@PathVariable("teamId") long teamId) {
        return teamService.find(teamId);
    }

    @PutMapping("/{teamId}")
    public Long updateTeam(@RequestBody Team team) {
        return teamService.save(team);
    }
}
