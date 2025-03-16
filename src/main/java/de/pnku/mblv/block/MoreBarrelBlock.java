package de.pnku.mblv.block;

import de.pnku.mblv.block.entity.MoreBarrelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class MoreBarrelBlock extends BarrelBlock {
    public final String barrelWoodType;

    public MoreBarrelBlock(MapColor colour, String barrelWoodType) {
        super(Properties.copy(Blocks.BARREL).mapColor(colour));
        this.barrelWoodType = barrelWoodType;
    }

    public MoreBarrelBlock(MapColor colour, SoundType soundType, String barrelWoodType) {
        super(Properties.copy(Blocks.BARREL).mapColor(colour).sound(soundType));
        this.barrelWoodType = barrelWoodType;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof MoreBarrelBlockEntity) {
                player.openMenu((MoreBarrelBlockEntity)blockEntity);
                player.awardStat(Stats.OPEN_BARREL);
                PiglinAi.angerNearbyPiglins(player, true);
            }

            return InteractionResult.CONSUME;
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof MoreBarrelBlockEntity) {
            ((MoreBarrelBlockEntity)blockEntity).recheckOpen();
        }

    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreBarrelBlockEntity(pos, state);
    }
}