package fr.firmeon.ecolink.util;

import fr.firmeon.ecolink.EcoLink;

public class Translator {

    private final ConfigFile translationConfig;

    public Translator(){
        this.translationConfig = new ConfigFile(EcoLink.getInstance().getConfig().getString("translation"));
    }

    public void reloadTranslation(){
        this.translationConfig.reload();
    }

    public static String trans(String path){
        return EcoLink.getInstance().getTranslator().translationConfig.getConfig().getString(path);
    }
}
