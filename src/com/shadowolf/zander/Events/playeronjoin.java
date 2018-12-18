package com.shadowolf.zander.Events;

import com.shadowolf.zander.zander;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class playeronjoin implements Listener {

    zander plugin;

    public playeronjoin(zander instance){
        plugin = instance;

    }

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event){
        Player player = event.getPlayer();

        event.setJoinMessage("");
        if(player.isOp()) {
            event.setJoinMessage(ChatColor.RED.toString() + ChatColor.BOLD + "[!!!] " + ChatColor.GOLD + "Server Operator " + player.getName() + " has joined the server");
        } else {
            event.setJoinMessage(ChatColor.YELLOW + player.getName() + " has joined the server");
        }

        String playername = player.getName();
        if (!player.hasPlayedBefore()){
            plugin.getConfig().set(playername + ".joins", 0);
        }

        int joined = plugin.getConfig().getInt(playername + ".joins");
        plugin.getConfig().set(playername + ".joins", joined + 1);
        plugin.saveConfig();
    }
}
