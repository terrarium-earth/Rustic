package earth.terrarium.rustic.mixin;

import earth.terrarium.rustic.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Fixes hardcoded things
@Mixin(CropBlock.class)
public abstract class CropBlockMixin {

    @Inject(method = "mayPlaceOn", at = @At("HEAD"), cancellable = true)
    private void rustic_mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(ModBlocks.FERTILE_SOIL.get())) cir.setReturnValue(true);
    }

    @Inject(method = "getGrowthSpeed", at = @At("HEAD"), cancellable = true)
    private static void rustic_getGrowthSpeed(Block block, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Float> cir) {
        if (level.getBlockState(pos.below()).is(ModBlocks.FERTILE_SOIL.get())) {
            float f = 1.0F;
            BlockPos blockPos = pos.below();

            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    float g = 0.0F;
                    BlockState blockState = level.getBlockState(blockPos.offset(i, 0, j));
                    if (blockState.is(ModBlocks.FERTILE_SOIL.get())) {
                        g = 3.0f;
                    }

                    if (i != 0 || j != 0) {
                        g /= 4.0F;
                    }

                    f += g;
                }
            }

            BlockPos blockPos2 = pos.north();
            BlockPos blockPos3 = pos.south();
            BlockPos blockPos4 = pos.west();
            BlockPos blockPos5 = pos.east();
            boolean bl = level.getBlockState(blockPos4).is(block) || level.getBlockState(blockPos5).is(block);
            boolean bl2 = level.getBlockState(blockPos2).is(block) || level.getBlockState(blockPos3).is(block);
            if (bl && bl2) {
                f /= 2.0F;
            } else {
                boolean bl3 = level.getBlockState(blockPos4.north()).is(block) || level.getBlockState(blockPos5.north()).is(block) || level.getBlockState(blockPos5.south()).is(block) || level.getBlockState(blockPos4.south()).is(block);
                if (bl3) {
                    f /= 2.0F;
                }
            }

            cir.setReturnValue(f);
        }
    }
}
