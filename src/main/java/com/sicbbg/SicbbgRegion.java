package com.sicbbg;

import com.mojang.serialization.Codec;
import net.minecraft.core.HolderGetter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class SicbbgRegion extends Region {
    private static final ResourceLocation NAME = new ResourceLocation("sicbbg", "main_region");

    public SicbbgRegion() {
        super(NAME, RegionType.OVERWORLD, 2); // weight 2
    }

    @Override
    public void addBiomes(HolderGetter<Biome> biomeRegistry) {
        // TODO: Add your ParameterPoints and biome assignments here
    }
}