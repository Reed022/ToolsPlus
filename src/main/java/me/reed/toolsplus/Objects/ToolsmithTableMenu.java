package me.reed.toolsplus.Objects;

import me.reed.toolsplus.ToolsPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ToolsmithTableMenu {
    private MenuViewer viewer;
    private Inventory inv;
    private final ToolsPlus plugin = ToolsPlus.getPlugin();

    public ToolsmithTableMenu(MenuViewer viewer) {
        this.viewer = viewer;
    }

    public void updateMenu() {
        viewer.getPlayer().updateInventory();
    }

    public void setBlankMenu() {
        ItemStack[] blankMenu = new ItemStack[27];
        for (int i = 0; i < 9; i++) {
            blankMenu[i] = addBlankIcon();
        }
        blankMenu[9] = addBlankIcon();
        blankMenu[10] = null; // tool slot
        blankMenu[11] = addBlankIcon();
        blankMenu[12] = null; // ingredient slot
        blankMenu[13] = addBlankIcon();
        blankMenu[14] = addModifyButton(); // modify button
        blankMenu[15] = addBlankIcon();
        blankMenu[16] = null; // output slot
        blankMenu[17] = addBlankIcon();
        for (int i = 18; i < 27; i++) {
            blankMenu[i] = addBlankIcon();
        }
        inv.setContents(blankMenu);
    }

    public void initializeMenu() {
        inv = Bukkit.createInventory(viewer.getPlayer(), 27, "Toolsmith Table");
        setBlankMenu();
        viewer.getPlayer().openInventory(inv);
    }

    public ItemStack addBlankIcon() {
        ItemStack blankIcon = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta blankIconMeta = blankIcon.getItemMeta();
        blankIconMeta.setDisplayName(" ");
        NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
        blankIconMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "ToolsPlus");
        blankIcon.setItemMeta(blankIconMeta);
        return blankIcon;
    }

    public ItemStack addModifyButton() {
        ItemStack modifyButton = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta modifyButtonMeta = modifyButton.getItemMeta();
        // name
        modifyButtonMeta.setDisplayName(ChatColor.GREEN + "Modify");
        // lore
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Press to modify.");
        modifyButtonMeta.setLore(lore);
        // tag
        NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
        modifyButtonMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "ToolsPlus");

        modifyButton.setItemMeta(modifyButtonMeta);
        return modifyButton;
    }

    public ItemStack getToolSlotItem() {
        return inv.getItem(10);
    }

    public void setToolSlotItem(ItemStack tool) {
        inv.setItem(10, tool);
        updateMenu();
    }

    public ItemStack getIngredientSlotItem() {
        return inv.getItem(12);
    }

    public void setIngredientSlotItem(ItemStack ingredient) {
        inv.setItem(12, ingredient);
        updateMenu();
    }

    public Inventory getInventory() {
        return inv;
    }
}
