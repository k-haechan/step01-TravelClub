package io.hc.java.travelClub.ui.console;

import io.hc.java.travelClub.entity.TravelClub;
import io.hc.java.travelClub.service.ClubService;
import io.hc.java.travelClub.service.logic.ClubServiceLogic;
import io.hc.java.travelClub.ui.menu.ClubMenu;
import io.hc.java.travelClub.util.ConsoleUtil;

public class ClubConsole {
    private ConsoleUtil consoleUtil;

    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        // 이후 변경될 코드...
        this.clubService = new ClubServiceLogic();
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
        TravelClub[] foundClubs = clubService.findAll();
        if(foundClubs.length==0) {
            System.out.println("Empty~~");
            return;
        }
        for(TravelClub club : foundClubs) {
            System.out.println(club.toString());
        }
    }
    public void findByID() {

    }
}
