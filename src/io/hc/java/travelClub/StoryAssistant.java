package io.hc.java.travelClub;

import io.hc.java.travelClub.ui.menu.ClubMenu;
import io.hc.java.travelClub.util.DateUtil;

public class StoryAssistant {
    private void startStory() {
        ClubMenu clubMenu = new ClubMenu();
        clubMenu.show();
    }

    public static void main(String[] args) {
        StoryAssistant assistant = new StoryAssistant();
        assistant.startStory();
    }
}
