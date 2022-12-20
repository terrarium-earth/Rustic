package earth.terrarium.rustic.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.rustic.common.blockentities.FluidBarrelBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

public class FluidBarrelRenderer implements BlockEntityRenderer<FluidBarrelBlockEntity>, FluidHolderRenderer {

    private static final AABB BOUNDS = new AABB(0.1875f, 0.0625f, 0.1875f, 0.8125f, 0.9375f, 0.8125f);

    public FluidBarrelRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(FluidBarrelBlockEntity barrel, float partialTick, PoseStack stack, MultiBufferSource source, int light, int overlay) {
        renderFluid(barrel.getFluidContainer().getTankCapacity(0), barrel.getFluid(), stack, source, light);
    }

    @Override
    public @NotNull AABB bounds() {
        return BOUNDS;
    }
}
