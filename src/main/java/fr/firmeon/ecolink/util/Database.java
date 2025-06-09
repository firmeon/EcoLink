package fr.firmeon.ecolink.util;

import fr.firmeon.ecolink.EcoLink;
import fr.firmeon.ecolink.entity.PersonalAccount;

import java.sql.*;
import java.util.UUID;

public class Database {

    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    public Database(String type, String host, String port, String database, String username, String password) {
        this.url = "jdbc:" + type + "://" + host + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            if (connection != null && !connection.isClosed()) return;
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            EcoLink.getInstance().getLogger().severe(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            EcoLink.getInstance().getLogger().severe(e.getMessage());
        }
    }

    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            EcoLink.getInstance().getLogger().severe(e.getMessage());
            return false;
        }
    }

    public void createTables(){
        if(!this.isConnected()){
            connect();
        }
        try{
            createUserTable();
        } catch (SQLException e){
            EcoLink.getInstance().getLogger().severe(e.getMessage());
        }
    }

    private void createUserTable() throws SQLException {
        String userTable = "CREATE TABLE IF NOT EXISTS User(" +
                "uuid VARCHAR(36) PRIMARY KEY," +
                "current_money NUMERIC(15,2) DEFAULT 0" +
                "variation_money NUMERIC(15,2) DEFAULT 0";

        Statement stm = this.connection.createStatement();
        stm.executeUpdate(userTable);
    }

    public void createPersonalAccount(UUID playerUUID){
        if(!this.isConnected()){
            connect();
        }
        try{
            String insertUser = "INSERT INTO User(uuid, current_money) VALUES (?, ?)";
            PreparedStatement stmt = this.connection.prepareStatement(insertUser);
            stmt.setString(1, playerUUID.toString());
            stmt.setInt(2, EcoLink.getInstance().getConfig().getInt("default-money"));
            stmt.executeUpdate();
        } catch (SQLException e){
            EcoLink.getInstance().getLogger().severe(e.getMessage());
        }
    }

    public PersonalAccount getPersonalAccount(UUID playerUUID){
        if(!this.isConnected()){
            connect();
        }
        try{
            String selectUser = "SELECT * FROM User WHERE uuid = ?";
            PreparedStatement stmt = this.connection.prepareStatement(selectUser);
            stmt.setString(1, playerUUID.toString());
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                double currentMoney = rs.getDouble("current_money");
                double variationMoney = rs.getDouble("variation_money");

                PersonalAccount account = new PersonalAccount(currentMoney + variationMoney, playerUUID);
                account.setAmount(rs.getDouble("current_money"));
                return account;
            }
        } catch (SQLException e){
            EcoLink.getInstance().getLogger().severe(e.getMessage());
        }
        return null;
    }

    public PersonalAccount updatePersonalAccount(UUID playerUUID){
        //TODO faire comme le get et modifier la base
        return null;
    }
}
