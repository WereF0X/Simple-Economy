package net.mcreator.easyeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.easyeconomy.world.inventory.NetheriteScrapGUIMenu;
import net.mcreator.easyeconomy.network.NetheriteScrapGUIButtonMessage;
import net.mcreator.easyeconomy.EasyEconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NetheriteScrapGUIScreen extends AbstractContainerScreen<NetheriteScrapGUIMenu> {
	private final static HashMap<String, Object> guistate = NetheriteScrapGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_buy;
	Button button_back;

	public NetheriteScrapGUIScreen(NetheriteScrapGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("easy_economy:textures/screens/netherite_scrap_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.easy_economy.netherite_scrap_gui.label_buy_price_7"), 52, 53, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.easy_economy.netherite_scrap_gui.label_sell_price_050"), 44, 94, -16711936, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_buy = Button.builder(Component.translatable("gui.easy_economy.netherite_scrap_gui.button_buy"), e -> {
			if (true) {
				EasyEconomyMod.PACKET_HANDLER.sendToServer(new NetheriteScrapGUIButtonMessage(0, x, y, z));
				NetheriteScrapGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 62, this.topPos + 68, 40, 20).build();
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_back = Button.builder(Component.translatable("gui.easy_economy.netherite_scrap_gui.button_back"), e -> {
			if (true) {
				EasyEconomyMod.PACKET_HANDLER.sendToServer(new NetheriteScrapGUIButtonMessage(1, x, y, z));
				NetheriteScrapGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 3, 46, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
