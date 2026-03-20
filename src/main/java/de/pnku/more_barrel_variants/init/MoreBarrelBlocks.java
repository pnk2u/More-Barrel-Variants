package de.pnku.more_barrel_variants.init;

import de.pnku.more_barrel_variants.MoreBarrelVariants;
import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;

import java.util.List;

import static de.pnku.more_barrel_variants.MoreBarrelVariants.withModId;

public class MoreBarrelBlocks {
    public static final Block OAK_BARREL = new MoreBarrelBlock(MapColor.WOOD, "oak");
    public static final Block BIRCH_BARREL = new MoreBarrelBlock(MapColor.SAND, "birch");
    public static final Block JUNGLE_BARREL = new MoreBarrelBlock(MapColor.DIRT, "jungle");
    public static final Block ACACIA_BARREL = new MoreBarrelBlock(MapColor.COLOR_ORANGE, "acacia");
    public static final Block DARK_OAK_BARREL = new MoreBarrelBlock(MapColor.COLOR_BROWN, "dark_oak");
    public static final Block PALE_OAK_BARREL = new MoreBarrelBlock(MapColor.QUARTZ, "pale_oak");
    public static final Block MANGROVE_BARREL = new MoreBarrelBlock(MapColor.COLOR_RED, "mangrove");
    public static final Block CHERRY_BARREL = new MoreBarrelBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry");
    public static final Block BAMBOO_BARREL = new MoreBarrelBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo");
    public static final Block CRIMSON_BARREL = new MoreBarrelBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson");
    public static final Block WARPED_BARREL = new MoreBarrelBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped");

    public static final TagKey<Block> BARRELS_TAG = TagKey.create(Registries.BLOCK, MoreBarrelVariants.withModId("barrels"));

    public static final List<Block> more_barrels = List.of(
            OAK_BARREL,
            BIRCH_BARREL,
            JUNGLE_BARREL,
            ACACIA_BARREL,
            DARK_OAK_BARREL,
            PALE_OAK_BARREL,
            MANGROVE_BARREL,
            CHERRY_BARREL,
            BAMBOO_BARREL,
            CRIMSON_BARREL,
            WARPED_BARREL
    );

    public static void registerBlocks() {
        for (Block barrel : more_barrels) {
            String barrelName = ((MoreBarrelBlock) barrel).barrelWoodType + "_barrel";
            Registry.register(BuiltInRegistries.BLOCK, withModId(barrelName), barrel);
            // mod_id change from lolmblv to more_barrel_variants - alias for backwards compatibility
                BuiltInRegistries.BLOCK.addAlias(withModId(barrelName, true), withModId(barrelName));
            BlockEntityType.BARREL.addValidBlock(barrel);
        }
    }
}