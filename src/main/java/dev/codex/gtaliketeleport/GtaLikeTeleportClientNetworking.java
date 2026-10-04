package dev.codex.gtaliketeleport;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

final class GtaLikeTeleportClientNetworking {
    private GtaLikeTeleportClientNetworking() {
    }

    static boolean canSendServerTeleportAck() {
        try {
            ClientPacketListener connection = Minecraft.getInstance().getConnection();
            return connection != null
                    && connection.hasChannel(GtaLikeTeleportNetworkPayloads.ServerTeleportAckPayload.TYPE);
        } catch (IllegalStateException | IllegalArgumentException ignored) {
            return false;
        }
    }

    static boolean isServerSideTeleportAvailable() {
        Minecraft client = Minecraft.getInstance();
        if (client.getConnection() == null) {
            return true;
        }
        if (client.hasSingleplayerServer()) {
            return true;
        }
        return canSendServerTeleportAck();
    }

    static void sendServerTeleportAck(long requestId) {
        if (!canSendServerTeleportAck()) {
            return;
        }
        PacketDistributor.sendToServer(new GtaLikeTeleportNetworkPayloads.ServerTeleportAckPayload(requestId));
    }

    static void sendBypassNextServerTeleport() {
        try {
            ClientPacketListener connection = Minecraft.getInstance().getConnection();
            if (connection != null
                    && connection.hasChannel(GtaLikeTeleportNetworkPayloads.BypassNextServerTeleportPayload.TYPE)) {
                PacketDistributor.sendToServer(new GtaLikeTeleportNetworkPayloads.BypassNextServerTeleportPayload());
            }
        } catch (IllegalStateException | IllegalArgumentException ignored) {
        }
    }

    static Vec3 targetFeet(GtaLikeTeleportNetworkPayloads.StartServerTeleportPayload payload) {
        return new Vec3(payload.x(), payload.y(), payload.z());
    }

    static String targetDimensionId(GtaLikeTeleportNetworkPayloads.StartServerTeleportPayload payload) {
        String dimension = payload.dimension();
        return DimensionIds.normalize(dimension);
    }
}
