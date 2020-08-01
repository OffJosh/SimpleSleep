package com.gmail.jlmerrett.SimpleSleep.Messenger;

import com.gmail.jlmerrett.SimpleSleep.SimpleSleep;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class MessageCreator {

    FileConfiguration configFile;

    public MessageCreator(){
        this.configFile = SimpleSleep.getConfigFile();
    }

    public String getMessageByKey(String messageKey){
        String message = configFile.getString(messageKey);

        message = replaceColourChar(message);

        return message;
    }

    public String constructMessage(Player player, String messageKey){
        String message = configFile.getString(messageKey);

        message = replacePlayerNames(message, player);
        message = replaceColourChar(message);

        return message;
    }

    public String constructMessage(int sleeping, int needed, String messageKey){
        String message = configFile.getString(messageKey);

        message = replaceSleepingNeededAmounts(message, sleeping, needed);
        message = replaceColourChar(message);

        return message;
    }

    private String replaceSleepingNeededAmounts(String message, int sleeping, int needed){
        String newMessage = message;
        if (newMessage.contains("<sleepingPlayers>")){
            newMessage = newMessage.replace("<sleepingPlayers>", Integer.toString(sleeping));
        }
        if (newMessage.contains("<neededPlayers>")){
            newMessage = newMessage.replace("<neededPlayers>", Integer.toString(needed));
        }
        return newMessage;
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
