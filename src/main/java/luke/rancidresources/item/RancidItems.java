package luke.rancidresources.item;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import turniplabs.halplibe.helper.ItemHelper;

import static luke.rancidresources.RancidResources.MOD_ID;

public class RancidItems {

	private static int itemID = 17750;

	public static final Item shit = ItemHelper.createItem(MOD_ID, new ItemShit("shitpiece", itemID++), "ShitItem.png");

	public static final Item cum = ItemHelper.createItem(MOD_ID, new ItemFood("cumwad", itemID++, -1, false), "CumItem.png").setMaxStackSize(64);

	public static final Item blood = ItemHelper.createItem(MOD_ID, new ItemBlood("blooddrop", itemID++), "Blood.png");


	public void initializeItems() {
	}
}
