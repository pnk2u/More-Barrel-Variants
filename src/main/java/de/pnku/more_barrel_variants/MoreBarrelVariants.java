package de.pnku.more_barrel_variants;

import de.pnku.more_barrel_variants.init.MoreBarrelBlocks;
import de.pnku.more_barrel_variants.init.MoreBarrelItems;
import de.pnku.more_barrel_variants.poi.MoreBarrelPointOfInterestTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class MoreBarrelVariants implements ModInitializer {
    public static final String MODID = "lolmblv";

    @Override
    public void onInitialize() {
        MoreBarrelBlocks.registerBlocks();
        MoreBarrelItems.registerItems();
        MoreBarrelPointOfInterestTypes.init();
    }

    public static ResourceLocation asId(String path) {
        return new ResourceLocation(MODID, path);
    }
}