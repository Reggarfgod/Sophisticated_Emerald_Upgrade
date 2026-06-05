package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BackpackBlockEntityTypeMixin {

    private static final ResourceLocation EMERALD_BACKPACK_ID =
            ResourceLocation.fromNamespaceAndPath(
                    "sophisticated_emerald_upgrade",
                    "emerald_backpack"
            );

    @Inject(
            method = "isValid",
            at = @At("HEAD"),
            cancellable = true
    )
    private void allowEmeraldBackpack(
            BlockState state,
            CallbackInfoReturnable<Boolean> cir
    ) {
        ResourceLocation id =
                BuiltInRegistries.BLOCK.getKey(state.getBlock());

        if (EMERALD_BACKPACK_ID.equals(id)) {
            cir.setReturnValue(true);
        }
    }
}