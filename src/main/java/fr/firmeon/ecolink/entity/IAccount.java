package fr.firmeon.ecolink.entity;

public interface IAccount {

    /**
     * Get the account identifier
     * @return A string that represent the account identifier
     */
    String getIdentifier();

    /**
     * Get the current amount of the account
     * @return the current amount
     */
    double getAmount();

    /**
     * Set a new amount for the account
     * @param newAmount The new amount for this account. Must be greater or equal than 0.
     */
    void setAmount(double newAmount);

    /**
     * Add money to the account
     * @param sum The sum that should be added to the account. Must be greater than 0.
     */
    void add(double sum);

    /**
     * Remove money to the account
     * @param sum The sum that should be removed from the account. Must be greater than 0.
     */
    void remove(double sum);
}
