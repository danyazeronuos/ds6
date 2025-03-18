package org.zero.ds6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zero.ds6.entity.Trip;
import org.zero.ds6.repository.TripRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public void save(Trip trip) {
        tripRepository.save(trip);
    }

    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }
}
