package com.bopsi.gullycricket.api.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public Iterable<Player> getPlayers(){
        return this.playerRepo.findAll();
    }
}
