package de.pnku.more_barrel_variants.init;

import de.pnku.more_barrel_variants.MoreBarrelVariants;
import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.List;

import static de.pnku.more_barrel_variants.MoreBarrelVariants.withModId;
import static de.pnku.more_barrel_variants.init.MoreBarrelBlocks.*;

public class MoreBarrelItems {
    public static final Item OAK_BARREL = itemFromBlock(MoreBarrelBlocks.OAK_BARREL);
    public static final Item BIRCH_BARREL = itemFromBlock(MoreBarrelBlocks.BIRCH_BARREL);
    public static final Item JUNGLE_BARREL = itemFromBlock(MoreBarrelBlocks.JUNGLE_BARREL);
    public static final Item ACACIA_BARREL = itemFromBlock(MoreBarrelBlocks.ACACIA_BARREL);
    public static final Item DARK_OAK_BARREL = itemFromBlock(MoreBarrelBlocks.DARK_OAK_BARREL);
    public static final Item PALE_OAK_BARREL = itemFromBlock(MoreBarrelBlocks.PALE_OAK_BARREL);
    public static final Item MANGROVE_BARREL = itemFromBlock(MoreBarrelBlocks.MANGROVE_BARREL);
    public static final Item CHERRY_BARREL = itemFromBlock(MoreBarrelBlocks.CHERRY_BARREL);
    public static final Item BAMBOO_BARREL = itemFromBlock(MoreBarrelBlocks.BAMBOO_BARREL);
    public static final Item CRIMSON_BARREL = itemFromBlock(MoreBarrelBlocks.CRIMSON_BARREL, true);
    public static final Item WARPED_BARREL = itemFromBlock(MoreBarrelBlocks.WARPED_BARREL, true);

    public static final TagKey<Item> BARRELS_TAG = TagKey.create(Registries.ITEM, MoreBarrelVariants.withModId("barrels"));

    public static BlockItem itemFromBlock(MoreBarrelBlock moreBarrelBlock) {
        return itemFromBlock(moreBarrelBlock, false);
    }

    public static BlockItem itemFromBlock(MoreBarrelBlock moreBarrelBlock, boolean isNether) {
        return new BlockItem(moreBarrelBlock, setProperties(moreBarrelBlock, isNether));
    }

    public static Item.Properties setProperties(MoreBarrelBlock moreBarrelBlock, boolean isNether) {
        Item.Properties properties = new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM,BuiltInRegistries.BLOCK.getKey(moreBarrelBlock))).useBlockDescriptionPrefix();
        if (isNether) properties.fireResistant();
        return properties;
    }

    public static final List<Item> more_barrels = List.of(
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

    public static void registerItems() {
        for (int i = 0; i != more_barrels.size(); ++i) {
            Item barrel = more_barrels.get(i);
            Item previousBarrel = i == 0 ? Items.BARREL : more_barrels.get(i - 1);
            String barrelName = ((MoreBarrelBlock) ((BlockItem) barrel).getBlock()).barrelWoodType + "_barrel";
            Registry.register(BuiltInRegistries.ITEM, withModId(barrelName), barrel);
            // mod_id change from lolmblv to more_barrel_variants - alias for backwards compatibility
                BuiltInRegistries.ITEM.addAlias(withModId(barrelName, true), withModId(barrelName));
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.addAfter(previousBarrel, barrel));
        }
    }
}