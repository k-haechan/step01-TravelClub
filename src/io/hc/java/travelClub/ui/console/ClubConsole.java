package io.hc.java.travelClub.ui.console;

import io.hc.java.travelClub.entity.TravelClub;
import io.hc.java.travelClub.service.ClubService;
import io.hc.java.travelClub.service.ServiceLogicLifeCycler;
import io.hc.java.travelClub.service.logic.ClubServiceLogic;
import io.hc.java.travelClub.ui.menu.ClubMenu;
import io.hc.java.travelClub.util.ConsoleUtil;

import java.util.List;

public class ClubConsole {
    private ConsoleUtil consoleUtil;

    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        // clubConsole은 clubServiceLogic을 모른다. -> 인터페이스를 통한 접근이기 때문.
        // 그런데 왜 인터페이스를 생성하는 방법도 따로 정의했는가? 매번 인터페이스 객체를 새로 생성하면 무결성에 문제가 생길 수밖에 없다.
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }

    public void register() {
        while(true) {
            String clubName=consoleUtil.getValueOf("Club Name(0.Club Menu)");
            if(clubName.equals("0")) {
                return;
            }
            String intro = consoleUtil.getValueOf("Club Intro(0.Club Menu)");
            if(intro.equals("0")){
                return;
            }

            TravelClub newClub = new TravelClub(clubName, intro);

            clubService.register(newClub);

            System.out.println("Registered Club : " + newClub.toString());

        }
    }
    public void findAll() {
        List<TravelClub> foundClubs = clubService.findAll();
        if(foundClubs.isEmpty()) {
            System.out.println("Empty~~");
            return;
        }
        for(TravelClub club : foundClubs) {
            System.out.println(club.toString());
        }
    }
    public void findByID() {
        TravelClub foundClub = null;
        while(true) {
            String clubId=consoleUtil.getValueOf("Club ID to find(0. Club Menu)");
            if(clubId.equals("0")){
                break;
            }
            foundClub=clubService.findById(clubId);
            if(foundClub != null) {
                System.out.println(foundClub);
            }else {
                System.out.println("Can not find club, ID : " + clubId);
            }
        }
    }

    public void findByName() {
        List<TravelClub> foundClubs = null;
        while(true) {
            String clubName=consoleUtil.getValueOf("Club Name to find(0. Club Menu)");
            if(clubName.equals("0")){
                break;
            }
            foundClubs = clubService.findByName(clubName);

            if(foundClubs!=null && !foundClubs.isEmpty()) {
                for(TravelClub club : foundClubs) {
                    System.out.println(club);
                }
            }else {
                System.out.println("Can not find club Name : " + clubName);
            }
        }
    }

    private TravelClub findOne() {
        TravelClub foundClub = null;
        while(true) {
            String clubId = consoleUtil.getValueOf("Club ID to find(0. Club Menu)");
            if (clubId.equals("0")) {
                break;
            }
            foundClub = clubService.findById(clubId);
            if (foundClub != null) {
                break;
            } else {
                System.out.println("Can not find club, ID : " + clubId);
            }
        }
        return foundClub;
    }

    public void modify() {
        TravelClub targetClub = findOne();

        String newName = consoleUtil.getValueOf("New Club name(0. Club Menu, Enter, No Change.)");
        if(newName.equals("0")) {
            return;
        }
        if(!newName.isEmpty()) {
            targetClub.setClubName(newName);
        }
        String newIntro = consoleUtil.getValueOf("New Club Intro(0. Club Menu, Enter, No Change.)");

        if(!newIntro.isEmpty()) {
            targetClub.setIntro(newIntro);
        }

        clubService.modify(targetClub);

        System.out.println("Modify Club : " + targetClub.toString());
    }

    public void remove() {
        TravelClub targetClub = findOne();

        String confirmStr = consoleUtil.getValueOf("Remove this Club? (Y:yes, N:no)");
        if(confirmStr.toLowerCase().equals("y")||confirmStr.toLowerCase().equals("yes")) {
            System.out.println("Remove club --> " + targetClub.getClubName());
            clubService.remove(targetClub.getId());
        }else {
            System.out.println("Remove cancelled, your club is safe." + targetClub.getClubName());
        }
    }
}
