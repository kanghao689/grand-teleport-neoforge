package dev.codex.gtaliketeleport;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

@Mod(GrandTeleportMod.MOD_ID)
public final class GrandTeleportMod {
    public static final String MOD_ID = "gtalike_teleport";

    public GrandTeleportMod(IEventBus modEventBus, ModContainer modContainer) {
        GtaLikeTeleportConfig.load();

        TeleportSounds.SOUNDS.register(modEventBus);
        modEventBus.addListener(GtaLikeTeleportNetworkPayloads::register);

        NeoForge.EVENT_BUS.addListener(GrandTeleportMod::onServerTick);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            GtaLikeTeleportClient.init(modEventBus);
        }
    }

    private static void onServerTick(ServerTickEvent.Post event) {
        GtaLikeTeleportServer.tick(event.getServer());
    }
}
