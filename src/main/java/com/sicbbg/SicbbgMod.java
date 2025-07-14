package com.sicbbg;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;

public class SicbbgMod implements ModInitializer {
    public static final String MOD_ID = "sicbbg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[{}] Initializing mod...", MOD_ID);
        Regions.register(new SicbbgRegion());
    }
}
