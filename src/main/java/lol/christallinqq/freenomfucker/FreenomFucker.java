package lol.christallinqq.freenomfucker;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public final class FreenomFucker extends Plugin implements Listener {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPing(ProxyPingEvent evt) {
        if (evt.getConnection().getVirtualHost().getHostName().contains("1b1t.tk")) {
            evt.getResponse().setDescriptionComponent(new TextComponent(ChatColor.translateAlternateColorCodes(
                    '&',
                    "&6Please connect using &71b1t.me"
            )));
            getLogger().info("Prevented " + evt.getConnection().getSocketAddress().toString() + " from pinging 1b1t.tk");
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onConnect(PreLoginEvent evt) {
        if (evt.getConnection().getVirtualHost().getHostName().contains("1b1t.tk")) {
            evt.setCancelReason(new TextComponent(ChatColor.translateAlternateColorCodes(
                    '&',
                    "\n" +
                            "&7&m-------------------------------------------------------" +
                            "\n\n" +
                            "&6Please connect using &71b1t.me" +
                            "\n" +
                            "&6Conéctese usando &71b1t.me" +
                            "\n\n" +
                            "&7&m-------------------------------------------------------"
            )));
            evt.setCancelled(true);
            getLogger().info("Prevented " + evt.getConnection().getName() + " from connecting with 1b1t.tk");
        }
    }
}
