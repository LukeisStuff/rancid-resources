package luke.rancidresources.block;

import net.minecraft.client.render.block.model.BlockModelLayer;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockLayer;
import net.minecraft.core.sound.BlockSound;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.CreativeHelper;

import static luke.rancidresources.RancidResourcesMod.MOD_ID;

public class RancidBlocks {

	public static int blockID = 2003;

	public static Block shit;

	public static Block cum;

	public static Block pork;

	public static Block puke;

	public void initializeBlockDetails() {
		for (int color = 2; color < 5; color++) {
			CreativeHelper.setParent(pork, color - 1, pork, 0);
		}
	}

	public void initializeBlocks() {


	shit = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.gravel", "step.gravel", 0.1f, 0.0f))
		.setHardness(0.6f)
		.setResistance(0.6f)
		.setTextures("rancidresources:block/shit")
		.setBlockModel((block) -> {
			TextureRegistry.getTexture(MOD_ID + ":block/fly");
			return new BlockModelStandard<>(block);
		})
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

	puke = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("", "", 0.1f, 1.0f))
		.setHardness(0.3f)
		.setResistance(0.2f)
		.setBlockModel(BlockModelLayer::new)
		.setItemBlock(ItemBlockLayer::new)
		.setTextures("rancidresources:block/puke")
		.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.MINEABLE_BY_SHOVEL)
		.build(new BlockPuke("puke", blockID++, Material.dirt).setFullBlockID(() -> puke.id));

	}

}

