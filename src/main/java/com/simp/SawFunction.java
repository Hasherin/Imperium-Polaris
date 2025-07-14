package com.simp;

import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import com.mojang.serialization.Codec;

public class SawFunction implements DensityFunction {
    private final DensityFunction input;

    public SawFunction(DensityFunction input) {
        this.input = input;
    }

    @Override
    public double compute(DensityFunction.FunctionContext context) {
        double value = input.compute(context);
        double wrapped = Math.IEEEremainder(value, 2.0); // wraps to (-1..1)
        return wrapped;
    }

    @Override
    public void fillArray(double[] buffer, DensityFunction.ContextProvider provider) {
        for (int i = 0; i < buffer.length; ++i) {
            double v = input.compute(provider.context(i));
            buffer[i] = Math.IEEEremainder(v, 2.0);
        }
    }

    @Override
    public DensityFunction mapAll(Visitor visitor) {
        return new SawFunction(input.mapAll(visitor));
    }

    @Override
    public Codec<? extends DensityFunction> codec() {
        return Codec.unit(() -> this); // No serialization support for now
    }

    @Override
    public DensityFunction input() {
        return input;
    }
}
