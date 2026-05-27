package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.client.texture;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
        targets =
                "net.p3pp3rf1y.sophisticatedstorage.client.render.ShulkerBoxRenderer"
)
public class ShulkerBoxRendererMixin {

    @Inject(
            method = "getTierMaterial",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private void sophisticated_emerald_upgrade$getTierMaterial(
            Block block,
            CallbackInfoReturnable<SpriteId> cir
    ) {

        if (block != ModCompat.EMERALD_SHULKER_BOX.get()) {
            return;
        }

        cir.setReturnValue(
                sophisticated_emerald_upgrade$getEmeraldMaterial()
        );
    }

    @Unique
    private SpriteId sophisticated_emerald_upgrade$getEmeraldMaterial() {

        return new SpriteId(

                Sheets.SHULKER_SHEET,

                Identifier.fromNamespaceAndPath(
                        "sophisticated_emerald_upgrade",
                        "entity/shulker_box/emerald_tier"
                )
        );
    }
}