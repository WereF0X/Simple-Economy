package net.mcreator.simpleeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.simpleeconomy.world.inventory.PvPGUIMenu;
import net.mcreator.simpleeconomy.network.PvPGUIButtonMessage;
import net.mcreator.simpleeconomy.SimpleEconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PvPGUIScreen extends AbstractContainerScreen<PvPGUIMenu> {
	private final static HashMap<String, Object> guistate = PvPGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_buy;
	Button button_buy1;
	Button button_back;
	Button button_next_page;

	public PvPGUIScreen(PvPGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("simple_economy:textures/screens/pv_pgui.png");

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
		button_buy = Button.builder(Component.translatable("gui.simple_economy.pv_pgui.button_buy"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new PvPGUIButtonMessage(0, x, y, z));
				PvPGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 32, this.topPos + 7, 40, 20).build();
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_buy1 = Button.builder(Component.translatable("gui.simple_economy.pv_pgui.button_buy1"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new PvPGUIButtonMessage(1, x, y, z));
				PvPGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 32, this.topPos + 32, 40, 20).build();
		guistate.put("button:button_buy1", button_buy1);
		this.addRenderableWidget(button_buy1);
		button_back = Button.builder(Component.translatable("gui.simple_economy.pv_pgui.button_back"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new PvPGUIButtonMessage(2, x, y, z));
				PvPGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 60, 46, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_next_page = Button.builder(Component.translatable("gui.simple_economy.pv_pgui.button_next_page"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new PvPGUIButtonMessage(3, x, y, z));
				PvPGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 82, this.topPos + 60, 72, 20).build();
		guistate.put("button:button_next_page", button_next_page);
		this.addRenderableWidget(button_next_page);
	}
}
