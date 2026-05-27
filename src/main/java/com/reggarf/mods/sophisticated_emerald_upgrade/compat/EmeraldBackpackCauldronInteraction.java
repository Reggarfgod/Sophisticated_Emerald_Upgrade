package com.reggarf.mods.sophisticated_emerald_upgrade.compat;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.InteractionHand;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.wrapper.BackpackWrapper;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.wrapper.IBackpackWrapper;
import net.p3pp3rf1y.sophisticatedcore.api.IStorageWrapper;

public class EmeraldBackpackCauldronInteraction implements CauldronInteraction {

    private static boolean hasDefaultColor(IStorageWrapper wrapper) {

        return wrapper.getAccentColor() == BackpackWrapper.DEFAULT_ACCENT_COLOR
                && wrapper.getMainColor() == BackpackWrapper.DEFAULT_MAIN_COLOR;
    }

    @Override
    public InteractionResult interact(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            ItemStack stack
    ) {

        IBackpackWrapper backpackWrapper =
                BackpackWrapper.fromStack(stack);

        if (hasDefaultColor(backpackWrapper)) {
            return InteractionResult.FAIL;
        }

        if (!level.isClientSide()) {

            backpackWrapper.setColors(
                    BackpackWrapper.DEFAULT_MAIN_COLOR,
                    BackpackWrapper.DEFAULT_ACCENT_COLOR
            );

            LayeredCauldronBlock.lowerFillLevel(state, level, pos);
        }

        return level.isClientSide()
                ? InteractionResult.SUCCESS
                : InteractionResult.SUCCESS_SERVER;
    }
}