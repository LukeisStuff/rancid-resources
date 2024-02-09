package luke.rancidresources;

import luke.rancidresources.block.RancidBlocks;
import luke.rancidresources.entity.EntityShit;
import luke.rancidresources.item.RancidItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.fx.EntitySlimeFX;
import net.minecraft.client.render.entity.SnowballRenderer;
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
}
