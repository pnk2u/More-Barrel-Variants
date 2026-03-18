package de.pnku.more_barrel_variants.block.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockState;

public interface MoreBarrelBlockEntityInterface {
    void recheckOpen();

    void updateBlockState(BlockState state, boolean open);

    void playSound(BlockState state, SoundEvent sound);
}
