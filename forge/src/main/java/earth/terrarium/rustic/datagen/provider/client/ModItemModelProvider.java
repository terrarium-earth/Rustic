package earth.terrarium.rustic.datagen.provider.client;

import earth.terrarium.rustic.Rustic;
import earth.terrarium.rustic.common.items.PotionFlaskItem;
import earth.terrarium.rustic.common.registry.ModBlocks;
import earth.terrarium.rustic.common.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator pGenerator, ExistingFileHelper exFileHelper) {
        super(pGenerator, Rustic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        ModItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof BlockItem blockItem) {
                if (blockItem.getBlock() instanceof SaplingBlock) {
                    basicBlockItem(item.get());
                } else if (blockItem.getBlock() instanceof DoorBlock) {
                    basicItem(item.get());
                } else if (blockItem.getBlock() instanceof ChainBlock) {
                    basicItem(item.get());
                } else if (blockItem.getBlock() instanceof LanternBlock) {
                    basicItem(item.get());
                } else if (blockItem.getBlock() instanceof SignBlock) {
                    basicItem(item.get());
                } else if (blockItem.equals(ModItems.CLAY_DIAGONAL_CROSS_WALL.get())) {
                    blockItem(item.get(), ModBlocks.CLAY_DIAGONAL_LEFT_CROSS_WALL.get());
                }
            } else if (item.get() instanceof PotionFlaskItem) {
                flaskItem(item.get());
            } else if (!(item.get() instanceof SignItem)) {
                basicItem(item.get());
            }
        });
    }

    public ItemModelBuilder blockItem(Item block, Block parent) {
        ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(block));
        return getBuilder(id.toString())
                .parent(
                        new ModelFile.UncheckedModelFile(
                            new ResourceLocation(id.getNamespace(),
                                    "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(parent)).getPath())
                        )
                );
    }

    public ItemModelBuilder basicBlockItem(Item item) {
        return basicBlockItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    public ItemModelBuilder basicBlockItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "block/" + item.getPath()));
    }

    public ItemModelBuilder flaskItem(Item item) {
        ResourceLocation id = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));

        return getBuilder(id.toString())
            .override()
                .model(getBuilder(id + "_empty")
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", new ResourceLocation(id.getNamespace(), "item/" + id.getPath() + "_empty"))
                )
                .predicate(new ResourceLocation(Rustic.MOD_ID, "filled"), 0)
                .end()
            .parent(new ModelFile.UncheckedModelFile("item/generated"))
            .texture("layer0", new ResourceLocation(id.getNamespace(), "item/" + id.getPath()))
            .texture("layer1", new ResourceLocation(id.getNamespace(), "item/" + id.getPath() + "_overlay"));
    }
}
