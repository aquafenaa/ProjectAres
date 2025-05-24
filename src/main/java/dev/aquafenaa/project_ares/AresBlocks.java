package dev.aquafenaa.project_ares;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AresBlocks {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectAres.MOD_ID);

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
