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
        TravelClub[] createdClubs = Arrays.copyOfRange(clubs,0,index);
        TravelClub[] foundClubs = new TravelClub[createdClubs.length];
        int subIndex=0;
        for(TravelClub club :createdClubs) {
            if(club.getClubName().equals(clubName)) {
                foundClubs[subIndex++]=club;
            }
        }
        return Arrays.copyOfRange(foundClubs,0,subIndex);
    }

    @Override
    public TravelClub findById(String clubId) {
        TravelClub[] createdClubs = Arrays.copyOfRange(clubs,0,index);
        TravelClub foundClub = null;
        for(TravelClub club :createdClubs) {
            if(club.getId().equals(clubId)) {
                foundClub=club;
                break;
            }
        }
        return foundClub;
    }

    @Override
    public void modify(TravelClub modifyClub) {
        int foundIndex=0;
        for(int i=0;i<clubs.length;i++) {
            if(clubs[i].getId().equals(modifyClub.getId())) {
                foundIndex=i;
                break;
            }
        }
        this.clubs[foundIndex]=modifyClub;
    }

    @Override
    public void remove(String clubId) {
        int foundIndex=0;
        for(int i=0;i<clubs.length;i++) {
            if(clubs[i].getId().equals(clubId)) {
                foundIndex=i;
                break;
            }
        }
        // 예외처리는 필요없다. 이미 그것은 ClubConsole에서 처리하므로 여기선 구현만!


        for(int i=foundIndex;i<this.index+1;i++) {
            clubs[i] = clubs[i+1];
        }
        clubs[index--]=null;
    }
}
