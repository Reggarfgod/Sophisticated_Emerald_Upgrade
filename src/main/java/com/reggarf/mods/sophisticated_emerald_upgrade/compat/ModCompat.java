package com.reggarf.mods.sophisticated_emerald_upgrade.compat;

import com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.p3pp3rf1y.sophisticatedbackpacks.SophisticatedBackpacks;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackBlock;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackItem;

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
                            () -> 108,
                            () -> 8,
                            EMERALD_BACKPACK_BLOCK
                    ));
}