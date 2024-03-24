package luke.rancidresources;

import luke.rancidresources.block.RancidBlocks;
import luke.rancidresources.entity.EntityShit;
import luke.rancidresources.item.RancidItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.fx.EntitySlimeFX;
import net.minecraft.client.render.entity.SnowballRenderer;
import net.minecraft.core.HitResult;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.lwjgl.input.Mouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.ParticleHelper;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;
import java.util.Random;


public class RancidResources implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	private boolean playerSneaked = false;
	private boolean playerSwinged = false;
	public static final String MOD_ID = "rancidresources";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ConfigHandler config;
	private static int blockID;
	private static int itemID;
	static {
		Properties properties = new Properties();
		properties.put("blockID", "2200");
		properties.put("itemID", "17750");
		config = new ConfigHandler(MOD_ID, properties);
		blockID = config.getInt("blockID");
		itemID = config.getInt("itemID");
	}
    @Override
    public void onInitialize() {
        LOGGER.info("Rancid Resources initialized.");
    }

		@Override
	public void beforeGameStart() {
		new RancidBlocks().initializeBlocks();
		new RancidItems().initializeItems();

		EntityHelper.Client.assignEntityRenderer(EntityShit.class, new SnowballRenderer(RancidItems.shit.getIconIndex(new ItemStack(RancidItems.shit))));

		ParticleHelper.createParticle(EntityShitFX.class, "shitpoof");
	}

	@Override
	public void afterGameStart() {
	}

	@Override
	public void onRecipesReady() {
		RecipeBuilderShaped template2x2 = new RecipeBuilderShaped(MOD_ID, "XX", "XX");
		template2x2.addInput('X', RancidItems.shit).create("shit_block", new ItemStack(RancidBlocks.shit, 2));
		template2x2.addInput('X', RancidItems.cum).create("cum_block", new ItemStack(RancidBlocks.cum, 2));
		template2x2.addInput('X', Item.foodPorkchopRaw).create("pork_block", new ItemStack(RancidBlocks.pork, 1));

	}

	public boolean runTick(Minecraft mc) {

		if(mc.thePlayer.health == 4)
		{
			int random = new Random().nextInt(200);
			if(random == 0) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}

		}

		if(mc.thePlayer.health == 3)
		{
			int random = new Random().nextInt(150);
			if(random == 0) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}
		}

		if(mc.thePlayer.health == 2)
		{
			int random = new Random().nextInt(100);
			if(random == 0) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}
		}

		if(mc.thePlayer.health == 1)
		{
			int random = new Random().nextInt(50);
			if(random == 0) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.blood, 1));
			}
		}

		if(mc.thePlayer.getPlayerProtectionAmount() == 0 && mc.thePlayer.isSneaking() && !playerSneaked)
		{
			int random = new Random().nextInt(30);
			if(random == 0) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.shit, 1));
			}
			if(random == 1) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.shit, 2));
			}
			if(random == 2) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.shit, 3));
			}
			if(random == 3) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidBlocks.shit, 1));
			}
			playerSneaked = true;
		}
		if(!mc.thePlayer.isSneaking()) {
			playerSneaked = false;
		}

		if(mc.thePlayer.getPlayerProtectionAmount() == 0 && Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && mc.thePlayer.health == 20 && !playerSwinged && mc.thePlayer.getCurrentEquippedItem() == null && mc.objectMouseOver != null && mc.objectMouseOver.hitType == HitResult.HitType.ENTITY && mc.objectMouseOver.x == (int)Math.floor(mc.thePlayer.x) && mc.objectMouseOver.y == (int)Math.floor(mc.thePlayer.y) - 2 && mc.objectMouseOver.z == (int)Math.floor(mc.thePlayer.z))
		{
			int random = new Random().nextInt(10);
			if(random == 0) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.cum, 1));
			}
			if(random == 1) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.cum, 2));
			}
			if(random == 2) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidItems.cum, 3));
			}
			if(random == 3) {
				mc.thePlayer.dropPlayerItem(new ItemStack(RancidBlocks.cum, 1));
			}

			playerSwinged = true;
		}
		if(Mouse.getEventButton() == 0 && !Mouse.getEventButtonState()) {
			playerSwinged = false;
		}
		return true;
	}

}
