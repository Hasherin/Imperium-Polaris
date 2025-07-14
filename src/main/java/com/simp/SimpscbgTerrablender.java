package com.simp;

import com.terraformersmc.terrablender.api.Region;
import com.terraformersmc.terrablender.api.TerraBlenderApi;

public class SimpscbgTerrablender implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Region.register(new BeltRegion());
    }
}
