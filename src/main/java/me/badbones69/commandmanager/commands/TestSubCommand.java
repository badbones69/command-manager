package me.badbones69.commandmanager.commands;

import me.badbones69.commandmanager.objects.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class TestSubCommand extends SubCommand {
    
    @Override
    public String getPermission() {
        return "test.test";
    }
    
    @Override
    public String getArguments() {
        return "/test <arg1> [arg2]";
    }
    
    @Override
    public String getDescription() {
        return "This is a test command to test the command manager.";
    }
    
    @Override
    public boolean allowConsole() {
        return true;
    }
    
    @Override
    public List<String> getAliases() {
        return Arrays.asList("t", "te", "tes");
    }
    
    @Override
    public void run(CommandSender sender, String[] args) {
        sender.sendMessage(getPrefix("&7This is a test command to test the command manager."));
    }
    
}