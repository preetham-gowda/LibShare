package com.preetham.libshare.connectivity.listeners;


public interface GroupCreationListener {
    void onGroupCreated();
    void onGroupCreationFailed(String failureMessage);
}
