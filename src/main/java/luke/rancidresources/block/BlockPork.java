package luke.rancidresources.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockPork extends Block {
	public static final String[] rotStages = new String[]{"mold", "moldy", "rotting", "pork"};

	public BlockPork(String key, int id, Material material) {
		super(key, id, material);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(this, 1, meta)};
	}

	public static int getMetadataForRot(int i) {
		return ~i & 3;
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.getBlockMetadata(x, y, z) == 0) {
			if (rand.nextInt(200) == 0) {
				world.setBlockAndMetadataWithNotify(x, y, z, this.id, 1);
			}
		}
		if (world.getBlockMetadata(x, y, z) == 1) {
			if (rand.nextInt(200) == 0) {
				world.setBlockAndMetadataWithNotify(x, y, z, this.id, 2);
			}
		}
		if (world.getBlockMetadata(x, y, z) == 2) {
			if (rand.nextInt(200) == 0) {
					world.setBlockAndMetadataWithNotify(x, y, z, this.id, 3);
			}
		}
	}

}
