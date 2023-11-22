package net.mcreator.simpleeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

public class PriceDisplayOverlayAhProcedure {
	public static String execute(LevelAccessor world) {
		return SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0Price + "$" + " by " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot0Seller;
	}
}
