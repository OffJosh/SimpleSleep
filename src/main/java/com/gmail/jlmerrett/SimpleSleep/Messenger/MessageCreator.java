package com.gmail.jlmerrett.SimpleSleep.Messenger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MessageCreator {

    FileConfiguration configFile;

    public MessageCreator(FileConfiguration configFile){
        this.configFile = configFile;
    }

    public String constructMessage(Player player, String messageKey){
        String message = configFile.getString(messageKey);

        message = replacePlayerNames(message, player);
        message = replaceColourChar(message);

        return message;
    }

    private String replacePlayerNames(String message, Player player){
        String newMessage = message;
        if (newMessage.contains("[player]")){
            newMessage = newMessage.replace("[player]", player.getDisplayName());
        }
        return newMessage;
    }

    private String replaceColourChar(String message){
        String newMessage = message;
        if(newMessage.contains("&")){
            newMessage = newMessage.replace("&","§");
        }
        return newMessage;
    }

}
