package org.zero.ds6.controller;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.zero.ds6.TripOuterClass.TripsResponse;
import org.zero.ds6.TripServiceGrpc.TripServiceImplBase;
import org.zero.ds6.mapper.TripMapper;
import org.zero.ds6.service.TripService;

@GrpcService
@RequiredArgsConstructor
public class TripController extends TripServiceImplBase{
    private final TripService tripService;

    @Override
    public void getTask(Empty request, StreamObserver<TripsResponse> responseObserver) {
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
