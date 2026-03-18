package de.pnku.more_barrel_variants.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import de.pnku.more_barrel_variants.block.MoreBarrelBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static de.pnku.more_barrel_variants.MoreBarrelVariants.MOD_ID;
import static de.pnku.more_barrel_variants.init.MoreBarrelBlocks.more_barrels;

@Mixin(BarrelBlockEntity.class)
public class BarrelBlockEntityMixin {
    @ModifyReturnValue(method = "getDefaultName", at = @At("RETURN"))
    private Component modifiedGetDefaultNameAtReturn(Component original) {
        if (((BarrelBlockEntity) (Object) this).getBlockState().getBlock() instanceof MoreBarrelBlock moreBarrelBlock) {
            if (more_barrels.contains(moreBarrelBlock)) {
                return Component.translatable("container." + MOD_ID + "." + moreBarrelBlock.barrelWoodType + "_barrel");
            } else {
                return Component.translatable(moreBarrelBlock.getDescriptionId());
            }
        }
        return original;
    }
}
