package fr.firmeon.ecolink;

import fr.firmeon.ecolink.manager.DatabaseManager;
import fr.firmeon.ecolink.util.Translator;
import org.bukkit.plugin.java.JavaPlugin;

public final class EcoLink extends JavaPlugin {

    private static EcoLink instance;
    private static DatabaseManager databaseManager;
    private static Translator translator;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    public static EcoLink getInstance() {
        return instance;
    }

    public static DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public static Translator getTranslator() {
        return translator;
    }
}
