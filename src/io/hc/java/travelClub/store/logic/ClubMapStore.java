package io.hc.java.travelClub.store.logic;

import io.hc.java.travelClub.entity.TravelClub;
import io.hc.java.travelClub.store.ClubStore;

import java.util.*;

// 클럽 CRUD를 담당하며, 값을 저장하는 객체
public class ClubMapStore implements ClubStore {
    private Map<String, TravelClub> clubMap; // 클럽 정보 저장

    public ClubMapStore() {
        this.clubMap=new HashMap<>();
    }
    @Override
    public void create(TravelClub travelClub) {
        this.clubMap.put(travelClub.getId(),travelClub);
    }

    @Override
    public TravelClub retrieve(String clubId) {
        return this.clubMap.get(clubId);
        // 기존의 자료구조는 배열로, 반복문의 순회를 통해서 데이터를 찾았다.
        // 이는 비효율적이므로, Map통해서 자료를 만든다.
    }

    @Override
    public List<TravelClub> retreiveAllByName(String clubName) {
       List<TravelClub> foundClubs = new ArrayList<>();
       for(TravelClub club: this.clubMap.values()) {
           if(club.getClubName().equals(clubName)) {
               foundClubs.add(club);
           }
       }

//       Iterator<TravelClub> iterator = this.clubMap.values().iterator();
//       while(iterator.hasNext()) {
//           TravelClub club = iterator.next();
//           if(club.getClubName().equals(clubName)) {
//               foundClubs.add(club);
//           }
//       }

       return foundClubs;
    }

    @Override
    public List<TravelClub> retireveAll() {
        return new ArrayList<>(this.clubMap.values());
    }

    @Override
    public void update(TravelClub updateClub) {
        this.clubMap.put(updateClub.getId(), updateClub);
    }

    @Override
    public void delete(String clubId) {
        this.clubMap.remove(clubId);
    }
}
