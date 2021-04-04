package com.bopsi.gullycricket.api.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping("")
    public Page<Venue> getVenues(@RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "10") Integer perPage,
                                 @RequestParam(defaultValue = "id") String sortBy) {
        return venueService.findAllPaginated(page, perPage, sortBy);
    }

    @PostMapping("")
    public Long saveVenue(@RequestBody Venue venue) {
        return venueService.save(venue);
    }

    @GetMapping("/{venueId}")
    public Optional<Venue> Venue(@PathVariable("venueId") long venueId) {
        return venueService.find(venueId);
    }

    @PutMapping("/{venueId}")
    public Long updateVenue(@PathVariable("venueId") long venueId,
                            @RequestBody Venue venue) {
        venue.setId(venueId);
        return venueService.save(venue);
    }
}
