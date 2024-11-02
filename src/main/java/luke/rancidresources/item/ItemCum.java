package luke.rancidresources.item;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

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
		if (entityplayer.getHealth() < entityplayer.getMaxHealth() && entityplayer.getHealth() + entityplayer.getTotalHealingRemaining() < entityplayer.getMaxHealth() && itemstack.consumeItem(entityplayer)) {
			entityplayer.eatFood(this);
			if (itemRand.nextInt(6) == 0) {
				entityplayer.dropPlayerItem(new ItemStack(RancidItems.puke, 1));
			}
		}
		return itemstack;
	}
}
