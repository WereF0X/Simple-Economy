package net.mcreator.simpleeconomy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

import java.util.function.Supplier;
import java.util.Map;

public class AuctionHouseBuyProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money - SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0Price >= 0) {
			{
				double _setval = (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money
						- SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0Price;
				entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Money = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0;
				_setstack.setCount((int) SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0Count);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(1)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0 = new ItemStack(Blocks.AIR);
			SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
			SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0Price = 0;
			SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You don't have enough money! Item price is " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem0Price + "$")), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}