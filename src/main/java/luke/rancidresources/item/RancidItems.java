package luke.rancidresources.item;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemBuilder;

import static luke.rancidresources.RancidResourcesMod.MOD_ID;

public class RancidItems {

	public static int itemID = 17750;

	public static Item shit;

	public static Item cum;

	public static Item blood;


	public void initilizeItems() {

		shit = new ItemBuilder(MOD_ID)
			.setIcon("rancidresources:item/shit")
			.build(new ItemShit("shit", itemID++));

		cum = new ItemBuilder(MOD_ID)
			.setIcon("rancidresources:item/cum")
			.build(new ItemCum("cum", itemID++, -1, 0, false, 64));

		blood = new ItemBuilder(MOD_ID)
			.setIcon("rancidresources:item/blood")
			.build(new ItemBlood("blood", itemID++));

	}

}
