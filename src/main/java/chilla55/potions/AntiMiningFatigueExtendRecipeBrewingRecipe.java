
package chilla55.potions;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

import chilla55.potions.potion.AntiMiningFatigueextendPotion;
import chilla55.potions.potion.AntiMiningFatiguePotion;

@Chilla55PotionsModElements.ModElement.Tag
public class AntiMiningFatigueExtendRecipeBrewingRecipe extends Chilla55PotionsModElements.ModElement {
	public AntiMiningFatigueExtendRecipeBrewingRecipe(Chilla55PotionsModElements instance) {
		super(instance, 13);
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
					&& PotionUtils.getPotionFromItem(input) == AntiMiningFatiguePotion.potionType;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Items.REDSTONE;
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return PotionUtils.addPotionToItemStack(new ItemStack(input.getItem()), AntiMiningFatigueextendPotion.potionType);
			}
			return ItemStack.EMPTY;
		}
	}
}
