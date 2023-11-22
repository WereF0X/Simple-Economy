package net.mcreator.simpleeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.simpleeconomy.world.inventory.AuctionHouseMenu;
import net.mcreator.simpleeconomy.procedures.PriceDisplayOverlayAhProcedure;
import net.mcreator.simpleeconomy.network.AuctionHouseButtonMessage;
import net.mcreator.simpleeconomy.SimpleEconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AuctionHouseScreen extends AbstractContainerScreen<AuctionHouseMenu> {
	private final static HashMap<String, Object> guistate = AuctionHouseMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_buy;
	Button button_buy1;
	Button button_buy2;
	Button button_price;
	Button button_price1;
	Button button_price2;

	public AuctionHouseScreen(AuctionHouseMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 304;
		this.imageHeight = 167;
	}

	private static final ResourceLocation texture = new ResourceLocation("simple_economy:textures/screens/auction_house.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 36 && mouseX < leftPos + 60 && mouseY > topPos + 11 && mouseY < topPos + 35)
			guiGraphics.renderTooltip(font, Component.literal(PriceDisplayOverlayAhProcedure.execute(world)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.simple_economy.auction_house.label_auction_house"), 2, 2, -256, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_buy = Button.builder(Component.translatable("gui.simple_economy.auction_house.button_buy"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new AuctionHouseButtonMessage(0, x, y, z));
				AuctionHouseButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 28, this.topPos + 13, 40, 20).build();
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_buy1 = Button.builder(Component.translatable("gui.simple_economy.auction_house.button_buy1"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new AuctionHouseButtonMessage(1, x, y, z));
				AuctionHouseButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 109, this.topPos + 13, 40, 20).build();
		guistate.put("button:button_buy1", button_buy1);
		this.addRenderableWidget(button_buy1);
		button_buy2 = Button.builder(Component.translatable("gui.simple_economy.auction_house.button_buy2"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new AuctionHouseButtonMessage(2, x, y, z));
				AuctionHouseButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 191, this.topPos + 13, 40, 20).build();
		guistate.put("button:button_buy2", button_buy2);
		this.addRenderableWidget(button_buy2);
		button_price = Button.builder(Component.translatable("gui.simple_economy.auction_house.button_price"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new AuctionHouseButtonMessage(3, x, y, z));
				AuctionHouseButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 144, 51, 20).build();
		guistate.put("button:button_price", button_price);
		this.addRenderableWidget(button_price);
		button_price1 = Button.builder(Component.translatable("gui.simple_economy.auction_house.button_price1"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new AuctionHouseButtonMessage(4, x, y, z));
				AuctionHouseButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 83, this.topPos + 34, 51, 20).build();
		guistate.put("button:button_price1", button_price1);
		this.addRenderableWidget(button_price1);
		button_price2 = Button.builder(Component.translatable("gui.simple_economy.auction_house.button_price2"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new AuctionHouseButtonMessage(5, x, y, z));
				AuctionHouseButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 165, this.topPos + 35, 51, 20).build();
		guistate.put("button:button_price2", button_price2);
		this.addRenderableWidget(button_price2);
	}
}
