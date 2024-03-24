package luke.rancidresources.block;

import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import turniplabs.halplibe.helper.BlockBuilder;

import static luke.rancidresources.RancidResources.MOD_ID;

public class RancidBlocks {

	private static int blockID = 2003;
	

	public static final Block shit = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 0.5f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("Shit.png")
		.setTags(BlockTags.MINEABLE_BY_SHOVEL)
		.build(new BlockShit("shit", blockID++, Material.dirt));

	public static final Block cum = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 1.5f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("Cum.png")
		.setTags(BlockTags.MINEABLE_BY_SHOVEL)
		.build(new Block("cum", blockID++, Material.dirt));

	public static final Block pork = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("Pork.png")
		.setTickOnLoad()
		.setTicking(true)
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.build(new BlockPork("pork", blockID++, Material.dirt));

	public static final Block rotting = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 0.9f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("RottingPork.png")
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.build(new BlockPorkRot("rot", blockID++, Material.dirt));

	public static final Block moldy = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 0.8f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("MoldyPork.png")
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.build(new BlockPorkMold("molding", blockID++, Material.dirt));

	public static final Block mold = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 0.7f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("Mold.png")
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.build(new Block("mold", blockID++, Material.dirt));

	public void initializeBlocks() {
	}
}

