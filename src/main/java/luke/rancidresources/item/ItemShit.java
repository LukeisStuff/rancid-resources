package luke.rancidresources.item;

import luke.rancidresources.entity.EntityShit;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemShit extends Item {
	public ItemShit(String name, int id) {
		super(name, id);
		this.maxStackSize = 64;
	}

	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		itemstack.consumeItem(entityplayer);
		world.playSoundAtEntity(entityplayer, entityplayer, "rancidresources.poop", 0.5F, 1.0F);
		if (!world.isClientSide) {
			world.entityJoinedWorld(new EntityShit(world, entityplayer));
		}
		return itemstack;
	}
}
