package net.mcreator.easyeconomy.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.easyeconomy.network.EasyEconomyModVariables;

public class TellMoneyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Your current balance is " + (entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money + "$")), false);
	}
}
