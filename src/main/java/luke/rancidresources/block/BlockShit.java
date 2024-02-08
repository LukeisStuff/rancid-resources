package luke.rancidresources.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockShit extends Block {
	public BlockShit(String key, int id, Material material) {
		super(key, id, material);
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(2) == 0) {
			world.spawnParticle("smoke", (float)x + rand.nextFloat(), (float)y + rand.nextFloat(), (float)z + rand.nextFloat(), 0.0, 0.0, 0.0);}

	}
}
