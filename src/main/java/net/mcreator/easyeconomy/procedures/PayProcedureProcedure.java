package net.mcreator.easyeconomy.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.easyeconomy.network.EasyEconomyModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class PayProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		Entity Sender = null;
		if ((entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money >= DoubleArgumentType.getDouble(arguments, "amount")) {
			Sender = entity;
			{
				double _setval = (entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money - DoubleArgumentType.getDouble(arguments, "amount");
				entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Money = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You successfully sent " + new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity() + " " + DoubleArgumentType.getDouble(arguments, "amount") + "$!")), false);
			{
				double _setval = ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money + DoubleArgumentType.getDouble(arguments, "amount");
				(new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Money = _setval;
					capability.syncPlayerVariables((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()));
				});
			}
			if ((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Sender + " sent you " + DoubleArgumentType.getDouble(arguments, "amount") + "$!")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal(
								("You don't have enough money! " + "Your current balance is " + (entity.getCapability(EasyEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EasyEconomyModVariables.PlayerVariables())).Money + "$")),
						false);
		}
	}
}
