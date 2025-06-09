package fr.firmeon.ecolink;

import fr.firmeon.ecolink.util.Database;
import fr.firmeon.ecolink.util.Translator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class EcoLink extends JavaPlugin {

    private static EcoLink instance;
    private Translator translator;
    private Database database;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        this.translator = new Translator();

        FileConfiguration config = getConfig();

        this.database = new Database(
                config.getString("database.type"),
                config.getString("database.host"),
                config.getString("database.port"),
                config.getString("database.database"),
                config.getString("database.user"),
                config.getString("database.password")
        );
        this.database.createTables();
    }

    @Override
    public void onDisable() {
        this.database.disconnect();
    }

    public static EcoLink getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return this.database;
    }

    public Translator getTranslator() {
        return this.translator;
    }
}
