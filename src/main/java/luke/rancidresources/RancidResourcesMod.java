package luke.rancidresources;

import luke.rancidresources.block.RancidBlocks;
import luke.rancidresources.entity.EntityShit;
import luke.rancidresources.item.RancidItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.entity.SnowballRenderer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class RancidResourcesMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint, ClientStartEntrypoint {
	public static final String MOD_ID = "rancidresources";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ConfigHandler config;

	static {
		Properties properties = new Properties();
		properties.put("blockID", "2200");
		properties.put("itemID", "17750");
		config = new ConfigHandler(MOD_ID, properties);
	}
    @Override
    public void onInitialize() {
		SoundHelper.addSound(RancidResourcesMod.MOD_ID, "poop1.ogg"); SoundHelper.addSound(RancidResourcesMod.MOD_ID, "poop2.ogg");

		SoundHelper.addSound(RancidResourcesMod.MOD_ID, "fart1.ogg"); SoundHelper.addSound(RancidResourcesMod.MOD_ID, "fart2.ogg");

		SoundHelper.addSound(RancidResourcesMod.MOD_ID, "puke1.ogg"); SoundHelper.addSound(RancidResourcesMod.MOD_ID, "puke2.ogg"); SoundHelper.addSound(RancidResourcesMod.MOD_ID, "puke3.ogg");

		SoundHelper.addSound(RancidResourcesMod.MOD_ID, "vomit.ogg");

		EntityHelper.createEntity(EntityShit.class, 2200, "flungShit", () -> new SnowballRenderer(RancidItems.shit));

		LOGGER.info("Rancid Resources initialized.");
    }

	@Override
	public void beforeGameStart() {
		new RancidBlocks().initializeBlocks();
		new RancidBlocks().initializeBlockDetails();
		new RancidItems().initilizeItems();
	}

	@Override
	public void afterGameStart() {
		new RancidBlocks().initializeBlockDetails();
	}

	@Override
	public void onRecipesReady() {
		RecipeBuilderShaped template2x2 = new RecipeBuilderShaped(MOD_ID, "XX", "XX");
		template2x2.addInput('X', RancidItems.shit).create("shit_block", new ItemStack(RancidBlocks.shit, 2));
		template2x2.addInput('X', RancidItems.cum).create("cum_block", new ItemStack(RancidBlocks.cum, 2));
		template2x2.addInput('X', Item.foodPorkchopRaw).create("pork_block", new ItemStack(RancidBlocks.pork, 1));

	}

	@Override
	public void initNamespaces() {

	}

	@Override
	public void beforeClientStart() {
	}

	@Override
	public void afterClientStart() {
	}

}
