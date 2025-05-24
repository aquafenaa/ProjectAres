package dev.aquafenaa.project_ares;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AresItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectAres.MOD_ID);

  // ASSEMBLY ITEMS
  public static final RegistryObject<SequencedAssemblyItem> 
    UNFINISHED_STATOR = ITEMS.register("unfinished_stator", () -> new SequencedAssemblyItem(new Item.Properties())),
    UNFINISHED_ROTOR = ITEMS.register("unfinished_rotor", () -> new SequencedAssemblyItem(new Item.Properties()));

  // THE REST
  public static final RegistryObject<Item> 
    ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties())),
    COPPER_COIL = ITEMS.register("copper_coil", () -> new Item(new Item.Properties())),

    FINISHED_STATOR = ITEMS.register("finished_stator", () -> new Item(new Item.Properties())),
    FINISHED_ROTOR = ITEMS.register("finished_rotor", () -> new Item(new Item.Properties()));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
