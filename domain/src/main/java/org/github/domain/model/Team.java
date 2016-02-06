package org.github.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cliente on 14/12/2015.
 */
public class Team {

    private String name;
    private List<Player> players;

    public Team(String name, List players){
        this.name = name;
        this.players = players;
    }

    public Team(String name){
        this.name = name;
        this.players = new ArrayList<>();
    }

    public boolean addPlayer(Player player){
        return  this.players.add(player);
    }

    public boolean removePlayer(Player player){
       return this.players.remove(player);
    }

    public List getPlayers() {
        return players;
    }

    public void setPlayers(List players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = new String();
        for (Player p:players) {
            s = s + p.toString() + "\n";
        }
        return s;
    }
}
