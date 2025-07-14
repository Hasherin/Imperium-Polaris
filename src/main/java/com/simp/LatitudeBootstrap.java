package com.simp;

import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrappingContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class LatitudeBootstrap {
    public static final ResourceKey<DensityFunction> KEY =
            ResourceKey.create(Registries.DENSITY_FUNCTION,
                               ClimateBelts.id("latitude"));

    public static void bootstrap(BootstrappingContext<DensityFunction> ctx) {
        int h = ConfigManager.CONFIG.beltHeight;
        // weirdness = ( (Z / h) % 2 ) * 2 - 1
        DensityFunction z = DensityFunctions.coordinate(DensityFunctions.Coordinate.Z);
        DensityFunction base = DensityFunctions.mul(
                DensityFunctions.constant(1.0 / h),
                z);
        DensityFunction saw = new SawFunction(base); // implement by extending DensityFunctions.Single

        ctx.register(KEY, saw);
    }
    public static void bootstrapDirect() {
    Registry.register(
        Registries.DENSITY_FUNCTION,
        KEY,
        new SawFunction(
            DensityFunctions.mul(
                DensityFunctions.constant(1.0 / ConfigManager.CONFIG.beltHeight),
                DensityFunctions.coordinate(DensityFunctions.Coordinate.Z)
            )
        )
    );
}
}