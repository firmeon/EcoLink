package fr.firmeon.ecolink.manager;

import fr.firmeon.ecolink.EcoLink;

import java.sql.*;

public class DatabaseManager {

    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    public DatabaseManager(String type, String host, int port, String database, String username, String password) {
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
}
