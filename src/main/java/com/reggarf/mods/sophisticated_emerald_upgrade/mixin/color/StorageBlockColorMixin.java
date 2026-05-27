package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.color;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.p3pp3rf1y.sophisticatedcore.util.WorldHelper;
import net.p3pp3rf1y.sophisticatedstorage.block.StorageBlockEntity;
import net.p3pp3rf1y.sophisticatedstorage.client.init.ModBlockColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ModBlockColors.class)
public class StorageBlockColorMixin {

    @Inject(
            method = "registerBlockColorHandlers",
            at = @At("TAIL")
    )
    private static void sophisticated_emerald_upgrade$registerColors(
            RegisterColorHandlersEvent.BlockTintSources event,
            CallbackInfo ci
    ) {

        BlockTintSource mainColor = new BlockTintSource() {
            @Override
            public int color(BlockState state) {
                return -1;
            }

            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter getter, BlockPos pos) {
                return WorldHelper.getBlockEntity(getter, pos, StorageBlockEntity.class)
                        .map(be -> be.getStorageWrapper().getMainColor())
                        .orElse(-1);
            }
        };

        BlockTintSource accentColor = new BlockTintSource() {
            @Override
            public int color(BlockState state) {
                return -1;
            }

            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter getter, BlockPos pos) {
                return WorldHelper.getBlockEntity(getter, pos, StorageBlockEntity.class)
                        .map(be -> be.getStorageWrapper().getAccentColor())
                        .orElse(-1);
            }
        };

        event.register(
                List.of(mainColor, accentColor),

                ModCompat.EMERALD_BARREL.get(),

                ModCompat.EMERALD_LIMITED_BARREL_1.get(),
                ModCompat.EMERALD_LIMITED_BARREL_2.get(),
                ModCompat.EMERALD_LIMITED_BARREL_3.get(),
                ModCompat.EMERALD_LIMITED_BARREL_4.get()
        );

        event.register(
                List.of(mainColor),

                ModCompat.EMERALD_CHEST.get(),
                ModCompat.EMERALD_SHULKER_BOX.get()
        );
    }
}