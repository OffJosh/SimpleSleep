package com.gmail.jlmerrett.SimpleSleep;

import com.gmail.jlmerrett.SimpleSleep.Calculators.Calculator;
import com.gmail.jlmerrett.SimpleSleep.EventHandlers.BedEventHandler;
import com.gmail.jlmerrett.SimpleSleep.Messenger.MessageCreator;
import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleSleep extends JavaPlugin {

    BedEventHandler bedEventHandler;
    Messenger messenger;
    MessageCreator messageCreator;
    Calculator calculator;

    @Override
    public void onEnable() {
       initPlugin();
    }

    @Override
    public void onDisable() {

    }

    private void initPlugin(){
        this.saveDefaultConfig();
        FileConfiguration configFile = this.getConfig();
        messageCreator = new MessageCreator(configFile);
        calculator = new Calculator(configFile);
        messenger = new Messenger(messageCreator);
        bedEventHandler = new BedEventHandler(messenger,calculator);
        getServer().getPluginManager().registerEvents(bedEventHandler, this);
    }

    public BedEventHandler bedEventHandler(){
        return bedEventHandler;
    }

}
