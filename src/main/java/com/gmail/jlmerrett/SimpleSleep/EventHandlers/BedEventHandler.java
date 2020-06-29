package com.gmail.jlmerrett.SimpleSleep.EventHandlers;

import com.gmail.jlmerrett.SimpleSleep.Calculators.Calculator;
import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedEventHandler implements Listener {

    Messenger messenger;
    Calculator calculator;

    public BedEventHandler(Messenger messenger, Calculator calculator){
        this.messenger = messenger;
        this.calculator = calculator;
    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent playerBedEnterEvent){
        Player player = playerBedEnterEvent.getPlayer();
        String message = messenger.getMessageCreator().constructMessage(player, "bed_entered_message");
        messenger.sendChatMessage(message);

        int needed = calculator.calculatePlayersNeeded();

        messenger.sendChatMessage(Integer.toString(needed));

    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent playerBedLeaveEvent){
        Player player = playerBedLeaveEvent.getPlayer();
        String message = messenger.getMessageCreator().constructMessage(player, "bed_left_message");
        messenger.sendChatMessage(message);
    }

}
