package de.pnku.mblv.init;

import de.pnku.mblv.MoreBarrelVariants;
import de.pnku.mblv.block.MoreBarrelBlock;
import de.pnku.mblv.block.entity.MoreBarrelBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;


import java.util.ArrayList;
import java.util.List;

public class MblvBlockInit {
    public static final MoreBarrelBlock OAK_BARREL = new MoreBarrelBlock(MapColor.WOOD, "oak");
    public static final MoreBarrelBlock BIRCH_BARREL = new MoreBarrelBlock(MapColor.SAND, "birch");
    public static final MoreBarrelBlock JUNGLE_BARREL = new MoreBarrelBlock(MapColor.DIRT, "jungle");
    public static final MoreBarrelBlock ACACIA_BARREL = new MoreBarrelBlock(MapColor.COLOR_ORANGE, "acacia");
    public static final MoreBarrelBlock DARK_OAK_BARREL = new MoreBarrelBlock(MapColor.COLOR_BROWN, "dark_oak");
    public static final MoreBarrelBlock PALE_OAK_BARREL = new MoreBarrelBlock(MapColor.QUARTZ, "pale_oak");
    public static final MoreBarrelBlock MANGROVE_BARREL = new MoreBarrelBlock(MapColor.COLOR_RED, "mangrove");
    public static final MoreBarrelBlock CHERRY_BARREL = new MoreBarrelBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry");
    public static final MoreBarrelBlock BAMBOO_BARREL = new MoreBarrelBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo");
    public static final MoreBarrelBlock CRIMSON_BARREL = new MoreBarrelBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson");
    public static final MoreBarrelBlock WARPED_BARREL = new MoreBarrelBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped");

    public static BlockEntityType<MoreBarrelBlockEntity> MORE_BARREL_BLOCK_ENTITY;

    public static final List<Block> more_barrels = new ArrayList<>();


    public static void registerBlocks() {
        registerBlock(OAK_BARREL);
        registerBlock(BIRCH_BARREL);
        registerBlock(JUNGLE_BARREL);
        registerBlock(ACACIA_BARREL);
        registerBlock(DARK_OAK_BARREL);
        registerBlock(PALE_OAK_BARREL);
        registerBlock(MANGROVE_BARREL);
        registerBlock(CHERRY_BARREL);
        registerBlock(BAMBOO_BARREL);
        registerBlock(CRIMSON_BARREL);
        registerBlock(WARPED_BARREL);

        MORE_BARREL_BLOCK_ENTITY =
                Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                        MoreBarrelVariants.asId("more_barrel"),
                        FabricBlockEntityTypeBuilder.create(MoreBarrelBlockEntity::new, MblvBlockInit.more_barrels.toArray(Block[]::new))
                                .build());

    }

    private static void registerBlock(MoreBarrelBlock barrel) {
        Registry.register(BuiltInRegistries.BLOCK, MoreBarrelVariants.asId(barrel.barrelWoodType + "_barrel"), barrel);
        more_barrels.add(barrel);
    }
}