package org.github.data;

import android.content.Context;

import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.storage.Storage;

import org.github.data.net.App42APIWrapper;
import org.github.data.net.DataRequestCallBack;
import org.github.domain.model.PickUpGame;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cliente on 01/02/2016.
 */
public class PickUpGameDAO {

    private final Context mContext;
    private final String DB_NAME = "MeuRachaDB";
    private final String COLLECTION_NAME = "PickUpGameCollection";
    public PickUpGameDAO(Context context){
        this.mContext = context;
    }
    
    public void findAll(final DataRequestCallBack callBack){
        App42APIWrapper wrapper = new App42APIWrapper(mContext);

        wrapper.findJSONObjectCollection(DB_NAME, COLLECTION_NAME, new App42CallBack() {
            @Override
            public void onSuccess(Object response) {
                Storage  storage  = (Storage )response;
                ArrayList<Storage.JSONDocument> jsonDocList = storage.getJsonDocList();
                ArrayList<PickUpGame> jsonObjectList = new ArrayList<PickUpGame>();

                for(int i=0;i<jsonDocList.size();i++)
                {
                    try {
                        JSONObject jsonObject = new JSONObject( jsonDocList.get(i).getJsonDoc());
                        PickUpGame pickUpGame = new PickUpGame(jsonObject.getString("name"));
                        jsonObjectList.add(pickUpGame);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                callBack.onSuccess(jsonObjectList);
            }

            @Override
            public void onException(Exception e) {
                callBack.onFailure(e);
            }
        });
    }
    //TODO
    public void findById(){
    }
    //TODO
    public void findByName(){
    }
    public void insertPickUpGame(PickUpGame pickUpGame, final DataRequestCallBack callback){
        App42APIWrapper wrapper = new App42APIWrapper(mContext);
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(pickUpGame.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        wrapper.saveJSONObject(jsonObject, DB_NAME, COLLECTION_NAME, new App42CallBack() {
            @Override
            public void onSuccess(Object o) {
                callback.onSuccess(o);
            }

            @Override
            public void onException(Exception e) {
                callback.onFailure(e);
            }
        });
    }
    public void updatePickUpGame(PickUpGame pickUpGame){
    }
    public void deletePickUpGame(PickUpGame pickUpGame){

    }

}
