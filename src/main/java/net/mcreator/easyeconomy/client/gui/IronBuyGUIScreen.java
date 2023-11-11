package net.mcreator.easyeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.easyeconomy.world.inventory.IronBuyGUIMenu;
import net.mcreator.easyeconomy.network.IronBuyGUIButtonMessage;
import net.mcreator.easyeconomy.EasyEconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class IronBuyGUIScreen extends AbstractContainerScreen<IronBuyGUIMenu> {
	private final static HashMap<String, Object> guistate = IronBuyGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_buy_x64;
	Button button_buy_x1;
	Button button_back;

	public IronBuyGUIScreen(IronBuyGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("easy_economy:textures/screens/iron_buy_gui.png");

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
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_buy_x64 = Button.builder(Component.translatable("gui.easy_economy.iron_buy_gui.button_buy_x64"), e -> {
			if (true) {
				EasyEconomyMod.PACKET_HANDLER.sendToServer(new IronBuyGUIButtonMessage(0, x, y, z));
				IronBuyGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 59, this.topPos + 93, 61, 20).build();
		guistate.put("button:button_buy_x64", button_buy_x64);
		this.addRenderableWidget(button_buy_x64);
		button_buy_x1 = Button.builder(Component.translatable("gui.easy_economy.iron_buy_gui.button_buy_x1"), e -> {
			if (true) {
				EasyEconomyMod.PACKET_HANDLER.sendToServer(new IronBuyGUIButtonMessage(1, x, y, z));
				IronBuyGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 61, this.topPos + 39, 56, 20).build();
		guistate.put("button:button_buy_x1", button_buy_x1);
		this.addRenderableWidget(button_buy_x1);
		button_back = Button.builder(Component.translatable("gui.easy_economy.iron_buy_gui.button_back"), e -> {
			if (true) {
				EasyEconomyMod.PACKET_HANDLER.sendToServer(new IronBuyGUIButtonMessage(2, x, y, z));
				IronBuyGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 2, 46, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
