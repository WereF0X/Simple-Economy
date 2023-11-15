
package net.mcreator.simpleeconomy.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.simpleeconomy.world.inventory.AuctionHouseMenu;
import net.mcreator.simpleeconomy.procedures.AuctionHouseSlot3TellPriceProcedure;
import net.mcreator.simpleeconomy.procedures.AuctionHouseSlot2TellPriceProcedure;
import net.mcreator.simpleeconomy.procedures.AuctionHouseSlot1TellPriceProcedure;
import net.mcreator.simpleeconomy.procedures.AuctionHouseBuySlot3Procedure;
import net.mcreator.simpleeconomy.procedures.AuctionHouseBuySlot2Procedure;
import net.mcreator.simpleeconomy.procedures.AuctionHouseBuyProcedure;
import net.mcreator.simpleeconomy.SimpleEconomyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AuctionHouseButtonMessage {
	private final int buttonID, x, y, z;

	public AuctionHouseButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AuctionHouseButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AuctionHouseButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AuctionHouseButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AuctionHouseMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AuctionHouseBuyProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			AuctionHouseBuySlot2Procedure.execute(world, entity);
		}
		if (buttonID == 2) {

			AuctionHouseBuySlot3Procedure.execute(world, entity);
		}
		if (buttonID == 3) {

			AuctionHouseSlot1TellPriceProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			AuctionHouseSlot2TellPriceProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			AuctionHouseSlot3TellPriceProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SimpleEconomyMod.addNetworkMessage(AuctionHouseButtonMessage.class, AuctionHouseButtonMessage::buffer, AuctionHouseButtonMessage::new, AuctionHouseButtonMessage::handler);
	}
}
