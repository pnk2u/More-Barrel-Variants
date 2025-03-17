package de.pnku.mblv;

import de.pnku.mblv.init.MblvBlockInit;
import de.pnku.mblv.init.MblvItemInit;
import de.pnku.mblv.poi.MblvPointOfInterestTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class MoreBarrelVariants implements ModInitializer {
    public static final String MODID = "lolmblv";

    @Override
    public void onInitialize() {
        MblvBlockInit.registerBlocks();
        MblvItemInit.registerItems();
        MblvPointOfInterestTypes.init();
    }

    public static ResourceLocation asId(String path) {
        return new ResourceLocation(MODID, path);
    }
}