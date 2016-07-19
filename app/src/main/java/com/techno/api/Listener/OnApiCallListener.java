package com.techno.api.Listener;

/**
 * Created by arbaz on 29/6/16.
 */
public interface OnApiCallListener {
    public void onFailure(String message);

    public void onSuccess(int responseCode, String responseString, String url);
}
