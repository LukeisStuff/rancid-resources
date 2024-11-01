package luke.rancidresources.item;

import luke.rancidresources.block.RancidBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemBlood extends Item {
	public ItemBlood(String name, int id) {
		super(name, id);
	}

	public boolean onUseItemOnBlock(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		int blockToScrape = world.getBlockId(blockX, blockY, blockZ);
		int meta = world.getBlockMetadata(blockX, blockY, blockZ);

		//COPPER BLOCK
		if (blockToScrape == RancidBlocks.pork.id) {
			if (meta > 0) {
				Block scrapedBlock = RancidBlocks.pork;
				world.playBlockSoundEffect(null, (float) blockX + 0.5f, (float) blockY + 0.5f, (float) blockZ + 0.5f, scrapedBlock, EnumBlockSoundEffectType.MINE);
				if (!world.isClientSide) {
					world.setBlockAndMetadataWithNotify(blockX, blockY, blockZ, scrapedBlock.id, meta - 1);
					itemstack.damageItem(1, entityplayer);
				}
			}
			entityplayer.swingItem();
		}
        return false;
    }

}
