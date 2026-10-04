package dev.codex.gtaliketeleport.mixin;

import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public final class GtaLikeTeleportMixinPlugin implements IMixinConfigPlugin {
    private static final String JOURNEYMAP_MIXIN = "dev.codex.gtaliketeleport.mixin.JourneyMapClientNetworkDispatcherMixin";
    private static final String VOXY_CLIENT_MIXIN = "dev.codex.gtaliketeleport.mixin.VoxyClientMixin";
    private static final String WAYSTONES_WARP_PLATE_MIXIN = "dev.codex.gtaliketeleport.mixin.WaystonesWarpPlateBlockEntityMixin";

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.equals(JOURNEYMAP_MIXIN)) {
            return isModLoaded("journeymap");
        }

        if (mixinClassName.equals(VOXY_CLIENT_MIXIN)) {
            return isModLoaded("voxy");
        }

        if (mixinClassName.equals(WAYSTONES_WARP_PLATE_MIXIN)) {
            return isModLoaded("waystones");
        }

        return true;
    }

    // Mixin config plugins run before the runtime ModList exists, so query the early
    // loading mod list instead. Default to false (skip the optional mixin) if unavailable.
    private static boolean isModLoaded(String modId) {
        try {
            LoadingModList loadingModList = FMLLoader.getLoadingModList();
            return loadingModList != null && loadingModList.getModFileById(modId) != null;
        } catch (Throwable ignored) {
            return false;
        }
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
