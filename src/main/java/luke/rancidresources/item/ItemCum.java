package luke.rancidresources.item;

import luke.rancidresources.block.RancidBlocks;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.world.World;

import java.util.Random;

public class ItemCum extends ItemFood {
	public final int healAmount;
	public final boolean isWolfsFavoriteMeat;
	public final int ticksPerHeal;
	public ItemCum(String name, int id, int healAmount, int ticksPerHeal, boolean favouriteWolfMeat, int maxStackSize) {
		super(name, id, healAmount, ticksPerHeal, favouriteWolfMeat, maxStackSize);
		this.healAmount = healAmount;
		this.ticksPerHeal = ticksPerHeal;
		this.isWolfsFavoriteMeat = favouriteWolfMeat;
		this.maxStackSize = maxStackSize;
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (itemstack.consumeItem(entityplayer)) {
			entityplayer.eatFood(this);
			entityplayer.playHurtSound();
			int random = new Random().nextInt(10);
			if (random == 0) {
				entityplayer.dropPlayerItem(new ItemStack(RancidBlocks.puke, 1));
				world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, entityplayer.x, entityplayer.y, entityplayer.z, "rancidresources.vomit", 0.1F, 1.0f);
			}
			if (random == 1) {
				entityplayer.dropPlayerItem(new ItemStack(RancidBlocks.puke, 2));
				world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, entityplayer.x, entityplayer.y, entityplayer.z, "rancidresources.vomit", 0.2F, 1.0f);
			}
			if (random == 2) {
				entityplayer.dropPlayerItem(new ItemStack(RancidBlocks.puke, 3));
				world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, entityplayer.x, entityplayer.y, entityplayer.z, "rancidresources.vomit", 0.3F, 1.0f);
			}
			if (random == 3) {
				entityplayer.dropPlayerItem(new ItemStack(RancidBlocks.puke, 4));
				world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, entityplayer.x, entityplayer.y, entityplayer.z, "rancidresources.vomit", 0.4F, 1.0f);
			}
			if (random == 4) {
				entityplayer.dropPlayerItem(new ItemStack(RancidBlocks.puke, 5));
				world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, entityplayer.x, entityplayer.y, entityplayer.z, "rancidresources.vomit", 0.5F, 1.0f);
			}
			if (random == 5) {
				entityplayer.dropPlayerItem(new ItemStack(RancidBlocks.puke, 6));
				world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, entityplayer.x, entityplayer.y, entityplayer.z, "rancidresources.vomit", 0.6F, 1.0f);
			}
		}
		return itemstack;
	}
}
