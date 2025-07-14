package com.sicbbg;

import terrablender.api.Region.BiomeEntry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class SicbbgRegion extends Region {
    private static final ResourceLocation NAME = ResourceLocation.fromNamespaceAndPath("sicbbg", "main_region");

    public SicbbgRegion() {
        super(NAME, RegionType.OVERWORLD, 2); // weight 2 = priority over vanilla
    }

    @Override
    public void addBiomes(RegistryAccess registryAccess, Consumer<BiomeEntry> builder) {
        // TODO: Add climate ParameterPoints and biome assignments here
    }
}
