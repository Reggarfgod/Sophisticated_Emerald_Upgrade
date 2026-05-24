package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.curios;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.p3pp3rf1y.sophisticatedbackpacks.compat.curios.BackpackCurioRenderer;
import net.p3pp3rf1y.sophisticatedbackpacks.compat.curios.CuriosCompatClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mixin(CuriosCompatClient.class)
public class CuriosCompatClientMixin {

    @Inject(
            method = "registerRenderers",
            at = @At("TAIL")
    )
    private static void registerEmeraldRenderer(
            CallbackInfo ci
    ) {

        CuriosRendererRegistry.register(
                ModCompat.EMERALD_BACKPACK.get(),
                BackpackCurioRenderer::new
        );
    }
}