package net.mcreator.simpleeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.simpleeconomy.world.inventory.OresMenu;
import net.mcreator.simpleeconomy.network.OresButtonMessage;
import net.mcreator.simpleeconomy.SimpleEconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class OresScreen extends AbstractContainerScreen<OresMenu> {
	private final static HashMap<String, Object> guistate = OresMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_iron;
	Button button_coal;
	Button button_gold;
	Button button_emerald;
	Button button_diamond;
	Button button_back;
	Button button_netherite;

	public OresScreen(OresMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("simple_economy:textures/screens/ores.png");

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
		button_iron = Button.builder(Component.translatable("gui.simple_economy.ores.button_iron"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new OresButtonMessage(0, x, y, z));
				OresButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 62, this.topPos + 27, 46, 20).build();
		guistate.put("button:button_iron", button_iron);
		this.addRenderableWidget(button_iron);
		button_coal = Button.builder(Component.translatable("gui.simple_economy.ores.button_coal"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new OresButtonMessage(1, x, y, z));
				OresButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 62, this.topPos + 3, 46, 20).build();
		guistate.put("button:button_coal", button_coal);
		this.addRenderableWidget(button_coal);
		button_gold = Button.builder(Component.translatable("gui.simple_economy.ores.button_gold"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new OresButtonMessage(2, x, y, z));
				OresButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 61, this.topPos + 55, 46, 20).build();
		guistate.put("button:button_gold", button_gold);
		this.addRenderableWidget(button_gold);
		button_emerald = Button.builder(Component.translatable("gui.simple_economy.ores.button_emerald"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new OresButtonMessage(3, x, y, z));
				OresButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 54, this.topPos + 85, 61, 20).build();
		guistate.put("button:button_emerald", button_emerald);
		this.addRenderableWidget(button_emerald);
		button_diamond = Button.builder(Component.translatable("gui.simple_economy.ores.button_diamond"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new OresButtonMessage(4, x, y, z));
				OresButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 55, this.topPos + 115, 61, 20).build();
		guistate.put("button:button_diamond", button_diamond);
		this.addRenderableWidget(button_diamond);
		button_back = Button.builder(Component.translatable("gui.simple_economy.ores.button_back"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new OresButtonMessage(5, x, y, z));
				OresButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 1, this.topPos + 2, 46, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_netherite = Button.builder(Component.translatable("gui.simple_economy.ores.button_netherite"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new OresButtonMessage(6, x, y, z));
				OresButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 48, this.topPos + 142, 72, 20).build();
		guistate.put("button:button_netherite", button_netherite);
		this.addRenderableWidget(button_netherite);
	}
}
