package com.yeetdot.positronium.block;

import com.yeetdot.positronium.Positronium;
import com.yeetdot.positronium.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Positronium.MOD_ID);

    public static final RegistryObject<Block> ELECTRON_BLOCK = registerBlock("electron_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).instabreak()), Positronium.POSITRONIUM_TAB);

    public static final RegistryObject<Block> POSITRON_BLOCK = registerBlock("positron_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).instabreak()), Positronium.POSITRONIUM_TAB);

    public static final RegistryObject<Block> ELECTRIFIED_STONE = registerBlock("electrified_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), Positronium.POSITRONIUM_TAB);

    public static final RegistryObject<Block> ELECTRIFIED_DEEPSLATE = registerBlock("electrified_deepslate",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.5f).requiresCorrectToolForDrops()), Positronium.POSITRONIUM_TAB);

    public static final RegistryObject<Block> GREATER_LOOTCRATE = registerBlock("greater_lootcrate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f)), Positronium.POSITRONIUM_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
