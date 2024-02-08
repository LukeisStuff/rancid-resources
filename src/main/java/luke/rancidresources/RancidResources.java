package luke.rancidresources;

import luke.rancidresources.block.RancidBlocks;
import luke.rancidresources.item.RancidItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ParticleHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class RancidResources implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static final String MOD_ID = "rancidresources";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ConfigHandler config;
	private static int blockID;
	private static int itemID;
	static {
		Properties properties = new Properties();
		properties.put("blockID", "2003");
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

//		ParticleHelper.createParticle(EntityFlyFX.class, "fly");

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}
}
