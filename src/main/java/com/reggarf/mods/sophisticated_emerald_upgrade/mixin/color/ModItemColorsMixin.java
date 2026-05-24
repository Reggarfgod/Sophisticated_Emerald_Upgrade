package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.color;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackItem;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.wrapper.BackpackWrapper;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.wrapper.IBackpackWrapper;
import net.p3pp3rf1y.sophisticatedbackpacks.client.init.ModItemColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ModItemColors.class)
public class ModItemColorsMixin {

    /**
     * @author Reggarf
     * @reason Add Emerald Backpack item colors
     */
    @Overwrite
    public static void registerItemColorHandlers(
            RegisterColorHandlersEvent.Item event
    ) {

        event.register((backpack, layer) -> {

            if (layer > 1 ||
                    !(backpack.getItem() instanceof BackpackItem)) {
                return -1;
            }

            IBackpackWrapper backpackWrapper =
                    BackpackWrapper.fromStack(backpack);

            if (layer == 0) {
                return backpackWrapper.getMainColor();
            } else if (layer == 1) {
                return backpackWrapper.getAccentColor();
            }

            return -1;

        },

                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.COPPER_BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.IRON_BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.GOLD_BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.DIAMOND_BACKPACK.get(),
                ModCompat.EMERALD_BACKPACK.get(),
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.NETHERITE_BACKPACK.get()
        );
    }
}