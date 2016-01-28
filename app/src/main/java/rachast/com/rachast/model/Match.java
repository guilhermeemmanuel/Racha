package rachast.com.rachast.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cliente on 14/12/2015.
 */
public class Match {

    private Team team1;
    private Team team2;
    private List<MatchEvent> events;
    private long startTime;
    private long finishTime;

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    private Team winner;

    private long matchNumber;

    public Match(Team team1, Team team2, int matchNumber){
        this.team1 = team1;
        this.team2 = team2;
        this.matchNumber = matchNumber;
        this.events = new ArrayList();
    }


    public long getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(long matchNumber) {
        this.matchNumber = matchNumber;
    }

    public boolean addMatchEvent(MatchEvent e){
        return  this.events.add( e);
    }

    public boolean removeMatchEvent(MatchEvent e){
        return this.events.remove( e);
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public List<MatchEvent> getEvents() {
        return events;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam1() {
        return team1;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }



}
