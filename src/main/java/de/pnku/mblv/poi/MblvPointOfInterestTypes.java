package de.pnku.mblv.poi;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import de.pnku.mblv.init.MblvBlockInit;
import de.pnku.mblv.mixin.PoiTypesAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MblvPointOfInterestTypes {
    public static void init() {
        Map<BlockState, Holder<PoiType>> poiStatesToType = PoiTypesAccessor
                .getPointOfInterestStatesToType();

        Holder<PoiType> fishermanEntry = BuiltInRegistries.POINT_OF_INTEREST_TYPE
                .get(PoiTypes.FISHERMAN).get();

        PoiType fishermanPoiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getValue(PoiTypes.FISHERMAN);

        List<BlockState> fishermanBlockStates = new ArrayList<BlockState>(fishermanPoiType.matchingStates);

        for (Block block : MblvBlockInit.more_barrels) {
            ImmutableList<BlockState> blockStates = block.getStateDefinition().getPossibleStates();

            for (BlockState blockState : blockStates) {
                poiStatesToType.putIfAbsent(blockState, fishermanEntry);
            }

            fishermanBlockStates.addAll(blockStates);
        }

        fishermanPoiType.matchingStates = ImmutableSet.copyOf(fishermanBlockStates);
    }
}