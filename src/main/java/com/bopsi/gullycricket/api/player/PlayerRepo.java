package com.bopsi.gullycricket.api.player;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepo extends PagingAndSortingRepository<Player, Long> {
}
