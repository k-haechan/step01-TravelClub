package io.hc.java.travelClub.store;

import io.hc.java.travelClub.store.logic.ClubMapStore;

public class StoreLifeCycler {
    private static StoreLifeCycler uniqueInstance;
    private ClubStore clubStore;
    private StoreLifeCycler() {
        this.clubStore=new ClubMapStore();
    }

    public static StoreLifeCycler getUniqueInstance() {
        if(uniqueInstance==null) {
            uniqueInstance=new StoreLifeCycler();
        }
        return uniqueInstance;
    }

    public ClubStore requestClubStore() {
        return this.clubStore;
    }
}
