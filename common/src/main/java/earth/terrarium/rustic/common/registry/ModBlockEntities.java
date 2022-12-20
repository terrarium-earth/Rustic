package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHelpers;
import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.blockentities.CrushingTubBlockEntity;
import earth.terrarium.rustic.common.blockentities.FluidBarrelBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final RegistryHolder<BlockEntityType<?>> BLOCK_ENTITIES = new RegistryHolder<>(Registry.BLOCK_ENTITY_TYPE, Rustic.MOD_ID);

    public static final Supplier<BlockEntityType<CrushingTubBlockEntity>> CRUSHING_TUB = BLOCK_ENTITIES.register("crushing_tub", () -> RegistryHelpers.createBlockEntityType(CrushingTubBlockEntity::new, ModBlocks.CRUSHING_TUB.get()));
    public static final Supplier<BlockEntityType<FluidBarrelBlockEntity>> FLUID_BARREL = BLOCK_ENTITIES.register("fluid_barrel", () -> RegistryHelpers.createBlockEntityType(FluidBarrelBlockEntity::new, ModBlocks.ACACIA_BARREL.get(), ModBlocks.BIRCH_BARREL.get(), ModBlocks.CRIMSON_BARREL.get(), ModBlocks.DARK_OAK_BARREL.get(), ModBlocks.IRONWOOD_BARREL.get(), ModBlocks.JUNGLE_BARREL.get(), ModBlocks.MANGROVE_BARREL.get(), ModBlocks.OAK_BARREL.get(), ModBlocks.OLIVEWOOD_BARREL.get(), ModBlocks.SPRUCE_BARREL.get(), ModBlocks.WARPED_BARREL.get()));

    public static void init() {
        BLOCK_ENTITIES.initialize();
    }
}