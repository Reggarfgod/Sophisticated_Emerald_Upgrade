package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.item;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.EmeraldBackpackCauldronInteraction;
import com.reggarf.mods.sophisticated_emerald_upgrade.compat.EmeraldBackpackDispenseBehavior;
import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.level.block.DispenserBlock;
import net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModItems.class)
public class ModItemsMixin {

    @Inject(method = "registerDispenseBehavior", at = @At("TAIL"))
    private static void emeraldBackpackDispense(CallbackInfo ci) {

        DispenserBlock.registerBehavior(
                ModCompat.EMERALD_BACKPACK.get(),
                new EmeraldBackpackDispenseBehavior()
        );
    }

    @Inject(method = "registerCauldronInteractions", at = @At("TAIL"))
    private static void emeraldBackpackCauldron(CallbackInfo ci) {

        CauldronInteraction.WATER.map().put(
                ModCompat.EMERALD_BACKPACK.get(),
                new EmeraldBackpackCauldronInteraction()
        );
    }
}