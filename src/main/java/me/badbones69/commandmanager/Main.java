package me.badbones69.commandmanager;

import me.badbones69.commandmanager.commands.TestSubCommand;
import me.badbones69.commandmanager.objects.BaseCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    private CommandManager commandManager = CommandManager.getInstance();
    
    @Override
    public void onLoad() {
        commandManager.registerCommand(new BaseCommand("test", new TestSubCommand()));
        getCommand("test").setExecutor(commandManager);
    }
    
}