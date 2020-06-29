package com.gmail.jlmerrett.SimpleSleep;

import com.gmail.jlmerrett.SimpleSleep.EventHandlers.BedEventHandler;
import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleSleep extends JavaPlugin {

    BedEventHandler bedEventHandler;
    Messenger messenger;

    @Override
    public void onEnable() {
       initPlugin();
    }

    @Override
    public void onDisable() {

    }

    private void initPlugin(){
        messenger = new Messenger();
        bedEventHandler = new BedEventHandler(messenger);
        getServer().getPluginManager().registerEvents(bedEventHandler, this);
    }

    public BedEventHandler bedEventHandler(){
        return bedEventHandler;
    }

}
