package me.reed.toolsplus.Managers;

import me.reed.toolsplus.ToolsPlus;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class ToolUtilities {
    private static final ToolsPlus plugin = ToolsPlus.getPlugin();

    /**
     * Used to get all the proper Tools+ tool data
     * @param tool The tool receiving the data
     * @return ItemMeta to give the tool
     */
    public static ItemMeta getNewToolData(ItemStack tool) {
        ItemMeta toolMeta = tool.getItemMeta();
        toolMeta.setDisplayName(ChatColor.WHITE + WordUtils.capitalize(tool.getType().toString().toLowerCase().replace("_", " ")) + "+");
        // lore
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GREEN + "Level: " + ChatColor.GREEN + "0" + ChatColor.DARK_GREEN + " - Level XP: " + ChatColor.GREEN + "[0/100]");
        String toolMaterial = tool.getType().toString().substring(0, tool.getType().toString().indexOf("_"));
        switch(toolMaterial) {
            case "STONE":
                lore.add(ChatColor.DARK_AQUA + "Modifier Slots: " + ChatColor.AQUA + "1");
                break;
            case "IRON":
                lore.add(ChatColor.DARK_AQUA + "Modifier Slots: " + ChatColor.AQUA + "2");
                break;
            case "DIAMOND":
                lore.add(ChatColor.DARK_AQUA + "Modifier Slots: " + ChatColor.AQUA + "3");
                break;
            case "NETHERITE":
                lore.add(ChatColor.DARK_AQUA + "Modifier Slots: " + ChatColor.AQUA + "4");
                break;
            case "WOODEN": // use default 0
            default:
                lore.add(ChatColor.DARK_AQUA + "Modifier Slots: " + ChatColor.AQUA + "0");
                break;
        }
        lore.add(getMaxDurabilityString(tool));
        toolMeta.setLore(lore);
        // hide enchants
        toolMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        // "ToolsPlus" tag
        NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
        toolMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "ToolsPlus");
        return toolMeta;
    }



    /**
     * Used to get all the proper Tools+ repair kit data
     * @param repair The repair kit receiving the data
     * @return ItemMeta to give the repair kit
     */
    public static ItemMeta getNewRepairKitData(ItemStack repair) {
        ItemMeta repairMeta = repair.getItemMeta();
        String displayName = ChatColor.WHITE + "Repair Kit";
        List<String> lore = new ArrayList<>();
        Material repairMaterial = repair.getType();
        switch(repairMaterial) {
            case OAK_PRESSURE_PLATE:
                displayName = ChatColor.translateAlternateColorCodes('&', "&fWooden Repair Kit");
                lore.add(ChatColor.translateAlternateColorCodes('&', "&eCombine with a &6wooden tool+ &ein a"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&6Toolsmith Table &eto fully repair the tool."));
                break;
            case STONE_PRESSURE_PLATE:
                displayName = ChatColor.translateAlternateColorCodes('&', "&fStone Repair Kit");
                lore.add(ChatColor.translateAlternateColorCodes('&', "&fCombine with a &7stone tool+ &fin a"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Toolsmith Table &fto fully repair the tool."));
                break;
            case HEAVY_WEIGHTED_PRESSURE_PLATE:
                displayName = ChatColor.translateAlternateColorCodes('&', "&fIron Repair Kit");
                lore.add(ChatColor.translateAlternateColorCodes('&', "&fCombine with an &7iron tool+ &fin a"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Toolsmith Table &fto fully repair the tool."));
                break;
            case DIAMOND:
                displayName = ChatColor.translateAlternateColorCodes('&', "&fDiamond Repair Kit");
                lore.add(ChatColor.translateAlternateColorCodes('&', "&bCombine with a &3diamond tool+ &bin a"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&3Toolsmith Table &bto fully repair the tool."));
                break;
            case NETHERITE_SCRAP:
                displayName = ChatColor.translateAlternateColorCodes('&', "&fNetherite Repair Kit");
                lore.add(ChatColor.translateAlternateColorCodes('&', "&7Combine with a &8netherite tool+ &7in a"));
                lore.add(ChatColor.translateAlternateColorCodes('&', "&8Toolsmith Table &7to fully repair the tool."));
                break;
            default:
                break;
        }
        repairMeta.setDisplayName(displayName);
        repairMeta.setLore(lore);
        // "ToolsPlus" tag
        NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
        repairMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "ToolsPlus");
        return repairMeta;
    }

    public static String getToolMaterial(ItemStack tool) {
        return tool.getType().toString().substring(0, tool.getType().toString().indexOf("_"));
    }

    public static String getMaxDurabilityString(ItemStack tool) {
        return ChatColor.DARK_GRAY + "Durability: " + ChatColor.GRAY + tool.getType().getMaxDurability() + "/" + tool.getType().getMaxDurability();
    }

    public static Damageable getToolFullDuraData(ItemStack tool) {
        Damageable dTool = (Damageable) tool.getItemMeta();
        List<String> lore = dTool.getLore();
        lore.set(dTool.getLore().size() - 1, getMaxDurabilityString(tool));
        dTool.setLore(lore);
        dTool.setDamage(0);
        return dTool;
    }

    public static int getToolModifierSlots(ItemStack tool) {
        List<String> lore = tool.getItemMeta().getLore();
        return Integer.parseInt(ChatColor.stripColor(lore.get(lore.size()-2).substring(lore.get(lore.size()-2).lastIndexOf(" ") + 1, lore.get(lore.size()-2).length())));
    }

    public static ItemMeta changeToolModifierSlotsData(ItemStack tool, int change) {
        List<String> lore = tool.getItemMeta().getLore();
        ItemMeta toolMeta = tool.getItemMeta();
        String modifierSlotsString = ChatColor.DARK_AQUA + "Modifier Slots: " + ChatColor.AQUA + (getToolModifierSlots(tool) + change);
        lore.set(lore.size() - 2, modifierSlotsString);
        toolMeta.setLore(lore);
        return toolMeta;
    }

    /**
     * Tests whether an ItemStack is a Tools+ tool
     * @param item an ItemStack
     * @return whether the item is a tool
     */
    public static boolean isTPTool(ItemStack item) {
        if (item != null) {
            if (hasTPTag(item)) {
                String itemMaterial = item.getType().toString();
                return (itemMaterial.contains("PICKAXE") || itemMaterial.contains("AXE") || itemMaterial.contains("SHOVEL") || itemMaterial.contains("SWORD"));
            }
        }
        return false;
    }

    /**
     * Tests whether an ItemStack has the Tools+ tag
     * @param item an ItemStack
     * @return whether the item has the Tools+ tag
     */
    public static boolean hasTPTag(ItemStack item) {
        if (item != null)
            return item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(plugin, "ToolsPlus"), PersistentDataType.STRING);
        return false;
    }
}
