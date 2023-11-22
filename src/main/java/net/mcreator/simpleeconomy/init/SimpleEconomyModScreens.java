
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.simpleeconomy.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.simpleeconomy.client.gui.ShopGUIScreen;
import net.mcreator.simpleeconomy.client.gui.SearchGUIScreen;
import net.mcreator.simpleeconomy.client.gui.PvPGUIScreen;
import net.mcreator.simpleeconomy.client.gui.OresScreen;
import net.mcreator.simpleeconomy.client.gui.NetheriteScrapGUIScreen;
import net.mcreator.simpleeconomy.client.gui.NetheriteScrapBuyGUIScreen;
import net.mcreator.simpleeconomy.client.gui.NetheriteIngotGUIScreen;
import net.mcreator.simpleeconomy.client.gui.NetheriteIngotBuyGUIScreen;
import net.mcreator.simpleeconomy.client.gui.NetheriteGUIScreen;
import net.mcreator.simpleeconomy.client.gui.IronGUIScreen;
import net.mcreator.simpleeconomy.client.gui.IronBuyGUIScreen;
import net.mcreator.simpleeconomy.client.gui.GoldGUIScreen;
import net.mcreator.simpleeconomy.client.gui.GoldBuyGUIScreen;
import net.mcreator.simpleeconomy.client.gui.FoodGUIScreen;
import net.mcreator.simpleeconomy.client.gui.FoodGUIPage2Screen;
import net.mcreator.simpleeconomy.client.gui.EmeraldGUIScreen;
import net.mcreator.simpleeconomy.client.gui.EmeraldBuyGUIScreen;
import net.mcreator.simpleeconomy.client.gui.DiamondGUIScreen;
import net.mcreator.simpleeconomy.client.gui.DiamondBuyGUIScreen;
import net.mcreator.simpleeconomy.client.gui.CoalGUIScreen;
import net.mcreator.simpleeconomy.client.gui.CoalBuyGUIScreen;
import net.mcreator.simpleeconomy.client.gui.AuctionHouseScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SimpleEconomyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SimpleEconomyModMenus.ORES.get(), OresScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.SHOP_GUI.get(), ShopGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.COAL_GUI.get(), CoalGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.COAL_BUY_GUI.get(), CoalBuyGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.IRON_GUI.get(), IronGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.IRON_BUY_GUI.get(), IronBuyGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.GOLD_GUI.get(), GoldGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.GOLD_BUY_GUI.get(), GoldBuyGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.EMERALD_GUI.get(), EmeraldGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.EMERALD_BUY_GUI.get(), EmeraldBuyGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.DIAMOND_GUI.get(), DiamondGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.DIAMOND_BUY_GUI.get(), DiamondBuyGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.NETHERITE_GUI.get(), NetheriteGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.NETHERITE_SCRAP_GUI.get(), NetheriteScrapGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.NETHERITE_SCRAP_BUY_GUI.get(), NetheriteScrapBuyGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.NETHERITE_INGOT_GUI.get(), NetheriteIngotGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.NETHERITE_INGOT_BUY_GUI.get(), NetheriteIngotBuyGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.SEARCH_GUI.get(), SearchGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.FOOD_GUI.get(), FoodGUIScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.FOOD_GUI_PAGE_2.get(), FoodGUIPage2Screen::new);
			MenuScreens.register(SimpleEconomyModMenus.AUCTION_HOUSE.get(), AuctionHouseScreen::new);
			MenuScreens.register(SimpleEconomyModMenus.PV_PGUI.get(), PvPGUIScreen::new);
		});
	}
}
