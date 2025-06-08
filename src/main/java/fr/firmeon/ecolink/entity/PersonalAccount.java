package fr.firmeon.ecolink.entity;

public class PersonalAccount implements IAccount {

    private int amount;

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int newAmount) {
        assert newAmount >= 0;

        this.amount = newAmount;
    }

    @Override
    public void add(int amount) {
        assert amount > 0;

        this.amount += amount;
    }

    @Override
    public void remove(int amount) {
        assert amount > 0;

        this.amount -= amount;
    }
}
