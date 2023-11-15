package net.mcreator.simpleeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

public class AuctionHouseSlot3TellPriceProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot2EMPTY == false) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("The item price is " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem2Price + "$")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("The slot is empty!"), false);
		}
	}
}
