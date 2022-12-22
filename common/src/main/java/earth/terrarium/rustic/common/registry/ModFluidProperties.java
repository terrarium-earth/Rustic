package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.fluid.FluidData;
import earth.terrarium.botarium.api.registry.fluid.FluidProperties;
import earth.terrarium.botarium.api.registry.fluid.FluidRegistry;
import earth.terrarium.rustic.Rustic;
import net.minecraft.resources.ResourceLocation;

public class ModFluidProperties {
    public static final FluidRegistry FLUID_PROPERTIES = new FluidRegistry(Rustic.MOD_ID);

    public static final FluidData SWEET_BERRY_JUICE = FLUID_PROPERTIES.register("sweet_berry_juice", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0x992c3e)
            .canConvertToSource(false));

    public static final FluidData SWEET_BERRY_WINE = FLUID_PROPERTIES.register("sweet_berry_wine", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0x75123d)
            .canConvertToSource(false));

    public static final FluidData SUGAR_WATER = FLUID_PROPERTIES.register("sugar_water", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xe6c3ac)
            .canConvertToSource(false));

    public static final FluidData IRON_BERRY_JUICE = FLUID_PROPERTIES.register("iron_berry_juice", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xada599)
            .canConvertToSource(false));

    public static final FluidData IRON_BERRY_WINE = FLUID_PROPERTIES.register("iron_berry_wine", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xd9ba91)
            .canConvertToSource(false));

    public static final FluidData GRAPE_JUICE = FLUID_PROPERTIES.register("grape_juice", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0x8a3d6c)
            .canConvertToSource(false));

    public static final FluidData RED_WINE = FLUID_PROPERTIES.register("red_wine", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0x941c60)
            .canConvertToSource(false));

    public static final FluidData APPLE_JUICE = FLUID_PROPERTIES.register("apple_juice", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xdba25c)
            .canConvertToSource(false));

    public static final FluidData OLIVE_OIL = FLUID_PROPERTIES.register("olive_oil", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xb8b35e)
            .canConvertToSource(false));

    public static final FluidData HONEY = FLUID_PROPERTIES.register("honey", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xF9D354)
            .canConvertToSource(false));

    public static final FluidData CIDER = FLUID_PROPERTIES.register("cider", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xdba25c)
            .canConvertToSource(false));

    public static final FluidData RUM = FLUID_PROPERTIES.register("rum", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0x823404)
            .canConvertToSource(false));

    public static final FluidData STARCHY_WATER = FLUID_PROPERTIES.register("starchy_water", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xa8a592)
            .canConvertToSource(false));

    public static final FluidData ALE = FLUID_PROPERTIES.register("ale", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0x8a330b)
            .canConvertToSource(false));

    public static final FluidData MEAD = FLUID_PROPERTIES.register("mead", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xf5ca56)
            .canConvertToSource(false));

    public static final FluidData VODKA = FLUID_PROPERTIES.register("vodka", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xf7f6f2)
            .canConvertToSource(false));

    public static final FluidData WHISKEY = FLUID_PROPERTIES.register("whiskey", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xbd6637)
            .canConvertToSource(false));

    public static final FluidData TOMATO_JUICE = FLUID_PROPERTIES.register("tomato_juice", FluidProperties.create()
            .still(new ResourceLocation("minecraft:block/water_still"))
            .flowing(new ResourceLocation("minecraft:block/water_flow"))
            .overlay(new ResourceLocation("minecraft:block/water_overlay"))
            .screenOverlay(new ResourceLocation("textures/misc/underwater.png"))
            .viscosity(1000)
            .density(1000)
            .tintColor(0xd64f33)
            .canConvertToSource(false));
}
