package net.mcreator.easyeconomy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.easyeconomy.network.EasyEconomyModVariables;

public class BuyEmeraldx64Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		if ((entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money >= 61 * 64) {
			{
				double _setval = (entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money - 61 * 64;
				entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Money = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.EMERALD);
				_setstack.setCount(64);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						("You successfully bought 64xEMERALD. " + "Your current balance is " + (entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money + "$")),
						false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal(
								("You don't have enough money! " + "Your current balance is " + (entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money + "$")),
						false);
		}
	}
}
