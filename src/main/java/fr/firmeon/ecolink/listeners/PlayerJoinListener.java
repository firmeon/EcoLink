package fr.firmeon.ecolink.listeners;

import fr.firmeon.ecolink.manager.PersonalAccountManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(!PersonalAccountManager.hasPersonalAccount(player.getUniqueId())){
            PersonalAccountManager.createPersonalAccount(player.getUniqueId());
        }
    }
}
