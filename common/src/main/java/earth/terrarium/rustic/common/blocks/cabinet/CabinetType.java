package earth.terrarium.rustic.common.blocks.cabinet;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;

public enum CabinetType implements StringRepresentable {
    SINGLE("single"),
    BOTTOM("bottom"),
    TOP("top");

    private final String name;

    CabinetType(String string2) {
        this.name = string2;
    }

    public String getSerializedName() {
        return this.name;
    }

    public ResourceLocation format(String namespace, String string) {
        return new ResourceLocation(namespace, string + "_" + this.name);
    }
}
