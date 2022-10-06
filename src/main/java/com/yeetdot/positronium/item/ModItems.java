package com.yeetdot.positronium.item;

import com.yeetdot.positronium.Positronium;
import com.yeetdot.positronium.item.custom.ElectronCollectorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Positronium.MOD_ID);
    public static final RegistryObject<Item> POSITRONIUM = ITEMS.register("positronium",
            () -> new Item(new Item.Properties().tab(Positronium.POSITRONIUM_TAB)));

    public static final RegistryObject<Item> ELECTRON = ITEMS.register("electron",
            () -> new Item(new Item.Properties().tab(Positronium.POSITRONIUM_TAB)));

    public static final RegistryObject<Item> POSITRON = ITEMS.register("positron",
            () -> new Item(new Item.Properties().tab(Positronium.POSITRONIUM_TAB)));

    public static final RegistryObject<Item> ELECTRON_COLLECTOR = ITEMS.register("electron_collector",
            () -> new ElectronCollectorItem(new Item.Properties().tab(Positronium.POSITRONIUM_TAB).rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
