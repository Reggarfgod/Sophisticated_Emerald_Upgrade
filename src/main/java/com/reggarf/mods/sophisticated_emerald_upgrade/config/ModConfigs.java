package com.reggarf.mods.sophisticated_emerald_upgrade.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.p3pp3rf1y.sophisticatedbackpacks.Config;
import net.p3pp3rf1y.sophisticatedstorage.Config.Server.LimitedBarrelConfig;
import net.p3pp3rf1y.sophisticatedstorage.Config.Server.StorageConfig;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {

    public static final Server SERVER;
    public static final ModConfigSpec SPEC;


    static {

        Pair<Server, ModConfigSpec> pair =
                new ModConfigSpec.Builder()
                        .configure(Server::new);

        SERVER = pair.getLeft();
        SPEC = pair.getRight();
    }

    public static class Server {

        public final StorageConfig
                emeraldBarrel;

        public final LimitedBarrelConfig
                emeraldLimitedBarrel1;

        public final LimitedBarrelConfig
                emeraldLimitedBarrel2;

        public final LimitedBarrelConfig
                emeraldLimitedBarrel3;

        public final LimitedBarrelConfig
                emeraldLimitedBarrel4;

        public final StorageConfig
                emeraldChest;

        public final StorageConfig
                emeraldShulkerBox;

        public final Config.Server.BackpackConfig
                emeraldBackpack;



        public Server(ModConfigSpec.Builder builder) {

            builder.comment("Emerald Storage Settings")
                    .push("server");

            emeraldBarrel =
                    new StorageConfig(
                            builder,
                            "Emerald Barrel",
                            168,
                            7
                    );

            emeraldLimitedBarrel1 =
                    new LimitedBarrelConfig(
                            builder,
                            "Emerald Limited Barrel I",
                            160,
                            7
                    );

            emeraldLimitedBarrel2 =
                    new LimitedBarrelConfig(
                            builder,
                            "Emerald Limited Barrel II",
                            80,
                            7
                    );

            emeraldLimitedBarrel3 =
                    new LimitedBarrelConfig(
                            builder,
                            "Emerald Limited Barrel III",
                            50,
                            7
                    );

            emeraldLimitedBarrel4 =
                    new LimitedBarrelConfig(
                            builder,
                            "Emerald Limited Barrel IV",
                            40,
                            7
                    );

            emeraldChest =
                    new StorageConfig(
                            builder,
                            "Emerald Chest",
                            168,
                            7
                    );

            emeraldShulkerBox =
                    new StorageConfig(
                            builder,
                            "Emerald Shulker Box",
                            168,
                            7
                    );

            emeraldBackpack =
                    new Config.Server.BackpackConfig(
                            builder,
                            "Emerald",
                            132,
                            9
                    );

            builder.pop();
        }
    }
}