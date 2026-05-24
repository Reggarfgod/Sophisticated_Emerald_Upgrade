package com.reggarf.mods.sophisticated_emerald_upgrade.mixin.curios;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import net.minecraft.world.entity.player.Player;
import net.p3pp3rf1y.sophisticatedbackpacks.compat.curios.CuriosCompat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.Set;

@Mixin(CuriosCompat.class)
public class CuriosCompatMixin {

    @Shadow
    @Final
    private Set<String> backpackCurioIdentifiers;

    @Inject(
            method = "getCurioTags",
            at = @At("TAIL")
    )
    private void addEmeraldBackpackTags(
            Player player,
            CallbackInfoReturnable<Set<String>> cir
    ) {

        backpackCurioIdentifiers.addAll(
                CuriosApi.getItemStackSlots(
                        ModCompat.EMERALD_BACKPACK.get().getDefaultInstance(),
                        true
                ).keySet()
        );
    }
}