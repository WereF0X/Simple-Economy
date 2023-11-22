package net.mcreator.simpleeconomy.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

public class MoneyDisplayOverlayIngameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Balance: " + (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money + "$";
	}
}
