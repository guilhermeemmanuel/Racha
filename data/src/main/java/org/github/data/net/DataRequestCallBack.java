package org.github.data.net;

/**
 * Created by Cliente on 01/02/2016.
 */
public interface DataRequestCallBack {
    void onFailure(Exception e);
    void onSuccess(Object o);

}
