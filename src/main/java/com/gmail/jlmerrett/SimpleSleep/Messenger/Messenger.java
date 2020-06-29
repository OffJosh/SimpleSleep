package com.gmail.jlmerrett.SimpleSleep.Messenger;

import org.bukkit.Bukkit;

public class Messenger {

    public void sendChatMessage(String message){
        Bukkit.broadcastMessage(message);
    }

}
