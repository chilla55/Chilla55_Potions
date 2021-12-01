
package chilla55.potions;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import chilla55.potions.potion.AntiWitheringPotionPotion;
import chilla55.potions.potion.AntiWithering2PotionPotion;

@Chilla55PotionsModElements.ModElement.Tag
public class AntiWithering2RecipeBrewingRecipe extends Chilla55PotionsModElements.ModElement {
	public AntiWithering2RecipeBrewingRecipe(Chilla55PotionsModElements instance) {
		super(instance, 18);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			Item inputItem = input.getItem();
			return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION)
					&& PotionUtils.getPotionFromItem(input) == AntiWitheringPotionPotion.potionType;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.BLAZE_POWDER;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return PotionUtils.addPotionToItemStack(new ItemStack(input.getItem()), AntiWithering2PotionPotion.potionType);
			}
			return ItemStack.EMPTY;
		}
	}
}
