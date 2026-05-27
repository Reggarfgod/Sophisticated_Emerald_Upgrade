package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.color;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackBlockEntity;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.wrapper.BackpackWrapper;
import net.p3pp3rf1y.sophisticatedbackpacks.client.init.ModBlockColors;
import net.p3pp3rf1y.sophisticatedcore.util.WorldHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ModBlockColors.class)
public class ModBlockColorsMixin {

    @Unique
    private static final BlockTintSource EMERALD_MAIN =
            new BlockTintSource() {

                @Override
                public int color(BlockState state) {
                    return BackpackWrapper.DEFAULT_MAIN_COLOR;
                }

                @Override
                public int colorInWorld(
                        BlockState state,
                        BlockAndTintGetter level,
                        BlockPos pos
                ) {

                    return WorldHelper.getBlockEntity(
                                    level,
                                    pos,
                                    BackpackBlockEntity.class
                            )
                            .map(be ->
                                    be.getBackpackWrapper()
                                            .getMainColor()
                            )
                            .orElse(
                                    BackpackWrapper.DEFAULT_MAIN_COLOR
                            );
                }
            };

    @Unique
    private static final BlockTintSource EMERALD_ACCENT =
            new BlockTintSource() {

                @Override
                public int color(BlockState state) {
                    return BackpackWrapper.DEFAULT_ACCENT_COLOR;
                }

                @Override
                public int colorInWorld(
                        BlockState state,
                        BlockAndTintGetter level,
                        BlockPos pos
                ) {

                    return WorldHelper.getBlockEntity(
                                    level,
                                    pos,
                                    BackpackBlockEntity.class
                            )
                            .map(be ->
                                    be.getBackpackWrapper()
                                            .getAccentColor()
                            )
                            .orElse(
                                    BackpackWrapper.DEFAULT_ACCENT_COLOR
                            );
                }
            };

    @Inject(
            method = "registerBlockColorHandlers",
            at = @At("TAIL")
    )
    private static void injectEmeraldBackpack(
            RegisterColorHandlersEvent.BlockTintSources event,
            CallbackInfo ci
    ) {

        event.register(
                List.of(
                        EMERALD_MAIN,
                        EMERALD_ACCENT
                ),

                ModCompat.EMERALD_BACKPACK_BLOCK.get()
        );
    }
}