package com.bopsi.gullycricket.api.venue;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends PagingAndSortingRepository<Venue, Long> {
}
