package rachast.com.rachast.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rachast.com.rachast.model.Player;

/**
 * Created by renan on 28/01/16.
 */
public class PickUpDAO {

    public List<Player> getPlayers(){
        Player player1 = new Player("Renan",3,2);
        Player player2 = new Player("Diego",5,4);
        Player player3 = new Player("Diogo",3,4);
        Player player4 = new Player("Del",4,2);
        Player player5 = new Player("Jonathan",1,3);
        Player player6 = new Player("jean",4,3);
        Player player7 = new Player("Guilherme",5,4);
        Player player8 = new Player("Cleber",5,4);
        Player player9 = new Player("Adriano",4,3);
        Player player10 = new Player("wallison",2,3);
        Player player11 = new Player("ernildo",4,4);
        Player player12 = new Player("kelvin",4,3);
        Player player13 = new Player("lucas",3,3);
        Player player14 = new Player("mael",4,3);
        ArrayList list = new ArrayList();
        list.addAll(Arrays.asList(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10, player11, player12, player13, player14));
        return list;
    }

}
