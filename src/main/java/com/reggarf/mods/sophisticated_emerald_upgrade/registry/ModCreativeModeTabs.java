package com.reggarf.mods.sophisticated_emerald_upgrade.registry;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade.CREATIVE_MODE_TABS;

public class ModCreativeModeTabs {

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB =
            CREATIVE_MODE_TABS.register("tab",
                    () -> CreativeModeTab.builder()

                            .title(Component.translatable(
                                    "creativetab.reggarf.sophisticated_emerald_upgrade"))

                            .withTabsBefore(CreativeModeTabs.COMBAT)

                            .icon(() ->
                                    ModCompat.EMERALD_BACKPACK.get()
                                            .getDefaultInstance())

                            .displayItems((parameters, output) -> {

                                output.accept(ModCompat.EMERALD_BACKPACK.get());
                                output.accept(ModCompat.EMERALD_BARREL_ITEM.get());
                                output.accept(ModCompat.EMERALD_CHEST_ITEM.get());
                                output.accept(ModCompat.EMERALD_SHULKER_BOX_ITEM.get());
                                output.accept(ModCompat.EMERALD_LIMITED_BARREL_1_ITEM.get());
                                output.accept(ModCompat.EMERALD_LIMITED_BARREL_2_ITEM.get());
                                output.accept(ModCompat.EMERALD_LIMITED_BARREL_3_ITEM.get());
                                output.accept(ModCompat.EMERALD_LIMITED_BARREL_4_ITEM.get());
                                output.accept(ModItems.EMERALD_UPGRADE_TEMPLATE.get());
                                output.accept(ModItems.STACK_UPGRADE_TIER_SB_5.get());
                                output.accept(ModItems.STACK_UPGRADE_TIER_SS_6.get());
                                output.accept(ModItems.STACK_UPGRADE_TIER_SBS_7.get());


                            }).build());

    public static void register(IEventBus modEventBus) {

        CREATIVE_MODE_TABS.register(modEventBus);
    }
}