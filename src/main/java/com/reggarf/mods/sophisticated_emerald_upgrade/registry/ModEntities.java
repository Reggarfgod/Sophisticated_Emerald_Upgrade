//package com.reggarf.mods.sophisticated_emerald_upgrade.registry;
//
//
//
//import com.reggarf.mods.sophisticated_emerald_upgrade.Sophisticated_emerald_upgrade;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.neoforged.bus.api.IEventBus;
//import net.neoforged.neoforge.capabilities.Capabilities;
//import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
//import net.neoforged.neoforge.registries.DeferredRegister;
//import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackBlockEntity;
//
//
//import java.util.function.Supplier;
//
//import static com.reggarf.mods.sophisticated_emerald_upgrade.registry.ModBlocks.EMERALD_BACKPACK;
//
//public class ModEntities {
//    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Sophisticated_emerald_upgrade.MODID);
//
//    @SuppressWarnings("ConstantConditions")
//    public static final Supplier<BlockEntityType<BackpackBlockEntity>> BACKPACK_TILE_TYPE = BLOCK_ENTITY_TYPES.register("backpack", () ->
//            BlockEntityType.Builder.of(BackpackBlockEntity::new, EMERALD_BACKPACK.get())
//                    .build(null));
//
//    private static void registerCapabilities(RegisterCapabilitiesEvent event) {
//        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BACKPACK_TILE_TYPE.get(), BackpackBlockEntity::getExternalItemHandler);
//        event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, BACKPACK_TILE_TYPE.get(), BackpackBlockEntity::getExternalFluidHandler);
//        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, BACKPACK_TILE_TYPE.get(), BackpackBlockEntity::getExternalEnergyStorage);
//    }
//    public static void register(IEventBus eventBus) {
//        BLOCK_ENTITY_TYPES.register(eventBus);
//        eventBus.addListener(ModEntities::registerCapabilities);
//    }
//
//}
