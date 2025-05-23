package dev.aquafenaa.project_ares.registries;

import dev.aquafenaa.project_ares.ProjectAres;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AresItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectAres.MODID);

  // BLOCK ITEMS
  public static final RegistryObject<Item> ANORTHITE_ORE_BLOCK_ITEM = ITEMS.register("anorthite_ore",
    () -> new BlockItem(AresBlocks.ANORTHITE_ORE_BLOCK.get(), new Item.Properties()));

  // ITEMS
  public static final RegistryObject<Item> RAW_ANORTHITE = ITEMS.register("raw_anorthite",
    () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
    () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> WOUND_UP_COIL = ITEMS.register("wound_up_coil",
    () -> new Item(new Item.Properties()));
  
  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
