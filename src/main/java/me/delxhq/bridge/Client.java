package me.delxhq.bridge;

import com.nukkitx.protocol.bedrock.BedrockClient;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.BedrockSession;
import net.minecraft.client.util.NetworkUtils;

import java.net.InetSocketAddress;

public class Client {

    public BedrockClient client;

    private String motd;
    private int players;
    private int maxPlayers;

    public Client(Bridge bridge) {
        InetSocketAddress bindAddress = new InetSocketAddress("0.0.0.0", NetworkUtils.findLocalPort());

        this.client = new BedrockClient(bindAddress);
        this.client.bind().whenComplete((client, throwable) -> {
//            this.pingRemoteServer(new InetSocketAddress("play.nethergames.org", 19132));
        }).join();
    }

    public void pingRemoteServer(InetSocketAddress address) {
        this.client.ping(address).whenComplete((bedrockPong, throwable) -> {
            if (throwable != null) {
                return;
            }
            this.motd = bedrockPong.getMotd();
            this.players = bedrockPong.getPlayerCount();
            this.maxPlayers = bedrockPong.getMaximumPlayerCount();
        }).join();
    }

    public void sendPacketImmediately(BedrockPacket packet) {
        BedrockSession session = this.client.getSession();

        session.sendPacketImmediately(packet);
    }

    public void sendPacket(BedrockPacket packet) {
        BedrockSession session = this.client.getSession();

        session.sendPacket(packet);
    }

    public String getMotd() {
        return motd;
    }

    public int getPlayers() {
        return players;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}