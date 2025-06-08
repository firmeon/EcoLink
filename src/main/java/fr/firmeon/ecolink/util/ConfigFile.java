package fr.firmeon.ecolink.util;

import fr.firmeon.ecolink.EcoLink;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {

    private String fileName;
    private File file;
    private FileConfiguration config;

    public ConfigFile(String fileName) {
        this.fileName = fileName;
        loadFile();
        loadConfiguration();
    }

    private void loadFile(){
        this.file = new File(EcoLink.getInstance().getDataFolder(), this.fileName);

        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            EcoLink.getInstance().saveResource(this.fileName, false);
        }
    }

    private void loadConfiguration(){
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void save() {
        try {
            config.save(this.file);
        } catch (IOException e) {
            EcoLink.getInstance().getLogger().severe(e.getMessage());
        }
    }

    public void reload() {
        loadFile();
        loadConfiguration();
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
