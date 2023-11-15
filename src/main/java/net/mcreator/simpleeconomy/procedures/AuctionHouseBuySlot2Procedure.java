package net.mcreator.simpleeconomy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

import java.util.function.Supplier;
import java.util.Map;

public class AuctionHouseBuySlot2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money - SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Price >= 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You successfully bought x" + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Count + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1 + " for "
						+ SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Price + "$")), false);
			{
				double _setval = (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money
						- SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Price;
				entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Money = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1;
				_setstack.setCount((int) SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Count);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(2)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1 = new ItemStack(Blocks.AIR);
			SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
			SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Count = 0;
			SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
			SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot1EMPTY = true;
			SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/balance:add " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot1Seller + " " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Price));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("/tellraw " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot1Seller + " {\"text\":\"Your item was purchased in the auction house!\",\"color\":\"white\"}"));
			SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Price = 0;
			SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You don't have enough money! Item price is " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem1Price + "$")), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
