package me.delxhq.bridge;

import net.fabricmc.api.ModInitializer;

public class Bridge implements ModInitializer {

	private Client client;

	@Override
	public void onInitialize() {
		this.client = new Client(this);
	}

	public Client getClient() {
		return client;
	}
}
