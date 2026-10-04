package dev.codex.gtaliketeleport;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

final class TeleportSounds {
    static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(Registries.SOUND_EVENT, GrandTeleportMod.MOD_ID);

    static final DeferredHolder<SoundEvent, SoundEvent> CAMERA_IN = create("teleport.camera_in");
    static final DeferredHolder<SoundEvent, SoundEvent> CAMERA_OUT = create("teleport.camera_out");
    static final DeferredHolder<SoundEvent, SoundEvent> TELEPORT = create("teleport.teleport");
    static final DeferredHolder<SoundEvent, SoundEvent> ZOOM_IN_LONG = create("teleport.zoom_in_long");
    static final DeferredHolder<SoundEvent, SoundEvent> ZOOM_IN_SHORT = create("teleport.zoom_in_short");
    static final DeferredHolder<SoundEvent, SoundEvent> ZOOM_OUT_LONG = create("teleport.zoom_out_long");
    static final DeferredHolder<SoundEvent, SoundEvent> ZOOM_OUT_SHORT = create("teleport.zoom_out_short");

    private TeleportSounds() {
    }

    private static DeferredHolder<SoundEvent, SoundEvent> create(String path) {
        return SOUNDS.register(path, () -> SoundEvent.createVariableRangeEvent(
                ResourceLocation.fromNamespaceAndPath(GrandTeleportMod.MOD_ID, path)));
    }
}
