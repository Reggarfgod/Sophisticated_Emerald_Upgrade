package com.reggarf.mods.sophisticated_emerald_upgrade.registry;


import com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.p3pp3rf1y.sophisticatedbackpacks.Config;
import net.p3pp3rf1y.sophisticatedcore.upgrades.stack.StackUpgradeItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Sophisticated_emerald_upgrade.MODID);

    public static final DeferredHolder<Item, StackUpgradeItem> STACK_UPGRADE_TIER_SB_5 = ITEMS.register("stack_upgrade_tier_sb_5", () ->
            new StackUpgradeItem(48, Config.SERVER.maxUpgradesPerStorage));

    public static final DeferredHolder<Item, StackUpgradeItem> STACK_UPGRADE_TIER_SS_6 = ITEMS.register("stack_upgrade_tier_ss_6", () ->
            new StackUpgradeItem(48, net.p3pp3rf1y.sophisticatedstorage.Config.SERVER.maxUpgradesPerStorage));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}