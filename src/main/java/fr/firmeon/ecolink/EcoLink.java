package fr.firmeon.ecolink;

import fr.firmeon.ecolink.manager.DatabaseManager;
import fr.firmeon.ecolink.util.Translator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class EcoLink extends JavaPlugin {

    private static EcoLink instance;
    private Translator translator;
    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        translator = new Translator();

        FileConfiguration config = getConfig();

        databaseManager = new DatabaseManager(
                config.getString("database.type"),
                config.getString("database.host"),
                config.getString("database.port"),
                config.getString("database.database"),
                config.getString("database.user"),
                config.getString("database.password")
        );
    }

    @Override
    public void onDisable() {

    }

    public static EcoLink getInstance() {
        return instance;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public Translator getTranslator() {
        return translator;
    }
}
