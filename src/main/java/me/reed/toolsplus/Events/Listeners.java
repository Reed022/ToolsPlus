package me.reed.toolsplus.Events;

import me.reed.toolsplus.Managers.RecipeManager;
import me.reed.toolsplus.Managers.ToolUtilities;
import me.reed.toolsplus.Objects.MenuViewer;
import me.reed.toolsplus.Objects.ToolsmithTableMenu;
import me.reed.toolsplus.ToolsPlus;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
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

import java.util.HashMap;

public class Listeners implements Listener {
    private final ToolsPlus plugin;
    private final RecipeManager recipeManager = ToolsPlus.getRecipeManager();

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
            if (itemToVerify.getType() == Material.GRAY_STAINED_GLASS_PANE && ToolUtilities.hasTPTag(itemToVerify)) {
                Inventory inv = event.getInventory();
                Player player = (Player) event.getWhoClicked();
                int clickedSlot = event.getRawSlot();
                if (clickedSlot < 27) {
                    switch(clickedSlot) {
                        case 10:
                        case 12:
                            break;
                        case 14:
                            // REPAIRS: WORKING - UPGRADES: WORKING
                            if (recipeManager.isValidRepair(player, inv.getItem(10), inv.getItem(12))) {
                                if (player.getLevel() >= 10) {
                                    ItemStack repairedTool = inv.getItem(10);
                                    // repair durability & adjust lore accordingly
                                    repairedTool.setItemMeta(ToolUtilities.getToolFullDuraData(repairedTool));
                                    // handle gui slots
                                    ItemStack repairItem = inv.getItem(12);
                                    repairItem.setAmount(repairItem.getAmount() - 1);
                                    inv.setItem(10, null);
                                    inv.setItem(12, repairItem);
                                    inv.setItem(16, repairedTool);
                                    player.updateInventory();
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f" + ChatColor.BOLD + "T+" + ChatColor.RESET + "&2] &aRepair success!"));
                                    player.setLevel(player.getLevel() - 10);
                                } else {
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f" + ChatColor.BOLD + "T+" + ChatColor.RESET + "&2] &7You need at least 10 levels to repair a tool+."));
                                }
                            } else if (recipeManager.isValidUpgrade(inv.getItem(10), inv.getItem(12))) {
                                if (ToolUtilities.getToolMaterial(inv.getItem(10)).equalsIgnoreCase("stone") && player.getLevel() < 10) {
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f" + ChatColor.BOLD + "T+" + ChatColor.RESET + "&2] &7You need at least 10 levels to upgrade a Stone Tool+."));
                                } else if (ToolUtilities.getToolMaterial(inv.getItem(10)).equalsIgnoreCase("iron") && player.getLevel() < 20) {
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f" + ChatColor.BOLD + "T+" + ChatColor.RESET + "&2] &7You need at least 20 levels to upgrade an Iron Tool+."));
                                } else if (ToolUtilities.getToolMaterial(inv.getItem(10)).equalsIgnoreCase("diamond") && player.getLevel() < 30) {
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f" + ChatColor.BOLD + "T+" + ChatColor.RESET + "&2] &7You need at least 30 levels to upgrade a Diamond Tool+."));
                                } else {
                                    ItemStack newTool = inv.getItem(10);
                                    String oldToolMaterial = ToolUtilities.getToolMaterial(newTool);
                                    // upgrade tool material
                                    if (newTool.getType().toString().substring(0, newTool.getType().toString().indexOf("_")).equalsIgnoreCase("diamond"))
                                        newTool.setType(recipeManager.getNUpgradeMap().get(newTool.getType()));
                                    else
                                        newTool.setType(recipeManager.getUpgradeMap().get(newTool.getType()));
                                    ItemMeta newToolMeta = newTool.getItemMeta();
                                    // set name according to new material
                                    newToolMeta.setDisplayName(ChatColor.WHITE + WordUtils.capitalize(newTool.getType().toString().toLowerCase().replace("_", " ")) + "+");
                                    newTool.setItemMeta(newToolMeta);
                                    // handle modifier slots
                                    newTool.setItemMeta(ToolUtilities.changeToolModifierSlotsData(newTool, 1));
                                    // repair durability & adjust lore accordingly
                                    newTool.setItemMeta(ToolUtilities.getToolFullDuraData(newTool));
                                    // handle gui slots
                                    ItemStack upgrade = inv.getItem(12);
                                    upgrade.setAmount(upgrade.getAmount() - 1);
                                    inv.setItem(10, null);
                                    inv.setItem(12, upgrade);
                                    inv.setItem(16, newTool);
                                    player.updateInventory();
                                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f" + ChatColor.BOLD + "T+" + ChatColor.RESET + "&2] &aUpgrade success!"));
                                    switch (oldToolMaterial) {
                                        case "STONE":
                                            player.setLevel(player.getLevel() - 10);
                                            break;
                                        case "IRON":
                                            player.setLevel(player.getLevel() - 20);
                                            break;
                                        case "DIAMOND":
                                            player.setLevel(player.getLevel() - 30);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            // TODO: write modification functionality & test
                            event.setCancelled(true);
                            break;
                        case 16:
                            if (inv.getItem(16) == null) {
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
            if (itemToVerify.getType() == Material.GRAY_STAINED_GLASS_PANE && ToolUtilities.hasTPTag(itemToVerify)) {
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
            if (itemToVerify.getType() == Material.GRAY_STAINED_GLASS_PANE && ToolUtilities.hasTPTag(itemToVerify)) {
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
                if (inv.getItem(16) != null) {
                    HashMap<Integer, ItemStack> noFit = player.getInventory().addItem(inv.getItem(16));
                    if (!noFit.isEmpty()) {
                        player.getWorld().dropItemNaturally(player.getLocation(), noFit.get(0));
                    }
                }
            }
        }
    }
}
