package dev.aquafenaa.project_ares.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.petrolpark.destroy.chemistry.minecraft.MixtureFluid;
import com.petrolpark.destroy.core.chemistry.vat.VatFluidTankBehaviour;

import dev.aquafenaa.project_ares.compat.NorthstarPlanetCompat;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;

// This is disgusting. I will probably fix this before launch
@SuppressWarnings("null")
@Mixin(VatFluidTankBehaviour.class)
public abstract class VatAtmosphereMixin {
  private VatFluidTankBehaviour self() {
    return (VatFluidTankBehaviour) (Object) this;
  }

  @Shadow
  protected int vatCapacity;

  @Shadow
  public VatFluidTankBehaviour.VatTankSegment.VatFluidTank getGasHandler() {
    return self().getGasTank().getTank();
  }

  /**
   * Overwrites the flush method to fill the air in the tank with the proper atmosphere compositions with respect to the planets
   * This is very disgusting! Expected to fix before release... Or if not, hi other dev :3
   * 
   * @author aquafenaa
   * @reason Northstar Compat
   */
  @Overwrite(remap = false)
  public FluidStack flush(float temperature) {
    ResourceKey<Level> dimension = self().blockEntity.getLevel().dimension();

    FluidStack oldGas = getGasHandler().getFluid();
    getGasHandler().setFluid(MixtureFluid.of(
      vatCapacity - self().getLiquidHandler().getFluidAmount(), 
      NorthstarPlanetCompat.getPlanetAir(dimension, temperature), String.format("fluid.project_ares.%s_air", dimension.toString())
    ));

    /* 
     * Stupid error with Mixins, Subclasses, and. First ever use for Copilot 
     *  
     * Functional code:
     * this.getGasHandler().flushed = true;
    */
    try {
      java.lang.reflect.Field flushedField = getGasHandler().getClass().getDeclaredField("flushed");
      flushedField.setAccessible(true);
      flushedField.setBoolean(getGasHandler(), true);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace(); // This should not error, but if it does, the feature isn't that important.
    }

    return oldGas;
  }
}
