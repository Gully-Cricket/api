package com.bopsi.gullycricket.api.team;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MemberRepo extends CrudRepository<Member, Long> {
    Iterable<Member> findAllByTeamIdAndEndDate(long teamId, Date startDate);

    Iterable<Member> findAllByTeamIdAndPlayerIdAndEndDate(long teamId, long playerId, Date startDate);
}
