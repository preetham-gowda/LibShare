package com.preetham.libshare.connectivity.listeners;

/**
 * Created by Preetham on 28/09/2017.
 */
public interface NewGroupListener {
    void newGroupFound(String Id, String groupName, String ownerName, String deviceName, int memberCount);
}
