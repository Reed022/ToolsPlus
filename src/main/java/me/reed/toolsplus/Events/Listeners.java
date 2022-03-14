package me.reed.toolsplus.Events;

import me.reed.toolsplus.Objects.MenuViewer;
import me.reed.toolsplus.Objects.ToolsmithTableMenu;
import me.reed.toolsplus.ToolsPlus;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class Listeners implements Listener {
    private final ToolsPlus plugin;
    public Listeners(ToolsPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.CRAFTING_TABLE) {
                Player player = event.getPlayer();
                Location tableLocation = event.getClickedBlock().getLocation();
                Location tableTopLocation = new Location(player.getWorld(), tableLocation.getX(), tableLocation.getY() + 1, tableLocation.getZ());
                if (tableTopLocation.getBlock().getType().toString().contains("PRESSURE_PLATE")) {
                    event.setCancelled(true);
                    MenuViewer viewer = new MenuViewer(player);
                    ToolsmithTableMenu menu = new ToolsmithTableMenu(viewer);
                    menu.initializeMenu();
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack itemToVerify = event.getInventory().getItem(0);
        if (itemToVerify != null) {
            ItemMeta itemMeta = itemToVerify.getItemMeta();
            PersistentDataContainer itemDataContainer = itemMeta.getPersistentDataContainer();
            NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
            if (itemToVerify.getType() == Material.GRAY_STAINED_GLASS_PANE && itemDataContainer.has(key, PersistentDataType.STRING)) {
                Inventory inv = event.getInventory();
                int clickedSlot = event.getRawSlot();
                if (clickedSlot < 27) {
                    switch(clickedSlot) {
                        case 10:
                        case 12:
                            break;
                        case 14:
                            if (true) {
                                // check for valid recipe
                            } else {
                                // send message recipe is invalid, do nothing
                            }
                            event.setCancelled(true);
                            break;
                        case 16:
                            if (inv.getItem(16) != null) {

                            } else {
                                event.setCancelled(true);
                            }
                            break;
                        default:
                            event.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        ItemStack itemToVerify = event.getInventory().getItem(0);
        if (itemToVerify != null) {
            ItemMeta itemMeta = itemToVerify.getItemMeta();
            PersistentDataContainer itemDataContainer = itemMeta.getPersistentDataContainer();
            NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
            if (itemToVerify.getType() == Material.GRAY_STAINED_GLASS_PANE && itemDataContainer.has(key, PersistentDataType.STRING)) {
                for (int i : event.getRawSlots()) {
                    if (i < 27) {
                        event.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        ItemStack itemToVerify = event.getInventory().getItem(0);
        if (itemToVerify != null) {
            ItemMeta itemMeta = itemToVerify.getItemMeta();
            PersistentDataContainer itemDataContainer = itemMeta.getPersistentDataContainer();
            NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
            if (itemToVerify.getType() == Material.GRAY_STAINED_GLASS_PANE && itemDataContainer.has(key, PersistentDataType.STRING)) {
                Inventory inv = event.getInventory();
                Player player = (Player) event.getPlayer();
                if (inv.getItem(10) != null) {
                    HashMap<Integer, ItemStack> noFit = player.getInventory().addItem(inv.getItem(10));
                    if (!noFit.isEmpty()) {
                        player.getWorld().dropItemNaturally(player.getLocation(), noFit.get(0));
                    }
                }
                if (inv.getItem(12) != null) {
                    HashMap<Integer, ItemStack> noFit = player.getInventory().addItem(inv.getItem(12));
                    if (!noFit.isEmpty()) {
                        player.getWorld().dropItemNaturally(player.getLocation(), noFit.get(0));
                    }
                }
            }
        }
    }
}
