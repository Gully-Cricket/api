package com.bopsi.gullycricket.api.team;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends PagingAndSortingRepository<Team, Long> {
}
