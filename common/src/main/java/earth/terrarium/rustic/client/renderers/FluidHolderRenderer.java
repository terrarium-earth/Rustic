package earth.terrarium.rustic.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import earth.terrarium.botarium.api.fluid.ClientFluidHooks;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

public interface FluidHolderRenderer {

    default void renderFluid(long maxAmount, FluidHolder fluid, PoseStack stack, MultiBufferSource source, int light) {
        float percent = (float) fluid.getFluidAmount() / (float) maxAmount;
        if (percent > 0) {
            stack.pushPose();
            int color = ClientFluidHooks.getFluidColor(fluid);
            TextureAtlasSprite sprite = ClientFluidHooks.getFluidSprite(fluid);
            RenderType type = Minecraft.useShaderTransparency() ? RenderType.translucentMovingBlock() : RenderType.translucentNoCrumbling();
            createQuad(stack, source.getBuffer(type), Mth.lerp(percent, (float)bounds().minY, (float)bounds().maxY), light, color, sprite);
            stack.popPose();
        }
    }

    private void createQuad(PoseStack stack, VertexConsumer builder, float verticalOffset, int light, int color, TextureAtlasSprite texture) {
        Matrix4f matrix4f = stack.last().pose();
        float x1 = (float) bounds().minX;
        float x2 = (float) bounds().maxX;
        float z1 = (float) bounds().minZ;
        float z2 = (float) bounds().maxZ;
        int r = FastColor.ARGB32.red(color);
        int g = FastColor.ARGB32.green(color);
        int b = FastColor.ARGB32.blue(color);
        int a = FastColor.ARGB32.alpha(color);
        builder.vertex(matrix4f, x1, verticalOffset, z2).color(r, g, b, a).uv(texture.getU(0), texture.getV(0)).uv2(light).normal(0, 0F, 0).endVertex();
        builder.vertex(matrix4f, x2, verticalOffset, z2).color(r, g, b, a).uv(texture.getU(16), texture.getV(0)).uv2(light).normal(0, 0F, 0).endVertex();
        builder.vertex(matrix4f, x2, verticalOffset, z1).color(r, g, b, a).uv(texture.getU(16), texture.getV(16)).uv2(light).normal(0, 0F, 0).endVertex();
        builder.vertex(matrix4f, x1, verticalOffset, z1).color(r, g, b, a).uv(texture.getU(0), texture.getV(16)).uv2(light).normal(0, 0F, 0).endVertex();
    }

    @NotNull AABB bounds();
}
