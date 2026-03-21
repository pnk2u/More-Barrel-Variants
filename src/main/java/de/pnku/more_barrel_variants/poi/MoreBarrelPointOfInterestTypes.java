package de.pnku.more_barrel_variants.poi;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import de.pnku.more_barrel_variants.init.MoreBarrelBlocks;
import de.pnku.more_barrel_variants.mixin.PoiTypesAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoreBarrelPointOfInterestTypes {
    public static void init() {
        addBarrelsToPoi(MoreBarrelBlocks.more_barrels);
    }

    public static boolean barrelsContainPoi(List<Block> barrels) {
        Map<BlockState, Holder<PoiType>> poiStatesToType = PoiTypesAccessor
                .getPointOfInterestStatesToType();

        Holder<PoiType> fishermanEntry = BuiltInRegistries.POINT_OF_INTEREST_TYPE
                .getHolder(PoiTypes.FISHERMAN).get();

        for (Block block : barrels) {
            ImmutableList<BlockState> blockStates = block.getStateDefinition().getPossibleStates();

            for (BlockState blockState : blockStates) {
                if (poiStatesToType.get(blockState) == fishermanEntry) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addBarrelsToPoi(List<Block> barrels) {
        Map<BlockState, Holder<PoiType>> poiStatesToType = PoiTypesAccessor
                .getPointOfInterestStatesToType();

        Holder<PoiType> fishermanEntry = BuiltInRegistries.POINT_OF_INTEREST_TYPE
                .getHolder(PoiTypes.FISHERMAN).get();

        PoiType fishermanPoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.get(PoiTypes.FISHERMAN);

        List<BlockState> fishermanBlockStates = new ArrayList<BlockState>(fishermanPoiType.matchingStates);

        for (Block block : barrels) {
            ImmutableList<BlockState> blockStates = block.getStateDefinition().getPossibleStates();

            for (BlockState blockState : blockStates) {
                poiStatesToType.putIfAbsent(blockState, fishermanEntry);
            }

            fishermanBlockStates.addAll(blockStates);
        }

        fishermanPoiType.matchingStates = ImmutableSet.copyOf(fishermanBlockStates);
    }
}