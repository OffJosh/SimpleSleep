package com.gmail.jlmerrett.SimpleSleep.Messenger;

import org.bukkit.Bukkit;

public class Messenger {

    MessageCreator messageCreator;

    public Messenger(MessageCreator messageCreator){
        this.messageCreator = messageCreator;
    }

    public void sendChatMessage(String message){
        Bukkit.broadcastMessage(message);
    }

    public MessageCreator getMessageCreator() {
        return messageCreator;
    }
}
