package io.github.elytra.fruitphone;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class FruitRecipes {

	public static List<Integer> craftableColors = Lists.newArrayList();
	
	public static void register() {
		OreDictionary.registerOre("blockObsidian", Blocks.OBSIDIAN);
		OreDictionary.registerOre("clay", Items.CLAY_BALL);
		// using the (broken) listAllfruit name for Pam's HarvestCraft compat
		OreDictionary.registerOre("listAllfruit", Items.APPLE);
		OreDictionary.registerOre("listAllfruit", Items.MELON);
		OreDictionary.registerOre("listAllfruit", Items.CHORUS_FRUIT);
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(FruitItems.HANDHELD,
				"ingotIron", "listAllfruit"));
		GameRegistry.addRecipe(new FruitUpgradeRecipe(FruitItems.PASSIVE,
				"/ /",
				"ghg",
				'/', "ingotIron",
				'g', "blockGlass",
				'h', FruitItems.HANDHELD));
		
		// Elegant Tungsten
		colorRecipe(0x2C2D2D, "ingotTungsten");
		colorRecipe(0x2C2D2D, "dyeBlack", "ingotIron");
		// Obsidian
		colorRecipe(0x322D44, "blockObsidian");
		colorRecipe(0x322D44, "dyeBlack", "dyePurple");
		// Silver
		colorRecipe(0xCDCDCD, "ingotSilver");
		colorRecipe(0xCDCDCD, "dyeLightGray");
		// White
		colorRecipe(0xFFFFFF, "dyeWhite");
		
		// Slate Red
		colorRecipe(0xB15573, "dustRedstone");
		colorRecipe(0xB15573, "dyeRed", "dyeGray");
		// Dull Pink
		colorRecipe(0xAC5596, "dyeMagenta", "dyeGray");
		// Lucious Lavender
		colorRecipe(0x8851AC, "cropLavender");
		colorRecipe(0x8851AC, "dyePurple", "dyeGray");
		// Kinda Blue
		colorRecipe(0x5557B1, "dyeBlue", "dyeGray");
		// Steel Blue
		colorRecipe(0x5589B1, "ingotSteel");
		colorRecipe(0x5589B1, "dyeLightBlue", "dyeGray");
		// Sea Green
		colorRecipe(0x55A9B1, "dyeGreen", "dyeCyan", "dyeGray");
		// Real Teal
		colorRecipe(0x55AF90, "dyeCyan", "dyeGray");
		// Cactus Green
		colorRecipe(0x73B155, "dyeGreen", "dyeGray");
		// Wasabi
		colorRecipe(0x9CB055, "dyeLime", "dyeGreen", "dyeGray");
		// Sulfur
		colorRecipe(0xB8AA4D, "dustSulfur");
		colorRecipe(0xB8AA4D, "dustSulphur");
		colorRecipe(0xB8AA4D, "dyeYellow", "dyeGray");
		// Cinnamon
		colorRecipe(0xB18255, "dyeBrown", "dyeGray");
		// Wet Clay
		colorRecipe(0xB17355, "clay");
		colorRecipe(0xB17355, "dyeBrown", "dyeOrange", "dyeGray");
		// Scarlet
		colorRecipe(0xAF5454, "dyeRed", "dyeGray");
		
		// Cherry Red
		colorRecipe(0xFD004D, "dustGlowstone", "dyeRed");
		// Terrific Pink
		colorRecipe(0xE300FF, "dustGlowstone", "dyeMagenta");
		// Vivid Violet
		colorRecipe(0x9C00FF, "dustGlowstone", "dyePurple");
		// Really Blue
		colorRecipe(0x1B1BEC, "dustGlowstone", "dyeBlue");
		// Cerulean
		colorRecipe(0x0078FF, "dustGlowstone", "dyeLightBlue");
		// Sky Blue
		colorRecipe(0x00BAFF, "dustGlowstone", "dyeCyan");
		// Brilliant Verdant
		colorRecipe(0x09FF97, "dustGlowstone", "dyeLime");
		Item misc = Item.getByNameOrId("correlated:misc");
		if (misc == null) {
			// try the legacy modid
			misc = Item.getByNameOrId("correlatedpotentialistics:misc");
		}
		if (misc != null) {
			ItemStack lum = new ItemStack(misc, 1, 3);
			colorRecipe(0x09FF97, lum);
		} else {
			colorRecipe(0x09FF97, "dustGlowstone", "enderpearl");
		}
		// Mean Green
		colorRecipe(0x8BFF00, "dustGlowstone", "dyeGreen");
		// Electric Green
		colorRecipe(0xCCFE00, "dustGlowstone", "dyeLime", "dyeLime");
		// Mustard Yellow
		colorRecipe(0xF6E700, "dustGlowstone", "cropMustard");
		colorRecipe(0xF6E700, "dustGlowstone", "seedMustard");
		colorRecipe(0xF6E700, "dustGlowstone", "dyeYellow", "dyeBrown");
		// Dandelion Yellow
		colorRecipe(0xFEC501, "dustGlowstone", "dyeYellow");
		// Sunset Orange
		colorRecipe(0xFF9C00, "dustGlowstone", "dyeOrange");
		// Vibrant Vermillion
		colorRecipe(0xFF5C00, "dustGlowstone", "dyeOrange", "dyeRed");
		
		// Rose Gold
		if (doesOreExist("ingotCopper")) {
			if (doesOreExist("ingotSilver")) {
				colorRecipe(0xEFC6BF, "ingotGold", "ingotSilver", "ingotCopper");
				colorRecipe(0xEFC6BF, "dustGold", "dustSilver", "dustCopper");
			} else {
				colorRecipe(0xEFC6BF, "ingotGold", "ingotCopper");
				colorRecipe(0xEFC6BF, "dustGold", "dustCopper");
			}
		} else {
			colorRecipe(0xEFC6BF, "ingotGold", "dyeRed");
			colorRecipe(0xEFC6BF, "dustGold", "dyeRed");
		}
		// Platinum
		if (doesOreExist("ingotPlatinum")) {
			colorRecipe(0xC9D2D2, "ingotPlatinum");
			colorRecipe(0xC9D2D2, "dustPlatinum");
		} else if (doesOreExist("ingotSilver")) {
			colorRecipe(0xC9D2D2, "ingotSilver", "gemDiamond");
			colorRecipe(0xC9D2D2, "dustSilver", "gemDiamond");
		} else {
			colorRecipe(0xC9D2D2, "ingotIron", "gemDiamond", "gemDiamond");
			colorRecipe(0xC9D2D2, "dustIron", "gemDiamond", "gemDiamond");
		}
		// Sriracha Red
		if (doOresExist("cropTomato", "cropChilipepper", "cropGarlic", "foodVinegar")) {
			colorRecipe(0xB31E02, "cropTomato", "cropChilipepper", "cropGarlic", "foodVinegar");
		} else if (doOresExist("cropTomato", "cropGarlic")) {
			colorRecipe(0xB31E02, "cropTomato", "cropGarlic");
		} else {
			colorRecipe(0xB31E02, "dyeRed", "dyeRed", "dyeRed");
		}
		// Ender Green
		colorRecipe(0x258474, "enderpearl");
	}

	private static boolean doesOreExist(String ore) {
		return !OreDictionary.getOres(ore, false).isEmpty();
	}
	
	private static boolean doOresExist(String... ores) {
		for (String s : ores) {
			if (!doesOreExist(s)) return false;
		}
		return true;
	}

	private static void colorRecipe(int color, Object... ingredients) {
		craftableColors.add(color);
		
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("fruitphone:color", color);
		
		ItemStack handheld = new ItemStack(FruitItems.HANDHELD);
		ItemStack passive = new ItemStack(FruitItems.PASSIVE);
		
		handheld.setTagCompound(tag.copy());
		passive.setTagCompound(tag.copy());
		
		Object[] handheldIngredients = new Object[ingredients.length+1];
		Object[] passiveIngredients = new Object[ingredients.length+1];
		
		handheldIngredients[0] = FruitItems.HANDHELD;
		passiveIngredients[0] = FruitItems.PASSIVE;
		
		System.arraycopy(ingredients, 0, handheldIngredients, 1, ingredients.length);
		System.arraycopy(ingredients, 0, passiveIngredients, 1, ingredients.length);
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(handheld, handheldIngredients));
		GameRegistry.addRecipe(new ShapelessOreRecipe(passive, passiveIngredients));
		
		Object[] handheldDirectIngredients = new Object[ingredients.length+2];
		
		handheldDirectIngredients[0] = "ingotIron";
		handheldDirectIngredients[1] = "listAllfruit";
		
		System.arraycopy(ingredients, 0, handheldDirectIngredients, 2, ingredients.length);
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(handheld, handheldDirectIngredients));
	}

}
