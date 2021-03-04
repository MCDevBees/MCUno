package io.mcdevbees.mcuno.main;

import org.bukkit.plugin.java.JavaPlugin;

import io.mcdevbees.mcuno.command.CommandUNO;

public final class MCUno extends JavaPlugin {

    private GameManager manager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        manager = new GameManager();
        this.getCommand("uno").setExecutor(new CommandUNO(manager));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
