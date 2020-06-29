package com.gmail.jlmerrett.SimpleSleep.Calculators;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class Calculator {

    FileConfiguration configFile;
    String sleeping_type;
    int percentage_amount;
    int absolute_amount;

    public Calculator(FileConfiguration configFile){
        this.configFile = configFile;
        sleeping_type = configFile.getString("sleeping_type");
        percentage_amount = configFile.getInt("percentage_amount");
        absolute_amount = configFile.getInt("absolute_amount");
    }

    public int calculatePlayersNeeded(){

        int playerCount = Bukkit.getServer().getWorld("world").getPlayers().size();
        if(sleeping_type.equals("PERCENTAGE")){
            int playersNeeded = Math.max(playerCount * percentage_amount / 100, 1);
            return playersNeeded;
        }
        else if(sleeping_type.equals("ABSOLUTE")){
            return absolute_amount;
        }
        return 0;
    }
}
