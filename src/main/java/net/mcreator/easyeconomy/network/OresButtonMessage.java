
package net.mcreator.easyeconomy.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.easyeconomy.world.inventory.OresMenu;
import net.mcreator.easyeconomy.procedures.ShopProcedureProcedure;
import net.mcreator.easyeconomy.procedures.OpenNetheriteGUIProcedure;
import net.mcreator.easyeconomy.procedures.OpenEmeraldGUIProcedure;
import net.mcreator.easyeconomy.procedures.OpenDiamondGUIProcedure;
import net.mcreator.easyeconomy.procedures.BackToIronGUIProcedure;
import net.mcreator.easyeconomy.procedures.BackToGoldGUIProcedure;
import net.mcreator.easyeconomy.procedures.BackToCoalGUIProcedure;
import net.mcreator.easyeconomy.EasyEconomyMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OresButtonMessage {
	private final int buttonID, x, y, z;

	public OresButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public OresButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(OresButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(OresButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = OresMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			BackToIronGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BackToCoalGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BackToGoldGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenEmeraldGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenDiamondGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ShopProcedureProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenNetheriteGUIProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EasyEconomyMod.addNetworkMessage(OresButtonMessage.class, OresButtonMessage::buffer, OresButtonMessage::new, OresButtonMessage::handler);
	}
}
