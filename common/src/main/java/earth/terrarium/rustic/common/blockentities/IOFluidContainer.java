package earth.terrarium.rustic.common.blockentities;

import earth.terrarium.botarium.api.Updatable;
import earth.terrarium.botarium.api.fluid.*;
import net.minecraft.nbt.CompoundTag;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class IOFluidContainer implements UpdatingFluidContainer<Updatable> {

    public final InsertOnlyUpdatingFluidContainer input;
    public final ExtractOnlyUpdatingFluidContainer output;
    private final Updatable updatable;

    public IOFluidContainer(Updatable updatable, long capacity, BiPredicate<Integer, FluidHolder> inputFilter, BiPredicate<Integer, FluidHolder> outputFilter) {
        this.input = new InsertOnlyUpdatingFluidContainer(updatable, (i) -> capacity,1, inputFilter);
        this.output = new ExtractOnlyUpdatingFluidContainer(updatable, (i) -> capacity, 1, outputFilter);
        this.updatable = updatable;
    }

    @Override
    public void update(Updatable updatable) {
        updatable.update();
    }

    @Override
    public long insertFluid(FluidHolder fluid, boolean simulate) {
        return input.insertFluid(fluid, simulate);
    }

    @Override
    public FluidHolder extractFluid(FluidHolder fluid, boolean simulate) {
        return output.extractFluid(fluid, simulate);
    }

    @Override
    public void setFluid(int slot, FluidHolder fluid) {
        if (slot == 0) {
            input.setFluid(0, fluid);
        } else {
            output.setFluid(0, fluid);
        }
    }

    @Override
    public List<FluidHolder> getFluids() {
        List<FluidHolder> holders = new ArrayList<>();
        holders.addAll(input.getFluids());
        holders.addAll(output.getFluids());
        return holders;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    @Override
    public FluidContainer copy() {
        IOFluidContainer container = new IOFluidContainer(updatable, input.maxAmount.applyAsLong(0), input.fluidFilter, output.fluidFilter);
        container.input.setFluid(0, input.getFluids().get(0).copyHolder());
        container.output.setFluid(0, output.getFluids().get(0).copyHolder());
        return container;
    }

    @Override
    public long getTankCapacity(int tankSlot) {
        if (tankSlot == 0) {
            return input.getTankCapacity(0);
        } else {
            return output.getTankCapacity(0);
        }
    }

    @Override
    public void fromContainer(FluidContainer container) {
        if (container instanceof IOFluidContainer ioFluidContainer) {
            input.setFluid(0, ioFluidContainer.input.getFluids().get(0).copyHolder());
            output.setFluid(0, ioFluidContainer.output.getFluids().get(0).copyHolder());
        }
    }

    @Override
    public long extractFromSlot(FluidHolder fluidHolder, FluidHolder toInsert, Runnable snapshot) {
        return output.extractFromSlot(fluidHolder, toInsert, snapshot);
    }

    @Override
    public boolean allowsInsertion() {
        return true;
    }

    @Override
    public boolean allowsExtraction() {
        return true;
    }

    @Override
    public FluidSnapshot createSnapshot() {
        return new IOFluidSnapshot(input.createSnapshot(), output.createSnapshot());
    }

    @Override
    public void deserialize(CompoundTag nbt) {
        input.deserialize(nbt.getCompound("InputTank"));
        output.deserialize(nbt.getCompound("OutputTank"));
    }

    @Override
    public CompoundTag serialize(CompoundTag nbt) {
        nbt.put("InputTank", input.serialize(new CompoundTag()));
        nbt.put("OutputTank", output.serialize(new CompoundTag()));
        return nbt;
    }

    public static class IOFluidSnapshot implements FluidSnapshot {
        private final FluidSnapshot input;
        private final FluidSnapshot output;

        public IOFluidSnapshot(FluidSnapshot input, FluidSnapshot output) {
            this.input = input;
            this.output = output;
        }

        @Override
        public void loadSnapshot(FluidContainer container) {
            if (container instanceof IOFluidContainer ioFluidContainer) {
                input.loadSnapshot(ioFluidContainer.input);
                output.loadSnapshot(ioFluidContainer.output);
            }
        }
    }
}
