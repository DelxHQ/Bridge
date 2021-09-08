package me.delxhq.bridge;

public class Bridge {

    private final Client client;
    private final Server server;

    public Bridge() {
        this.client = new Client(this);
        this.server = new Server(this);
    }

    public Client getClient() {
        return client;
    }

    public Server getServer() {
        return server;
    }
}
