package dev.codex.gtaliketeleport;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

final class GtaLikeTeleportServerNetworking {
    private GtaLikeTeleportServerNetworking() {
    }

    static void handleAck(GtaLikeTeleportNetworkPayloads.ServerTeleportAckPayload payload, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer player) {
            GtaLikeTeleportServer.handleTeleportAck(player, payload.requestId());
        }
    }

    static void handleBypass(GtaLikeTeleportNetworkPayloads.BypassNextServerTeleportPayload payload, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer player) {
            GtaLikeTeleportServer.markNextServerTeleportBypassed(player);
        }
    }

    static boolean canSendStart(ServerPlayer player) {
        try {
            return player.connection.hasChannel(GtaLikeTeleportNetworkPayloads.StartServerTeleportPayload.TYPE);
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    static void sendStart(ServerPlayer player, long requestId, int source, Vec3 targetFeet, ResourceKey<Level> targetDimension) {
        PacketDistributor.sendToPlayer(player, new GtaLikeTeleportNetworkPayloads.StartServerTeleportPayload(
                requestId,
                source,
                targetFeet.x(),
                targetFeet.y(),
                targetFeet.z(),
                dimensionId(targetDimension)
        ));
    }

    private static String dimensionId(ResourceKey<Level> targetDimension) {
        String dimension = DimensionIds.fromResourceKey(targetDimension);
        return dimension == null ? "" : dimension;
    }
}
