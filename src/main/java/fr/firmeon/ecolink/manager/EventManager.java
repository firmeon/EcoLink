package fr.firmeon.ecolink.manager;

import fr.firmeon.ecolink.EcoLink;
import fr.firmeon.ecolink.listeners.PlayerJoinListener;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    public static void register(){
        PluginManager pm = EcoLink.getInstance().getServer().getPluginManager();

        pm.registerEvents(new PlayerJoinListener(), EcoLink.getInstance());
    }
}
