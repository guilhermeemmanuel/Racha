package rachast.com.rachast.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rachast.com.rachast.data.PickUpDAO;

/**
 * Created by Cliente on 14/12/2015.
 */

public class PUGameManager {

    private static PUGameManager controller;
    private List PickUpGames;
    private PickUpGame currentPickUpGame;

    private PUGameManager(){
        PickUpGames = new ArrayList();

    }

    public static PUGameManager getInstance(){
        if(controller == null){
            controller = new PUGameManager();
        }
        return controller;
    }


    public void newPickUpGame(){
        PickUpGame pickUpGame = new PickUpGame("Racha");
        currentPickUpGame = pickUpGame;
        PickUpGames.add(pickUpGame);
    }

    public List getPickUpGames() {
        return PickUpGames;
    }

    public PickUpGame getCurrentPickUpGame() {
        return currentPickUpGame;
    }

    public  void addPlayerToCurrentPickUpGame(List<Player> players){
        for(Player p: players){
            currentPickUpGame.addPlayer(p);
        }
    }

    public void startCurrentPickUpGame(){
        PickUpDAO dao = new PickUpDAO();
        addPlayerToCurrentPickUpGame(dao.getPlayers());
        currentPickUpGame.start();
        currentPickUpGame.printTeams();
    }




}
