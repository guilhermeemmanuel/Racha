package rachast.com.rachast.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Cliente on 14/12/2015.
 */
public class PickUpGame {

    private String name;

    List<Player> playerList;
    List<Match> matchList;
    public List<Team> getTeamsList() {
        return teamsList;
    }
    List<Team> teamsList;
    private Match currentMath = null;

    private int matchCont = 0;
    private int teamSize = 5;

    private Date date;

    public PickUpGame(String name) {
        this.name = name;
        this.playerList = new ArrayList<>();
        this.matchList = new ArrayList<>();
        this.teamsList = new ArrayList<>();
        date = new Date();
    }

    public void NextMatch(){
        Team team1 = null;
        Team team2 = null;

        if(currentMath != null){
            team1 = currentMath.getWinner();
        }else{
            team1 = getNextTeam();
        }
        team2 = getNextTeam();
        Match newMatch = new Match(team1,team2,matchCont++);
        this.currentMath = newMatch;
        matchList.add(newMatch);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean removePlayer(Player player) {
        return this.playerList.add(player);
    }

    public boolean removePlayer(Team team) {
        return this.teamsList.add(team);
    }

    public boolean removePlayer(Match match) {
        return this.matchList.add(match);
    }

    public void start() {
        raffleTeams();
    }

    //TODO melhorar para tratar times incompletos
    private void raffleTeams(){
        System.out.println(" valores: " +  playerList.size() + " - " + teamSize);
        int numberOfTeams = (int)Math.ceil((double) playerList.size() / (double) teamSize);
        System.out.println(" numberOfTeams: " + numberOfTeams);
        for(int i = 0; i < numberOfTeams; i++){
            Team team = new Team("Time "+i);
            this.teamsList.add(team);
        }


        Collections.sort(this.playerList);
        Collections.reverse(this.playerList);
        List<List> playerGrups = new ArrayList<>();
        List<Player> group = new ArrayList<>();

        //TODO melhorar para tratar times incompletos
        for(Player p: this.playerList){
            System.out.println(group.size() + " - " +  numberOfTeams);
            if(group.size() < numberOfTeams){
                group.add(p);
            }
            if(group.size() == numberOfTeams){
                playerGrups.add(group);
                group = new ArrayList<>();
            }
        }
        playerGrups.add(group);

        for (List<Player> a: playerGrups){
                System.out.println(a.toString());
                System.out.println("--------");
        }

        for(List a: playerGrups){
            Collections.shuffle(a);
        }

        for (List<Player> a: playerGrups){
            for (Team t: teamsList)  {
               if(!a.isEmpty()) t.addPlayer(a.remove(0));
            }
        }

    }

    public Team getNextTeam(){
        //TODO
        return null;
    }

    public void printTeams(){
        for (Team t:teamsList ){
            System.out.println("-----" + t.getName() +"----");
            System.out.println(t.toString());
        }
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

}
