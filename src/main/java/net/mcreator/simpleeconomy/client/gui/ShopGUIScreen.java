package net.mcreator.simpleeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.simpleeconomy.world.inventory.ShopGUIMenu;
import net.mcreator.simpleeconomy.network.ShopGUIButtonMessage;
import net.mcreator.simpleeconomy.SimpleEconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ShopGUIScreen extends AbstractContainerScreen<ShopGUIMenu> {
	private final static HashMap<String, Object> guistate = ShopGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ores;
	Button button_blocks;
	Button button_pvp;
	Button button_miscellaneous;
	Button button_food;
	Button button_balance;
	Button button_search;
	Button button_auction_house;

	public ShopGUIScreen(ShopGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 273;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("simple_economy:textures/screens/shop_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.simple_economy.shop_gui.label_shop"), 130, 4, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_ores = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_ores"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(0, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 35, this.topPos + 47, 46, 20).build();
		guistate.put("button:button_ores", button_ores);
		this.addRenderableWidget(button_ores);
		button_blocks = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_blocks"), e -> {
		}).bounds(this.leftPos + 112, this.topPos + 47, 56, 20).build();
		guistate.put("button:button_blocks", button_blocks);
		this.addRenderableWidget(button_blocks);
		button_pvp = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_pvp"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(2, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 200, this.topPos + 48, 40, 20).build();
		guistate.put("button:button_pvp", button_pvp);
		this.addRenderableWidget(button_pvp);
		button_miscellaneous = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_miscellaneous"), e -> {
		}).bounds(this.leftPos + 41, this.topPos + 98, 93, 20).build();
		guistate.put("button:button_miscellaneous", button_miscellaneous);
		this.addRenderableWidget(button_miscellaneous);
		button_food = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_food"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(4, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 164, this.topPos + 98, 46, 20).build();
		guistate.put("button:button_food", button_food);
		this.addRenderableWidget(button_food);
		button_balance = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_balance"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(5, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 1, this.topPos + 145, 61, 20).build();
		guistate.put("button:button_balance", button_balance);
		this.addRenderableWidget(button_balance);
		button_search = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_search"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(6, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 0, this.topPos + 0, 56, 20).build();
		guistate.put("button:button_search", button_search);
		this.addRenderableWidget(button_search);
		button_auction_house = Button.builder(Component.translatable("gui.simple_economy.shop_gui.button_auction_house"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(7, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 179, this.topPos + 146, 93, 20).build();
		guistate.put("button:button_auction_house", button_auction_house);
		this.addRenderableWidget(button_auction_house);
	}
}
