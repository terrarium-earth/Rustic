package earth.terrarium.rustic.client.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.teamresourceful.resourcefullib.client.scissor.ScissorBoxStack;
import com.teamresourceful.resourcefullib.client.utils.RenderUtils;
import com.teamresourceful.resourcefullib.common.utils.types.Bound;
import earth.terrarium.botarium.api.fluid.ClientFluidHooks;
import earth.terrarium.botarium.api.fluid.FluidHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;

public class ClientRenderUtils {

    public static void renderTank(PoseStack stack, int blit, int x, int y, int width, int height, long capacity, FluidHolder fluid) {
        renderTank(new ScissorBoxStack(), stack, blit, x, y, width, height, capacity, fluid);
    }

    public static void renderTank(ScissorBoxStack scissor, PoseStack stack, int blit, int x, int y, int width, int height, long capacity, FluidHolder fluid) {
        if (fluid.isEmpty()) return;
        final int roundedHeight = roundTo16(height);
        final int roundedWidth = roundTo16(width);
        final int roundedFluidHeight = Math.min(Mth.ceil(((double)fluid.getFluidAmount() / (double) capacity) * roundedHeight), roundedHeight);
        final int fluidHeight = Math.min((int)(((double)fluid.getFluidAmount() / (double) capacity) * (double)height), height);
        final int startY = y + roundedHeight - roundedFluidHeight;
        TextureAtlasSprite sprite = ClientFluidHooks.getFluidSprite(fluid);
        int color = ClientFluidHooks.getFluidColor(fluid);

        if (sprite == null) return;

        Bound bound = RenderUtils.getScissorBounds(Minecraft.getInstance(), stack, x, y + height - fluidHeight, width, fluidHeight);
        scissor.push(bound.x(), bound.y(), bound.width(), bound.height());

        RenderUtils.bindTexture(InventoryMenu.BLOCK_ATLAS);
        RenderSystem.setShaderColor(FastColor.ARGB32.red(color) / 255f, FastColor.ARGB32.green(color) / 255f, FastColor.ARGB32.blue(color) / 255f, FastColor.ARGB32.alpha(color) / 255f);

        for (int y1 = 0; y1 < roundedFluidHeight; y1+=16) {
            for (int x1 = 0; x1 < roundedWidth; x1+=16) {
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                BufferBuilder builder = Tesselator.getInstance().getBuilder();
                builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                builder.vertex(stack.last().pose(), x + x1, startY + y1, blit).uv(sprite.getU0(), sprite.getV0()).endVertex();
                builder.vertex(stack.last().pose(), x + x1, startY + y1 + 16, blit).uv(sprite.getU0(), sprite.getV1()).endVertex();
                builder.vertex(stack.last().pose(), x + x1 + 16, startY + y1 + 16, blit).uv(sprite.getU1(), sprite.getV1()).endVertex();
                builder.vertex(stack.last().pose(), x + x1 + 16, startY + y1, blit).uv(sprite.getU1(), sprite.getV0()).endVertex();
                BufferUploader.drawWithShader(builder.end());
            }
        }
        scissor.pop();
    }

    private static int roundTo16(int num) {
        return ((num + 15) / 16) * 16;
    }
}
