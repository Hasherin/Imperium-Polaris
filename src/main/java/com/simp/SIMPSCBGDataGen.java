package com.simp;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;

public class SIMPSCBGDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        generator.createPack().addProvider(LatitudeDensityFunctionProvider::new);
    }
}