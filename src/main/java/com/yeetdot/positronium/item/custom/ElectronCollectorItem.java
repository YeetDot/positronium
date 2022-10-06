package com.yeetdot.positronium.item.custom;

import com.yeetdot.positronium.item.ModItems;
import com.yeetdot.positronium.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElectronCollectorItem extends Item {

    public ElectronCollectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            player.causeFoodExhaustion(0.1f);
            player.addItem(new ItemStack(ModItems.ELECTRON.get()));
            level.playSound(null, player.getOnPos(), SoundEvents.ITEM_PICKUP,SoundSource.PLAYERS, 100f, level.random.nextFloat()*1f + 0.9f);
            player.getCooldowns().addCooldown(this, 20);

        }


        return super.use(level, player, hand);
    }



    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.literal("Right click to get an electron item.").withStyle(ChatFormatting.GREEN));
            components.add(Component.literal("If clicking is too annoying for you, craft the Electron Harvesting Machine").withStyle(ChatFormatting.GREEN));
        } else if (Screen.hasControlDown()) {
            components.add(Component.literal("Production speed: 1/s").withStyle(ChatFormatting.DARK_GREEN));
        } else {
            components.add(Component.literal("§aPress §bShift §afor more info"));
            components.add(Component.literal("§2Press §1CTRL §2for stats"));
        }

        super.appendHoverText(itemStack, level, components, flag);
    }
}
