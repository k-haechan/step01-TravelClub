package io.hc.java.travelClub.entity;

import io.hc.java.travelClub.util.DateUtil;

import java.util.UUID;

public class TravelClub {
    // Fields
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final int MINIMUM_INTRO_LENGTH = 5;

    private String id;
    private String clubName;
    private String intro;
    private String foundationDay;

    // Constructors
    private TravelClub() {this.id = UUID.randomUUID().toString();}

    public TravelClub(String clubName, String intro) {
        this();
        setClubName(clubName);
        setIntro(intro);
        this.foundationDay=DateUtil.today();
    }

    // Methods
    // setter
    public void setClubName(String clubName) {
        if(clubName.length()<MINIMUM_NAME_LENGTH) {
            System.out.println("Club name should be longer than " + MINIMUM_NAME_LENGTH);
            return;
        }
        this.clubName = clubName;
    }

    public String getClubName() {
        return this.clubName;
    }

    public void setIntro(String intro) {
        if(intro.length()<MINIMUM_INTRO_LENGTH) {
            System.out.println("Club intro should be longer than " + MINIMUM_INTRO_LENGTH);
            return;
        }
        this.intro = intro;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getId() {
        return this.id;
    }

    public String getFoundationDay() {
        return this.foundationDay;
    }

    public static TravelClub getSample() {
        String ClubName = "Sample Club";
        String intro = "Sample CLub Intro";
        TravelClub sampleClub = new TravelClub(ClubName,intro);
        return sampleClub;
    }

    @Override
    public String toString() {
        return "TravelClub club ID : " + id +
                ", ClubName : " + clubName +
                ", Intro : " + intro +
                ", FoundationDay : " + foundationDay;
    }
}
