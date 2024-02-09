package luke.rancidresources.item;

import luke.rancidresources.block.RancidBlocks;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemBlood extends Item {
	public ItemBlood(String name, int id) {
		super(name, id);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (world.getBlockId(blockX, blockY - 1, blockZ) == RancidBlocks.pork.id) {
			world.setBlockMetadataWithNotify(blockX, blockY, blockZ, 1);
			itemstack.consumeItem(entityplayer);
			return true;
		} else {
			return false;
		}
	}
}
