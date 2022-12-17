package earth.terrarium.rustic.common.registry;

import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> IRONWOOD_LOGS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "ironwood_logs"));
        public static final TagKey<Item> OLIVEWOOD_LOGS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "olivewood_logs"));
        public static final TagKey<Item> PAINTED_WOOD = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "painted_wood"));
    }
    public static class Blocks {
        public static final TagKey<Block> IRONWOOD_LOGS = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "ironwood_logs"));
        public static final TagKey<Block> OLIVEWOOD_LOGS = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "olivewood_logs"));
        public static final TagKey<Block> PAINTED_WOOD = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Rustic.MOD_ID, "painted_wood"));
    }
}
