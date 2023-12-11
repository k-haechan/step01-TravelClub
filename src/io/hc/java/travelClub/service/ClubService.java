package io.hc.java.travelClub.service;

import io.hc.java.travelClub.entity.TravelClub;

import java.util.List;

public interface ClubService {
    void register(TravelClub travelClub);
    List<TravelClub> findAll();
    List<TravelClub> findByName(String clubName);
    TravelClub findById(String clubId);

    void modify(TravelClub modifyClub);
    void remove(String clubId);

}
