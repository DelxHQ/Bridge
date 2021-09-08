package me.delxhq.bridge;

import net.fabricmc.api.ModInitializer;

public class Bridge implements ModInitializer {

	private Client client;
	private Server server;

	@Override
	public void onInitialize() {
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
