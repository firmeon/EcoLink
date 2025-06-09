package fr.firmeon.ecolink.entity;

import java.util.UUID;

public class PersonalAccount implements IAccount {

    private double amount;
    private final UUID identifier;

    public PersonalAccount(double amount, UUID identifier){
        this.amount = amount;
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier.toString();
    }

    public UUID getUUID(){
        return this.identifier;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double newAmount) {
        assert newAmount >= 0;

        this.amount = newAmount;
    }

    @Override
    public void add(double sum) {
        assert sum > 0;

        this.amount += sum;
    }

    @Override
    public void remove(double sum) {
        assert sum > 0;

        this.amount -= sum;
    }
}
