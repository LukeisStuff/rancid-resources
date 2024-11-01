package luke.rancidresources.block;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.stitcher.IconCoordinate;
import net.minecraft.client.render.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;

import static luke.rancidresources.RancidResourcesMod.MOD_ID;

public class BlockModelPork<T extends Block> extends BlockModelStandard<T> {
	public final IconCoordinate[] rotStageTextures = new IconCoordinate[]{
		TextureRegistry.getTexture(MOD_ID + ":block/pork"),
		TextureRegistry.getTexture(MOD_ID + ":block/pork_rotting"),
		TextureRegistry.getTexture(MOD_ID + ":block/pork_moldy"),
		TextureRegistry.getTexture(MOD_ID + ":block/mold"),
	};

	public BlockModelPork(Block block) {
		super(block);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return this.rotStageTextures[MathHelper.clamp(data, 0, 3)];
	}
}
