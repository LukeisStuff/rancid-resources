package luke.rancidresources.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.block.ItemBlock;

public class ItemBlockPork extends ItemBlock {
	public final boolean upperMetadata;

	public ItemBlockPork(Block block, boolean upperMetadata) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.upperMetadata = upperMetadata;
	}

	public int getPlacedBlockMetadata(int i) {
		return i;
	}

	public String getLanguageKey(ItemStack itemstack) {
		return this.upperMetadata ? super.getKey() + "." + BlockPork.rotStages[BlockPork.getMetadataForRot((itemstack.getMetadata() & 9) >> 3)] : super.getKey() + "." + BlockPork.rotStages[BlockPork.getMetadataForRot(itemstack.getMetadata())];
	}
}
