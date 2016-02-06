package org.github.domain.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cliente on 14/12/2015.
 */
public class PickUpGame {
    public String getName() {
        return name;
    }

    String name;
    List<Player> members;

    public PickUpGame(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(Player player){
        members.add(player);
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",name);
            jsonObject.put("players",members);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();

    }

}
