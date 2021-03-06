package com.preetham.libshare.connectivity.listeners;

public interface GroupConnectionListener {
    void onExchangingInfo();
    void onConnectionSuccess(String connectedGroup);
    void onConnectionFailed(String failureMessage);
    void onOwnerDisconnected();
}