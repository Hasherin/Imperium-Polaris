package main.java.com.simp;

import com.terraformersmc.terrablender.api.Region;
import com.terraformersmc.terrablender.api.RegionType;
import com.terraformersmc.terrablender.api.Regions;
import com.terraformersmc.terrablender.api.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.core.Holder;

public class BeltRegion extends Region {
    public BeltRegion() {
        super(ClimateBelts.id("overworld"), RegionType.OVERWORLD, 4);
    }

    @Override
    public void addBiomes(BiomeSelectionContext ctx, RegionContext data) {
        double latitude = data.weirdness();
        for (ConfigManager.Belt belt : ConfigManager.CONFIG.belts) {
            if (belt.matches(latitude, ConfigManager.CONFIG.gradient)) {
                ctx.replaceBiome(ClimateBelts.biome(belt.biome()));
                return;
            }
        }
    }
}