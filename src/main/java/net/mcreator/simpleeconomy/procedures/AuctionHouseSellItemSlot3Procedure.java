package net.mcreator.simpleeconomy.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.simpleeconomy.world.inventory.AuctionHouseMenu;
import net.mcreator.simpleeconomy.network.SimpleEconomyModVariables;

import java.util.function.Supplier;
import java.util.Map;

import io.netty.buffer.Unpooled;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class AuctionHouseSellItemSlot3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("AuctionHouse");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new AuctionHouseMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if (SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot2EMPTY == true) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Please select something to sell!"), false);
			} else {
				if (DoubleArgumentType.getDouble(arguments, "price") <= SimpleEconomyModVariables.MapVariables.get(world).MaximumBalance) {
					SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot2EMPTY = false;
					SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
					SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem2Price = DoubleArgumentType.getDouble(arguments, "price");
					SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
					SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem2Count = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount();
					SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
					SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem2 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_setstack.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount());
						((Slot) _slots.get(3)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount(),
								_player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You successfully sold the items for " + SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseItem2Price + "$")), false);
					SimpleEconomyModVariables.MapVariables.get(world).AuctionHouseSlot2Seller = entity.getDisplayName().getString();
					SimpleEconomyModVariables.MapVariables.get(world).syncData(world);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("The price you set is bigger than the maximum balance allowed. The maximum balance is " + SimpleEconomyModVariables.MapVariables.get(world).MaximumBalance + "$")), false);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Sorry, the auction house is full. Please wait until Simple Economy next release to have more slots."), false);
		}
	}
}
