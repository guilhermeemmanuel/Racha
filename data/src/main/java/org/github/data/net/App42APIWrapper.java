package org.github.data.net;

import android.content.Context;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.storage.Storage;
import com.shephertz.app42.paas.sdk.android.storage.StorageService;

import org.json.JSONObject;

import java.util.ArrayList;

// http://api.shephertz.com/app42-docs/nosql-storage-service/?sdk=android
public class App42APIWrapper {

    private Context mContext;
    private String API_KEY = "c6863399044b2427958e22b901f7281234ab5ec15894fc293ed1a5d774f5a5d7";
    private String SECRET_KEY = "f906ea543b38ef5867c56d28a0448df8c0522ceab540342b65b37f1692e3ae3d";

    public App42APIWrapper(Context context) {
        this.mContext = context;
    }

    public void saveJSONObject(JSONObject json, String dbName, String collectionName, App42CallBack callBack) {
        App42API.initialize(mContext, API_KEY, SECRET_KEY);
        StorageService storageService = App42API.buildStorageService();
        storageService.insertJSONDocument(dbName, collectionName, json, callBack);
    }

    public void findJSONObjectCollection(String dbName, String collectionName, App42CallBack callBack) {
        App42API.initialize(mContext, API_KEY, SECRET_KEY);
        StorageService storageService = App42API.buildStorageService();
        storageService.findAllDocuments(dbName, collectionName, callBack);
    }

}


