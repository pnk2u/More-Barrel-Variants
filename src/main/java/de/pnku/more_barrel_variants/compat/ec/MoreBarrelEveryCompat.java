package de.pnku.more_barrel_variants.compat.ec;

import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import de.pnku.more_barrel_variants.init.MoreBarrelBlocks;
import de.pnku.more_barrel_variants.init.MoreBarrelItems;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.modules.EveryCompatModule;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.mehvahdjukaar.moonlight.api.set.BlockType;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;


import static de.pnku.more_barrel_variants.MoreBarrelVariants.*;
import static de.pnku.more_barrel_variants.init.MoreBarrelBlocks.OAK_BARREL;

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
            // Preventing Pale Oak Barrels already added by "More Variants: Pale Oak Barrel"
            if (blockId.getPath().endsWith("pale_oak_barrel")) return true;
            else return super.isEntryAlreadyRegistered(entrySetId, blockId, blockType, registry);
        }

        @Override
        public void onModInit() {
            super.onModInit();
            RegHelper.addExtraPOIStatesRegistration(event ->
                    barrelSet.blocks.values().forEach(block -> event.addBlock(PoiTypes.FISHERMAN, block))
            );
        }
    }
}

