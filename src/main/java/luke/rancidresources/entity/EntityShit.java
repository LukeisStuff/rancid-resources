package luke.rancidresources.entity;

import luke.rancidresources.item.RancidItems;
import net.minecraft.core.HitResult;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.projectile.EntityProjectile;
import net.minecraft.core.world.World;

public class EntityShit
	extends EntityProjectile {

	public EntityShit(World world) {
		super(world);
		this.modelItem = RancidItems.shit;
	}

	public EntityShit(World world, EntityLiving entityliving) {
		super(world, entityliving);
		this.modelItem = RancidItems.shit;
	}

	public EntityShit(World world, double d, double d1, double d2) {
		super(world, d, d1, d2);
		this.modelItem = RancidItems.shit;
	}

	@Override
	public void init() {
		super.init();
		this.modelItem = RancidItems.shit;
	}

	@Override
	public void onHit(HitResult hitResult) {
		if (hitResult.entity != null) {
			this.world.spawnParticle("item", this.x, this.y, this.z, 0.0, 0.0, 0.0, this.modelItem.id);
			world.playSoundAtEntity(null, this, "rancidresources.fart", 0.5F, 1.0F);
		}
		this.world.spawnParticle("item", this.x, this.y, this.z, 0.0, 0.0, 0.0, this.modelItem.id);
		world.playSoundAtEntity(null, this, "rancidresources.fart", 0.5F, 1.0F);
		this.remove();
	}
}
