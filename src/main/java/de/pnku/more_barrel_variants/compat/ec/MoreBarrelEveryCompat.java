/* Disabled as Every Compat is not available for versions above 1.21.1
package de.pnku.more_barrel_variants.compat.ec;

import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import de.pnku.more_barrel_variants.init.MoreBarrelBlocks;
import de.pnku.more_barrel_variants.init.MoreBarrelItems;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.modules.EveryCompatModule;
import net.mehvahdjukaar.moonlight.api.set.BlockType;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import static de.pnku.more_barrel_variants.MoreBarrelVariants.MOD_ID;
import static de.pnku.more_barrel_variants.MoreBarrelVariants.withModId;
import static de.pnku.more_barrel_variants.init.MoreBarrelBlocks.OAK_BARREL;
import static de.pnku.more_barrel_variants.poi.MoreBarrelPointOfInterestTypes.*;
import static org.apache.logging.log4j.LogManager.getLogger;

public class MoreBarrelEveryCompat {
    public static void init() {
        EveryCompatAPI.registerModule(new MoreBarrelECModule());
    }

    public static class MoreBarrelECModule extends EveryCompatModule {
        public static SimpleEntrySet<WoodType, Block> barrelSet;

        public MoreBarrelECModule() {
            super(MOD_ID, "mblv");
            String pre = "block/oak_barrel_";
            barrelSet = SimpleEntrySet.builder(
                    WoodType.class, "barrel",
                    () -> (Block) OAK_BARREL, () -> VanillaWoodTypes.OAK,
                    woodType -> new MoreBarrelBlock(
                            woodType.planks.defaultMapColor(),
                            woodType.getSound(),
                            woodType.getTypeName()
                    ))
                    .addTag(MoreBarrelBlocks.BARRELS_TAG, Registries.BLOCK)
                    .addTag(MoreBarrelItems.BARRELS_TAG, Registries.ITEM)
                    .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                    .addTile(() -> BlockEntityType.BARREL)
                    .defaultRecipe()
                    .setTabKey(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                    .addTexture(withModId(pre + "bottom"))
                    .addTextureM(withModId(pre + "side"), withModId(pre + "side_m"))
                    .addTextureM(withModId(pre + "top"), withModId(pre + "top_m"))
                    .addTexture(withModId(pre + "top_open"))
                    .copyParentDrop()
                    .build();
            this.addEntry(barrelSet);
        }
        @Override
        public boolean isEntryAlreadyRegistered(String entrySetId, ResourceLocation blockId, BlockType blockType, Registry<?> registry) {
            // Preventing Pale Oak Barrels already added by "More Variants: Pale Oak Backport"
            if (blockId.getPath().endsWith("pale_oak_barrel")) return true;
            else return super.isEntryAlreadyRegistered(entrySetId, blockId, blockType, registry);
        }

        @Override
        public void onModSetup() {
            String loggerId = MOD_ID + " (EC)";
            if (!barrelSet.blocks.isEmpty() && !barrelsContainPoi(barrelSet.blocks.values().stream().toList())) {
                addBarrelsToPoi(barrelSet.blocks.values().stream().toList());
                if (barrelsContainPoi(barrelSet.blocks.values().stream().toList())) {
                    getLogger(loggerId).info("Compat Barrels have successfully been registered as valid Villager Job Site Block for Fishermen.");
                } else getLogger(loggerId).warn("Compat Barrels could not be registered as valid Villager Job Site Block for Fishermen. This is a known but rare issue and can usually be fixed by restarting the game.\n=================================================================== In case a restart does not fix the issue, please report this to pnku via Github (pnk2u/More-Barrel-Variants), Email (contact@pnku.de) or Discord (discord.lieonlion.dev).");
            } else if (barrelSet.blocks.isEmpty()) getLogger(loggerId).warn("Could not find registered Compat Barrels, unable to register as POI. This should not happen unless none of your installed mods add non-vanilla Wood Types.\n==================================================================== If you do have such mods installed while receiving this warning, please report this to pnku via Github (pnk2u/More-Barrel-Variants), Email (contact@pnku.de) or Discord (discord.lieonlion.dev).");
            super.onModSetup();
        }
    }
}

*/
