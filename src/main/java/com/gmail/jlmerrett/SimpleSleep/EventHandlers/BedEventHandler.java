package com.gmail.jlmerrett.SimpleSleep.EventHandlers;

import com.gmail.jlmerrett.SimpleSleep.Calculators.SleepCalculator;
import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import com.gmail.jlmerrett.SimpleSleep.NightSkipper.NightSkipper;
import com.gmail.jlmerrett.SimpleSleep.SimpleSleep;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class BedEventHandler implements Listener {

    Messenger messenger;
    SleepCalculator sleepCalculator;
    NightSkipper nightSkipper;

    public BedEventHandler(){
        this.messenger = SimpleSleep.getMessenger();
        this.sleepCalculator = SimpleSleep.getSleepCalculator();
        this.nightSkipper = SimpleSleep.getNightSkipper();
    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent playerBedEnterEvent){
        if(playerBedEnterEvent.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OK)) {

            nightSkipper.setNightSkipped(false);
            sleepCalculator.addSleepingPlayer();
            Player player = playerBedEnterEvent.getPlayer();
            String message = messenger.getMessageCreator().constructMessage(player, "bed_entered_message");
            messenger.sendChatMessage(message);
            messenger.sendPlayersNeededChatMessage();
            nightSkipper.tryNightSkip();

        }

    }

    @EventHandler
    public void onPlayerLeaveBed(PlayerBedLeaveEvent playerBedLeaveEvent){
        sleepCalculator.removeSleepingPlayer();
        if (!nightSkipper.getNightSkipped()) {
            Player player = playerBedLeaveEvent.getPlayer();
            String message = messenger.getMessageCreator().constructMessage(player, "bed_left_message");
            messenger.sendChatMessage(message);
            messenger.sendPlayersNeededChatMessage();
        }

    }

}
