package earth.terrarium.rustic.common.blocks.candle;

import com.google.common.base.Suppliers;
import earth.terrarium.rustic.Rustic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Supplier;

public enum CandleColor implements StringRepresentable {
    NONE("none", () -> null),
    NORMAL("normal", () -> Blocks.CANDLE),
    WHITE("white", () -> Blocks.WHITE_CANDLE),
    ORANGE("orange", () -> Blocks.ORANGE_CANDLE),
    MAGENTA("magenta", () -> Blocks.MAGENTA_CANDLE),
    LIGHT_BLUE("light_blue", () -> Blocks.LIGHT_BLUE_CANDLE),
    YELLOW("yellow", () -> Blocks.YELLOW_CANDLE),
    LIME("lime", () -> Blocks.LIME_CANDLE),
    PINK("pink", () -> Blocks.PINK_CANDLE),
    GRAY("gray", () -> Blocks.GRAY_CANDLE),
    LIGHT_GRAY("light_gray", () -> Blocks.LIGHT_GRAY_CANDLE),
    CYAN("cyan", () -> Blocks.CYAN_CANDLE),
    PURPLE("purple", () -> Blocks.PURPLE_CANDLE),
    BLUE("blue", () -> Blocks.BLUE_CANDLE),
    BROWN("brown", () -> Blocks.BROWN_CANDLE),
    GREEN("green", () -> Blocks.GREEN_CANDLE),
    RED("red", () -> Blocks.RED_CANDLE),
    BLACK("black", () -> Blocks.BLACK_CANDLE);

    private static final Supplier<Map<Block, CandleColor>> LOOK_UP = Suppliers.memoize(() -> {
        IdentityHashMap<Block, CandleColor> builder = new IdentityHashMap<>();
        for (CandleColor color : values()) {
            Block candle = color.block.get();
            if (candle != null) {
                builder.put(candle, color);
            }
        }
        return builder;
    });

    private final String name;
    private final Supplier<Block> block;

    CandleColor(String name, Supplier<Block> block) {
        this.name = name;
        this.block = block;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public Block getBlock() {
        return this.block.get();
    }

    @Nullable
    public static CandleColor fromBlock(Block block) {
        return LOOK_UP.get().getOrDefault(block, null);
    }

    public ResourceLocation format(String string) {
        if (this == NONE) {
            return new ResourceLocation(Rustic.MOD_ID, "empty");
        }
        final String suffix = string.isEmpty() ? "" : "_" + string;
        if (this == NORMAL) {
            return new ResourceLocation("candle" + suffix);
        }
        return new ResourceLocation(this.name + "_candle" + suffix);
    }
}
