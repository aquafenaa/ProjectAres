package dev.aquafenaa.project_ares;

import dev.aquafenaa.project_ares.registries.AresBlocks;
import dev.aquafenaa.project_ares.registries.AresItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(ProjectAres.MODID)
public class ProjectAres {
  public static final String MODID = "project_ares";
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

  public static final RegistryObject<CreativeModeTab> ARES_TAB = CREATIVE_MODE_TABS.register("project_ares_tab",
    () -> CreativeModeTab.builder()
      .withTabsBefore(CreativeModeTabs.COMBAT)
      .icon(() -> AresItems.ANORTHITE_ORE_BLOCK_ITEM.get().getDefaultInstance())
      .displayItems((parameters, output) -> {
        output.accept(AresItems.ANORTHITE_ORE_BLOCK_ITEM.get());
      }).build());
      
  public ProjectAres(FMLJavaModLoadingContext context) {
    IEventBus modEventBus = context.getModEventBus();

    AresBlocks.register(modEventBus);
    AresItems.register(modEventBus);
    CREATIVE_MODE_TABS.register(modEventBus);

    MinecraftForge.EVENT_BUS.register(this);

    modEventBus.addListener(this::addCreative);
    context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
      event.accept(AresItems.ANORTHITE_ORE_BLOCK_ITEM);
  }
}
