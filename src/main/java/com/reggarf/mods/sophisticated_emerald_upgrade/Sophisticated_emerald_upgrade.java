package com.reggarf.mods.sophisticated_emerald_upgrade;

import com.mojang.logging.LogUtils;
import com.reggarf.mods.sophisticated_emerald_upgrade.config.ModConfigs;
import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import com.reggarf.mods.sophisticated_emerald_upgrade.datagen.DataGenerators;
import com.reggarf.mods.sophisticated_emerald_upgrade.registry.ModCreativeModeTabs;
import com.reggarf.mods.sophisticated_emerald_upgrade.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.transfer.EmptyResourceHandler;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackBlockEntity;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.wrapper.BackpackWrapper;
import net.p3pp3rf1y.sophisticatedstorage.block.StorageBlockEntity;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Sophisticated_emerald_upgrade.MODID)
public class Sophisticated_emerald_upgrade {

    public static final String MODID = "sophisticated_emerald_upgrade";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public Sophisticated_emerald_upgrade(IEventBus modEventBus, Dist dist, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        modEventBus.addListener(this::addCreative);

        ModCompat.BLOCKS.register(modEventBus);
        ModCompat.ITEMS.register(modEventBus);

        modEventBus.addListener(this::onBlockEntityTypeAddBlocks);
        modEventBus.addListener(this::registerCapabilities);

        modContainer.registerConfig(ModConfig.Type.SERVER, ModConfigs.SPEC,
                "sophisticated_emerald_upgrade-server.toml"
        );
        if (
                dist == Dist.CLIENT
                        &&
                        !ModList.get().isLoaded("configured")
        ) {

            modContainer.registerExtensionPoint(

                    IConfigScreenFactory.class,

                    ConfigurationScreen::new
            );

        } // DATAGEN
        if (dist == Dist.CLIENT) {

            modEventBus.addListener(
                    DataGenerators::gatherData
            );
        }

    }

    private void onBlockEntityTypeAddBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(
                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.BARREL_BLOCK_ENTITY_TYPE.get(),
                ModCompat.EMERALD_BARREL.get()
        );
        event.modify(
                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_BARREL_BLOCK_ENTITY_TYPE.get(),
                ModCompat.EMERALD_LIMITED_BARREL_1.get(),
                ModCompat.EMERALD_LIMITED_BARREL_2.get(),
                ModCompat.EMERALD_LIMITED_BARREL_3.get(),
                ModCompat.EMERALD_LIMITED_BARREL_4.get()
        );
        event.modify(
                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.CHEST_BLOCK_ENTITY_TYPE.get(),
                ModCompat.EMERALD_CHEST.get()
        );
        event.modify(
                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.SHULKER_BOX_BLOCK_ENTITY_TYPE.get(),
                ModCompat.EMERALD_SHULKER_BOX.get()
        );
        event.modify(
                net.p3pp3rf1y.sophisticatedbackpacks.init.ModBlocks.BACKPACK_TILE_TYPE.get(),
                ModCompat.EMERALD_BACKPACK_BLOCK.get()
        );
    }

    private void registerCapabilities(RegisterCapabilitiesEvent event) {
        // Register emerald backpack item capabilities (since items are registered per ItemLike, not BlockEntityType)
        event.registerItem(
                Capabilities.Item.ITEM,
                (stack, context) -> {
                    var wrapper = BackpackWrapper.fromStack(stack);
                    if (wrapper.getContentsUuid().isEmpty()) {
                        return EmptyResourceHandler.instance();
                    }
                    return wrapper.getInventoryForInputOutput();
                },
                ModCompat.EMERALD_BACKPACK.get()
        );
        event.registerItem(
                Capabilities.Fluid.ITEM,
                (stack, context) -> {
                    if (!net.p3pp3rf1y.sophisticatedbackpacks.Config.SERVER.itemFluidHandlerEnabled.get()) {
                        return null;
                    }
                    var wrapper = BackpackWrapper.fromStack(stack);
                    return wrapper.getItemFluidHandler(context).orElse(null);
                },
                ModCompat.EMERALD_BACKPACK.get()
        );
        event.registerItem(
                Capabilities.Energy.ITEM,
                (stack, context) -> {
                    var wrapper = BackpackWrapper.fromStack(stack);
                    return wrapper.getEnergyHandler().orElse(null);
                },
                ModCompat.EMERALD_BACKPACK.get()
        );

        // Fallback block capability registrations in case parent mods haven't bound them
        if (!event.isBlockRegistered(Capabilities.Item.BLOCK, ModCompat.EMERALD_BARREL.get())) {
            event.registerBlock(
                    Capabilities.Item.BLOCK,
                    (level, pos, state, be, side) -> be instanceof StorageBlockEntity storageBe ? storageBe.getExternalItemHandler(side) : null,
                    ModCompat.EMERALD_BARREL.get()
            );
        }
        if (!event.isBlockRegistered(Capabilities.Item.BLOCK, ModCompat.EMERALD_LIMITED_BARREL_1.get())) {
            event.registerBlock(
                    Capabilities.Item.BLOCK,
                    (level, pos, state, be, side) -> be instanceof StorageBlockEntity storageBe ? storageBe.getExternalItemHandler(side) : null,
                    ModCompat.EMERALD_LIMITED_BARREL_1.get(),
                    ModCompat.EMERALD_LIMITED_BARREL_2.get(),
                    ModCompat.EMERALD_LIMITED_BARREL_3.get(),
                    ModCompat.EMERALD_LIMITED_BARREL_4.get()
            );
        }
        if (!event.isBlockRegistered(Capabilities.Item.BLOCK, ModCompat.EMERALD_CHEST.get())) {
            event.registerBlock(
                    Capabilities.Item.BLOCK,
                    (level, pos, state, be, side) -> be instanceof StorageBlockEntity storageBe ? storageBe.getExternalItemHandler(side) : null,
                    ModCompat.EMERALD_CHEST.get()
            );
        }
        if (!event.isBlockRegistered(Capabilities.Item.BLOCK, ModCompat.EMERALD_SHULKER_BOX.get())) {
            event.registerBlock(
                    Capabilities.Item.BLOCK,
                    (level, pos, state, be, side) -> be instanceof StorageBlockEntity storageBe ? storageBe.getExternalItemHandler(side) : null,
                    ModCompat.EMERALD_SHULKER_BOX.get()
            );
        }
        if (!event.isBlockRegistered(Capabilities.Item.BLOCK, ModCompat.EMERALD_BACKPACK_BLOCK.get())) {
            event.registerBlock(
                    Capabilities.Item.BLOCK,
                    (level, pos, state, be, side) -> be instanceof BackpackBlockEntity backpackBe ? backpackBe.getExternalItemHandler(side) : null,
                    ModCompat.EMERALD_BACKPACK_BLOCK.get()
            );
        }
        if (!event.isBlockRegistered(Capabilities.Fluid.BLOCK, ModCompat.EMERALD_BACKPACK_BLOCK.get())) {
            event.registerBlock(
                    Capabilities.Fluid.BLOCK,
                    (level, pos, state, be, side) -> be instanceof BackpackBlockEntity backpackBe ? backpackBe.getExternalFluidHandler(side) : null,
                    ModCompat.EMERALD_BACKPACK_BLOCK.get()
            );
        }
        if (!event.isBlockRegistered(Capabilities.Energy.BLOCK, ModCompat.EMERALD_BACKPACK_BLOCK.get())) {
            event.registerBlock(
                    Capabilities.Energy.BLOCK,
                    (level, pos, state, be, side) -> be instanceof BackpackBlockEntity backpackBe ? backpackBe.getExternalEnergyHandler(side) : null,
                    ModCompat.EMERALD_BACKPACK_BLOCK.get()
            );
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
