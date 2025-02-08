//package com.reggarf.mods.sophisticated_emerald_upgrade.registry;
//
//
//
//
//import net.minecraft.world.item.BlockItem;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.block.Block;
//import net.neoforged.bus.api.IEventBus;
//import net.neoforged.neoforge.registries.DeferredBlock;
//import net.neoforged.neoforge.registries.DeferredRegister;
//import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackBlock;
//
//
//import java.util.function.Supplier;
//
//import static com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade.MODID;
//
//
//public class ModBlocks {
//    public static final DeferredRegister.Blocks BLOCKS =
//            DeferredRegister.createBlocks(MODID);
//
//    public static final Supplier<BackpackBlock> EMERALD_BACKPACK = BLOCKS.register("emerald_backpack", () -> new BackpackBlock(1200));
//
//
//    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
//        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn);
//        return toReturn;
//    }
//
//    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
//        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
//    }
//    public static void register(IEventBus eventBus) {
//
//        BLOCKS.register(eventBus);
//    }
//}
