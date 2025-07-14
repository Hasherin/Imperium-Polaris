package com.sicbbg;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.ParameterUtils.*;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class SicbbgRegion extends Region {
    public SicbbgRegion() {
        super(ResourceLocation.fromNamespaceAndPath("sicbbg", "main_region"), RegionType.OVERWORLD, 2);
    }

    @Override
public void addBiomes(HolderGetter<Biome> biomeRegistry) {
    // Import ResourceKey.create for each biome
    final var biome = (String name) ->
        biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("minecraft", name)));

    // Tropical band – hot and humid
    this.addBiome(
        new ParameterPoint(
            Climate.Parameter.span(0.9F, 1.0F),   // hot
            Climate.Parameter.span(0.8F, 1.0F),   // very humid
            Climate.Parameter.span(0.1F, 0.6F),
            Climate.Parameter.span(0.3F, 0.8F),
            Climate.Parameter.point(0.0F),
            0, 0
        ),
        biome.apply("jungle")
    );

    // Subtropical band – warm and dry
    this.addBiome(
        new ParameterPoint(
            Climate.Parameter.span(0.8F, 0.95F),
            Climate.Parameter.span(0.0F, 0.4F),
            Climate.Parameter.span(0.1F, 0.7F),
            Climate.Parameter.span(0.2F, 0.8F),
            Climate.Parameter.point(0.0F),
            0, 0
        ),
        biome.apply("savanna")
    );

    // Temperate zone – mild and seasonal
    this.addBiome(
        new ParameterPoint(
            Climate.Parameter.span(0.4F, 0.8F),
            Climate.Parameter.span(0.3F, 0.9F),
            Climate.Parameter.span(0.2F, 0.8F),
            Climate.Parameter.span(0.3F, 0.7F),
            Climate.Parameter.point(0.0F),
            0, 0
        ),
        biome.apply("plains")
    );

    this.addBiome(
        new ParameterPoint(
            Climate.Parameter.span(0.3F, 0.7F),
            Climate.Parameter.span(0.4F, 0.8F),
            Climate.Parameter.span(0.2F, 0.9F),
            Climate.Parameter.span(0.3F, 0.7F),
            Climate.Parameter.point(0.0F),
            0, 0
        ),
        biome.apply("forest")
    );

    // Boreal – cool and damp
    this.addBiome(
        new ParameterPoint(
            Climate.Parameter.span(0.2F, 0.4F),
            Climate.Parameter.span(0.3F, 0.7F),
            Climate.Parameter.span(0.3F, 1.0F),
            Climate.Parameter.span(0.2F, 0.6F),
            Climate.Parameter.point(0.0F),
            0, 0
        ),
        biome.apply("taiga")
    );

    // Arctic – cold and dry
    this.addBiome(
        new ParameterPoint(
            Climate.Parameter.span(-1.0F, 0.2F),
            Climate.Parameter.span(0.0F, 0.3F),
            Climate.Parameter.span(0.0F, 1.0F),
            Climate.Parameter.span(-1.0F, 0.4F),
            Climate.Parameter.point(0.0F),
            0, 0
        ),
        biome.apply("snowy_plains")
    );
}
}

