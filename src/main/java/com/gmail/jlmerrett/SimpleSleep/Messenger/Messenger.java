package com.gmail.jlmerrett.SimpleSleep.Messenger;

import com.gmail.jlmerrett.SimpleSleep.Calculators.SleepCalculator;
import com.gmail.jlmerrett.SimpleSleep.SimpleSleep;
import org.bukkit.Bukkit;

public class Messenger {

    MessageCreator messageCreator;
    SleepCalculator sleepCalculator;

    public Messenger(){
        this.messageCreator = SimpleSleep.getMessageCreator();
        this.sleepCalculator = SimpleSleep.getSleepCalculator();
    }

    public void sendChatMessage(String message){
        Bukkit.broadcastMessage(message);
    }

    public MessageCreator getMessageCreator() {
        return messageCreator;
    }

    public void sendPlayersNeededChatMessage(){

        int playersSleeping = sleepCalculator.getPlayersSleeping();
        int playersNeeded = sleepCalculator.getPlayersNeeded();
        sendChatMessage(messageCreator.constructMessage(playersSleeping, playersNeeded, "sleeping_needed_message"));

    }

    public void sendNightSkipMessage(){
        sendChatMessage(messageCreator.getMessageByKey("skipped_night_message"));
    }
}
