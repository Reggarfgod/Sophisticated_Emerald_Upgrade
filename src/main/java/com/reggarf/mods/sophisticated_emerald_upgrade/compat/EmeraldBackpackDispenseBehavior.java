package com.reggarf.mods.sophisticated_emerald_upgrade.compat;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.DirectionalPlaceContext;
import net.minecraft.world.level.block.DispenserBlock;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackItem;

public class EmeraldBackpackDispenseBehavior extends OptionalDispenseItemBehavior {

    @Override
    protected ItemStack execute(BlockSource source, ItemStack stack) {

        setSuccess(false);

        if (stack.getItem() instanceof BackpackItem backpackItem) {

            Direction dispenserDirection =
                    source.state().getValue(DispenserBlock.FACING);

            BlockPos blockpos =
                    source.pos().relative(dispenserDirection);

            Direction against =
                    source.level().isEmptyBlock(blockpos.below())
                            ? dispenserDirection.getOpposite()
                            : Direction.UP;

            setSuccess(
                    backpackItem.tryPlace(
                            null,
                            dispenserDirection.getAxis() == Direction.Axis.Y
                                    ? Direction.NORTH
                                    : dispenserDirection.getOpposite(),

                            new DirectionalPlaceContext(
                                    source.level(),
                                    blockpos,
                                    dispenserDirection,
                                    stack,
                                    against
                            )
                    ).consumesAction()
            );
        }

        return stack;
    }
}