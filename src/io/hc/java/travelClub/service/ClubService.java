package io.hc.java.travelClub.service;

import io.hc.java.travelClub.entity.TravelClub;

public interface ClubService {
    void register(TravelClub travelClub);
    TravelClub[] findAll();
    TravelClub[] findByName(String clubName);
    TravelClub[] findById(String clubId);

    void modify(TravelClub modifyClub);
    void remove(TravelClub clubId);

}
