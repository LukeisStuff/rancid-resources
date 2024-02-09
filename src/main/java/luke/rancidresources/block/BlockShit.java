package luke.rancidresources.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.sound.SoundType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockShit extends Block {
	public BlockShit(String key, int id, Material material) {
		super(key, id, material);
	}

	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		world.playSoundEffect(SoundType.WORLD_SOUNDS, (double)x + 0.5, (double)y + 0.5, (double)z + 0.5, "rancidresources.poop1", 1.0F, world.rand.nextFloat() * 0.4F + 0.8F);
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(2) == 0) {
			world.spawnParticle("shitpoof", (float)x + rand.nextFloat(), (float)y + rand.nextFloat(), (float)z + rand.nextFloat(), 0.0, 5.0, 0.0);}

	}
}
