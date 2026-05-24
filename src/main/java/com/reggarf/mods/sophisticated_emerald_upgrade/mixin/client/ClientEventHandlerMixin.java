package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.client;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.p3pp3rf1y.sophisticatedbackpacks.client.ClientEventHandler;
import net.p3pp3rf1y.sophisticatedbackpacks.client.render.BackpackItemStackRenderer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.neoforge.common.util.Lazy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientEventHandler.class)
public class ClientEventHandlerMixin {

    @Inject(
            method = "registerBackpackClientExtension",
            at = @At("TAIL")
    )
    private static void addEmeraldRenderer(
            RegisterClientExtensionsEvent event,
            CallbackInfo ci
    ) {

        event.registerItem(new IClientItemExtensions() {

            private final Lazy<BlockEntityWithoutLevelRenderer> ister =
                    Lazy.of(() -> new BackpackItemStackRenderer(
                            Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                            Minecraft.getInstance().getEntityModels()
                    ));

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ister.get();
            }

        }, ModCompat.EMERALD_BACKPACK.get());
    }
}