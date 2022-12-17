package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryHolder<Block> BLOCKS = new RegistryHolder<>(Registry.BLOCK, Rustic.MOD_ID);

    public static final Supplier<Block> BLACK_PAINTED_WOOD = BLOCKS.register("black_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BLACK)));
    public static final Supplier<Block> BLUE_PAINTED_WOOD = BLOCKS.register("blue_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BLUE)));
    public static final Supplier<Block> BROWN_PAINTED_WOOD = BLOCKS.register("brown_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_BROWN)));
    public static final Supplier<Block> CYAN_PAINTED_WOOD = BLOCKS.register("cyan_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_CYAN)));
    public static final Supplier<Block> GRAY_PAINTED_WOOD = BLOCKS.register("gray_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_GRAY)));
    public static final Supplier<Block> GREEN_PAINTED_WOOD = BLOCKS.register("green_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_GREEN)));
    public static final Supplier<Block> LIGHT_BLUE_PAINTED_WOOD = BLOCKS.register("light_blue_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_BLUE)));
    public static final Supplier<Block> LIGHT_GRAY_PAINTED_WOOD = BLOCKS.register("light_gray_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GRAY)));
    public static final Supplier<Block> LIME_PAINTED_WOOD = BLOCKS.register("lime_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_LIGHT_GREEN)));
    public static final Supplier<Block> MAGENTA_PAINTED_WOOD = BLOCKS.register("magenta_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_MAGENTA)));
    public static final Supplier<Block> ORANGE_PAINTED_WOOD = BLOCKS.register("orange_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_ORANGE)));
    public static final Supplier<Block> PINK_PAINTED_WOOD = BLOCKS.register("pink_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_PINK)));
    public static final Supplier<Block> PURPLE_PAINTED_WOOD = BLOCKS.register("purple_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_PURPLE)));
    public static final Supplier<Block> RED_PAINTED_WOOD = BLOCKS.register("red_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_RED)));
    public static final Supplier<Block> WHITE_PAINTED_WOOD = BLOCKS.register("white_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> YELLOW_PAINTED_WOOD = BLOCKS.register("yellow_painted_wood", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(MaterialColor.COLOR_YELLOW)));

    public static final Supplier<Block> IRONWOOD_PLANKS = BLOCKS.register("ironwood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> OLIVEWOOD_PLANKS = BLOCKS.register("olivewood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> IRONWOOD_LOG = BLOCKS.register("ironwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final Supplier<Block> OLIVEWOOD_LOG = BLOCKS.register("olivewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));


    public static void init() {
        BLOCKS.initialize();
    }
}