package com.simp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.*;
import java.io.IOException;

public class ConfigManager {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static Config CONFIG;

    public static void init() {
        Path cfgPath = Path.of("config", "simp_climate_belts.json");
        try {
            if (Files.notExists(cfgPath)) {
                CONFIG = Config.defaults();
                Files.createDirectories(cfgPath.getParent());
                Files.writeString(cfgPath, GSON.toJson(CONFIG));
            } else {
                CONFIG = GSON.fromJson(Files.readString(cfgPath), Config.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read config", e);
        }
    }

    /** ---- Plain-old data classes ---- */
    public record Config(int beltHeight, int gradient, Belt[] belts) {
        static Config defaults() {
            return new Config(10_000, 600, new Belt[]{
                new Belt("pygame:snowy_plains",  4000, 5000),
                new Belt("minecraft:taiga",      2000, 4000),
                new Belt("minecraft:plains",    -2000, 2000),
                new Belt("minecraft:savanna",   -4000,-2000),
                new Belt("minecraft:desert",    -5000,-4000)
            });
        }
    }
    public record Belt(String biome, int min, int max) {
        boolean matches(double lat, int grad) {
            // lat = -1..+1  → convert to block coords
            double z = lat * ConfigManager.CONFIG.beltHeight / 2.0;
            return z >= (min - grad) && z <= (max + grad);
        }
    }
}
