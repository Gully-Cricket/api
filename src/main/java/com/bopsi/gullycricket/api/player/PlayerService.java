package com.bopsi.gullycricket.api.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public Page<Player> findAllPaginated(int page, int perPage, String sortBy) {
        return playerRepo.findAll(PageRequest.of(page, perPage, Sort.by(sortBy)));
    }

    public Long save(Player player){
        Player newPlayer = playerRepo.save(player);
        return newPlayer.getId();
    }

    public Optional<Player> find(long playerId) {
        return playerRepo.findById(playerId);
    }
}
