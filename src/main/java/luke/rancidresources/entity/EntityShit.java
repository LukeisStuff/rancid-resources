package luke.rancidresources.entity;

import com.mojang.nbt.CompoundTag;
import luke.rancidresources.item.RancidItems;
import net.minecraft.core.HitResult;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

import java.util.List;

public class EntityShit extends Entity {
	private int xTileShit = -1;
	private int yTileShit = -1;
	private int zTileShit = -1;
	private int inTileShit = 0;
	private boolean inGroundShit = false;
	public int shakeShit = 0;
	public EntityLiving thrower;
	private int ticksInGroundShit;
	private int ticksInAirShit = 0;
	public int damage = 0;

	public EntityShit(World world) {
		super(world);
		this.setSize(0.25F, 0.25F);
	}

	protected void init() {
	}

	public boolean shouldRenderAtSqrDistance(double distance) {
		double d1 = this.bb.getAverageEdgeLength() * 4.0;
		d1 *= 64.0;
		return distance < d1 * d1;
	}

	public EntityShit(World world, EntityLiving entityliving) {
		super(world);
		this.thrower = entityliving;
		this.setSize(0.25F, 0.25F);
		this.moveTo(entityliving.x, entityliving.y + (double)entityliving.getHeadHeight(), entityliving.z, entityliving.yRot, entityliving.xRot);
		this.x -= (double)(MathHelper.cos(this.yRot / 180.0F * 3.141593F) * 0.16F);
		this.y -= 0.10000000149011612;
		this.z -= (double)(MathHelper.sin(this.yRot / 180.0F * 3.141593F) * 0.16F);
		this.setPos(this.x, this.y, this.z);
		this.heightOffset = 0.0F;
		float f = 0.4F;
		this.xd = (double)(-MathHelper.sin(this.yRot / 180.0F * 3.141593F) * MathHelper.cos(this.xRot / 180.0F * 3.141593F) * f);
		this.zd = (double)(MathHelper.cos(this.yRot / 180.0F * 3.141593F) * MathHelper.cos(this.xRot / 180.0F * 3.141593F) * f);
		this.yd = (double)(-MathHelper.sin(this.xRot / 180.0F * 3.141593F) * f);
		this.setShitHeading(this.xd, this.yd, this.zd, 1.5F, 1.0F);
	}

	public EntityShit(World world, double d, double d1, double d2) {
		super(world);
		this.ticksInGroundShit = 0;
		this.setSize(0.25F, 0.25F);
		this.setPos(d, d1, d2);
		this.heightOffset = 0.0F;
	}

	public void setShitHeading(double d, double d1, double d2, float f, float f1) {
		float f2 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
		d /= (double)f2;
		d1 /= (double)f2;
		d2 /= (double)f2;
		d += this.random.nextGaussian() * 0.007499999832361937 * (double)f1;
		d1 += this.random.nextGaussian() * 0.007499999832361937 * (double)f1;
		d2 += this.random.nextGaussian() * 0.007499999832361937 * (double)f1;
		d *= (double)f;
		d1 *= (double)f;
		d2 *= (double)f;
		this.xd = d;
		this.yd = d1;
		this.zd = d2;
		float f3 = MathHelper.sqrt_double(d * d + d2 * d2);
		this.yRotO = this.yRot = (float)(Math.atan2(d, d2) * 180.0 / 3.1415927410125732);
		this.xRotO = this.xRot = (float)(Math.atan2(d1, (double)f3) * 180.0 / 3.1415927410125732);
		this.ticksInGroundShit = 0;
	}

	public void setShitHeadingPrecise(double d, double d1, double d2, float f, float f1) {
		float f2 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
		d /= (double)f2;
		d1 /= (double)f2;
		d2 /= (double)f2;
		d *= (double)f;
		d1 *= (double)f;
		d2 *= (double)f;
		this.xd = d;
		this.yd = d1;
		this.zd = d2;
		float f3 = MathHelper.sqrt_double(d * d + d2 * d2);
		this.yRotO = this.yRot = (float)(Math.atan2(d, d2) * 180.0 / 3.1415927410125732);
		this.xRotO = this.xRot = (float)(Math.atan2(d1, (double)f3) * 180.0 / 3.1415927410125732);
		this.ticksInGroundShit = 0;
	}

