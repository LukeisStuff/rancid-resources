package luke.rancidresources.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockPork extends Block {
	int ticks;
	public BlockPork(String key, int id, Material material) {
		super(key, id, material);
		this.setTicking(true);
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		if (world.getBlockMetadata(x, y, z) == 0) {
			++this.ticks;
			if (this.ticks == 20) {
				world.setBlockAndMetadataWithNotify(x, y, z, RancidBlocks.rotting.id, 0);
				this.ticks = 0;
			}
		}
	}
}
