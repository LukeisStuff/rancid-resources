package luke.rancidresources.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static luke.rancidresources.RancidResourcesMod.MOD_ID;

public class RancidBlocks {

	public static int blockID = 2003;

	public static Block shit;

	public static Block cum;

	public static Block pork;

	public void initializeBlockDetails() {
		for (int color = 2; color < 5; color++) {
			CreativeHelper.setParent(pork, color - 1, pork, 0);
		}
	}

	public void initializeBlocks() {


	shit = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 0.5f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("rancidresources:block/shit")
		.setTags(BlockTags.MINEABLE_BY_SHOVEL)
		.build(new BlockShit("shit", blockID++, Material.dirt));

	cum = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 1.5f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("rancidresources:block/cum")
		.setTags(BlockTags.MINEABLE_BY_SHOVEL)
		.build(new Block("cum", blockID++, Material.dirt));

	pork = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setBlockModel(BlockModelPork::new)
		.setItemBlock(block -> new ItemBlockPork(block, false))
		.setTickOnLoad()
		.setTicking(true)
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.build(new BlockPork("pork", blockID++, Material.dirt));

	}

}

