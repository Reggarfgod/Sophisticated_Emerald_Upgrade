package com.reggarf.mods.sophisticated_emerald_upgrade.registry;

import com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.p3pp3rf1y.sophisticatedbackpacks.Config;
import net.p3pp3rf1y.sophisticatedcore.upgrades.stack.StackUpgradeItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(
                    Sophisticated_emerald_upgrade.MODID
            );

    public static final DeferredHolder<Item, StackUpgradeItem>
            STACK_UPGRADE_TIER_SB_5 =
            ITEMS.registerItem(
                    "stack_upgrade_tier_sb_5",

                    properties ->
                            new StackUpgradeItem(
                                    48,
                                    Config.SERVER.maxUpgradesPerStorage,
                                    properties
                            )
            );

    public static final DeferredHolder<Item, StackUpgradeItem>
            STACK_UPGRADE_TIER_SS_6 =
            ITEMS.registerItem(
                    "stack_upgrade_tier_ss_6",

                    properties ->
                            new StackUpgradeItem(
                                    48,
                                    net.p3pp3rf1y.sophisticatedstorage.Config.SERVER.maxUpgradesPerStorage,
                                    properties
                            )
            );

    public static final DeferredHolder<Item, StackUpgradeItem>
            STACK_UPGRADE_TIER_SBS_7 =
            ITEMS.registerItem(
                    "stack_upgrade_tier_sbs_7",

                    properties ->
                            new StackUpgradeItem(
                                    128,
                                    net.p3pp3rf1y.sophisticatedstorage.Config.SERVER.maxUpgradesPerStorage,
                                    properties
                            )
            );

    public static final DeferredHolder<Item, Item> EMERALD_UPGRADE_TEMPLATE = ITEMS.registerItem("emerald_upgrade_template", Item::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}