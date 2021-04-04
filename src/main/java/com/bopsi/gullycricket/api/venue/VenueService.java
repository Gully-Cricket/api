package com.bopsi.gullycricket.api.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueService {
    @Autowired
    private VenueRepo venueRepo;

    public Page<Venue> findAllPaginated(int page, int perPage, String sortBy) {
        return venueRepo.findAll(PageRequest.of(page, perPage, Sort.by(sortBy)));
    }

    public Long save(Venue venue) {
        Venue newVenue = venueRepo.save(venue);
        return newVenue.getId();
    }

    public Optional<Venue> find(long venueId) {
        return venueRepo.findById(venueId);
    }
}
