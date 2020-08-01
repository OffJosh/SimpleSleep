package com.gmail.jlmerrett.SimpleSleep;

import com.gmail.jlmerrett.SimpleSleep.Calculators.SleepCalculator;
import com.gmail.jlmerrett.SimpleSleep.EventHandlers.BedEventHandler;
import com.gmail.jlmerrett.SimpleSleep.Messenger.MessageCreator;
import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import com.gmail.jlmerrett.SimpleSleep.NightSkipper.NightSkipper;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleSleep extends JavaPlugin {

    static BedEventHandler bedEventHandler;
    static Messenger messenger;
    static MessageCreator messageCreator;
    static SleepCalculator sleepCalculator;
    static FileConfiguration configFile;
    static NightSkipper nightSkipper;
    static Plugin plugin;
    static String mainWorldName;

    @Override
    public void onEnable() {
       initPlugin();
    }

    @Override
    public void onDisable() {

    }

    private void initPlugin(){
        plugin = this;
        plugin.saveDefaultConfig();
        configFile = plugin.getConfig();
        messageCreator = new MessageCreator();
        sleepCalculator = new SleepCalculator();
        messenger = new Messenger();
        nightSkipper = new NightSkipper();
        bedEventHandler = new BedEventHandler();
        getServer().getPluginManager().registerEvents(bedEventHandler, plugin);
        mainWorldName = configFile.getString("world_name");
    }

    public static BedEventHandler getBedEventHandler(){
        return bedEventHandler;
    }

    public static Messenger getMessenger(){
        return messenger;
    }

    public static MessageCreator getMessageCreator(){
        return messageCreator;
    }

    public static SleepCalculator getSleepCalculator(){
        return sleepCalculator;
    }

    public static FileConfiguration getConfigFile(){
        return configFile;
    }

    public static NightSkipper getNightSkipper(){
        return nightSkipper;
    }

    public static Plugin getPlugin(){
        return plugin;
    }

    public static String getMainWorldName(){
        return mainWorldName;
    }
}
