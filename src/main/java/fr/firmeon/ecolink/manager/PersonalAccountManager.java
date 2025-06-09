package fr.firmeon.ecolink.manager;

import fr.firmeon.ecolink.EcoLink;
import fr.firmeon.ecolink.entity.IAccount;
import fr.firmeon.ecolink.util.Database;
import fr.firmeon.ecolink.util.Translator;

import java.util.UUID;

public class PersonalAccountManager extends AccountManager {

    public static boolean hasPersonalAccount(UUID playerUUID){
        Database db = EcoLink.getInstance().getDatabase();
        return false;
    }

    public static void createPersonalAccount(UUID playerUUID){
        EcoLink.getInstance().getDatabase().createPersonalAccount(playerUUID);
        EcoLink.getInstance().getLogger().info(Translator.trans("personal-account.create.success"));
    }

    @Override
    protected void saveAccount(IAccount account) {
        //TODO
    }

    @Override
    protected IAccount findAccount(String identifier) {
        //TODO
        return null;
    }
}
