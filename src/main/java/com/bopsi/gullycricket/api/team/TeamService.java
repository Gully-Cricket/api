package com.bopsi.gullycricket.api.team;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private MemberRepo memberRepo;

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

    public Iterable<Member> getCurrentSquad(long teamId){
        return memberRepo.findAllByTeamIdAndEndDate(teamId, null);
    }

    public Member addToSquad(long teamId, MemberDTO memberDTO) throws Exception {
        List<Member> members = (List<Member>) memberRepo.findAllByTeamIdAndPlayerIdAndEndDate(teamId, memberDTO.getPlayerId(), null);
        if(members.size()>0){
            throw new Exception("Member already present in current squad");
        }
        Member member = new Member(teamId, memberDTO);
        return memberRepo.save(member);
    }

    public Member removeFromSquad(long teamId, MemberDTO memberDTO) throws Exception {
        List<Member> members = (List<Member>) memberRepo.findAllByTeamIdAndPlayerIdAndEndDate(teamId, memberDTO.getPlayerId(), null);
        if(members.size() == 0){
            throw new Exception("Member not present in current squad");
        }
        Member member = new Member(teamId, memberDTO);
        return memberRepo.save(member);
    }
}
