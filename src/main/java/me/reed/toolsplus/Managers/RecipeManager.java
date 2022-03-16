package me.reed.toolsplus.Managers;

import me.reed.toolsplus.ToolsPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.Damageable;

import java.util.*;

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
        RecipeChoice.MaterialChoice stones = new RecipeChoice.MaterialChoice(Arrays.asList(
                Material.COBBLESTONE,
                Material.COBBLED_DEEPSLATE,
                Material.STONE,
                Material.DEEPSLATE));

        // PICKAXES:
        ItemStack woodPick = new ItemStack(Material.WOODEN_PICKAXE, 1);
        woodPick.setItemMeta(ToolUtilities.getNewToolData(woodPick));
        ShapedRecipe woodPickRecipe = new ShapedRecipe(new NamespacedKey(plugin, "wooden_pickaxe_plus"), woodPick);
        woodPickRecipe.shape("PPP", " S ", " T ");
        woodPickRecipe.setIngredient('P', planks);
        woodPickRecipe.setIngredient('S', Material.STRING);
        woodPickRecipe.setIngredient('T', Material.STICK);

        ItemStack stonePick = new ItemStack(Material.STONE_PICKAXE, 1);
        stonePick.setItemMeta(ToolUtilities.getNewToolData(stonePick));
        ShapedRecipe stonePickRecipe = new ShapedRecipe(new NamespacedKey(plugin, "stone_pickaxe_plus"), stonePick);
        stonePickRecipe.shape("PPP", " S ", " T ");
        stonePickRecipe.setIngredient('P', stones);
        stonePickRecipe.setIngredient('S', Material.STRING);
        stonePickRecipe.setIngredient('T', Material.STICK);

        ItemStack ironPick = new ItemStack(Material.IRON_PICKAXE, 1);
        ironPick.setItemMeta(ToolUtilities.getNewToolData(ironPick));
        ShapedRecipe ironPickRecipe = new ShapedRecipe(new NamespacedKey(plugin, "iron_pickaxe_plus"), ironPick);
        ironPickRecipe.shape("PPP", " S ", " T ");
        ironPickRecipe.setIngredient('P', Material.IRON_INGOT);
        ironPickRecipe.setIngredient('S', Material.STRING);
        ironPickRecipe.setIngredient('T', Material.STICK);

        ItemStack diamondPick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        diamondPick.setItemMeta(ToolUtilities.getNewToolData(diamondPick));
        ShapedRecipe diamondPickRecipe = new ShapedRecipe(new NamespacedKey(plugin, "diamond_pickaxe_plus"), diamondPick);
        diamondPickRecipe.shape("PPP", " S ", " T ");
        diamondPickRecipe.setIngredient('P', Material.DIAMOND);
        diamondPickRecipe.setIngredient('S', Material.STRING);
        diamondPickRecipe.setIngredient('T', Material.STICK);

        // AXES:
        ItemStack woodAxe = new ItemStack(Material.WOODEN_AXE, 1);
        woodAxe.setItemMeta(ToolUtilities.getNewToolData(woodAxe));
        ShapedRecipe woodAxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "wooden_axe_plus"), woodAxe);
        woodAxeRecipe.shape("PP", "PS", " T");
        woodAxeRecipe.setIngredient('P', planks);
        woodAxeRecipe.setIngredient('S', Material.STRING);
        woodAxeRecipe.setIngredient('T', Material.STICK);

        ItemStack stoneAxe = new ItemStack(Material.STONE_AXE, 1);
        stoneAxe.setItemMeta(ToolUtilities.getNewToolData(stoneAxe));
        ShapedRecipe stoneAxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "stone_axe_plus"), stoneAxe);
        stoneAxeRecipe.shape("PP", "PS", " T");
        stoneAxeRecipe.setIngredient('P', stones);
        stoneAxeRecipe.setIngredient('S', Material.STRING);
        stoneAxeRecipe.setIngredient('T', Material.STICK);

        ItemStack ironAxe = new ItemStack(Material.IRON_AXE, 1);
        ironAxe.setItemMeta(ToolUtilities.getNewToolData(ironAxe));
        ShapedRecipe ironAxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "iron_axe_plus"), ironAxe);
        ironAxeRecipe.shape("PP", "PS", " T");
        ironAxeRecipe.setIngredient('P', Material.IRON_INGOT);
        ironAxeRecipe.setIngredient('S', Material.STRING);
        ironAxeRecipe.setIngredient('T', Material.STICK);

        ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE, 1);
        diamondAxe.setItemMeta(ToolUtilities.getNewToolData(diamondAxe));
        ShapedRecipe diamondAxeRecipe = new ShapedRecipe(new NamespacedKey(plugin, "diamond_axe_plus"), diamondAxe);
        diamondAxeRecipe.shape("PP", "PS", " T");
        diamondAxeRecipe.setIngredient('P', Material.DIAMOND);
        diamondAxeRecipe.setIngredient('S', Material.STRING);
        diamondAxeRecipe.setIngredient('T', Material.STICK);

        // SHOVELS:
        ItemStack woodShovel = new ItemStack(Material.WOODEN_SHOVEL, 1);
        woodShovel.setItemMeta(ToolUtilities.getNewToolData(woodShovel));
        ShapedRecipe woodShovelRecipe = new ShapedRecipe(new NamespacedKey(plugin, "wooden_shovel_plus"), woodShovel);
        woodShovelRecipe.shape("P", "S", "T");
        woodShovelRecipe.setIngredient('P', planks);
        woodShovelRecipe.setIngredient('S', Material.STRING);
        woodShovelRecipe.setIngredient('T', Material.STICK);

        ItemStack stoneShovel = new ItemStack(Material.STONE_SHOVEL, 1);
        stoneShovel.setItemMeta(ToolUtilities.getNewToolData(stoneShovel));
        ShapedRecipe stoneShovelRecipe = new ShapedRecipe(new NamespacedKey(plugin, "stone_shovel_plus"), stoneShovel);
        stoneShovelRecipe.shape("P", "S", "T");
        stoneShovelRecipe.setIngredient('P', stones);
        stoneShovelRecipe.setIngredient('S', Material.STRING);
        stoneShovelRecipe.setIngredient('T', Material.STICK);

        ItemStack ironShovel = new ItemStack(Material.IRON_SHOVEL, 1);
        ironShovel.setItemMeta(ToolUtilities.getNewToolData(ironShovel));
        ShapedRecipe ironShovelRecipe = new ShapedRecipe(new NamespacedKey(plugin, "iron_shovel_plus"), ironShovel);
        ironShovelRecipe.shape("P", "S", "T");
        ironShovelRecipe.setIngredient('P', Material.IRON_INGOT);
        ironShovelRecipe.setIngredient('S', Material.STRING);
        ironShovelRecipe.setIngredient('T', Material.STICK);

        ItemStack diamondShovel = new ItemStack(Material.DIAMOND_SHOVEL, 1);
        diamondShovel.setItemMeta(ToolUtilities.getNewToolData(diamondShovel));
        ShapedRecipe diamondShovelRecipe = new ShapedRecipe(new NamespacedKey(plugin, "diamond_shovel_plus"), diamondShovel);
        diamondShovelRecipe.shape("P", "S", "T");
        diamondShovelRecipe.setIngredient('P', Material.DIAMOND);
        diamondShovelRecipe.setIngredient('S', Material.STRING);
        diamondShovelRecipe.setIngredient('T', Material.STICK);

        // SWORDS:
        ItemStack woodSword = new ItemStack(Material.WOODEN_SWORD, 1);
        woodSword.setItemMeta(ToolUtilities.getNewToolData(woodSword));
        ShapedRecipe woodSwordRecipe = new ShapedRecipe(new NamespacedKey(plugin, "wooden_sword_plus"), woodSword);
        woodSwordRecipe.shape(" P", "SP", " T");
        woodSwordRecipe.setIngredient('P', planks);
        woodSwordRecipe.setIngredient('S', Material.STRING);
        woodSwordRecipe.setIngredient('T', Material.STICK);

        ItemStack stoneSword = new ItemStack(Material.STONE_SWORD, 1);
        stoneSword.setItemMeta(ToolUtilities.getNewToolData(stoneSword));
        ShapedRecipe stoneSwordRecipe = new ShapedRecipe(new NamespacedKey(plugin, "stone_sword_plus"), stoneSword);
        stoneSwordRecipe.shape(" P", "SP", " T");
        stoneSwordRecipe.setIngredient('P', stones);
        stoneSwordRecipe.setIngredient('S', Material.STRING);
        stoneSwordRecipe.setIngredient('T', Material.STICK);

        ItemStack ironSword = new ItemStack(Material.IRON_SWORD, 1);
        ironSword.setItemMeta(ToolUtilities.getNewToolData(ironSword));
        ShapedRecipe ironSwordRecipe = new ShapedRecipe(new NamespacedKey(plugin, "iron_sword_plus"), ironSword);
        ironSwordRecipe.shape(" P", "SP", " T");
        ironSwordRecipe.setIngredient('P', Material.IRON_INGOT);
        ironSwordRecipe.setIngredient('S', Material.STRING);
        ironSwordRecipe.setIngredient('T', Material.STICK);

        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        diamondSword.setItemMeta(ToolUtilities.getNewToolData(diamondSword));
        ShapedRecipe diamondSwordRecipe = new ShapedRecipe(new NamespacedKey(plugin, "diamond_sword_plus"), diamondSword);
        diamondSwordRecipe.shape(" P", "SP", " T");
        diamondSwordRecipe.setIngredient('P', Material.DIAMOND);
        diamondSwordRecipe.setIngredient('S', Material.STRING);
        diamondSwordRecipe.setIngredient('T', Material.STICK);

        // REPAIR KITS:
        ItemStack woodenRepairKit = new ItemStack(Material.OAK_PRESSURE_PLATE, 1);
        woodenRepairKit.setItemMeta(ToolUtilities.getNewRepairKitData(woodenRepairKit));
        ShapelessRecipe woodenRepairKitRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "wooden_repair_kit"), woodenRepairKit);
        woodenRepairKitRecipe.addIngredient(planks);
        woodenRepairKitRecipe.addIngredient(planks);
        woodenRepairKitRecipe.addIngredient(2, Material.STICK);

        ItemStack stoneRepairKit = new ItemStack(Material.STONE_PRESSURE_PLATE, 1);
        stoneRepairKit.setItemMeta(ToolUtilities.getNewRepairKitData(stoneRepairKit));
        ShapelessRecipe stoneRepairKitRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "stone_repair_kit"), stoneRepairKit);
        stoneRepairKitRecipe.addIngredient(stones);
        stoneRepairKitRecipe.addIngredient(stones);
        stoneRepairKitRecipe.addIngredient(2, Material.STICK);

        ItemStack ironRepairKit = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 1);
        ironRepairKit.setItemMeta(ToolUtilities.getNewRepairKitData(ironRepairKit));
        ShapelessRecipe ironRepairKitRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "iron_repair_kit"), ironRepairKit);
        ironRepairKitRecipe.addIngredient(2, Material.IRON_INGOT);
        ironRepairKitRecipe.addIngredient(2, Material.STICK);

        ItemStack diamondRepairKit = new ItemStack(Material.DIAMOND, 1);
        diamondRepairKit.setItemMeta(ToolUtilities.getNewRepairKitData(diamondRepairKit));
        ShapelessRecipe diamondRepairKitRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "diamond_repair_kit"), diamondRepairKit);
        diamondRepairKitRecipe.addIngredient(2, Material.DIAMOND);
        diamondRepairKitRecipe.addIngredient(2, Material.STICK);

        ItemStack netheriteRepairKit = new ItemStack(Material.NETHERITE_SCRAP, 1);
        netheriteRepairKit.setItemMeta(ToolUtilities.getNewRepairKitData(netheriteRepairKit));
        ShapelessRecipe netheriteRepairKitRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "netherite_repair_kit"), netheriteRepairKit);
        netheriteRepairKitRecipe.addIngredient(2, Material.NETHERITE_SCRAP);
        netheriteRepairKitRecipe.addIngredient(2, Material.GOLD_INGOT);

        // REGISTER RECIPES:
        Bukkit.addRecipe(woodPickRecipe);
        Bukkit.addRecipe(stonePickRecipe);
        Bukkit.addRecipe(ironPickRecipe);
        Bukkit.addRecipe(diamondPickRecipe);
        Bukkit.addRecipe(woodAxeRecipe);
        Bukkit.addRecipe(stoneAxeRecipe);
        Bukkit.addRecipe(ironAxeRecipe);
        Bukkit.addRecipe(diamondAxeRecipe);
        Bukkit.addRecipe(woodShovelRecipe);
        Bukkit.addRecipe(stoneShovelRecipe);
        Bukkit.addRecipe(ironShovelRecipe);
        Bukkit.addRecipe(diamondShovelRecipe);
        Bukkit.addRecipe(woodSwordRecipe);
        Bukkit.addRecipe(stoneSwordRecipe);
        Bukkit.addRecipe(ironSwordRecipe);
        Bukkit.addRecipe(diamondSwordRecipe);
        Bukkit.addRecipe(woodenRepairKitRecipe);
        Bukkit.addRecipe(stoneRepairKitRecipe);
        Bukkit.addRecipe(ironRepairKitRecipe);
        Bukkit.addRecipe(diamondRepairKitRecipe);
        Bukkit.addRecipe(netheriteRepairKitRecipe);
    }

    /**
     * Checks whether a modification can happen with the provided tool and modifier item
     * @param tool The tool to receive the modification
     * @param modifierItem The item used to apply the modifier
     * @return Whether the tool can receive a modifier based on the items provided in the toolsmith table
     */
    public boolean isValidModification(ItemStack tool, ItemStack modifierItem) {
        if (ToolUtilities.isTPTool(tool)) {
            List<String> lore = tool.getItemMeta().getLore();
            String modifierSlotsString = lore.get(lore.size() - 2);
            int modifierSlots = Integer.parseInt(modifierSlotsString.substring(modifierSlotsString.lastIndexOf(" ") + 1, modifierSlotsString.length()));
            if (modifierSlots > 0) {
                if (isVanillaModifierItem(modifierItem)) {
                    return true;
                } //TODO: custom modifier item check
            }
        }
        return false;
    }

    public boolean isValidUpgrade(ItemStack tool, ItemStack upgrade) {
        if (ToolUtilities.isTPTool(tool) && !ToolUtilities.isTPTool(upgrade)) {
            Material toolMaterial = tool.getType();
            Material upgradeMaterial = upgrade.getType();
            Map<Material, Material> upgradeMap = getUpgradeMap();
            return upgradeMaterial == upgradeMap.get(toolMaterial);
        } else
            return false;
    }

    /**
     * Used to verify that a tool repair is valid
     * @param tool a Tools+ tool that is not at full durability
     * @param repair a tool repair kit that matches the tool's material
     * @return whether the repair is valid
     */
    public boolean isValidRepair(Player user, ItemStack tool, ItemStack repair) {
        if (ToolUtilities.isTPTool(tool) && ToolUtilities.hasTPTag(repair)) {
            Damageable dTool = (Damageable) tool.getItemMeta();
            if (dTool.hasDamage()) {
                String toolMaterial = tool.getType().toString().substring(0, tool.getType().toString().indexOf("_"));
                String repairMaterial = ChatColor.stripColor(repair.getItemMeta().getDisplayName().substring(0, repair.getItemMeta().getDisplayName().indexOf(" ")));
                if (toolMaterial.equalsIgnoreCase(repairMaterial)) {
                    return true;
                } else {
                    user.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f" + ChatColor.BOLD + "T+" + ChatColor.RESET + "&2] &7You can only repair tools with the same material repair kit" + "."));
                    return false;
                }
            } else {
                user.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[&f&lT+&r&2] &7You can only repair tools that have durability damage."));
            }
        }
        return false;
    }

    /**
     * Returns a HashMap with a tool type's corresponding upgrade Material (i.e. WOODEN_PICKAXE:STONE_PICKAXE)
     */
    public Map<Material, Material> getUpgradeMap() {
        Map<Material, Material> upgradeMap = new HashMap<>();
        upgradeMap.put(Material.WOODEN_PICKAXE, Material.STONE_PICKAXE);
        upgradeMap.put(Material.STONE_PICKAXE, Material.IRON_PICKAXE);
        upgradeMap.put(Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE);
        upgradeMap.put(Material.DIAMOND_PICKAXE, Material.NETHERITE_INGOT);
        upgradeMap.put(Material.WOODEN_AXE, Material.STONE_AXE);
        upgradeMap.put(Material.STONE_AXE, Material.IRON_AXE);
        upgradeMap.put(Material.IRON_AXE, Material.DIAMOND_AXE);
        upgradeMap.put(Material.DIAMOND_AXE, Material.NETHERITE_INGOT);
        upgradeMap.put(Material.WOODEN_SHOVEL, Material.STONE_SHOVEL);
        upgradeMap.put(Material.STONE_SHOVEL, Material.IRON_SHOVEL);
        upgradeMap.put(Material.IRON_SHOVEL, Material.DIAMOND_SHOVEL);
        upgradeMap.put(Material.DIAMOND_SHOVEL, Material.NETHERITE_INGOT);
        upgradeMap.put(Material.WOODEN_SWORD, Material.STONE_SWORD);
        upgradeMap.put(Material.STONE_SWORD, Material.IRON_SWORD);
        upgradeMap.put(Material.IRON_SWORD, Material.DIAMOND_SWORD);
        upgradeMap.put(Material.DIAMOND_SWORD, Material.NETHERITE_INGOT);
        return upgradeMap;
    }

    public Map<Material, Material> getNUpgradeMap() {
        Map<Material, Material> nUpgradeMap = new HashMap<>();
        nUpgradeMap.put(Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE);
        nUpgradeMap.put(Material.DIAMOND_AXE, Material.NETHERITE_AXE);
        nUpgradeMap.put(Material.DIAMOND_SHOVEL, Material.NETHERITE_SHOVEL);
        nUpgradeMap.put(Material.DIAMOND_SWORD, Material.NETHERITE_SWORD);
        return nUpgradeMap;
    }

    public boolean isVanillaModifierItem(ItemStack item) {
        if (item.getType() == Material.REDSTONE
                || item.getType() == Material.REDSTONE_BLOCK
                || item.getType() == Material.LAPIS_LAZULI
                || item.getType() == Material.LAPIS_BLOCK
                || item.getType() == Material.OBSIDIAN)
            return true;
        else
            return false;
    }
}
