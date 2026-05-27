package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.color;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.p3pp3rf1y.sophisticatedcore.util.WorldHelper;
import net.p3pp3rf1y.sophisticatedstorage.block.StorageBlockEntity;
import net.p3pp3rf1y.sophisticatedstorage.client.init.ModBlockColors;
import net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ModBlockColors.class)
public class StorageBlockColorsMixin {

    /**
     * @author Reggarf
     * @reason Add Emerald Storage blocks
     */
    @Overwrite
    public static void registerBlockColorHandlers(
            RegisterColorHandlersEvent.Block event
    ) {

        event.register(
                StorageBlockColorsMixin::getBarrelTintColor,

                ModBlocks.BARREL.get(),
                ModBlocks.COPPER_BARREL.get(),
                ModBlocks.IRON_BARREL.get(),
                ModBlocks.GOLD_BARREL.get(),
                ModBlocks.DIAMOND_BARREL.get(),
                ModBlocks.NETHERITE_BARREL.get(),

                ModCompat.EMERALD_BARREL.get(),

                ModBlocks.LIMITED_BARREL_1.get(),
                ModBlocks.LIMITED_COPPER_BARREL_1.get(),
                ModBlocks.LIMITED_IRON_BARREL_1.get(),
                ModBlocks.LIMITED_GOLD_BARREL_1.get(),
                ModBlocks.LIMITED_DIAMOND_BARREL_1.get(),
                ModBlocks.LIMITED_NETHERITE_BARREL_1.get(),

                ModCompat.EMERALD_LIMITED_BARREL_1.get(),
                ModCompat.EMERALD_LIMITED_BARREL_2.get(),
                ModCompat.EMERALD_LIMITED_BARREL_3.get(),
                ModCompat.EMERALD_LIMITED_BARREL_4.get(),

                ModBlocks.LIMITED_BARREL_2.get(),
                ModBlocks.LIMITED_COPPER_BARREL_2.get(),
                ModBlocks.LIMITED_IRON_BARREL_2.get(),
                ModBlocks.LIMITED_GOLD_BARREL_2.get(),
                ModBlocks.LIMITED_DIAMOND_BARREL_2.get(),
                ModBlocks.LIMITED_NETHERITE_BARREL_2.get(),

                ModBlocks.LIMITED_BARREL_3.get(),
                ModBlocks.LIMITED_COPPER_BARREL_3.get(),
                ModBlocks.LIMITED_IRON_BARREL_3.get(),
                ModBlocks.LIMITED_GOLD_BARREL_3.get(),
                ModBlocks.LIMITED_DIAMOND_BARREL_3.get(),
                ModBlocks.LIMITED_NETHERITE_BARREL_3.get(),

                ModBlocks.LIMITED_BARREL_4.get(),
                ModBlocks.LIMITED_COPPER_BARREL_4.get(),
                ModBlocks.LIMITED_IRON_BARREL_4.get(),
                ModBlocks.LIMITED_GOLD_BARREL_4.get(),
                ModBlocks.LIMITED_DIAMOND_BARREL_4.get(),
                ModBlocks.LIMITED_NETHERITE_BARREL_4.get()
        );

        event.register(
                StorageBlockColorsMixin::getChestShulkerBoxColor,

                ModBlocks.CHEST.get(),
                ModBlocks.COPPER_CHEST.get(),
                ModBlocks.IRON_CHEST.get(),
                ModBlocks.GOLD_CHEST.get(),
                ModBlocks.DIAMOND_CHEST.get(),
                ModBlocks.NETHERITE_CHEST.get(),

                ModCompat.EMERALD_CHEST.get(),

                ModBlocks.SHULKER_BOX.get(),
                ModBlocks.COPPER_SHULKER_BOX.get(),
                ModBlocks.IRON_SHULKER_BOX.get(),
                ModBlocks.GOLD_SHULKER_BOX.get(),
                ModBlocks.DIAMOND_SHULKER_BOX.get(),
                ModBlocks.NETHERITE_SHULKER_BOX.get(),

                ModCompat.EMERALD_SHULKER_BOX.get()
        );
    }

    private static int getBarrelTintColor(
            BlockState state,
            @Nullable BlockAndTintGetter blockDisplayReader,
            @Nullable BlockPos pos,
            int tintIndex
    ) {

        if (tintIndex < 0 || pos == null) {
            return -1;
        }

        return WorldHelper.getBlockEntity(
                        blockDisplayReader,
                        pos,
                        StorageBlockEntity.class
                )

                .map(be -> {

                    if (tintIndex == 0) {
                        return be.getStorageWrapper().getMainColor();

                    } else if (tintIndex == 1) {
                        return be.getStorageWrapper().getAccentColor();
                    }

                    return -1;
                })

                .orElse(-1);
    }


    private static int getChestShulkerBoxColor(
            BlockState state,
            @Nullable BlockAndTintGetter blockDisplayReader,
            @Nullable BlockPos pos,
            int tintIndex
    ) {

        if (tintIndex < 0 || pos == null) {
            return -1;
        }

        return WorldHelper.getBlockEntity(
                        blockDisplayReader,
                        pos,
                        StorageBlockEntity.class
                )

                .map(be -> {

                    if (tintIndex == 0) {
                        return be.getStorageWrapper()
                                .getMainColor();
                    }

                    return -1;
                })

                .orElse(-1);
    }
}