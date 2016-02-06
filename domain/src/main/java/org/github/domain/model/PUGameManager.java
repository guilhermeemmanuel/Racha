package org.github.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Cliente on 14/12/2015.
 */



public class PUGameManager {

    private static PUGameManager controller;
    private List PickUpGames;
    private PickUpGameEvent currentPickUpGame;

    private PUGameManager(){
        PickUpGames = new ArrayList();

    }



    public static PUGameManager getInstance(){
        if(controller == null){
            controller = new PUGameManager();
        }
        return controller;
    }


    public void newPickUpGameEvent(){
        PickUpGameEvent pickUpGame = new PickUpGameEvent();
        currentPickUpGame = pickUpGame;
        PickUpGames.add(pickUpGame);
    }

    public PickUpGame newPickUpGame(String name){
        PickUpGame pickUpGame = new PickUpGame(name);
        return pickUpGame;
    }


    public  void addPlayerToCurrentPickUpGame(List<Player> players){
        for(Player p: players){
            currentPickUpGame.addPlayer(p);
        }
    }

    public void startCurrentPickUpGame(){
        addPlayerToCurrentPickUpGame(getPlayers());
        currentPickUpGame.start();
        currentPickUpGame.printTeams();
    }

    private List<Player> getPlayers(){
        Player player1 = new Player("Renan",3,1);
        Player player2 = new Player("Diego",5,4);
        Player player3 = new Player("Diogo",3,4);
        Player player4 = new Player("Del",4,2);
        Player player5 = new Player("Jonathan",1,3);
        Player player6 = new Player("jean",4,3);
        Player player7 = new Player("Guilherme",5,4);
        Player player8 = new Player("Cleber",5,4);
        Player player9 = new Player("Adriano",4,3);

        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(player1, player2, player3, player4, player5, player6, player7, player8, player9));
        return list;
    }


}
