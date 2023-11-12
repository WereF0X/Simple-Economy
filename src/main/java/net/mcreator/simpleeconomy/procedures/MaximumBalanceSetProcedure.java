package net.mcreator.simpleeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class MaximumBalanceSetProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (DoubleArgumentType.getDouble(arguments, "amount") <= 1000000000) {
			SimpleEconomyModVariables.MapVariables.get(world).MaximumBalance = DoubleArgumentType.getDouble(arguments, "amount");
			SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Successfully set the maximum balance to " + DoubleArgumentType.getDouble(arguments, "amount") + "$!")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("The amount you selected is too big! Maximum is 1 Billion"), false);
		}
	}
}
