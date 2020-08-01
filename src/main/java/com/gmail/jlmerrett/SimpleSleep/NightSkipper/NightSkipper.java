package com.gmail.jlmerrett.SimpleSleep.NightSkipper;

import com.gmail.jlmerrett.SimpleSleep.Calculators.SleepCalculator;
import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import com.gmail.jlmerrett.SimpleSleep.SimpleSleep;
import org.bukkit.Bukkit;

public class NightSkipper {

    SleepCalculator sleepCalculator;
    Messenger messenger;
    boolean nightSkipped = false;

    public NightSkipper(){
        this.sleepCalculator = SimpleSleep.getSleepCalculator();
        this.messenger = SimpleSleep.getMessenger();
    }

    public void tryNightSkip(){
        Bukkit.getScheduler().runTaskLater(SimpleSleep.getPlugin(), () -> {
                if (sleepCalculator.getPlayersSleeping() >= sleepCalculator.getPlayersNeeded()) {
                    Bukkit.getWorld("world").setTime(1000);
                    messenger.sendChatMessage("Skipping the Night");
                    setNightSkipped(true);
                }
            }, 40);
    }

    public void setNightSkipped(boolean bool){
        nightSkipped = bool;
    }

    public boolean getNightSkipped(){
        return nightSkipped;
    }
}
