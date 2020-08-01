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
        sendChatMessage(String.format("%s/%s players needed are sleeping.", playersSleeping, playersNeeded));

    }
}
