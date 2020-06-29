package com.gmail.jlmerrett.SimpleSleep.EventHandlers;

import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import com.mojang.brigadier.Message;
import org.bukkit.entity.Player;
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
        Player player = playerBedEnterEvent.getPlayer();
        String message = messenger.getMessageCreator().constructMessage(player, "bed_entered_message");
        messenger.sendChatMessage(message);
    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent playerBedLeaveEvent){
        Player player = playerBedLeaveEvent.getPlayer();
        String message = messenger.getMessageCreator().constructMessage(player, "bed_left_message");
        messenger.sendChatMessage(message);
    }

}
