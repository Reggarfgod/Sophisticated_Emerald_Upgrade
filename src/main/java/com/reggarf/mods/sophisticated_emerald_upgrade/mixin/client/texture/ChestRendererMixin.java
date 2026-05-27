package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.client.texture;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
        targets =
                "net.p3pp3rf1y.sophisticatedstorage.client.render.ChestRenderer$ChestSubRenderer"
)
public class ChestRendererMixin {

    @Shadow
    @Final
    private ChestType chestType;

    @Inject(
            method = "getTierMaterial",
            at = @At("HEAD"),
            cancellable = true
    )
    private void sophisticated_emerald_upgrade$getTierMaterial(
            Block block,
            CallbackInfoReturnable<Material> cir
    ) {

        if (block != ModCompat.EMERALD_CHEST.get()) {
            return;
        }

        cir.setReturnValue(
                sophisticated_emerald_upgrade$getEmeraldMaterial()
        );
    }

    @Unique
    private Material sophisticated_emerald_upgrade$getEmeraldMaterial() {

        String texture;

        if (chestType == ChestType.LEFT) {

            texture =
                    "entity/chest/left_emerald_tier";

        } else if (chestType == ChestType.RIGHT) {

            texture =
                    "entity/chest/right_emerald_tier";

        } else {

            texture =
                    "entity/chest/emerald_tier";
        }

        return new Material(
                Sheets.CHEST_SHEET,

                Identifier.fromNamespaceAndPath(
                        "sophisticated_emerald_upgrade",
                        texture
                )
        );
    }
}