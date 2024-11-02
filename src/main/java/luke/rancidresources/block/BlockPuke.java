package luke.rancidresources.block;

import net.minecraft.core.block.BlockLayerBase;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.world.World;

public class BlockPuke extends BlockLayerBase {
	public BlockPuke(String key, int id, Material material) {
		super(key, id, material);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, x, y, z, "rancidresources.puke", 0.6F, 1.0f);
	}

	public void onBlockRemoved(World world, int x, int y, int z, int data) {
		world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, x, y, z, "rancidresources.puke", 0.6F, 1.0f);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK: {
				return new ItemStack[]{new ItemStack(this)};
			}
			case SILK_TOUCH:
			case EXPLOSION:
			case IMPROPER_TOOL:
			case PROPER_TOOL: {
				return new ItemStack[]{new ItemStack(this, meta + 1)};
			}
		}
		return null;
	}
}
