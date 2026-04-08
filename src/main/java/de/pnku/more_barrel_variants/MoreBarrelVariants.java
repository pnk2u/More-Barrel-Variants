package de.pnku.more_barrel_variants;

import de.pnku.more_barrel_variants.compat.ec.MoreBarrelEveryCompat;
import de.pnku.more_barrel_variants.init.MoreBarrelBlocks;
import de.pnku.more_barrel_variants.init.MoreBarrelItems;
import de.pnku.more_barrel_variants.poi.MoreBarrelPointOfInterestTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;

public class MoreBarrelVariants implements ModInitializer {
    public static final String MOD_ID = "more_barrel_variants";
    public static final String LEGACY_MOD_ID = "lolmblv";

    @Override
    public void onInitialize() {
        MoreBarrelBlocks.registerBlocks();
        MoreBarrelItems.registerItems();
        MoreBarrelPointOfInterestTypes.init();
        initECModule();
    }

    public static ResourceLocation withModId(String path) {return withModId(path, false);}

    public static ResourceLocation withModId(String path, boolean legacy) {
        return new ResourceLocation(legacy ? LEGACY_MOD_ID : MOD_ID, path);
    }

    private void initECModule() {
        if (FabricLoader.getInstance().isModLoaded("everycomp")) {
            MoreBarrelEveryCompat.init();
        }
    }
}