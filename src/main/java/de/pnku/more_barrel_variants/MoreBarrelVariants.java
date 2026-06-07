package de.pnku.more_barrel_variants;

// import de.pnku.more_barrel_variants.compat.ec.MoreBarrelEveryCompat;
// import net.fabricmc.loader.api.FabricLoader;
import de.pnku.more_barrel_variants.init.MoreBarrelBlocks;
import de.pnku.more_barrel_variants.init.MoreBarrelItems;
import de.pnku.more_barrel_variants.poi.MoreBarrelPointOfInterestTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBarrelVariants implements ModInitializer {
    public static final String MOD_ID = "more_barrel_variants";
    public static final String LEGACY_MOD_ID = "lolmblv";
    public static final String MOD_NAME = "More Barrel Variants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        MoreBarrelBlocks.registerBlocks();
        MoreBarrelItems.registerItems();
        MoreBarrelPointOfInterestTypes.init();
        // initECModule();
    }

    public static Identifier withModId(String path) {return withModId(path, false);}

    public static Identifier withModId(String path, boolean legacy) {
        return Identifier.fromNamespaceAndPath(legacy ? LEGACY_MOD_ID : MOD_ID, path);
    }

    /*private void initECModule() {
        if (FabricLoader.getInstance().isModLoaded("everycomp")) {
            MoreBarrelEveryCompat.init();
        }
    }*/
}