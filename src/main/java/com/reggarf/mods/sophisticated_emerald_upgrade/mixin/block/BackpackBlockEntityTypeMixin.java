package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.block;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class BackpackBlockEntityTypeMixin {

    @Inject(
            method = "isValid",
            at = @At("HEAD"),
            cancellable = true
    )
    private void allowEmeraldBackpack(
            BlockState state,
            CallbackInfoReturnable<Boolean> cir
    ) {

        if (state.getBlock() ==
                ModCompat.EMERALD_BACKPACK_BLOCK.get()) {

            cir.setReturnValue(true);
        }
    }
}