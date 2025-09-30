package de.pnku.mblv.block;

import de.pnku.mblv.MoreBarrelVariants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class MoreBarrelBlock extends BarrelBlock {
    public final String barrelWoodType;

    public MoreBarrelBlock(MapColor colour, String barrelWoodType) {
        super(Properties.ofFullCopy(Blocks.BARREL).mapColor(colour).setId(ResourceKey.create(Registries.BLOCK, MoreBarrelVariants.asId(barrelWoodType + "_barrel"))));
        this.barrelWoodType = barrelWoodType;
    }

    public MoreBarrelBlock(MapColor colour, SoundType soundType, String barrelWoodType) {
        super(Properties.ofFullCopy(Blocks.BARREL).mapColor(colour).setId(ResourceKey.create(Registries.BLOCK, MoreBarrelVariants.asId(barrelWoodType + "_barrel"))).sound(soundType));
        this.barrelWoodType = barrelWoodType;
    }

}