package me.delxhq.bridge;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.protocol.MinecraftConstants;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.mc.protocol.data.status.PlayerInfo;
import com.github.steveice10.mc.protocol.data.status.ServerStatusInfo;
import com.github.steveice10.mc.protocol.data.status.VersionInfo;
import com.github.steveice10.mc.protocol.data.status.handler.ServerInfoBuilder;
import com.github.steveice10.packetlib.tcp.TcpServer;
import net.kyori.adventure.text.Component;

import java.net.Proxy;

public class Server {

    public com.github.steveice10.packetlib.Server server;

    private static final String HOST = "0.0.0.0";
    private static final int PORT = 25565;

    public Server() {
        SessionService sessionService = new SessionService();
        sessionService.setProxy(Proxy.NO_PROXY);

        this.server = new TcpServer(HOST, PORT, MinecraftProtocol.class);
        this.server.setGlobalFlag(MinecraftConstants.SESSION_SERVICE_KEY, sessionService);
        this.server.setGlobalFlag(MinecraftConstants.VERIFY_USERS_KEY, false);

        this.server.setGlobalFlag(MinecraftConstants.SERVER_INFO_BUILDER_KEY, (ServerInfoBuilder) session ->
                new ServerStatusInfo(
                        new VersionInfo(MinecraftConstants.GAME_VERSION, MinecraftConstants.PROTOCOL_VERSION),
                        new PlayerInfo(100, 0, new GameProfile[0]),
                        Component.text("§eA Bridge Server"),
                        null
                )
        );
        this.server.bind();
    }
}
