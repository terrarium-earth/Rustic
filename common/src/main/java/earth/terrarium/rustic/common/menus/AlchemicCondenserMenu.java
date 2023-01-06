package earth.terrarium.rustic.common.menus;

import earth.terrarium.rustic.common.blockentities.AlchemicCondenserBlockEntity;
import earth.terrarium.rustic.common.items.PotionFlaskItem;
import earth.terrarium.rustic.common.menus.slots.CustomSlot;
import earth.terrarium.rustic.common.menus.slots.ResultSlot;
import earth.terrarium.rustic.common.registry.ModBlockEntities;
import earth.terrarium.rustic.common.registry.ModMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class AlchemicCondenserMenu extends AbstractContainerMenu {

    protected final Container container;
    protected final ContainerData data;
    protected final AlchemicCondenserBlockEntity block;

    public AlchemicCondenserMenu(int id, Inventory inventory, FriendlyByteBuf buf) {
        this(id, inventory, getBlockEntity(inventory, buf.readBlockPos()), new SimpleContainerData(4));

    }

    public AlchemicCondenserMenu(int i, Inventory inventory, AlchemicCondenserBlockEntity block, ContainerData data) {
        super(ModMenuTypes.ALCHEMIC_CONDENSER.get(), i);
        this.container = block;
        this.block = block;
        this.data = data;
        for (int slot : AlchemicCondenserBlockEntity.INPUT_SLOTS) {
            this.addSlot(new Slot(container, slot, 25, 17 + (slot * 18)));
        }
        this.addSlot(new CustomSlot(container, AlchemicCondenserBlockEntity.FUEL_SLOT[0], 80, 53, item -> item.is(Items.BLAZE_POWDER)));
        this.addSlot(new CustomSlot(container, AlchemicCondenserBlockEntity.FLASK_SLOT[0], 80, 35, item -> item.getItem() instanceof PotionFlaskItem));

        this.addSlot(new ResultSlot(container, AlchemicCondenserBlockEntity.BY_PRODUCT_SLOT[0], 110, 35));

        int j;
        for(j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }

        this.addDataSlots(this.data);
    }

    public float getFuelProgress() {
        int i = this.data.get(0);
        return (float) i / (float) AlchemicCondenserBlockEntity.TOTAL_FUEL_TIME;
    }

    public float getBrewProgress() {
        int i = this.data.get(1);
        return (float) i / (float) AlchemicCondenserBlockEntity.TOTAL_BREW_TIME;
    }

    public AlchemicCondenserBlockEntity getBlockEntity() {
        return this.block;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    private static AlchemicCondenserBlockEntity getBlockEntity(Inventory inventory, BlockPos pos) {
        var level = inventory.player.level;
        if (level.isClientSide && level.isLoaded(pos)) {
            return level.getBlockEntity(pos, ModBlockEntities.ALCHEMIC_CONDENSER.get()).orElse(null);
        }
        return null;
    }
}
