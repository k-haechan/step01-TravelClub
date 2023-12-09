package io.hc.java.travelClub.ui.console;

import io.hc.java.travelClub.service.ClubService;
import io.hc.java.travelClub.service.ServiceLogicLifeCycler;
import io.hc.java.travelClub.service.logic.ClubServiceLogic;

public class ClubSubConsole {
    private ClubService clubService;

    public ClubSubConsole() {
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }
}
