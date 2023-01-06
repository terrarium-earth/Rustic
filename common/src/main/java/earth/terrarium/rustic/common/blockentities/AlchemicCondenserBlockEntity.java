package earth.terrarium.rustic.common.blockentities;

import earth.terrarium.botarium.api.fluid.FluidHolder;
import earth.terrarium.botarium.api.fluid.FluidHoldingBlock;
import earth.terrarium.botarium.api.fluid.FluidHooks;
import earth.terrarium.botarium.api.fluid.SimpleUpdatingFluidContainer;
import earth.terrarium.botarium.api.menu.ExtraDataMenuProvider;
import earth.terrarium.rustic.common.config.AlchemyConfig;
import earth.terrarium.rustic.common.items.PotionFlaskItem;
import earth.terrarium.rustic.common.menus.AlchemicCondenserMenu;
import earth.terrarium.rustic.common.recipes.AlchemicCondenserRecipe;
import earth.terrarium.rustic.common.registry.ModBlockEntities;
import earth.terrarium.rustic.common.registry.ModRecipeTypes;
import earth.terrarium.rustic.common.utils.ItemUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class AlchemicCondenserBlockEntity extends BlockEntity implements BasicContainer, WorldlyContainer, FluidHoldingBlock, ExtraDataMenuProvider {

    public static final int[] INPUT_SLOTS = new int[]{0, 1, 2};
    public static final int[] FUEL_SLOT = new int[]{3};
    public static final int[] FLASK_SLOT = new int[]{4};
    public static final int[] BY_PRODUCT_SLOT = new int[]{5};

    public static final int TOTAL_BREW_TIME = 400;
    public static final int TOTAL_FUEL_TIME = TOTAL_BREW_TIME * AlchemyConfig.FLASK_MAX_AMOUNT;

    protected SimpleUpdatingFluidContainer fluidContainer;
    protected NonNullList<ItemStack> items;
    protected final ContainerData data;

    private AlchemicCondenserRecipe recipe;

    private int fuelTime;
    private int cookTime;

    public AlchemicCondenserBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.ALCHEMIC_CONDENSER.get(), blockPos, blockState);
        this.items = NonNullList.withSize(6, ItemStack.EMPTY);
        this.data = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> fuelTime;
                    case 1 -> cookTime;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> fuelTime = value;
                    case 1 -> cookTime = value;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AlchemicCondenserBlockEntity block) {
        if (block.fuelTime > 0) {
            block.fuelTime--;
        }
        if (block.recipe != null && block.canCraft()) {
            if (block.fuelTime > 0) {
                block.cookTime++;
                if (block.cookTime == TOTAL_BREW_TIME) {
                    block.cookTime = 0;
                    block.craft();
                }
            } else if (!block.checkAndConsumeFuel()) {
                block.cookTime = 0;
            }
        } else {
            block.cookTime = 0;
        }
    }

    public void tick() {
        if (this.fuelTime > 0) {
            this.fuelTime--;
        }
        if (this.recipe != null && this.canCraft()) {
            if (this.fuelTime > 0) {
                this.cookTime++;
                if (this.cookTime == TOTAL_BREW_TIME) {
                    this.cookTime = 0;
                    this.craft();
                }
            } else if (!this.checkAndConsumeFuel()) {
                this.cookTime = 0;
            }
        } else {
            this.cookTime = 0;
        }
    }

    private boolean canCraft() {
        return recipe != null && PotionFlaskItem.canSetPotion(getItem(4), recipe.output());
    }

    private boolean checkAndConsumeFuel() {
        if (recipe == null) {
            return false;
        }
        ItemStack fuel = items.get(3);
        if (fuel.is(Items.BLAZE_POWDER)) {
            fuelTime = TOTAL_FUEL_TIME;
            fuel.shrink(1);
            return true;
        }
        return false;
    }

    private void craft() {
        if (recipe == null) {
            return;
        }
        ItemStack flaskSlot = getItem(4);
        if (PotionFlaskItem.canSetPotion(flaskSlot, recipe.output())) {
            PotionFlaskItem.setPotion(flaskSlot, recipe.output(), PotionFlaskItem.getPotion(flaskSlot).getSecond() + 1);
        }
        for (int i = 0; i < recipe.inputs().size(); i++) {
            getItem(i).shrink(1);
        }
        getFluidContainer().internalExtract(getFluid().copyWithAmount(FluidHooks.buckets(recipe.buckets())), false);

        ItemUtils.addItem(this, 5, recipe.byProduct());
        recipe = null;
        update();
    }

    @Override
    public SimpleUpdatingFluidContainer getFluidContainer() {
        if (this.fluidContainer == null) {
            this.fluidContainer = new SimpleUpdatingFluidContainer(this, i -> FluidHooks.buckets(8D), 1, (a, b) -> true);
        }
        return this.fluidContainer;
    }

    public FluidHolder getFluid() {
        return getFluidContainer().getFluids().get(0);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, this.items);
        this.fuelTime = tag.getInt("FuelTime");
        this.cookTime = tag.getInt("CookTime");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.items);
        tag.putInt("FuelTime", this.fuelTime);
        tag.putInt("CookTime", this.cookTime);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void update() {
        if (level == null) return;
        this.recipe = level.getRecipeManager().getRecipeFor(ModRecipeTypes.ALCHEMIC_CONDENSER.get(), this, level).orElse(null);
        if (this.recipe == null) {
            this.cookTime = 0;
        } else if (!canCraft()) {
            this.recipe = null;
        }
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.UP) return INPUT_SLOTS;
        if (side == Direction.DOWN) return new int[]{4, 5};
        return new int[]{3, 4};
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        if (index == 3) {
            return itemStack.is(Items.BLAZE_POWDER);
        }
        if (index == 4) {
            return itemStack.getItem() instanceof PotionFlaskItem;
        }
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return index == 4 || index == 5;
    }

    @Override
    public void writeExtraData(ServerPlayer player, FriendlyByteBuf buffer) {
        buffer.writeBlockPos(this.getBlockPos());
    }

    @Override
    public Component getDisplayName() {
        return CommonComponents.EMPTY;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new AlchemicCondenserMenu(i, inventory, this, this.data);
    }
}
