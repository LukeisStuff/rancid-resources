package luke.rancidresources.mixin;

import luke.rancidresources.block.RancidBlocks;
import luke.rancidresources.item.RancidItems;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.World;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = EntityPlayer.class, remap = false)
public abstract class EntityPlayerMixin extends EntityLiving {
	@Unique
	private boolean playerSneaked = false;
	@Unique
	private boolean playerSwinged = false;

	@Shadow
	public abstract void remove();

	@Shadow
	public abstract void dropPlayerItem(ItemStack itemstack);

	@Shadow
	public InventoryPlayer inventory;

	@Shadow
	public abstract ItemStack getCurrentEquippedItem();

	public EntityPlayerMixin(World world) {
		super(world);
	}

	@Inject(method = "tick", at = @At(value = "HEAD"), cancellable = true)
	public void tick(CallbackInfo ci) {
		if(this.getHealth() == 4)
		{
			int random = new Random().nextInt(200);
			if(random == 0) {
				this.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}
		}

		if(this.getHealth() == 3)
		{
			int random = new Random().nextInt(150);
			if(random == 0) {
				this.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}
		}

		if(this.getHealth() == 2)
		{
			int random = new Random().nextInt(100);
			if(random == 0) {
				this.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}
		}

		if(this.getHealth() == 1)
		{
			int random = new Random().nextInt(50);
			if(random == 0) {
				this.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}
		}

		if(this.inventory.getTotalProtectionAmount(DamageType.COMBAT) == 0 && this.isSneaking() && !playerSneaked)
		{
			int random = new Random().nextInt(30);
			if(random == 0) {
				this.dropPlayerItem(new ItemStack(RancidItems.shit, 1));
			}
			if(random == 1) {
				this.dropPlayerItem(new ItemStack(RancidItems.shit, 2));
			}
			if(random == 2) {
				this.dropPlayerItem(new ItemStack(RancidItems.shit, 3));
			}
			if(random == 3) {
				this.dropPlayerItem(new ItemStack(RancidBlocks.shit, 1));
			}
			playerSneaked = true;
		}
		if(!this.isSneaking()) {
			playerSneaked = false;
		}

		if(this.inventory.getTotalProtectionAmount(DamageType.COMBAT) == 0 && Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.getHealth() == 20 && !playerSwinged && this.getCurrentEquippedItem() == null)
			{
			int random = new Random().nextInt(10);
			if(random == 0) {
				this.dropPlayerItem(new ItemStack(RancidItems.cum, 1));
			}
			if(random == 1) {
				this.dropPlayerItem(new ItemStack(RancidItems.cum, 2));
			}
			if(random == 2) {
				this.dropPlayerItem(new ItemStack(RancidItems.cum, 3));
			}
			if(random == 3) {
				this.dropPlayerItem(new ItemStack(RancidBlocks.cum, 1));
			}
			playerSwinged = true;
		}
		if(Mouse.getEventButton() == 0 && !Mouse.getEventButtonState()) {
			playerSwinged = false;
		}
	}

}
