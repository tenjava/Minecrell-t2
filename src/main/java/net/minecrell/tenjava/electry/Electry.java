package net.minecrell.tenjava.electry;

import net.minecrell.tenjava.electry.electrics.registry.DefaultElectric;
import net.minecrell.tenjava.electry.electrics.registry.ElectricRegistry;
import net.minecrell.tenjava.electry.listeners.ElectricListener;
import net.minecrell.tenjava.electry.listeners.FurnaceListener;

import org.bukkit.plugin.java.JavaPlugin;

public class Electry extends JavaPlugin {
    private ElectricRegistry registry;

    @Override
    public void onEnable() {
        this.registry = new ElectricRegistry(this);
        DefaultElectric.register(registry);
        new ElectricListener(this).register();
        new FurnaceListener(this).register();

        // For the people complaining about such messages: CraftBukkit does only display that it IS enabling the
        // plugin and not that the plugin was SUCCESSFULLY enabled. Therefore this message just says that the
        // configuration and everything was successfully loaded and not only the plugin.
        this.getLogger().info(this.getDescription().getFullName() + " enabled.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(this.getDescription().getFullName() + " disabled.");
    }

    public ElectricRegistry getRegistry() {
        return registry;
    }
}
