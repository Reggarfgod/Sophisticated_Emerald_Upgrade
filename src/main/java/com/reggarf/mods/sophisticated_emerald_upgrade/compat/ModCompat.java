package com.reggarf.mods.sophisticated_emerald_upgrade.compat;

import com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.p3pp3rf1y.sophisticatedbackpacks.SophisticatedBackpacks;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackBlock;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackItem;
import net.p3pp3rf1y.sophisticatedstorage.Config;
import net.p3pp3rf1y.sophisticatedstorage.block.BarrelBlock;
import net.p3pp3rf1y.sophisticatedstorage.block.ChestBlock;
import net.p3pp3rf1y.sophisticatedstorage.block.LimitedBarrelBlock;
import net.p3pp3rf1y.sophisticatedstorage.block.ShulkerBoxBlock;
import net.p3pp3rf1y.sophisticatedstorage.item.BarrelBlockItem;
import net.p3pp3rf1y.sophisticatedstorage.item.ChestBlockItem;
import net.p3pp3rf1y.sophisticatedstorage.item.LimitedBarrelBlockItem;
import net.p3pp3rf1y.sophisticatedstorage.item.ShulkerBoxItem;

import java.util.function.Supplier;

public class ModCompat {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Sophisticated_emerald_upgrade.MODID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Sophisticated_emerald_upgrade.MODID);

    public static final DeferredHolder<Block, BackpackBlock> EMERALD_BACKPACK_BLOCK =
            BLOCKS.registerBlock(
                    "emerald_backpack",
                    BackpackBlock::new
            );

    public static final DeferredHolder<Item, BackpackItem> EMERALD_BACKPACK =
            ITEMS.registerItem("emerald_backpack",
                    properties ->
                            new BackpackItem(
                                    () -> 132,
                                    () -> 8,
                                    EMERALD_BACKPACK_BLOCK,
                                    properties
                            )
            );


    public static final Supplier<BarrelBlock> EMERALD_BARREL =
            BLOCKS.registerBlock(
                    "emerald_barrel",
                    properties -> new BarrelBlock(
                            Config.SERVER.netheriteBarrel,
                            1200,
                            properties
                    )
            );

    public static final Supplier<BlockItem> EMERALD_BARREL_ITEM =
            ITEMS.registerItem(
                    "emerald_barrel",
                    properties -> new BarrelBlockItem(
                            EMERALD_BARREL.get(),
                            properties.useBlockDescriptionPrefix().fireResistant()
                    )
            );

    public static final Supplier<BarrelBlock> EMERALD_LIMITED_BARREL_1 =
            BLOCKS.registerBlock(
                    "emerald_limited_barrel_1",
                    properties -> new LimitedBarrelBlock(
                            1,
                            Config.SERVER.netheriteLimitedBarrel1,
                            1200,
                            properties
                    )
            );

    public static final Supplier<BlockItem> EMERALD_LIMITED_BARREL_1_ITEM =
            ITEMS.registerItem(
                    "emerald_limited_barrel_1",
                    properties -> new LimitedBarrelBlockItem(
                            EMERALD_LIMITED_BARREL_1.get(),
                            properties.useBlockDescriptionPrefix().fireResistant()
                    )
            );

    public static final Supplier<BarrelBlock> EMERALD_LIMITED_BARREL_2 =
            BLOCKS.registerBlock(
                    "emerald_limited_barrel_2",
                    properties -> new LimitedBarrelBlock(
                            2,
                            Config.SERVER.netheriteLimitedBarrel2,
                            1200,
                            properties
                    )
            );

    public static final Supplier<BlockItem> EMERALD_LIMITED_BARREL_2_ITEM =
            ITEMS.registerItem(
                    "emerald_limited_barrel_2",
                    properties -> new LimitedBarrelBlockItem(
                            EMERALD_LIMITED_BARREL_2.get(),
                            properties.useBlockDescriptionPrefix().fireResistant()
                    )
            );

    public static final Supplier<BarrelBlock> EMERALD_LIMITED_BARREL_3 =
            BLOCKS.registerBlock(
                    "emerald_limited_barrel_3",
                    properties -> new LimitedBarrelBlock(
                            3,
                            Config.SERVER.netheriteLimitedBarrel3,
                            1200,
                            properties
                    )
            );

    public static final Supplier<BlockItem> EMERALD_LIMITED_BARREL_3_ITEM =
            ITEMS.registerItem(
                    "emerald_limited_barrel_3",
                    properties -> new LimitedBarrelBlockItem(
                            EMERALD_LIMITED_BARREL_3.get(),
                            properties.useBlockDescriptionPrefix().fireResistant()
                    )
            );

    public static final Supplier<BarrelBlock> EMERALD_LIMITED_BARREL_4 =
            BLOCKS.registerBlock(
                    "emerald_limited_barrel_4",
                    properties -> new LimitedBarrelBlock(
                            4,
                            Config.SERVER.netheriteLimitedBarrel4,
                            1200,
                            properties
                    )
            );

    public static final Supplier<BlockItem> EMERALD_LIMITED_BARREL_4_ITEM =
            ITEMS.registerItem(
                    "emerald_limited_barrel_4",
                    properties -> new LimitedBarrelBlockItem(
                            EMERALD_LIMITED_BARREL_4.get(),
                            properties.useBlockDescriptionPrefix().fireResistant()
                    )
            );

    public static final Supplier<ChestBlock> EMERALD_CHEST =
            BLOCKS.registerBlock(
                    "emerald_chest",
                    properties -> new ChestBlock(
                            Config.SERVER.netheriteChest,
                            1200,
                            properties
                    )
            );

    public static final Supplier<BlockItem> EMERALD_CHEST_ITEM =
            ITEMS.registerItem(
                    "emerald_chest",
                    properties -> new ChestBlockItem(
                            EMERALD_CHEST.get(),
                            properties.useBlockDescriptionPrefix().fireResistant()
                    )
            );

    public static final Supplier<ShulkerBoxBlock> EMERALD_SHULKER_BOX =
            BLOCKS.registerBlock(
                    "emerald_shulker_box",
                    properties -> new ShulkerBoxBlock(
                            Config.SERVER.netheriteShulkerBox,
                            1200,
                            properties
                    )
            );

    public static final Supplier<BlockItem> EMERALD_SHULKER_BOX_ITEM =
            ITEMS.registerItem(
                    "emerald_shulker_box",
                    properties -> new ShulkerBoxItem(
                            EMERALD_SHULKER_BOX.get(),
                            properties.useBlockDescriptionPrefix().fireResistant()
                    )
            );
}