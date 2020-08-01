package com.gmail.jlmerrett.SimpleSleep.NightSkipper;

import com.gmail.jlmerrett.SimpleSleep.Calculators.SleepCalculator;
import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import com.gmail.jlmerrett.SimpleSleep.SimpleSleep;
import org.bukkit.Bukkit;
import org.bukkit.World;

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
                    messenger.sendNightSkipMessage();
                    World world = Bukkit.getWorld(SimpleSleep.getMainWorldName());
                    world.setTime(1000);
                    if(world.isThundering()){
                        world.setThundering(false);
                    }
                    if(world.hasStorm()){
                        world.setStorm(false);
                    }
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
