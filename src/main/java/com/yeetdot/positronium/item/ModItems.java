package com.yeetdot.positronium.item;

import com.yeetdot.positronium.Positronium;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Positronium.MOD_ID);
    public static final RegistryObject<Item> POSITRONIUM = ITEMS.register("positronium",
            () -> new Item(new Item.Properties().tab(Positronium.POSITRONIUM_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
