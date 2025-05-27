package dev.aquafenaa.project_ares.compat;

import com.lightning.northstar.world.dimension.NorthstarDimensions;
import com.lightning.northstar.world.dimension.NorthstarPlanets;
import com.petrolpark.destroy.chemistry.legacy.LegacyMixture;
import com.petrolpark.destroy.chemistry.legacy.index.DestroyMolecules;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class NorthstarPlanetCompat {
  public static LegacyMixture getPlanetAir(ResourceKey<Level> planet, float temperature) {
    int planetTemp = NorthstarPlanets.getPlanetTemp(planet);
    LegacyMixture atmosphereMixture = new LegacyMixture().setTemperature(planetTemp);

    // Default dimensions
    if (planet == Level.OVERWORLD) {
      atmosphereMixture.addMolecule(DestroyMolecules.NITROGEN, 12.147453F / temperature * 0.78084F);
      atmosphereMixture.addMolecule(DestroyMolecules.OXYGEN, 12.147453F / temperature * 0.21916F);
    } else if (planet == Level.NETHER) {
      atmosphereMixture.addMolecule(DestroyMolecules.SULFUR_DIOXIDE, 147453F / temperature * 0.95F);
    } else if (planet == Level.END) {
      atmosphereMixture.addMolecule(DestroyMolecules.NITROGEN, 12.147453F / temperature * 0.78084F);
      atmosphereMixture.addMolecule(DestroyMolecules.CARBON_DIOXIDE, 12.147453F / temperature * 0.21916F);
    }
    // Northstar dimensions
    else if (planet == NorthstarDimensions.MERCURY_DIM_KEY) {
      atmosphereMixture.addMolecule(DestroyMolecules.OXYGEN, 12.147453F / temperature * 0.42F);
      atmosphereMixture.addMolecule(DestroyMolecules.SODIUM_ION, 12.147453F / temperature * 0.29F);
      atmosphereMixture.addMolecule(DestroyMolecules.HYDROGEN, 12.147453F / temperature * 0.22F);
    } else if (planet == NorthstarDimensions.MARS_DIM_KEY) {
      atmosphereMixture.addMolecule(DestroyMolecules.CARBON_DIOXIDE, 12.147453F / temperature * 0.95F);
      atmosphereMixture.addMolecule(DestroyMolecules.NITROGEN, 12.147453F / temperature * 0.027F);
    } else if (planet == NorthstarDimensions.MOON_DIM_KEY) {
      atmosphereMixture.addMolecule(DestroyMolecules.ARGON, 12.147453F / temperature * 0.95F);
    } else if (planet == NorthstarDimensions.VENUS_DIM_KEY) {
      atmosphereMixture.addMolecule(DestroyMolecules.CARBON_DIOXIDE, 12.147453F / temperature * 0.965F);
      atmosphereMixture.addMolecule(DestroyMolecules.NITROGEN, 12.147453F / temperature * 0.035F);
    }

    return atmosphereMixture;
  }
}
