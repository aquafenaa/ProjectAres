package dev.aquafenaa.project_ares.registries;

import dev.aquafenaa.project_ares.ProjectAres;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AresBlocks {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectAres.MODID);

  // ORES
  public static final RegistryObject<Block> ANORTHITE_ORE_BLOCK = BLOCKS.register("anorthite_ore",
    () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
  public static final RegistryObject<Block> DEEP_ANORTHITE_ORE_BLOCK = BLOCKS.register("deep_anorthite_ore",
    () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