	public void lerpMotion(double xd, double yd, double zd) {
		this.xd = xd;
		this.yd = yd;
		this.zd = zd;
		if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
			float f = MathHelper.sqrt_double(xd * xd + zd * zd);
			this.yRotO = this.yRot = (float)(Math.atan2(xd, zd) * 180.0 / 3.1415927410125732);
			this.xRotO = this.xRot = (float)(Math.atan2(yd, (double)f) * 180.0 / 3.1415927410125732);
		}

	}

	public void tick() {
		this.xOld = this.x;
		this.yOld = this.y;
		this.zOld = this.z;
		super.tick();
		if (this.shakeShit > 0) {
			--this.shakeShit;
		}

		if (this.inGroundShit) {
			int i = this.world.getBlockId(this.xTileShit, this.yTileShit, this.zTileShit);
			if (i == this.inTileShit) {
				++this.ticksInGroundShit;
				if (this.ticksInGroundShit == 1200) {
					this.remove();
				}

				return;
			}

			this.inGroundShit = false;
			this.xd *= (double)(this.random.nextFloat() * 0.2F);
			this.yd *= (double)(this.random.nextFloat() * 0.2F);
			this.zd *= (double)(this.random.nextFloat() * 0.2F);
			this.ticksInGroundShit = 0;
			this.ticksInAirShit = 0;
		} else {
			++this.ticksInAirShit;
		}

		Vec3d vec3d = Vec3d.createVector(this.x, this.y, this.z);
		Vec3d vec3d1 = Vec3d.createVector(this.x + this.xd, this.y + this.yd, this.z + this.zd);
		HitResult movingobjectposition = this.world.checkBlockCollisionBetweenPoints(vec3d, vec3d1);
		vec3d = Vec3d.createVector(this.x, this.y, this.z);
		vec3d1 = Vec3d.createVector(this.x + this.xd, this.y + this.yd, this.z + this.zd);
		if (movingobjectposition != null) {
			vec3d1 = Vec3d.createVector(movingobjectposition.location.xCoord, movingobjectposition.location.yCoord, movingobjectposition.location.zCoord);
		}

		if (!this.world.isClientSide) {
			Entity entity = null;
			List list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.bb.addCoord(this.xd, this.yd, this.zd).expand(1.0, 1.0, 1.0));
			double d = 0.0;

			for(int l = 0; l < list.size(); ++l) {
				Entity entity1 = (Entity)list.get(l);
				if (entity1.isPickable() && (entity1 != this.thrower || this.ticksInAirShit >= 5)) {
					float f4 = 0.3F;
					AABB axisalignedbb = entity1.bb.expand((double)f4, (double)f4, (double)f4);
					HitResult movingobjectposition1 = axisalignedbb.func_1169_a(vec3d, vec3d1);
					if (movingobjectposition1 != null) {
						double d1 = vec3d.distanceTo(movingobjectposition1.location);
						if (d1 < d || d == 0.0) {
							entity = entity1;
							d = d1;
						}
					}
				}
			}

			if (entity != null) {
				movingobjectposition = new HitResult(entity);
			}
		}

		if (movingobjectposition != null) {
			if (movingobjectposition.entity != null && !movingobjectposition.entity.hurt(this.thrower, this.damage, DamageType.COMBAT)) {
			}

			for(int j = 0; j < 8; ++j) {
				this.world.spawnParticle("boatbreak", this.x, this.y, this.z, 0.0, 0.0, 0.0);
			}

			this.remove();
		}

		this.x += this.xd;
		this.y += this.yd;
		this.z += this.zd;
		float f = MathHelper.sqrt_double(this.xd * this.xd + this.zd * this.zd);
		this.yRot = (float)(Math.atan2(this.xd, this.zd) * 180.0 / 3.1415927410125732);

		for(this.xRot = (float)(Math.atan2(this.yd, (double)f) * 180.0 / 3.1415927410125732); this.xRot - this.xRotO < -180.0F; this.xRotO -= 360.0F) {
		}

		while(this.xRot - this.xRotO >= 180.0F) {
			this.xRotO += 360.0F;
		}

		while(this.yRot - this.yRotO < -180.0F) {
			this.yRotO -= 360.0F;
		}

		while(this.yRot - this.yRotO >= 180.0F) {
			this.yRotO += 360.0F;
		}

		this.xRot = this.xRotO + (this.xRot - this.xRotO) * 0.2F;
		this.yRot = this.yRotO + (this.yRot - this.yRotO) * 0.2F;
		float f1 = 0.99F;
		float f2 = 0.03F;
		if (this.isInWater()) {
			for(int k = 0; k < 4; ++k) {
				float f3 = 0.25F;
				this.world.spawnParticle("bubble", this.x - this.xd * (double)f3, this.y - this.yd * (double)f3, this.z - this.zd * (double)f3, this.xd, this.yd, this.zd);
			}

			f1 = 0.8F;
		}

		this.xd *= (double)f1;
		this.yd *= (double)f1;
		this.zd *= (double)f1;
		this.yd -= (double)f2;
		this.setPos(this.x, this.y, this.z);
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		tag.putShort("xTile", (short)this.xTileShit);
		tag.putShort("yTile", (short)this.yTileShit);
		tag.putShort("zTile", (short)this.zTileShit);
		tag.putShort("inTile", (short)this.inTileShit);
		tag.putByte("shake", (byte)this.shakeShit);
		tag.putByte("inGround", (byte)(this.inGroundShit ? 1 : 0));
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		this.xTileShit = tag.getShort("xTile");
		this.yTileShit = tag.getShort("yTile");
		this.zTileShit = tag.getShort("zTile");
		this.inTileShit = tag.getShort("inTile") & 16383;
		this.shakeShit = tag.getByte("shake") & 255;
		this.inGroundShit = tag.getByte("inGround") == 1;
	}

	public float getShadowHeightOffs() {
		return 0.0F;
	}
}
