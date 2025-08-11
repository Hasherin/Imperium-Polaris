package io.github.hasherin.simpscbg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class CBGConfigIO {
    private static final Logger LOG = LoggerFactory.getLogger("cbg-config");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_NAME = "cbg.json";

    public static CBGConfig loadOrCreate() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve(FILE_NAME);
        try {
            if (Files.notExists(path)) {
                CBGConfig def = new CBGConfig();
                save(def, path);
                return def;
            }
            try (Reader r = Files.newBufferedReader(path)) {
                CBGConfig cfg = GSON.fromJson(r, CBGConfig.class);
                return (cfg != null) ? cfg : new CBGConfig();
            }
        } catch (IOException e) {
            LOG.error("Failed to read config; using defaults.", e);
            return new CBGConfig();
        }
    }

    private static void save(CBGConfig cfg, Path path) throws IOException {
        Files.createDirectories(path.getParent());
        try (Writer w = Files.newBufferedWriter(path)) {
            GSON.toJson(cfg, w);
        }
    }
}