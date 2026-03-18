package de.pnku.more_barrel_variants.init;

import de.pnku.more_barrel_variants.MoreBarrelVariants;
import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.List;

import static de.pnku.more_barrel_variants.MoreBarrelVariants.withModId;

public class MoreBarrelItems {
    public static final Item OAK_BARREL = new BlockItem(MoreBarrelBlocks.OAK_BARREL, new Item.Properties());
    public static final Item BIRCH_BARREL = new BlockItem(MoreBarrelBlocks.BIRCH_BARREL, new Item.Properties());
    public static final Item JUNGLE_BARREL = new BlockItem(MoreBarrelBlocks.JUNGLE_BARREL, new Item.Properties());
    public static final Item ACACIA_BARREL = new BlockItem(MoreBarrelBlocks.ACACIA_BARREL, new Item.Properties());
    public static final Item DARK_OAK_BARREL = new BlockItem(MoreBarrelBlocks.DARK_OAK_BARREL, new Item.Properties());
    public static final Item MANGROVE_BARREL = new BlockItem(MoreBarrelBlocks.MANGROVE_BARREL, new Item.Properties());
    public static final Item CHERRY_BARREL = new BlockItem(MoreBarrelBlocks.CHERRY_BARREL, new Item.Properties());
    public static final Item BAMBOO_BARREL = new BlockItem(MoreBarrelBlocks.BAMBOO_BARREL, new Item.Properties());
    public static final Item CRIMSON_BARREL = new BlockItem(MoreBarrelBlocks.CRIMSON_BARREL, new Item.Properties().fireResistant());
    public static final Item WARPED_BARREL = new BlockItem(MoreBarrelBlocks.WARPED_BARREL, new Item.Properties().fireResistant());

    public static final TagKey<Item> BARRELS_TAG = TagKey.create(Registries.ITEM, MoreBarrelVariants.withModId("barrels"));

    public static final List<Item> more_barrels = List.of(
            OAK_BARREL,
            BIRCH_BARREL,
            JUNGLE_BARREL,
            ACACIA_BARREL,
            DARK_OAK_BARREL,
            MANGROVE_BARREL,
            CHERRY_BARREL,
            BAMBOO_BARREL,
            CRIMSON_BARREL,
            WARPED_BARREL
    );

    public static void registerItems() {
        for (int i = 0; i != more_barrels.size(); ++i) {
            Item barrel = more_barrels.get(i);
            Item previousBarrel = i == 0 ? Items.BARREL : more_barrels.get(i - 1);
            String barrelName = ((MoreBarrelBlock) ((BlockItem) barrel).getBlock()).barrelWoodType + "_barrel";
            Registry.register(BuiltInRegistries.ITEM, withModId(barrelName), barrel);
          ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.addAfter(previousBarrel, barrel));
        }
    }
}