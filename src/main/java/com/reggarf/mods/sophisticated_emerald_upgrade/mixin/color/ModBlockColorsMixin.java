package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.color;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackBlockEntity;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.wrapper.BackpackWrapper;
import net.p3pp3rf1y.sophisticatedbackpacks.client.init.ModBlockColors;
import net.p3pp3rf1y.sophisticatedcore.util.WorldHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ModBlockColors.class)
public class ModBlockColorsMixin {

    /**
     * @author Reggarf
     * @reason Add Emerald Backpack block colors
     */
    @Overwrite
    public static void registerBlockColorHandlers(
            RegisterColorHandlersEvent.Block event
    ) {

        event.register((state, blockDisplayReader, pos, tintIndex) -> {

            if (tintIndex < 0 || tintIndex > 1 || pos == null) {
                return -1;
            }

            return WorldHelper.getBlockEntity(
                            blockDisplayReader,
                            pos,
                            BackpackBlockEntity.class
                    )
                    .map(be ->
                            tintIndex == 0
                                    ? be.getBackpackWrapper().getMainColor()
                                    : be.getBackpackWrapper().getAccentColor()
                    )
                    .orElse(getDefaultColor(tintIndex));

        },

                net.p3pp3rf1y.sophisticatedbackpacks.init.ModBlocks.BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModBlocks.COPPER_BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModBlocks.IRON_BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModBlocks.GOLD_BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModBlocks.DIAMOND_BACKPACK.get(),
                ModCompat.EMERALD_BACKPACK_BLOCK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModBlocks.NETHERITE_BACKPACK.get()
        );
    }

    private static int getDefaultColor(int tintIndex) {
        return tintIndex == 0
                ? BackpackWrapper.DEFAULT_MAIN_COLOR
                : BackpackWrapper.DEFAULT_ACCENT_COLOR;
    }
}