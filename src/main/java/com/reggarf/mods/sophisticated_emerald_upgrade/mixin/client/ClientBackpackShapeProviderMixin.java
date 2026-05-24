package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.client;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.world.level.block.Block;

import net.p3pp3rf1y.sophisticatedbackpacks.client.render.ClientBackpackShapeProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Mixin(ClientBackpackShapeProvider.class)
public class ClientBackpackShapeProviderMixin {

    @ModifyVariable(
            method = "rebuildShapes",
            at = @At("STORE")
    )
    private List<Supplier<? extends Block>> addEmeraldBackpack(
            List<Supplier<? extends Block>> original
    ) {

        List<Supplier<? extends Block>> list =
                new ArrayList<>(original);

        list.add(() -> ModCompat.EMERALD_BACKPACK_BLOCK.get());

        return list;
    }
}