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
import net.p3pp3rf1y.sophisticatedstorage.block.BarrelBlock;
import net.p3pp3rf1y.sophisticatedstorage.block.ChestBlock;
import net.p3pp3rf1y.sophisticatedstorage.block.LimitedBarrelBlock;
import net.p3pp3rf1y.sophisticatedstorage.block.ShulkerBoxBlock;
import net.p3pp3rf1y.sophisticatedstorage.item.BarrelBlockItem;
import net.p3pp3rf1y.sophisticatedstorage.item.ChestBlockItem;
import net.p3pp3rf1y.sophisticatedstorage.item.ShulkerBoxItem;

public class ModCompat {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.createBlocks(Sophisticated_emerald_upgrade.MODID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.createItems(Sophisticated_emerald_upgrade.MODID);

    public static final DeferredHolder<Block, BackpackBlock> EMERALD_BACKPACK_BLOCK =
            BLOCKS.register("emerald_backpack",
                    () -> new BackpackBlock());

    public static final DeferredHolder<Item, BackpackItem> EMERALD_BACKPACK =
            ITEMS.register("emerald_backpack",
                    () -> new BackpackItem(
                            () -> 132,
                            () -> 9,
                            EMERALD_BACKPACK_BLOCK
                    ));

    public static final DeferredHolder<Block, BarrelBlock>
            EMERALD_BARREL = BLOCKS.register(
                    "emerald_barrel",
                    () -> new BarrelBlock(
                            () -> 162,
                            () -> 8,
                            0
                    )
            );

    public static final DeferredHolder<Item, BlockItem>
            EMERALD_BARREL_ITEM = ITEMS.register(
                    "emerald_barrel",
                    () -> new BarrelBlockItem(
                            EMERALD_BARREL.get(),
                            new Item.Properties()
                    )
            );


    public static final DeferredHolder<Block, LimitedBarrelBlock>
            EMERALD_LIMITED_BARREL_1 = BLOCKS.register(
                    "emerald_limited_barrel_1",
                    () -> new LimitedBarrelBlock(
                            1,
                            () -> 128,
                            () -> 8,
                            0
                    )
            );

    public static final DeferredHolder<Item, BlockItem>
            EMERALD_LIMITED_BARREL_1_ITEM = ITEMS.register(
                    "emerald_limited_barrel_1",
                    () -> new BarrelBlockItem(
                            EMERALD_LIMITED_BARREL_1.get(),
                            new Item.Properties()
                    )
            );

    public static final DeferredHolder<Block, LimitedBarrelBlock>
            EMERALD_LIMITED_BARREL_2 = BLOCKS.register(
            "emerald_limited_barrel_2",
            () -> new LimitedBarrelBlock(
                    2,
                    () -> 128,
                    () -> 8,
                    0
            )
    );

    public static final DeferredHolder<Item, BlockItem>
            EMERALD_LIMITED_BARREL_2_ITEM = ITEMS.register(
            "emerald_limited_barrel_2",
            () -> new BarrelBlockItem(
                    EMERALD_LIMITED_BARREL_2.get(),
                    new Item.Properties()
            )
    );


    public static final DeferredHolder<Block, LimitedBarrelBlock>
            EMERALD_LIMITED_BARREL_3 = BLOCKS.register(
            "emerald_limited_barrel_3",
            () -> new LimitedBarrelBlock(
                    3,
                    () -> 128,
                    () -> 8,
                    0
            )
    );

    public static final DeferredHolder<Item, BlockItem>
            EMERALD_LIMITED_BARREL_3_ITEM = ITEMS.register(
            "emerald_limited_barrel_3",
            () -> new BarrelBlockItem(
                    EMERALD_LIMITED_BARREL_3.get(),
                    new Item.Properties()
            )
    );


    public static final DeferredHolder<Block, LimitedBarrelBlock>
            EMERALD_LIMITED_BARREL_4 = BLOCKS.register(
            "emerald_limited_barrel_4",
            () -> new LimitedBarrelBlock(
                    4,
                    () -> 128,
                    () -> 8,
                    0
            )
    );

    public static final DeferredHolder<Item, BlockItem>
            EMERALD_LIMITED_BARREL_4_ITEM = ITEMS.register(
            "emerald_limited_barrel_4",
            () -> new BarrelBlockItem(
                    EMERALD_LIMITED_BARREL_4.get(),
                    new Item.Properties()
            )
    );

    public static final DeferredHolder<Block, ChestBlock>
            EMERALD_CHEST = BLOCKS.register(
                    "emerald_chest",
                    () -> new ChestBlock(
                            () -> 162,
                            () -> 8
                    )
            );

    public static final DeferredHolder<Item, BlockItem>
            EMERALD_CHEST_ITEM = ITEMS.register(
                    "emerald_chest",
                    () -> new ChestBlockItem(
                            EMERALD_CHEST.get(),
                            new Item.Properties()
                    )
            );


    public static final DeferredHolder<Block, ShulkerBoxBlock>
            EMERALD_SHULKER_BOX = BLOCKS.register(
                    "emerald_shulker_box",
                    () -> new ShulkerBoxBlock(
                            () -> 162,
                            () -> 8
                    )
            );

    public static final DeferredHolder<Item, BlockItem>
            EMERALD_SHULKER_BOX_ITEM = ITEMS.register(
                    "emerald_shulker_box",
                    () -> new ShulkerBoxItem(
                            EMERALD_SHULKER_BOX.get(),
                            new Item.Properties()
                    )
            );
}