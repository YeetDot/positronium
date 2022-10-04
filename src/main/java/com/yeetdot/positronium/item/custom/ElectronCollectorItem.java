package com.yeetdot.positronium.item.custom;

import com.yeetdot.positronium.item.ModItems;
import com.yeetdot.positronium.sound.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ElectronCollectorItem extends Item {

    public ElectronCollectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide()){
            player.causeFoodExhaustion(0.1f);
            player.addItem(new ItemStack(ModItems.ELECTRON.get()));
            player.playSound(ModSounds.ELECTRON_OBTAINED.get(), 10f, 1f);
            player.getCooldowns().addCooldown(this,20);
        }


        return super.use(level, player, hand);
    }


}
