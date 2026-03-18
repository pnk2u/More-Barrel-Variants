package de.pnku.more_barrel_variants.init;

import de.pnku.more_barrel_variants.MoreBarrelVariants;
import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class MoreBarrelItems {
    public static final BlockItem OAK_BARREL_I = new BlockItem(MoreBarrelBlocks.OAK_BARREL, new Item.Properties());
    public static final BlockItem BIRCH_BARREL_I = new BlockItem(MoreBarrelBlocks.BIRCH_BARREL, new Item.Properties());
    public static final BlockItem JUNGLE_BARREL_I = new BlockItem(MoreBarrelBlocks.JUNGLE_BARREL, new Item.Properties());
    public static final BlockItem ACACIA_BARREL_I = new BlockItem(MoreBarrelBlocks.ACACIA_BARREL, new Item.Properties());
    public static final BlockItem DARK_OAK_BARREL_I = new BlockItem(MoreBarrelBlocks.DARK_OAK_BARREL, new Item.Properties());
    public static final BlockItem MANGROVE_BARREL_I = new BlockItem(MoreBarrelBlocks.MANGROVE_BARREL, new Item.Properties());
    public static final BlockItem CHERRY_BARREL_I = new BlockItem(MoreBarrelBlocks.CHERRY_BARREL, new Item.Properties());
    public static final BlockItem BAMBOO_BARREL_I = new BlockItem(MoreBarrelBlocks.BAMBOO_BARREL, new Item.Properties());
    public static final BlockItem CRIMSON_BARREL_I = new BlockItem(MoreBarrelBlocks.CRIMSON_BARREL, new Item.Properties().fireResistant());
    public static final BlockItem WARPED_BARREL_I = new BlockItem(MoreBarrelBlocks.WARPED_BARREL, new Item.Properties().fireResistant());


    public static void registerItems() {
        registerItem(OAK_BARREL_I, Items.BARREL);
        registerItem(BIRCH_BARREL_I, OAK_BARREL_I);
        registerItem(JUNGLE_BARREL_I, BIRCH_BARREL_I);
        registerItem(ACACIA_BARREL_I, JUNGLE_BARREL_I);
        registerItem(DARK_OAK_BARREL_I, ACACIA_BARREL_I);
        registerItem(MANGROVE_BARREL_I, DARK_OAK_BARREL_I);
        registerItem(CHERRY_BARREL_I, MANGROVE_BARREL_I);
        registerItem(BAMBOO_BARREL_I, CHERRY_BARREL_I);
        registerItem(CRIMSON_BARREL_I, BAMBOO_BARREL_I);
        registerItem(WARPED_BARREL_I, CRIMSON_BARREL_I);
    }

    private static void registerItem(BlockItem barrel, Item barrelAfter) {
        Registry.register(BuiltInRegistries.ITEM, MoreBarrelVariants.asId(((MoreBarrelBlock) barrel.getBlock()).barrelWoodType + "_barrel"), barrel);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.addAfter(barrelAfter, barrel));
    }
}