package io.github.unjoinable.skriptprotocol;

import ch.njol.skript.Skript;
import ch.njol.skript.util.Version;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SkriptProtocol extends JavaPlugin {


    @Override
    public void onEnable() {

        //Dependency search.
        Plugin skript = getServer().getPluginManager().getPlugin("Skript");
        if (skript == null || !skript.isEnabled()) {
            getLogger().severe("Could not find Skript! Make sure you have it installed and that it properly loaded. Disabling...");
            getServer().getPluginManager().disablePlugin(this);
        } else if (Skript.getVersion().isSmallerThan(new Version(2, 9, 0))) {
            getLogger().severe("You are running an unsupported version of Skript. Please update to at least Skript 2.9.0. Disabling...");
            getServer().getPluginManager().disablePlugin(this);
        }

    }
}