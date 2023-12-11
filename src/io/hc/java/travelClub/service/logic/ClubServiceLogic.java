package io.hc.java.travelClub.service.logic;

import io.hc.java.travelClub.entity.TravelClub;
import io.hc.java.travelClub.service.ClubService;
import io.hc.java.travelClub.store.ClubStore;
import io.hc.java.travelClub.store.StoreLifeCycler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClubServiceLogic implements ClubService {
    private ClubStore clubStore;
    public ClubServiceLogic() {
        this.clubStore = StoreLifeCycler.getUniqueInstance().requestClubStore();
    }

    @Override
    public void register(TravelClub travelClub) {
        this.clubStore.create(travelClub);
    }

    @Override
    public List<TravelClub> findAll() {
        return new ArrayList<>(clubStore.retireveAll());
    }

    @Override
    public List<TravelClub> findByName(String clubName) {
        return new ArrayList<>(clubStore.retreiveAllByName(clubName));
    }

    @Override
    public TravelClub findById(String clubId) {
        return this.clubStore.retrieve(clubId);
    }

    @Override
    public void modify(TravelClub modifyClub) {
        this.clubStore.update(modifyClub);
    }

    @Override
    public void remove(String clubId) {
        this.clubStore.delete(clubId);
    }
}
