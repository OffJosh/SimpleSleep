package com.gmail.jlmerrett.SimpleSleep.Calculators;

import com.gmail.jlmerrett.SimpleSleep.SimpleSleep;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class SleepCalculator {

    FileConfiguration configFile;
    String sleeping_type;
    int percentage_amount;
    int absolute_amount;
    int playersSleeping;
    int playersNeeded;

    public SleepCalculator(){
        this.configFile = SimpleSleep.getConfigFile();
        sleeping_type = configFile.getString("sleeping_type");
        percentage_amount = configFile.getInt("percentage_amount");
        absolute_amount = configFile.getInt("absolute_amount");
    }

    public int getPlayersSleeping(){
        return playersSleeping;
    }

    public void addSleepingPlayer(){
        playersSleeping++;
    }

    public void removeSleepingPlayer(){
        playersSleeping--;
    }

    public int getPlayersNeeded(){
        calculatePlayersNeeded();
        return playersNeeded;
    }

    private void calculatePlayersNeeded(){

        int playerCount = Bukkit.getServer().getWorld(SimpleSleep.getMainWorldName()).getPlayers().size();
        if(sleeping_type.equals("PERCENTAGE")){
            playersNeeded = Math.max(playerCount * percentage_amount / 100, 1);
        }
        else if(sleeping_type.equals("ABSOLUTE")){
            playersNeeded = absolute_amount;
        }
    }
}
