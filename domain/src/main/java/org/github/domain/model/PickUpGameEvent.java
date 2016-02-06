package org.github.domain.model;

/**
 * Created by Cliente on 05/02/2016.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Cliente on 14/12/2015.
 */
public class PickUpGameEvent {
    List<Player> playerList;
    List<Match> matchList;
    List<Team> teamsList;

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    private int teamSize = 3;

    private Date date;

    public PickUpGameEvent() {
        this.playerList = new ArrayList<>();
        this.matchList = new ArrayList<>();
        this.teamsList = new ArrayList<>();
        date = new Date();
    }

    public boolean addPlayer(Player player) {
        return this.playerList.add(player);
    }

    public boolean addTeam(Team team) {
        return this.teamsList.add(team);
    }

    public boolean addMatch(Match match) {
        return this.matchList.add(match);
    }

    public boolean removelayer(Player player) {
        return this.playerList.add(player);
    }

    public boolean removelayer(Team team) {
        return this.teamsList.add(team);
    }

    public boolean removelayer(Match match) {
        return this.matchList.add(match);
    }

    public void start() {
        raffleTeams();
    }

    //TODO melhorar para tratar times incompletos
    private void raffleTeams() {

        int numberOfTeams = playerList.size() / teamSize;
        for (int i = 0; i < numberOfTeams; i++) {
            Team team = new Team("Time " + i);
            this.teamsList.add(team);
        }


        Collections.sort(this.playerList);
        List<List> playerGrups = new ArrayList<>();
        List<Player> group = new ArrayList<>();

        //TODO melhorar para tratar times incompletos
        for (Player p : this.playerList) {
            System.out.println(group.size() + " - " + numberOfTeams);
            if (group.size() < numberOfTeams) {
                group.add(p);
            }
            if (group.size() == numberOfTeams) {
                playerGrups.add(group);
                group = new ArrayList<>();
            }
        }
        for (List a : playerGrups) {
            Collections.shuffle(a);
        }


        for (Team t : teamsList) {
            for (List<Player> g : playerGrups) {
                t.addPlayer(g.remove(0));
            }
        }

    }

    public void printTeams() {
        for (Team t : teamsList) {
            System.out.println("-----" + t.getName() + "----");
            System.out.println(t.toString());


        }
    }

    public String toJson() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "{\"players\" :[");
        for (Player p : playerList) {
            stringBuilder.append(p.toJson());
        }
        stringBuilder.append( "]}");
        return stringBuilder.toString();

    }
}
