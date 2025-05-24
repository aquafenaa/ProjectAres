package dev.aquafenaa.project_ares;

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

@Mod(ProjectAres.MOD_ID)
public class ProjectAres {
  public static final String MOD_ID = "project_ares";
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
  
  public static final RegistryObject<CreativeModeTab> ARES_TAB = CREATIVE_MODE_TABS.register("project_ares_tab",
    () -> CreativeModeTab.builder()
      .withTabsBefore(CreativeModeTabs.COMBAT)
      .icon(() -> AresItems.ALUMINUM_INGOT.get().getDefaultInstance())
      .displayItems((parameters, output) -> {
        output.accept(AresItems.ALUMINUM_INGOT.get());
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
    if (event.getTabKey() == ARES_TAB.getKey()) {
      event.accept(AresItems.ALUMINUM_INGOT);
      event.accept(AresItems.COPPER_COIL);
      event.accept(AresItems.UNFINISHED_STATOR);
      event.accept(AresItems.FINISHED_STATOR);
      event.accept(AresItems.UNFINISHED_ROTOR);
      event.accept(AresItems.FINISHED_ROTOR);
    }
  }
}
