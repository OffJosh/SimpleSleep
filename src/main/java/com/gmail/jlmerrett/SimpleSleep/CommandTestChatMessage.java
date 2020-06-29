package com.gmail.jlmerrett.SimpleSleep;

import com.gmail.jlmerrett.SimpleSleep.Messenger.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandTestChatMessage implements CommandExecutor {

    Messenger messenger = new Messenger();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        messenger.sendChatMessage("This is a test message");

        return true;
    }

}
