package com.preetham.libshare.connectivity.listeners;


public interface ResponseListener {
    void onResponseReceived(Object responseData);
    void onRequestFailed();
}