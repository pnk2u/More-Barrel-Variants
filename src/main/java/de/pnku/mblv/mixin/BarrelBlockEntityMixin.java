package de.pnku.mblv.mixin;

import de.pnku.mblv.block.MoreBarrelBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BarrelBlockEntity.class)
public class BarrelBlockEntityMixin {
    @Inject(method = "getDefaultName", at = @At("HEAD"), cancellable = true)
    private void injectedGetDefaultName(CallbackInfoReturnable<Component> cir) {
        if (((BarrelBlockEntity) (Object) this).getBlockState().getBlock() instanceof MoreBarrelBlock moreBarrelBlock) {
            cir.setReturnValue(Component.translatable("container.lolmblv." + moreBarrelBlock.barrelWoodType + "_barrel"));
        }
    }
}
