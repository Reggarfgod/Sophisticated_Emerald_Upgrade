package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.block;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
public class StorageBlockEntityTypeMixin {

    @Inject(
            method = "isValid",
            at = @At("HEAD"),
            cancellable = true
    )
    private void allowEmeraldStorage(
            BlockState state,
            CallbackInfoReturnable<Boolean> cir
    ) {

        if (

                state.getBlock() ==
                        ModCompat.EMERALD_BARREL.get()

                        ||

                        state.getBlock() ==
                                ModCompat.EMERALD_LIMITED_BARREL_1.get()

                        ||

                        state.getBlock() ==
                                ModCompat.EMERALD_LIMITED_BARREL_2.get()

                        ||

                        state.getBlock() ==
                                ModCompat.EMERALD_LIMITED_BARREL_3.get()

                        ||

                        state.getBlock() ==
                                ModCompat.EMERALD_LIMITED_BARREL_4.get()

                        ||

                        state.getBlock() ==
                                ModCompat.EMERALD_CHEST.get()

                        ||

                        state.getBlock() ==
                                ModCompat.EMERALD_SHULKER_BOX.get()

        ) {

            cir.setReturnValue(true);
        }
    }
}