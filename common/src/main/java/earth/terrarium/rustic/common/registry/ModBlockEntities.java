package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHelpers;
import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.blockentities.CrushingTubBlockEntity;
import earth.terrarium.rustic.common.blockentities.FluidBarrelBlockEntity;
import earth.terrarium.rustic.mixin.BlockEntityTypeAccessor;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class ModBlockEntities {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = ResourcefulRegistries.create(Registry.BLOCK_ENTITY_TYPE, Rustic.MOD_ID);

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(RegistryHelpers.BlockEntityFactory<E> factory, ResourcefulRegistry<Block> registry) {
        return RegistryHelpers.createBlockEntityType(factory, registry.stream().map(RegistryEntry::get).toArray(Block[]::new));
    }    public static final RegistryEntry<BlockEntityType<CrushingTubBlockEntity>> CRUSHING_TUB = BLOCK_ENTITY_TYPES.register("crushing_tub", () -> RegistryHelpers.createBlockEntityType(CrushingTubBlockEntity::new, ModBlocks.CRUSHING_TUB.get()));
    public static final RegistryEntry<BlockEntityType<FluidBarrelBlockEntity>> FLUID_BARREL = BLOCK_ENTITY_TYPES.register("fluid_barrel", () -> createBlockEntityType(FluidBarrelBlockEntity::new, ModBlocks.BARRELS));

    public static final Supplier<BlockEntityType<CrushingTubBlockEntity>> CRUSHING_TUB = BLOCK_ENTITIES.register("crushing_tub", () -> RegistryHelpers.createBlockEntityType(CrushingTubBlockEntity::new, ModBlocks.CRUSHING_TUB.get()));
    public static final Supplier<BlockEntityType<FluidBarrelBlockEntity>> FLUID_BARREL = BLOCK_ENTITIES.register("fluid_barrel", () -> RegistryHelpers.createBlockEntityType(FluidBarrelBlockEntity::new, ModBlocks.ACACIA_BARREL.get(), ModBlocks.BIRCH_BARREL.get(), ModBlocks.CRIMSON_BARREL.get(), ModBlocks.DARK_OAK_BARREL.get(), ModBlocks.IRONWOOD_BARREL.get(), ModBlocks.JUNGLE_BARREL.get(), ModBlocks.MANGROVE_BARREL.get(), ModBlocks.OAK_BARREL.get(), ModBlocks.OLIVEWOOD_BARREL.get(), ModBlocks.SPRUCE_BARREL.get(), ModBlocks.WARPED_BARREL.get()));
    public static final Supplier<BlockEntityType<AlchemicCondenserBlockEntity>> ALCHEMIC_CONDENSER = BLOCK_ENTITIES.register("alchemic_condenser", () -> RegistryHelpers.createBlockEntityType(AlchemicCondenserBlockEntity::new, ModBlocks.ALCHEMIC_CONDENSER.get(), ModBlocks.BIRCH_BARREL.get(), ModBlocks.CRIMSON_BARREL.get(), ModBlocks.DARK_OAK_BARREL.get(), ModBlocks.IRONWOOD_BARREL.get(), ModBlocks.JUNGLE_BARREL.get(), ModBlocks.MANGROVE_BARREL.get(), ModBlocks.OAK_BARREL.get(), ModBlocks.OLIVEWOOD_BARREL.get(), ModBlocks.SPRUCE_BARREL.get(), ModBlocks.WARPED_BARREL.get()));

    public static void postInit() {
        BlockEntityTypeAccessor signRegistry = ((BlockEntityTypeAccessor) BlockEntityType.SIGN);
        Set<Block> signBlocks = new HashSet<>(signRegistry.getValidBlocks());
        signBlocks.addAll(List.of(ModBlocks.IRONWOOD_SIGN.get(), ModBlocks.IRONWOOD_WALL_SIGN.get(), ModBlocks.OLIVEWOOD_SIGN.get(), ModBlocks.OLIVEWOOD_WALL_SIGN.get()));
        signRegistry.setValidBlocks(signBlocks);
    }
}