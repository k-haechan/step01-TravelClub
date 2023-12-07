package io.hc.java.travelClub.service.logic;

import io.hc.java.travelClub.entity.TravelClub;
import io.hc.java.travelClub.service.ClubService;

import java.util.Arrays;

public class ClubServiceLogic implements ClubService {
    private TravelClub[] clubs;
    private int index; // 초기값은 0


    public ClubServiceLogic() {
        this.clubs = new TravelClub[10];
    }

    @Override
    public void register(TravelClub travelClub) {
        clubs[index++]=travelClub;
        // index범위는?
    }

    @Override
    public TravelClub[] findAll() {
        return Arrays.copyOfRange(clubs,0,index);
    }

    @Override
    public TravelClub[] findByName(String clubName) {
        return new TravelClub[0];
    }

    @Override
    public TravelClub[] findById(String clubId) {
        return new TravelClub[0];
    }

    @Override
    public void modify(TravelClub modifyClub) {

    }

    @Override
    public void remove(TravelClub clubId) {

    }
}
