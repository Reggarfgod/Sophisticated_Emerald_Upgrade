package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.render;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.p3pp3rf1y.sophisticatedstorage.block.BarrelBlockClientExtensions;
import net.p3pp3rf1y.sophisticatedstorage.client.ClientEventHandler;
import net.p3pp3rf1y.sophisticatedstorage.client.render.ChestItemRenderer;
import net.p3pp3rf1y.sophisticatedstorage.client.render.ShulkerBoxItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientEventHandler.class)
public class EmeraldClientRenderMixin {

    @Inject(
            method = "registerStorageClientExtensions",
            at = @At("TAIL")
    )
    private static void sophisticated_emerald_upgrade$registerClientExtensions(
            RegisterClientExtensionsEvent event,
            CallbackInfo ci
    ) {

        event.registerBlock(

                new BarrelBlockClientExtensions(
                        ModCompat.EMERALD_BARREL.get()
                ),

                ModCompat.EMERALD_BARREL.get(),

                ModCompat.EMERALD_LIMITED_BARREL_1.get(),
                ModCompat.EMERALD_LIMITED_BARREL_2.get(),
                ModCompat.EMERALD_LIMITED_BARREL_3.get(),
                ModCompat.EMERALD_LIMITED_BARREL_4.get()
        );

        event.registerItem(

                ChestItemRenderer.getItemRenderProperties(),

                ModCompat.EMERALD_CHEST_ITEM.get()
        );

        event.registerItem(

                ShulkerBoxItemRenderer.getItemRenderProperties(),

                ModCompat.EMERALD_SHULKER_BOX_ITEM.get()
        );
    }
}