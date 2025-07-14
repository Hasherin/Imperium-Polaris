package com.simp;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import com.terraformersmc.terrablender.api.TerraBlenderApi;

import main.java.com.simp.BeltRegion;
import main.java.com.simp.ConfigManager;
import main.java.com.simp.LatitudeBootstrap;

import com.terraformersmc.terrablender.api.Region;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SIMPSCBG implements ModInitializer {
	public static final String MOD_ID = "simpscbg";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ConfigManager.init();
		LatitudeBootstrap.bootstrapDirect();
		
        TerraBlenderApi.onTerraBlenderInitialized(() ->
            Region.register(new BeltRegion())
        );
		LOGGER.info("Hello Fabric world!");
	}

	 /** Conveniences */
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    public static Holder<Biome> biome(String key) {
        return Registries.BIOME.getHolder(ResourceLocation.tryParse(key))
                               .orElseThrow();
    }
}