package com.reggarf.mods.sophisticated_emerald_upgrade.datagen;

import com.reggarf.mods.sophisticated_emerald_upgrade.compat.ModCompat;
import com.reggarf.mods.sophisticated_emerald_upgrade.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> registries
    ) {

        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        ModItems.EMERALD_UPGRADE_TEMPLATE.get(),
                        2
                )

                .pattern("DED")
                .pattern("DTD")
                .pattern("DDD")

                .define('E', Items.DIAMOND)
                .define('D', Items.EMERALD_BLOCK)
                .define('T', ModItems.EMERALD_UPGRADE_TEMPLATE.get())

                .unlockedBy(
                        "has_emerald_upgrade_template",
                        has(ModItems.EMERALD_UPGRADE_TEMPLATE.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_upgrade_template_duplication"
                );

        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.STACK_UPGRADE_TIER_4.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.MISC,

                        ModItems.STACK_UPGRADE_TIER_SB_5.get()
                )

                .unlocks(
                        "has_stack_upgrade_tier_4",
                        has(net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.STACK_UPGRADE_TIER_4.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:stack_upgrade_tier_sb_5"
                );

        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModItems.STACK_UPGRADE_TIER_5.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.MISC,

                        ModItems.STACK_UPGRADE_TIER_SS_6.get()
                )

                .unlocks(
                        "has_stack_upgrade_tier_5",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModItems.STACK_UPGRADE_TIER_5.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:stack_upgrade_tier_ss_6"
                );


        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                ModItems.STACK_UPGRADE_TIER_SB_5.get()
                        ),

                        Ingredient.of(
                                ModItems.STACK_UPGRADE_TIER_SS_6.get()
                        ),

                        RecipeCategory.MISC,

                        ModItems.STACK_UPGRADE_TIER_SBS_7.get()
                )

                .unlocks(
                        "has_stack_upgrade_tier_ss_6",
                        has(ModItems.STACK_UPGRADE_TIER_SS_6.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:stack_upgrade_tier_sbs_7"
                );

        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.NETHERITE_BACKPACK.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.MISC,

                        ModCompat.EMERALD_BACKPACK.get()
                )

                .unlocks(
                        "has_diamond_backpack",
                        has(net.p3pp3rf1y.sophisticatedbackpacks.init.ModItems.DIAMOND_BACKPACK.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_backpack"
                );

        /*
         * EMERALD BARREL
         */
        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.NETHERITE_BARREL_ITEM.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.DECORATIONS,

                        ModCompat.EMERALD_BARREL_ITEM.get()
                )

                .unlocks(
                        "has_netherite_barrel",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.NETHERITE_BARREL_ITEM.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_barrel"
                );

        /*
         * EMERALD LIMITED BARREL 1
         */
        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_1_ITEM.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.DECORATIONS,

                        ModCompat.EMERALD_LIMITED_BARREL_1_ITEM.get()
                )

                .unlocks(
                        "has_limited_netherite_barrel_1",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_1_ITEM.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_limited_barrel_1"
                );

        /*
         * EMERALD LIMITED BARREL 2
         */
        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_2_ITEM.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.DECORATIONS,

                        ModCompat.EMERALD_LIMITED_BARREL_2_ITEM.get()
                )

                .unlocks(
                        "has_limited_netherite_barrel_2",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_2_ITEM.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_limited_barrel_2"
                );

        /*
         * EMERALD LIMITED BARREL 3
         */
        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_3_ITEM.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.DECORATIONS,

                        ModCompat.EMERALD_LIMITED_BARREL_3_ITEM.get()
                )

                .unlocks(
                        "has_limited_netherite_barrel_3",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_3_ITEM.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_limited_barrel_3"
                );

        /*
         * EMERALD LIMITED BARREL 4
         */
        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_4_ITEM.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.DECORATIONS,

                        ModCompat.EMERALD_LIMITED_BARREL_4_ITEM.get()
                )

                .unlocks(
                        "has_limited_netherite_barrel_4",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.LIMITED_NETHERITE_BARREL_4_ITEM.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_limited_barrel_4"
                );

        /*
         * EMERALD CHEST
         */
        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.NETHERITE_CHEST_ITEM.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.DECORATIONS,

                        ModCompat.EMERALD_CHEST_ITEM.get()
                )

                .unlocks(
                        "has_netherite_chest",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.NETHERITE_CHEST_ITEM.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_chest"
                );

        /*
         * EMERALD SHULKER BOX
         */
        SmithingTransformRecipeBuilder
                .smithing(

                        Ingredient.of(
                                ModItems.EMERALD_UPGRADE_TEMPLATE.get()
                        ),

                        Ingredient.of(
                                net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.NETHERITE_SHULKER_BOX_ITEM.get()
                        ),

                        Ingredient.of(
                                Tags.Items.STORAGE_BLOCKS_EMERALD
                        ),

                        RecipeCategory.DECORATIONS,

                        ModCompat.EMERALD_SHULKER_BOX_ITEM.get()
                )

                .unlocks(
                        "has_netherite_shulker_box",
                        has(net.p3pp3rf1y.sophisticatedstorage.init.ModBlocks.NETHERITE_SHULKER_BOX_ITEM.get())
                )

                .save(
                        recipeOutput,
                        "sophisticated_emerald_upgrade:emerald_shulker_box"
                );
    }
}