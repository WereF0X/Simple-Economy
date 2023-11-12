package net.mcreator.simpleeconomy.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.simpleeconomy.world.inventory.SearchGUIMenu;
import net.mcreator.simpleeconomy.network.SearchGUIButtonMessage;
import net.mcreator.simpleeconomy.SimpleEconomyMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SearchGUIScreen extends AbstractContainerScreen<SearchGUIMenu> {
	private final static HashMap<String, Object> guistate = SearchGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Search;
	Button button_search;

	public SearchGUIScreen(SearchGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 203;
		this.imageHeight = 42;
	}

	private static final ResourceLocation texture = new ResourceLocation("simple_economy:textures/screens/search_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Search.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (Search.isFocused())
			return Search.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Search.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.simple_economy.search_gui.label_ores_only"), 82, 29, -65536, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		Search = new EditBox(this.font, this.leftPos + 6, this.topPos + 9, 120, 20, Component.translatable("gui.simple_economy.search_gui.Search")) {
			{
				setSuggestion(Component.translatable("gui.simple_economy.search_gui.Search").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simple_economy.search_gui.Search").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.simple_economy.search_gui.Search").getString());
				else
					setSuggestion(null);
			}
		};
		Search.setMaxLength(32767);
		guistate.put("text:Search", Search);
		this.addWidget(this.Search);
		button_search = Button.builder(Component.translatable("gui.simple_economy.search_gui.button_search"), e -> {
			if (true) {
				SimpleEconomyMod.PACKET_HANDLER.sendToServer(new SearchGUIButtonMessage(0, x, y, z));
				SearchGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 139, this.topPos + 9, 56, 20).build();
		guistate.put("button:button_search", button_search);
		this.addRenderableWidget(button_search);
	}
}
