package com.preetham.libshare.connectivity.listeners;

/**
 * Created by Preetham on 28/09/2017.
 */

public interface RequestListener {
    Object onNewRequest(String deviceId, int action, Object requestData);
}
