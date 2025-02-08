package com.reggarf.mods.sophisticated_emerald_upgrade.datagen;


import com.reggarf.mods.sophisticated_emerald_upgrade.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModItems.STACK_UPGRADE_TIER_SB_5.get())
                .pattern("CCC")
                .pattern("CSC")
                .pattern("BCB")
                .define('S', net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.STACK_UPGRADE_TIER_4.get())
                .define('C', Tags.Items.GEMS_EMERALD)
                .define('B', Tags.Items.STORAGE_BLOCKS_EMERALD)
                .unlockedBy("has_stack_upgrade_tier_4", has(net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.STACK_UPGRADE_TIER_4.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModItems.STACK_UPGRADE_TIER_SS_6.get())
                .pattern("CCC")
                .pattern("CSC")
                .pattern("BCB")
                .define('S', net.p3pp3rf1y.sophisticatedstorage.init.ModItems.STACK_UPGRADE_TIER_5.get())
                .define('C', Tags.Items.GEMS_EMERALD)
                .define('B', Tags.Items.STORAGE_BLOCKS_EMERALD)
                .unlockedBy("has_stack_upgrade_tier_4", has(net.p3pp3rf1y.sophisticatedstorage.init.ModItems.STACK_UPGRADE_TIER_5.get())).save(recipeOutput);


    }

}
