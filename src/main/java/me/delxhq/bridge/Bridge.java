package me.delxhq.bridge;

public class Bridge {

    public final Client client;
    public final Server server;

    public Bridge() {
        this.client = new Client();
        this.server = new Server();
    }
}
