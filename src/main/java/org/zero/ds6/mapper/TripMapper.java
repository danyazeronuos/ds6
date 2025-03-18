package org.zero.ds6.mapper;

import org.zero.ds6.TripOuterClass;
import org.zero.ds6.entity.Trip;

public class TripMapper {
    public static Trip map(TripOuterClass.Trip trip) {
        return Trip.builder()
                .seatsAvailable(trip.getSeatsAvailable())
                .destination(trip.getDestination())
                .price(trip.getPrice())
//                .id(trip.getId())
                .build();
    }
    public static TripOuterClass.Trip map(Trip element) {
        return TripOuterClass.Trip.newBuilder()
                .setId(element.getId())
                .setDestination(element.getDestination())
                .setPrice(element.getPrice())
                .build();
    }
}
