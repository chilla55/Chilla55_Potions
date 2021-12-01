package chilla55.potions.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import chilla55.potions.Chilla55PotionsMod;

public class AntiminingfatigueefectoneffectactivetickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Chilla55PotionsMod.LOGGER.warn("Failed to load dependency entity for procedure Antiminingfatigueefectoneffectactivetick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(Effects.MINING_FATIGUE);
		}
	}
}
