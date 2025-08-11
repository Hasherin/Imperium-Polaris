package io.github.hasherin.simpscbg;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CBGMod implements ModInitializer {
    public static final String MODID = "simpscbg";
    public static final Logger LOG = LoggerFactory.getLogger(MODID);

    // cached, read-only at runtime
    public static CBGConfig CONFIG = new CBGConfig();

    @Override
    public void onInitialize() {
        CONFIG = CBGConfigIO.loadOrCreate();
        LOG.info("Loaded config: deltaTemp={}", CONFIG.deltaTemp);
    }
}