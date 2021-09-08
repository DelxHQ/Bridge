package me.delxhq.bridge;

import com.nukkitx.protocol.bedrock.BedrockClient;

import java.net.InetSocketAddress;

public class Client {

    public BedrockClient client;

    public Client() {
        InetSocketAddress bindAddress = new InetSocketAddress("0.0.0.0", 56437);

        this.client = new BedrockClient(bindAddress);
        this.client.bind().join();
    }

    public void pingRemoteServer(InetSocketAddress address) {
        this.client.ping(address).whenComplete((bedrockPong, throwable) -> {
            if (throwable != null) {
                return;
            }
            System.out.println(bedrockPong.getMotd());
        }).join();
    }
}
