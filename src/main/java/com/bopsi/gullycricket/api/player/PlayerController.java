package com.bopsi.gullycricket.api.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public Page<Player> getPlayers(@RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "10") Integer perPage,
                                   @RequestParam(defaultValue = "id") String sortBy) {
        return playerService.findAllPaginated(page, perPage, sortBy);
    }

    @PostMapping("")
    public Long savePlayer(@RequestBody Player player) {
        return playerService.save(player);
    }

    @GetMapping("/{playerId}")
    public Optional<Player> Player(@PathVariable("playerId") long playerId) {
        return playerService.find(playerId);
    }

    @PutMapping("/{playerId}")
    public Long updatePlayer(@PathVariable("playerId") long playerId, @RequestBody Player player) {
        player.setId(playerId);
        return playerService.save(player);
    }

}
