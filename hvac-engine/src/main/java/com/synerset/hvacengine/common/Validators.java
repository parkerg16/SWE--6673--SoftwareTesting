package com.synerset.hvacengine.common;

import com.synerset.hvacengine.common.exceptions.HvacEngineArgumentException;
import com.synerset.hvacengine.common.exceptions.HvacEngineMissingArgumentException;
import com.synerset.unitility.unitsystem.PhysicalQuantity;
import com.synerset.unitility.unitsystem.Unit;
import com.synerset.unitility.unitsystem.thermodynamic.Pressure;
import com.synerset.unitility.unitsystem.thermodynamic.Temperature;

import java.util.Collection;
import java.util.Objects;

public final class Validators {

    private Validators() {
    }

    public static void requireNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new HvacEngineMissingArgumentException("Argument cannot be null.");
        }
    }

    public static void requireNotEmpty(Collection<?> collection) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new HvacEngineMissingArgumentException("Collection cannot be null and not empty.");
        }
    }

    public static <K extends Unit> void requireAboveLowerBound(PhysicalQuantity<K> quantityToCheck, PhysicalQuantity<K> lowerBoundLimit) {
        if (quantityToCheck.isEqualOrLowerThan(lowerBoundLimit)) {
            throw new HvacEngineArgumentException(String.format("Lower bound limit exceeded. Actual: %s, limit: %s", quantityToCheck, lowerBoundLimit));
        }
    }

    public static <K extends Unit> void requireBelowUpperBound(PhysicalQuantity<K> quantityToCheck, PhysicalQuantity<K> upperBoundLimit) {
        if (quantityToCheck.isEqualOrGreaterThan(upperBoundLimit)) {
            throw new HvacEngineArgumentException(String.format("Upper bound limit exceeded. Actual:  %s, limit: %s", quantityToCheck, upperBoundLimit));
        }
    }

    public static <K extends Unit> void requireBetweenBounds(PhysicalQuantity<K> quantityToCheck, PhysicalQuantity<K> lowerBoundLimit, PhysicalQuantity<K> upperBoundLimit) {
        requireAboveLowerBound(quantityToCheck, lowerBoundLimit);
        requireBelowUpperBound(quantityToCheck, upperBoundLimit);
    }

    public static <K extends Unit> void requireAboveLowerBoundInclusive(PhysicalQuantity<K> quantityToCheck, PhysicalQuantity<K> lowerBoundLimit) {
        if (quantityToCheck.isLowerThan(lowerBoundLimit)) {
            throw new HvacEngineArgumentException(String.format("Lower bound limit reached or exceeded. Actual: %s, limit: %s", quantityToCheck, lowerBoundLimit));
        }
    }

    public static <K extends Unit> void requireBelowUpperBoundInclusive(PhysicalQuantity<K> quantityToCheck, PhysicalQuantity<K> upperBoundLimit) {
        if (quantityToCheck.isGreaterThan(upperBoundLimit)) {
            throw new HvacEngineArgumentException(String.format("Upper bound limit reached or exceeded: Actual: %s, limit: %s", quantityToCheck, upperBoundLimit));
        }
    }

    public static <K extends Unit> void requireBetweenBoundsInclusive(PhysicalQuantity<K> quantityToCheck, PhysicalQuantity<K> lowerBoundLimit, PhysicalQuantity<K> upperBoundLimit) {
        requireAboveLowerBoundInclusive(quantityToCheck, lowerBoundLimit);
        requireBelowUpperBoundInclusive(quantityToCheck, upperBoundLimit);
    }

    public static void requireValidSaturationPressure(Pressure saturationPressure, Pressure humidAirAbsolutePressure, Temperature temperature) {
        if (saturationPressure.isEqualOrGreaterThan(humidAirAbsolutePressure)) {
            throw new HvacEngineArgumentException(
                    String.format("Water vapour saturation pressure exceeds humid air absolute pressure. Calculations are not possible. " +
                                    " Psat=%s, Pabs=%s, Temp=%s. Increase pressure or change input data.",
                            saturationPressure, humidAirAbsolutePressure, temperature));
        }
    }

}