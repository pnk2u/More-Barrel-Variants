package de.pnku.mblv.init;

import de.pnku.mblv.MoreBarrelVariants;
import de.pnku.mblv.block.MoreBarrelBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static de.pnku.mblv.init.MblvBlockInit.*;

public class MblvItemInit {
    public static final BlockItem OAK_BARREL_I = itemFromBlock(OAK_BARREL);
    public static final BlockItem BIRCH_BARREL_I = itemFromBlock(BIRCH_BARREL);
    public static final BlockItem JUNGLE_BARREL_I = itemFromBlock(JUNGLE_BARREL);
    public static final BlockItem ACACIA_BARREL_I = itemFromBlock(ACACIA_BARREL);
    public static final BlockItem DARK_OAK_BARREL_I = itemFromBlock(DARK_OAK_BARREL);
    public static final BlockItem PALE_OAK_BARREL_I = itemFromBlock(PALE_OAK_BARREL);
    public static final BlockItem MANGROVE_BARREL_I = itemFromBlock(MANGROVE_BARREL);
    public static final BlockItem CHERRY_BARREL_I = itemFromBlock(CHERRY_BARREL);
    public static final BlockItem BAMBOO_BARREL_I = itemFromBlock(BAMBOO_BARREL);
    public static final BlockItem CRIMSON_BARREL_I = itemFromBlock(CRIMSON_BARREL);
    public static final BlockItem WARPED_BARREL_I = itemFromBlock(WARPED_BARREL);

    public static BlockItem itemFromBlock(MoreBarrelBlock moreBarrelBlock) {
        return new BlockItem(moreBarrelBlock, setProperties(moreBarrelBlock));
    }

    public static Item.Properties setProperties(MoreBarrelBlock moreBarrelBlock) {
        return new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM,BuiltInRegistries.BLOCK.getKey(moreBarrelBlock))).useBlockDescriptionPrefix();
    }

    public static void registerItems() {
        registerItem(OAK_BARREL_I, Items.BARREL);
        registerItem(BIRCH_BARREL_I, OAK_BARREL_I);
        registerItem(JUNGLE_BARREL_I, BIRCH_BARREL_I);
        registerItem(ACACIA_BARREL_I, JUNGLE_BARREL_I);
        registerItem(DARK_OAK_BARREL_I, ACACIA_BARREL_I);
        registerItem(PALE_OAK_BARREL_I, DARK_OAK_BARREL_I);
        registerItem(MANGROVE_BARREL_I, PALE_OAK_BARREL_I);
        registerItem(CHERRY_BARREL_I, MANGROVE_BARREL_I);
        registerItem(BAMBOO_BARREL_I, CHERRY_BARREL_I);
        registerItem(CRIMSON_BARREL_I, BAMBOO_BARREL_I);
        registerItem(WARPED_BARREL_I, CRIMSON_BARREL_I);
    }

    private static void registerItem(BlockItem barrel, Item barrelAfter) {
        Registry.register(BuiltInRegistries.ITEM, MoreBarrelVariants.asId(((MoreBarrelBlock) barrel.getBlock()).barrelWoodType + "_barrel"), barrel);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.addAfter(barrelAfter, barrel));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(entries -> entries.addAfter(barrelAfter,barrel));
    }
}