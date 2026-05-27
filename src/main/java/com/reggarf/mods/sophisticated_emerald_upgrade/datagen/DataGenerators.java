package com.reggarf.mods.sophisticated_emerald_upgrade.datagen;

import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {

    private DataGenerators() {
    }

    public static void gatherData(
            GatherDataEvent.Client event
    ) {

        event.createProvider(
                ModRecipeProvider.Runner::new
        );
    }
}