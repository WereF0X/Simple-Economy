
package net.mcreator.simpleeconomy.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.simpleeconomy.world.inventory.ShopGUIMenu;
import net.mcreator.simpleeconomy.procedures.TellMoneyProcedure;
import net.mcreator.simpleeconomy.procedures.PvPSlot0SetProcedure;
import net.mcreator.simpleeconomy.procedures.OpenSearchGUIProcedure;
import net.mcreator.simpleeconomy.procedures.OpenOresGUIProcedure;
import net.mcreator.simpleeconomy.procedures.FoodSlot0SetProcedure;
import net.mcreator.simpleeconomy.procedures.AuctionHouseOpenProcedure;
import net.mcreator.simpleeconomy.SimpleEconomyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShopGUIButtonMessage {
	private final int buttonID, x, y, z;

	public ShopGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ShopGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ShopGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ShopGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = ShopGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenOresGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			PvPSlot0SetProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			FoodSlot0SetProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			TellMoneyProcedure.execute(entity);
		}
		if (buttonID == 6) {

			OpenSearchGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			AuctionHouseOpenProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SimpleEconomyMod.addNetworkMessage(ShopGUIButtonMessage.class, ShopGUIButtonMessage::buffer, ShopGUIButtonMessage::new, ShopGUIButtonMessage::handler);
	}
}
