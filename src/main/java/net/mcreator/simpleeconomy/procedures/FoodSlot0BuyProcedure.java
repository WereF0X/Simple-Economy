package net.mcreator.simpleeconomy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class FoodSlot0BuyProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (guistate.containsKey("checkbox:amount") && ((Checkbox) guistate.get("checkbox:amount")).selected()) {
			if ((entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money >= 12 * 64) {
				{
					double _setval = (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money - 12 * 64;
					entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Money = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
					_setstack.setCount(64);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("You successfully bought 64xSTEAK. " + "Your current balance is "
							+ (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money + "$")), false);
			} else {
				if (entity instanceof Player _player)
					_player.closeContainer();
				DisableProcedure.execute();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							("You don't have enough money! " + "Your current balance is " + (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money + "$")),
							false);
			}
		} else {
			if ((entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money >= 12) {
				{
					double _setval = (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money - 12;
					entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Money = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							("You successfully bought 1xSTEAK. " + "Your current balance is " + (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money + "$")),
							false);
			} else {
				if (entity instanceof Player _player)
					_player.closeContainer();
				DisableProcedure.execute();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							("You don't have enough money! " + "Your current balance is " + (entity.getCapability(SimpleEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SimpleEconomyModVariables.PlayerVariables())).Money + "$")),
							false);
			}
		}
	}
}
