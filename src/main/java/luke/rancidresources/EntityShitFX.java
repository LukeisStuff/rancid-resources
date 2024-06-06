package luke.rancidresources;

import net.minecraft.client.entity.fx.EntityFX;
import net.minecraft.client.render.Tessellator;
import net.minecraft.core.Global;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

import static luke.rancidresources.RancidResources.MOD_ID;

public class EntityShitFX extends EntityFX {
	private static final int shit = TextureHelper.getOrCreateItemTextureIndex(MOD_ID, "ShitItem.png");


	public EntityShitFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(world, x, y, z, motionX, motionY, motionZ);
		float var14 = this.random.nextFloat() * 0.1F + 0.2F;
		this.particleRed = var14;
		this.particleGreen = var14;
		this.particleBlue = var14;
		this.particleTextureIndex = shit;
		this.setSize(0.02F, 0.02F);
		this.particleScale *= this.random.nextFloat() * 0.6F + 0.5F;
		this.xd *= 1.00F;
		this.yd *= 0.20F;
		this.zd *= 1.00F;
		this.particleMaxAge = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
		this.collision = false;
	}

	public void renderParticle(Tessellator t, float partialTick, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY) {
		float f6 = ((float)(this.particleTextureIndex % Global.TEXTURE_ATLAS_WIDTH_TILES) + this.particleTextureJitterX / 4.0F) / (float)Global.TEXTURE_ATLAS_WIDTH_TILES;
		float f7 = f6 + 0.25F / (float)Global.TEXTURE_ATLAS_WIDTH_TILES;
		float f8 = ((float)(this.particleTextureIndex / Global.TEXTURE_ATLAS_WIDTH_TILES) + this.particleTextureJitterY / 4.0F) / (float)Global.TEXTURE_ATLAS_WIDTH_TILES;
		float f9 = f8 + 0.25F / (float)Global.TEXTURE_ATLAS_WIDTH_TILES;
		float f10 = 0.1F * this.particleScale;
		float f11 = (float)(this.xo + (this.x - this.xo) * (double)partialTick - lerpPosX);
		float f12 = (float)(this.yo + (this.y - this.yo) * (double)partialTick - lerpPosY);
		float f13 = (float)(this.zo + (this.z - this.zo) * (double)partialTick - lerpPosZ);
		float f14 = this.getBrightness(partialTick);
		t.setColorOpaque_F(f14 * this.particleRed, f14 * this.particleGreen, f14 * this.particleBlue);
		t.addVertexWithUV(f11 - rotationX * f10 - rotationYZ * f10, f12 - rotationXZ * f10, f13 - rotationZ * f10 - rotationXY * f10, f6, f9);
		t.addVertexWithUV(f11 - rotationX * f10 + rotationYZ * f10, f12 + rotationXZ * f10, f13 - rotationZ * f10 + rotationXY * f10, f6, f8);
		t.addVertexWithUV(f11 + rotationX * f10 + rotationYZ * f10, f12 + rotationXZ * f10, f13 + rotationZ * f10 + rotationXY * f10, f7, f8);
		t.addVertexWithUV(f11 + rotationX * f10 - rotationYZ * f10, f12 - rotationXZ * f10, f13 + rotationZ * f10 - rotationXY * f10, f7, f9);
	}

	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.particleAge++ >= this.particleMaxAge) {
			this.remove();
		}

		this.particleTextureIndex = shit;
		this.yd -= 0.03;
		this.move(this.xd, this.yd, this.zd);
		this.xd *= 0.9900000095367432;
		this.yd *= 0.9900000095367432;
		this.zd *= 0.9900000095367432;
		if (this.onGround) {
			this.xd *= 0.699999988079071;
			this.zd *= 0.699999988079071;
		}

	}

	public int getFXLayer() {
		return 2;
	}
}
