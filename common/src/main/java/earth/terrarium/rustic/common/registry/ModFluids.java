package earth.terrarium.rustic.common.registry;

import earth.terrarium.botarium.api.registry.RegistryHolder;
import earth.terrarium.botarium.api.registry.fluid.BotariumFlowingFluid;
import earth.terrarium.botarium.api.registry.fluid.BotariumSourceFluid;
import earth.terrarium.rustic.Rustic;
import net.minecraft.core.Registry;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class ModFluids {
    public static final RegistryHolder<Fluid> FLUIDS = new RegistryHolder<>(Registry.FLUID, Rustic.MOD_ID);

    public static final Supplier<FlowingFluid> SWEET_BERRY_JUICE = FLUIDS.register("sweet_berry_juice", () -> new BotariumSourceFluid(ModFluidProperties.SWEET_BERRY_JUICE));
    public static final Supplier<FlowingFluid> FLOWING_SWEET_BERRY_JUICE = FLUIDS.register("flowing_sweet_berry_juice", () -> new BotariumFlowingFluid(ModFluidProperties.SWEET_BERRY_JUICE));

    public static final Supplier<FlowingFluid> SWEET_BERRY_WINE = FLUIDS.register("sweet_berry_wine", () -> new BotariumSourceFluid(ModFluidProperties.SWEET_BERRY_WINE));
    public static final Supplier<FlowingFluid> FLOWING_SWEET_BERRY_WINE = FLUIDS.register("flowing_sweet_berry_wine", () -> new BotariumFlowingFluid(ModFluidProperties.SWEET_BERRY_WINE));

    public static final Supplier<FlowingFluid> SUGAR_WATER = FLUIDS.register("sugar_water", () -> new BotariumSourceFluid(ModFluidProperties.SUGAR_WATER));
    public static final Supplier<FlowingFluid> FLOWING_SUGAR_WATER = FLUIDS.register("flowing_sugar_water", () -> new BotariumFlowingFluid(ModFluidProperties.SUGAR_WATER));

    public static final Supplier<FlowingFluid> IRON_BERRY_JUICE = FLUIDS.register("iron_berry_juice", () -> new BotariumSourceFluid(ModFluidProperties.IRON_BERRY_JUICE));
    public static final Supplier<FlowingFluid> FLOWING_IRON_BERRY_JUICE = FLUIDS.register("flowing_iron_berry_juice", () -> new BotariumFlowingFluid(ModFluidProperties.IRON_BERRY_JUICE));

    public static final Supplier<FlowingFluid> IRON_BERRY_WINE = FLUIDS.register("iron_berry_wine", () -> new BotariumSourceFluid(ModFluidProperties.IRON_BERRY_WINE));
    public static final Supplier<FlowingFluid> FLOWING_IRON_BERRY_WINE = FLUIDS.register("flowing_iron_berry_wine", () -> new BotariumFlowingFluid(ModFluidProperties.IRON_BERRY_WINE));

    public static final Supplier<FlowingFluid> GRAPE_JUICE = FLUIDS.register("grape_juice", () -> new BotariumSourceFluid(ModFluidProperties.GRAPE_JUICE));
    public static final Supplier<FlowingFluid> FLOWING_GRAPE_JUICE = FLUIDS.register("flowing_grape_juice", () -> new BotariumFlowingFluid(ModFluidProperties.GRAPE_JUICE));

    public static final Supplier<FlowingFluid> RED_WINE = FLUIDS.register("red_wine", () -> new BotariumSourceFluid(ModFluidProperties.RED_WINE));
    public static final Supplier<FlowingFluid> FLOWING_RED_WINE = FLUIDS.register("flowing_red_wine", () -> new BotariumFlowingFluid(ModFluidProperties.RED_WINE));

    public static final Supplier<FlowingFluid> APPLE_JUICE = FLUIDS.register("apple_juice", () -> new BotariumSourceFluid(ModFluidProperties.APPLE_JUICE));
    public static final Supplier<FlowingFluid> FLOWING_APPLE_JUICE = FLUIDS.register("flowing_apple_juice", () -> new BotariumFlowingFluid(ModFluidProperties.APPLE_JUICE));

    public static final Supplier<FlowingFluid> OLIVE_OIL = FLUIDS.register("olive_oil", () -> new BotariumSourceFluid(ModFluidProperties.OLIVE_OIL));
    public static final Supplier<FlowingFluid> FLOWING_OLIVE_OIL = FLUIDS.register("flowing_olive_oil", () -> new BotariumFlowingFluid(ModFluidProperties.OLIVE_OIL));

    public static final Supplier<FlowingFluid> HONEY = FLUIDS.register("honey", () -> new BotariumSourceFluid(ModFluidProperties.HONEY));
    public static final Supplier<FlowingFluid> FLOWING_HONEY = FLUIDS.register("flowing_honey", () -> new BotariumFlowingFluid(ModFluidProperties.HONEY));

    public static final Supplier<FlowingFluid> CIDER = FLUIDS.register("cider", () -> new BotariumSourceFluid(ModFluidProperties.CIDER));
    public static final Supplier<FlowingFluid> FLOWING_CIDER = FLUIDS.register("flowing_cider", () -> new BotariumFlowingFluid(ModFluidProperties.CIDER));

    public static final Supplier<FlowingFluid> RUM = FLUIDS.register("rum", () -> new BotariumSourceFluid(ModFluidProperties.RUM));
    public static final Supplier<FlowingFluid> FLOWING_RUM = FLUIDS.register("flowing_rum", () -> new BotariumFlowingFluid(ModFluidProperties.RUM));

    public static final Supplier<FlowingFluid> STARCHY_WATER = FLUIDS.register("starchy_water", () -> new BotariumSourceFluid(ModFluidProperties.STARCHY_WATER));
    public static final Supplier<FlowingFluid> FLOWING_STARCHY_WATER = FLUIDS.register("flowing_starchy_water", () -> new BotariumFlowingFluid(ModFluidProperties.STARCHY_WATER));

    public static final Supplier<FlowingFluid> ALE = FLUIDS.register("ale", () -> new BotariumSourceFluid(ModFluidProperties.ALE));
    public static final Supplier<FlowingFluid> FLOWING_ALE = FLUIDS.register("flowing_ale", () -> new BotariumFlowingFluid(ModFluidProperties.ALE));

    public static final Supplier<FlowingFluid> MEAD = FLUIDS.register("mead", () -> new BotariumSourceFluid(ModFluidProperties.MEAD));
    public static final Supplier<FlowingFluid> FLOWING_MEAD = FLUIDS.register("flowing_mead", () -> new BotariumFlowingFluid(ModFluidProperties.MEAD));

    public static final Supplier<FlowingFluid> VODKA = FLUIDS.register("vodka", () -> new BotariumSourceFluid(ModFluidProperties.VODKA));
    public static final Supplier<FlowingFluid> FLOWING_VODKA = FLUIDS.register("flowing_vodka", () -> new BotariumFlowingFluid(ModFluidProperties.VODKA));

    public static final Supplier<FlowingFluid> WHISKEY = FLUIDS.register("whiskey", () -> new BotariumSourceFluid(ModFluidProperties.WHISKEY));
    public static final Supplier<FlowingFluid> FLOWING_WHISKEY = FLUIDS.register("flowing_whiskey", () -> new BotariumFlowingFluid(ModFluidProperties.WHISKEY));

    public static final Supplier<FlowingFluid> TOMATO_JUICE = FLUIDS.register("tomato_juice", () -> new BotariumSourceFluid(ModFluidProperties.TOMATO_JUICE));
    public static final Supplier<FlowingFluid> FLOWING_TOMATO_JUICE = FLUIDS.register("flowing_tomato_juice", () -> new BotariumFlowingFluid(ModFluidProperties.TOMATO_JUICE));
}