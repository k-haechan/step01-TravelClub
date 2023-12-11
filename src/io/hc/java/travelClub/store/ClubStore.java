package io.hc.java.travelClub.store;

import io.hc.java.travelClub.entity.TravelClub;

import java.util.List;

// 클럽 CRUD를 담당하는 인터페이스
public interface ClubStore {
    void create(TravelClub travelClub);
    TravelClub retrieve(String clubId);
    List<TravelClub> retreiveAllByName(String clubName);
    List<TravelClub> retireveAll();

    void update(TravelClub updateClub);
    void delete(String clubId);
}
