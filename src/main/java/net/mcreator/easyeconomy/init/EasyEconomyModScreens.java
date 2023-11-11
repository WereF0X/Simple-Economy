
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.easyeconomy.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.easyeconomy.client.gui.ShopGUIScreen;
import net.mcreator.easyeconomy.client.gui.OresScreen;
import net.mcreator.easyeconomy.client.gui.NetheriteScrapGUIScreen;
import net.mcreator.easyeconomy.client.gui.NetheriteScrapBuyGUIScreen;
import net.mcreator.easyeconomy.client.gui.NetheriteIngotGUIScreen;
import net.mcreator.easyeconomy.client.gui.NetheriteIngotBuyGUIScreen;
import net.mcreator.easyeconomy.client.gui.NetheriteGUIScreen;
import net.mcreator.easyeconomy.client.gui.IronGUIScreen;
import net.mcreator.easyeconomy.client.gui.IronBuyGUIScreen;
import net.mcreator.easyeconomy.client.gui.GoldGUIScreen;
import net.mcreator.easyeconomy.client.gui.GoldBuyGUIScreen;
import net.mcreator.easyeconomy.client.gui.EmeraldGUIScreen;
import net.mcreator.easyeconomy.client.gui.EmeraldBuyGUIScreen;
import net.mcreator.easyeconomy.client.gui.DiamondGUIScreen;
import net.mcreator.easyeconomy.client.gui.DiamondBuyGUIScreen;
import net.mcreator.easyeconomy.client.gui.CoalGUIScreen;
import net.mcreator.easyeconomy.client.gui.CoalBuyGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EasyEconomyModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EasyEconomyModMenus.ORES.get(), OresScreen::new);
			MenuScreens.register(EasyEconomyModMenus.SHOP_GUI.get(), ShopGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.COAL_GUI.get(), CoalGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.COAL_BUY_GUI.get(), CoalBuyGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.IRON_GUI.get(), IronGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.IRON_BUY_GUI.get(), IronBuyGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.GOLD_GUI.get(), GoldGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.GOLD_BUY_GUI.get(), GoldBuyGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.EMERALD_GUI.get(), EmeraldGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.EMERALD_BUY_GUI.get(), EmeraldBuyGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.DIAMOND_GUI.get(), DiamondGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.DIAMOND_BUY_GUI.get(), DiamondBuyGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.NETHERITE_GUI.get(), NetheriteGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.NETHERITE_SCRAP_GUI.get(), NetheriteScrapGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.NETHERITE_SCRAP_BUY_GUI.get(), NetheriteScrapBuyGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.NETHERITE_INGOT_GUI.get(), NetheriteIngotGUIScreen::new);
			MenuScreens.register(EasyEconomyModMenus.NETHERITE_INGOT_BUY_GUI.get(), NetheriteIngotBuyGUIScreen::new);
		});
	}
}
