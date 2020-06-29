package com.gmail.jlmerrett.SimpleSleep.EventHandlers;

import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedEventHandler implements Listener {

    Messenger messenger;

    public BedEventHandler(Messenger messenger){
        this.messenger = messenger;
    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent playerBedEnterEvent){
        messenger.sendChatMessage("Player has entered bed");
    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent playerBedLeaveEvent){
        messenger.sendChatMessage("Player has left bed");
    }

}
