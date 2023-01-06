package earth.terrarium.rustic.datagen.provider.server;

import com.mojang.datafixers.util.Pair;
import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.registry.ModBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ModLootTableProvider extends LootTableProvider {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    public ModLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = new ArrayList<>();
        tables.add(Pair.of(BlockLootTables::new, LootContextParamSets.BLOCK));
        return tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
    }


    public static class BlockLootTables extends BlockLoot {
        @Override
        protected void addTables() {
            for (Supplier<Block> b : ModBlocks.BLOCKS.getEntries()) {
                if (b.get() instanceof LeavesBlock) {
                } else if (b.get() instanceof SlabBlock) {
                    this.add(b.get(), createSlabItemTable(b.get()));
                } else if (b.get() instanceof DoorBlock) {
                    this.add(b.get(), createDoorTable(b.get()));
                } else {
                    dropSelf(b.get());
                }
            }

            this.add(ModBlocks.IRONWOOD_LEAVES.get(), (arg) -> createLeavesDrops(arg, ModBlocks.IRONWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
            this.add(ModBlocks.OLIVEWOOD_LEAVES.get(), (arg) -> createLeavesDrops(arg, ModBlocks.OLIVEWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(b -> ForgeRegistries.BLOCKS.getKey(b).getNamespace().equals(Rustic.MOD_ID)).toList();
        }
    }
}
