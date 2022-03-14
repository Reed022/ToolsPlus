package me.reed.toolsplus.Objects;

import org.bukkit.entity.Player;

public class MenuViewer {
    private Player player;

    public MenuViewer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
