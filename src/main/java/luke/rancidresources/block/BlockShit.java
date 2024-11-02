package luke.rancidresources.block;

import luke.rancidresources.EntityShitFX;
import net.minecraft.client.Minecraft;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockShit extends Block {
	public BlockShit(String key, int id, Material material) {
		super(key, id, material);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, x, y, z, "rancidresources.poop", 1.0F, 1.0f);
	}

	public void onBlockRemoved(World world, int x, int y, int z, int data) {
		world.playSoundEffect(null, SoundCategory.ENTITY_SOUNDS, x, y, z, "rancidresources.poop", 1.0F, 1.0f);
	}

	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		Minecraft mc = Minecraft.getMinecraft(Minecraft.class);
		if (rand.nextInt(6) == 0) {
			mc.effectRenderer.addEffect(new EntityShitFX(world, x + rand.nextFloat(), (double) y + rand.nextFloat(), z + rand.nextFloat(), 0.0, 0.0, 0.0));
		}
	}

}
