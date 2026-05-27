package com.reggarf.mods.sophisticated_emerald_upgrade.registry;

import com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.p3pp3rf1y.sophisticatedbackpacks.Config;
import net.p3pp3rf1y.sophisticatedcore.upgrades.stack.StackUpgradeItem;

import java.util.List;
import java.util.function.Consumer;

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

    public static final DeferredHolder<Item, SmithingTemplateItem>
            EMERALD_UPGRADE_TEMPLATE =

            ITEMS.registerItem(
                    "emerald_upgrade_template",

                    properties ->

                            new SmithingTemplateItem(

                                    Component.translatable(
                                            "item.sophisticated_emerald_upgrade.emerald_upgrade_template.applies_to"
                                    ),

                                    Component.translatable(
                                            "item.sophisticated_emerald_upgrade.emerald_upgrade_template.ingredients"
                                    ),

                                    Component.translatable(
                                            "item.sophisticated_emerald_upgrade.emerald_upgrade_template.base_slot_description"
                                    ),

                                    Component.translatable(
                                            "item.sophisticated_emerald_upgrade.emerald_upgrade_template.additions_slot_description"
                                    ),

                                    List.of(

                                            Identifier.withDefaultNamespace(
                                                    "container/slot/chestplate"
                                            ),

                                            Identifier.withDefaultNamespace(
                                                    "container/slot/pickaxe"
                                            ),

                                            Identifier.withDefaultNamespace(
                                                    "container/slot/chest"
                                            )
                                    ),

                                    List.of(

                                            Identifier.withDefaultNamespace(
                                                    "container/slot/emerald"
                                            )
                                    ),

                                    properties
                            ) {

                                @Override
                                public void appendHoverText(
                                        ItemStack stack,
                                        Item.TooltipContext context,
                                        TooltipDisplay tooltipDisplay,
                                        Consumer<Component> tooltip,
                                        TooltipFlag flag
                                ) {

                                    super.appendHoverText(
                                            stack,
                                            context,
                                            tooltipDisplay,
                                            tooltip,
                                            flag
                                    );

                                    tooltip.accept(
                                            Component.empty()
                                    );

                                    tooltip.accept(

                                            Component.translatable(
                                                    "tooltip.sophisticated_emerald_upgrade.emerald_upgrade_template.loot"
                                            ).withStyle(
                                                    ChatFormatting.GOLD
                                            )
                                    );
                                }
                            }
            );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}