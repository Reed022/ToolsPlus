package me.reed.toolsplus.Managers;

import me.reed.toolsplus.ToolsPlus;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeManager {
    private final ToolsPlus plugin = ToolsPlus.getPlugin();

    /**
     * Register all ToolsPlus crafting table recipes
     */
    public void registerCraftingRecipes() {
        RecipeChoice.MaterialChoice planks = new RecipeChoice.MaterialChoice(Arrays.asList(
                Material.OAK_PLANKS,
                Material.SPRUCE_PLANKS,
                Material.BIRCH_PLANKS,
                Material.DARK_OAK_PLANKS,
                Material.ACACIA_PLANKS,
                Material.JUNGLE_PLANKS,
                Material.WARPED_PLANKS,
                Material.CRIMSON_PLANKS));

        // PICKAXES:
        ItemStack woodPick = new ItemStack(Material.WOODEN_PICKAXE, 1);
        woodPick.setItemMeta(getToolsPlusData(woodPick));
        NamespacedKey woodPickKey = new NamespacedKey(plugin, "wooden_pickaxe_plus");
        ShapedRecipe woodPickRecipe = new ShapedRecipe(woodPickKey, woodPick);
        woodPickRecipe.shape("PPP", " S ", " T ");
        woodPickRecipe.setIngredient('P', planks);
        woodPickRecipe.setIngredient('S', Material.STRING);
        woodPickRecipe.setIngredient('T', Material.STICK);

        // add recipes
        Bukkit.addRecipe(woodPickRecipe);
    }

    /**
     * Used to get all the proper Tools+ tool data (lore, name, persistent data tag)
     * @param tool - The tool receiving the data
     * @return - ItemMeta to give the tool
     */
    public ItemMeta getToolsPlusData(ItemStack tool) {
        ItemMeta toolMeta = tool.getItemMeta();
        toolMeta.setDisplayName(ChatColor.WHITE + WordUtils.capitalize(tool.getType().toString().toLowerCase().replace("_", " ")) + "+");
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
        lore.add(ChatColor.DARK_GRAY + "Durability: " + ChatColor.GRAY + tool.getData().getItemType().getMaxDurability() + "/" + tool.getData().getItemType().getMaxDurability());
        toolMeta.setLore(lore);
        // "ToolsPlus" tag
        NamespacedKey key = new NamespacedKey(plugin, "ToolsPlus");
        toolMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "ToolsPlus");
        return toolMeta;
    }
    // isValidToolsmithRecipe:
    // isValidUpgrade
    // isValidModification
    // isValidRepair
}
