package com.gmail.jlmerrett.SimpleSleep;

import org.bukkit.plugin.java.JavaPlugin;

public class SimpleSleep extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("TestChatMessage").setExecutor(new CommandTestChatMessage());
    }

    @Override
    public void onDisable() {

    }

}
