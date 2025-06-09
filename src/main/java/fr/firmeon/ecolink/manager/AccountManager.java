package fr.firmeon.ecolink.manager;

import fr.firmeon.ecolink.entity.IAccount;

import java.util.HashMap;

public abstract class AccountManager {

    private final HashMap<String, IAccount> accounts;

    public AccountManager(){
        this.accounts = new HashMap<>();
    }

    public IAccount getAccount(String identifier){
        if(accounts.containsKey(identifier)){
            return this.accounts.get(identifier);
        } else {
            IAccount account = findAccount(identifier);
            this.accounts.put(identifier, account);
            return account;
        }
    }

    public void removeAccountFromCache(IAccount account){
        saveAccount(account);
        this.accounts.remove(account.getIdentifier());
    }

    public void clearCache(){
        this.accounts.forEach((identifier, account) -> removeAccountFromCache(account));
    }

    /**
     * Save the account to the database. Does not remove the account from the cache.
     * @param account The account to save
     */
    protected abstract void saveAccount(IAccount account);

    /**
     * Fin an account in the database
     * @param identifier The identifier of the account
     * @return The account from the database
     */
    protected abstract IAccount findAccount(String identifier);
}
