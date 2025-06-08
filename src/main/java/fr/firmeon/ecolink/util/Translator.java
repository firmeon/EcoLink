package fr.firmeon.ecolink.util;

import fr.firmeon.ecolink.EcoLink;

public class Translator {

    private final ConfigFile translationConfig;

    public Translator(){
        this.translationConfig = new ConfigFile(EcoLink.getInstance().getConfig().getString("translation"));
    }

    public String trans(String path){
        return translationConfig.getConfig().getString(path);
    }

    public void reloadTranslation(){
        this.translationConfig.reload();
    }
}
