package de.pnku.more_barrel_variants.block.entity;

import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import de.pnku.more_barrel_variants.init.MoreBarrelBlocks;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static de.pnku.more_barrel_variants.MoreBarrelVariants.MOD_ID;
import static de.pnku.more_barrel_variants.init.MoreBarrelBlocks.more_barrels;

public class MoreBarrelBlockEntity extends RandomizableContainerBlockEntity implements MoreBarrelBlockEntityInterface {
    private NonNullList<ItemStack> items;
    private final ContainerOpenersCounter openersCounter;

    public MoreBarrelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(MoreBarrelBlocks.MORE_BARREL_BLOCK_ENTITY, blockPos, blockState);
        this.items = NonNullList.withSize(27, ItemStack.EMPTY);
        this.openersCounter = new ContainerOpenersCounter() {
            protected void onOpen(Level level, BlockPos pos, BlockState state) {
                MoreBarrelBlockEntity.this.playSound(state, SoundEvents.BARREL_OPEN);
                MoreBarrelBlockEntity.this.updateBlockState(state, true);
            }

            protected void onClose(Level level, BlockPos pos, BlockState state) {
                MoreBarrelBlockEntity.this.playSound(state, SoundEvents.BARREL_CLOSE);
                MoreBarrelBlockEntity.this.updateBlockState(state, false);
            }

            protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int count, int openCount) {
            }

            protected boolean isOwnContainer(Player player) {
                if (player.containerMenu instanceof ChestMenu) {
                    Container container = ((ChestMenu)player.containerMenu).getContainer();
                    return container == MoreBarrelBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items);
        }

    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items);
        }

    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        MoreBarrelBlock moreBarrelBlock = (MoreBarrelBlock) getBlockState().getBlock();
        if (more_barrels.contains(moreBarrelBlock)) {
            return Component.translatable("container." + MOD_ID + "." + moreBarrelBlock.barrelWoodType + "_barrel");
        } else {
            return Component.translatable(moreBarrelBlock.getDescriptionId());
        }
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return ChestMenu.threeRows(containerId, inventory, this);
    }

    @Override
    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    @Override
    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    @Override
    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    @Override
    public void updateBlockState(BlockState state, boolean open) {
        this.level.setBlock(this.getBlockPos(), (BlockState)state.setValue(BarrelBlock.OPEN, open), 3);
    }

    @Override
    public void playSound(BlockState state, SoundEvent sound) {
        Vec3i vec3i = ((Direction)state.getValue(BarrelBlock.FACING)).getNormal();
        double d = (double)this.worldPosition.getX() + 0.5 + (double)vec3i.getX() / 2.0;
        double e = (double)this.worldPosition.getY() + 0.5 + (double)vec3i.getY() / 2.0;
        double f = (double)this.worldPosition.getZ() + 0.5 + (double)vec3i.getZ() / 2.0;
        assert this.level != null;
        this.level.playSound((Player)null, d, e, f, sound, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }

    public MoreBarrelBlock getBlock() {
        return (MoreBarrelBlock) getBlockState().getBlock();
    }
}