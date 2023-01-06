package earth.terrarium.rustic.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.rustic.client.utils.ClientRenderUtils;
import earth.terrarium.rustic.common.blockentities.AlchemicCondenserBlockEntity;
import earth.terrarium.rustic.common.menus.AlchemicCondenserMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AlchemicCondenserScreen extends AbstractContainerScreen<AlchemicCondenserMenu> implements MenuAccess<AlchemicCondenserMenu> {

    public AlchemicCondenserScreen(AlchemicCondenserMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
//        for (Slot slot : this.getMenu().slots) {
//            GuiComponent.fill(poseStack, this.leftPos + slot.x, this.topPos + slot.y, this.leftPos + slot.x + 16, this.topPos + slot.y + 16, 0xFFFFFFFF);
//        }
        font.draw(poseStack, "Fuel: " + this.getMenu().getFuelProgress(), 10, 10, 0x000000);
        font.draw(poseStack, "Brew: " + this.getMenu().getBrewProgress(), 10, 20, 0x000000);
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(stack);
        super.render(stack, mouseX, mouseY, partialTick);
        AlchemicCondenserBlockEntity block = this.getMenu().getBlockEntity();
        ClientRenderUtils.renderTank(stack, this.getBlitOffset(), this.leftPos + 80, this.topPos + 17, 16, 54, block.getFluidContainer().getTankCapacity(0), block.getFluid());
        this.renderTooltip(stack, mouseX, mouseY);
    }
}
