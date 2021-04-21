package org.bukkit.craftbukkit.util;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.MinecraftException;

public class ServerShutdownThread extends Thread {
    private final MinecraftServer server;

    public ServerShutdownThread(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            server.stopServer();
        } catch (MinecraftException ex) {
            ex.printStackTrace();
        } finally {
            try { catserver.server.threads.ConsoleWriteThread.stopThread(); net.minecraftforge.server.terminalconsole.TerminalConsoleAppender.close(); } catch (Exception ignored) {} // CatServer
        }
    }
}
