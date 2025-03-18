package org.zero.ds6.controller;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.zero.ds6.TripOuterClass;
import org.zero.ds6.TripOuterClass.TripsResponse;
import org.zero.ds6.TripServiceGrpc.TripServiceImplBase;
import org.zero.ds6.mapper.TripMapper;
import org.zero.ds6.service.TripService;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class TripController extends TripServiceImplBase{
    private final TripService tripService;

    @Override
    public void removeTrip(TripOuterClass.RemoveRequest request, StreamObserver<Empty> responseObserver) {
        var tripId = request.getTripId();

        tripService.delete(tripId);

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void createTrip(TripOuterClass.Trip request, StreamObserver<Empty> responseObserver) {
        var requestBody = TripMapper.map(request);

        tripService.save(requestBody);

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void getTrip(Empty request, StreamObserver<TripsResponse> responseObserver) {
        var trips = tripService.getAllTrips().stream()
                .map(TripMapper::map)
                .toList();


        var response = TripsResponse.newBuilder()
                .addAllTrips(trips)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
