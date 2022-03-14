package me.reed.toolsplus;

import me.reed.toolsplus.Events.Listeners;
import me.reed.toolsplus.Managers.RecipeManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ToolsPlus extends JavaPlugin {
    private static ToolsPlus plugin;
    private static RecipeManager recipeManager;
    private final static Logger log = Bukkit.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        recipeManager = new RecipeManager();
        recipeManager.registerCraftingRecipes();
        getServer().getPluginManager().registerEvents(new Listeners(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ToolsPlus getPlugin() {
        return plugin;
    }

    public static RecipeManager getRecipeManager() {
        return recipeManager;
    }
}
