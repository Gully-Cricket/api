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
    public Page<Team> getTeams(@RequestParam(defaultValue = "0") Integer page,
                               @RequestParam(defaultValue = "10") Integer perPage,
                               @RequestParam(defaultValue = "id") String sortBy) {
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
    public Long updateTeam(@PathVariable("teamId") long teamId,
                           @RequestBody Team team) {
        team.setId(teamId);
        return teamService.save(team);
    }

    @GetMapping("/{teamId}/squad")
    public Iterable<Member> createSquad(@PathVariable("teamId") long teamId) {
        return teamService.getCurrentSquad(teamId);
    }

    @PostMapping("/{teamId}/squad/add")
    public Member createSquad(@PathVariable("teamId") long teamId,
                              @RequestBody MemberDTO member) throws Exception {
        return teamService.addToSquad(teamId, member);
    }

    @DeleteMapping("/{teamId}/squad/remove")
    public Member addToSquad(@PathVariable("teamId") long teamId,
                             @RequestBody MemberDTO member) throws Exception {
        return teamService.removeFromSquad(teamId, member);
    }

}
