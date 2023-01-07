package earth.terrarium.rustic.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.blockentities.AlchemicCondenserBlockEntity;
import earth.terrarium.rustic.common.blockentities.CrushingTubBlockEntity;
import earth.terrarium.rustic.common.blockentities.FluidBarrelBlockEntity;
import earth.terrarium.rustic.common.blocks.sign.CustomSignBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;

public class ModBlockEntities {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = ResourcefulRegistries.create(Registry.BLOCK_ENTITY_TYPE, Rustic.MOD_ID);

    public static final RegistryEntry<BlockEntityType<SignBlockEntity>> SIGN = BLOCK_ENTITY_TYPES.register("sign", () -> createBlockEntityType(CustomSignBlockEntity::new, ModBlocks.SIGNS));    public static final RegistryEntry<BlockEntityType<CrushingTubBlockEntity>> CRUSHING_TUB = BLOCK_ENTITY_TYPES.register("crushing_tub", () -> createBlockEntityType(CrushingTubBlockEntity::new, ModBlocks.CRUSHING_TUB.get()));
    public static final RegistryEntry<BlockEntityType<FluidBarrelBlockEntity>> FLUID_BARREL = BLOCK_ENTITY_TYPES.register("fluid_barrel", () -> createBlockEntityType(FluidBarrelBlockEntity::new, ModBlocks.BARRELS));

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityType.BlockEntitySupplier<E> factory, Block... blocks) {
        return BlockEntityType.Builder.of(factory, blocks).build(null);
    }    public static final RegistryEntry<BlockEntityType<AlchemicCondenserBlockEntity>> ALCHEMIC_CONDENSER = BLOCK_ENTITY_TYPES.register("alchemic_condenser", () -> createBlockEntityType(AlchemicCondenserBlockEntity::new, ModBlocks.ALCHEMIC_CONDENSER.get()));

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityType.BlockEntitySupplier<E> factory, ResourcefulRegistry<Block> registry) {
        return BlockEntityType.Builder.of(factory, registry.stream().map(RegistryEntry::get).toArray(Block[]::new)).build(null);
    }




}