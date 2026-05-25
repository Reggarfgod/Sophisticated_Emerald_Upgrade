package com.reggarf.mods.sophisticated_emerald_upgrade.registry;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.p3pp3rf1y.sophisticatedstorage.item.BarrelBlockItem;
import net.p3pp3rf1y.sophisticatedstorage.item.ChestBlockItem;

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
                                /*
                                 * TEMPLATE
                                 */
                                output.accept(ModItems.EMERALD_UPGRADE_TEMPLATE.get());

                                /*
                                 * UPGRADES
                                 */
                                output.accept(ModItems.STACK_UPGRADE_TIER_SB_5.get());
                                output.accept(ModItems.STACK_UPGRADE_TIER_SS_6.get());
                                output.accept(ModItems.STACK_UPGRADE_TIER_SBS_7.get());

                                /*
                                 * BACKPACK
                                 */
                                output.accept(ModCompat.EMERALD_BACKPACK.get());

                                /*
                                 * SHULKER
                                 */
                                output.accept(ModCompat.EMERALD_SHULKER_BOX_ITEM.get());

                                /*
                                 * BARREL ALL WOOD TYPES
                                 */
                                if (ModCompat.EMERALD_BARREL_ITEM.get() instanceof BarrelBlockItem barrelItem) {
                                    barrelItem.addCreativeTabItems(output::accept);
                                } else {
                                    output.accept(ModCompat.EMERALD_BARREL_ITEM.get());
                                }

                                /*
                                 * LIMITED BARREL 1
                                 */
                                if (ModCompat.EMERALD_LIMITED_BARREL_1_ITEM.get() instanceof BarrelBlockItem barrelItem) {
                                    barrelItem.addCreativeTabItems(output::accept);
                                } else {
                                    output.accept(ModCompat.EMERALD_LIMITED_BARREL_1_ITEM.get());
                                }

                                /*
                                 * LIMITED BARREL 2
                                 */
                                if (ModCompat.EMERALD_LIMITED_BARREL_2_ITEM.get() instanceof BarrelBlockItem barrelItem) {
                                    barrelItem.addCreativeTabItems(output::accept);
                                } else {
                                    output.accept(ModCompat.EMERALD_LIMITED_BARREL_2_ITEM.get());
                                }

                                /*
                                 * LIMITED BARREL 3
                                 */
                                if (ModCompat.EMERALD_LIMITED_BARREL_3_ITEM.get() instanceof BarrelBlockItem barrelItem) {
                                    barrelItem.addCreativeTabItems(output::accept);
                                } else {
                                    output.accept(ModCompat.EMERALD_LIMITED_BARREL_3_ITEM.get());
                                }

                                /*
                                 * LIMITED BARREL 4
                                 */
                                if (ModCompat.EMERALD_LIMITED_BARREL_4_ITEM.get() instanceof BarrelBlockItem barrelItem) {
                                    barrelItem.addCreativeTabItems(output::accept);
                                } else {
                                    output.accept(ModCompat.EMERALD_LIMITED_BARREL_4_ITEM.get());
                                }

                                /*
                                 * CHEST ALL WOOD TYPES
                                 */
                                if (ModCompat.EMERALD_CHEST_ITEM.get() instanceof ChestBlockItem chestItem) {
                                    chestItem.addCreativeTabItems(output::accept);
                                } else {
                                    output.accept(ModCompat.EMERALD_CHEST_ITEM.get());
                                }



                            }).build());

    public static void register(IEventBus modEventBus) {

        CREATIVE_MODE_TABS.register(modEventBus);
    }
}