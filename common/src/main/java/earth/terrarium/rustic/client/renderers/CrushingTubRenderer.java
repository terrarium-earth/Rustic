package earth.terrarium.rustic.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.teamresourceful.resourcefullib.common.caches.CacheableFunction;
import earth.terrarium.rustic.common.blockentities.CrushingTubBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CrushingTubRenderer implements BlockEntityRenderer<CrushingTubBlockEntity>, FluidHolderRenderer {

    private static final AABB BOUNDS = new AABB(0.0625, 0.0625f, 0.0625, 0.9375, 0.5625f, 0.9375);
    private static final CacheableFunction<Integer, Quaternion> ROTATION_CACHE = new CacheableFunction<>((id) -> {
        Random random = new Random();
        return Vector3f.YP.rotationDegrees(random.nextInt(360));
    });

    private final ItemRenderer itemRenderer;

    public CrushingTubRenderer(BlockEntityRendererProvider.Context context) {
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CrushingTubBlockEntity tub, float partialTick, PoseStack stack, MultiBufferSource source, int light, int overlay) {
        ItemStack item = tub.getItem(0);
        if (!item.isEmpty()) {
            renderItems(item, stack, source, light, overlay);
        }
        renderFluid(tub.getFluidContainer().getTankCapacity(0), tub.getFluid(), stack, source, light);
    }

    private void renderItems(ItemStack item, PoseStack stack, MultiBufferSource source, int light, int overlay) {
        stack.pushPose();
        stack.translate(0.5, 0.118125f, 0.5);
        int count = Math.max(1, item.getCount() / 8);
        for (int i = 1; i <= count; i++) {
            stack.translate(0, 0.03125, 0);
            stack.pushPose();
            stack.mulPose(ROTATION_CACHE.apply(i));
            stack.mulPose(Vector3f.XP.rotationDegrees(90));
            itemRenderer.renderStatic(item, ItemTransforms.TransformType.GROUND, light, overlay, stack, source, 0);
            stack.popPose();
        }
        stack.popPose();
    }

    @Override
    public @NotNull AABB bounds() {
        return BOUNDS;
    }
}
