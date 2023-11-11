
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.easyeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.easyeconomy.world.inventory.ShopGUIMenu;
import net.mcreator.easyeconomy.world.inventory.OresMenu;
import net.mcreator.easyeconomy.world.inventory.NetheriteScrapGUIMenu;
import net.mcreator.easyeconomy.world.inventory.NetheriteScrapBuyGUIMenu;
import net.mcreator.easyeconomy.world.inventory.NetheriteIngotGUIMenu;
import net.mcreator.easyeconomy.world.inventory.NetheriteIngotBuyGUIMenu;
import net.mcreator.easyeconomy.world.inventory.NetheriteGUIMenu;
import net.mcreator.easyeconomy.world.inventory.IronGUIMenu;
import net.mcreator.easyeconomy.world.inventory.IronBuyGUIMenu;
import net.mcreator.easyeconomy.world.inventory.GoldGUIMenu;
import net.mcreator.easyeconomy.world.inventory.GoldBuyGUIMenu;
import net.mcreator.easyeconomy.world.inventory.EmeraldGUIMenu;
import net.mcreator.easyeconomy.world.inventory.EmeraldBuyGUIMenu;
import net.mcreator.easyeconomy.world.inventory.DiamondGUIMenu;
import net.mcreator.easyeconomy.world.inventory.DiamondBuyGUIMenu;
import net.mcreator.easyeconomy.world.inventory.CoalGUIMenu;
import net.mcreator.easyeconomy.world.inventory.CoalBuyGUIMenu;
import net.mcreator.easyeconomy.EasyEconomyMod;

public class EasyEconomyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EasyEconomyMod.MODID);
	public static final RegistryObject<MenuType<OresMenu>> ORES = REGISTRY.register("ores", () -> IForgeMenuType.create(OresMenu::new));
	public static final RegistryObject<MenuType<ShopGUIMenu>> SHOP_GUI = REGISTRY.register("shop_gui", () -> IForgeMenuType.create(ShopGUIMenu::new));
	public static final RegistryObject<MenuType<CoalGUIMenu>> COAL_GUI = REGISTRY.register("coal_gui", () -> IForgeMenuType.create(CoalGUIMenu::new));
	public static final RegistryObject<MenuType<CoalBuyGUIMenu>> COAL_BUY_GUI = REGISTRY.register("coal_buy_gui", () -> IForgeMenuType.create(CoalBuyGUIMenu::new));
	public static final RegistryObject<MenuType<IronGUIMenu>> IRON_GUI = REGISTRY.register("iron_gui", () -> IForgeMenuType.create(IronGUIMenu::new));
	public static final RegistryObject<MenuType<IronBuyGUIMenu>> IRON_BUY_GUI = REGISTRY.register("iron_buy_gui", () -> IForgeMenuType.create(IronBuyGUIMenu::new));
	public static final RegistryObject<MenuType<GoldGUIMenu>> GOLD_GUI = REGISTRY.register("gold_gui", () -> IForgeMenuType.create(GoldGUIMenu::new));
	public static final RegistryObject<MenuType<GoldBuyGUIMenu>> GOLD_BUY_GUI = REGISTRY.register("gold_buy_gui", () -> IForgeMenuType.create(GoldBuyGUIMenu::new));
	public static final RegistryObject<MenuType<EmeraldGUIMenu>> EMERALD_GUI = REGISTRY.register("emerald_gui", () -> IForgeMenuType.create(EmeraldGUIMenu::new));
	public static final RegistryObject<MenuType<EmeraldBuyGUIMenu>> EMERALD_BUY_GUI = REGISTRY.register("emerald_buy_gui", () -> IForgeMenuType.create(EmeraldBuyGUIMenu::new));
	public static final RegistryObject<MenuType<DiamondGUIMenu>> DIAMOND_GUI = REGISTRY.register("diamond_gui", () -> IForgeMenuType.create(DiamondGUIMenu::new));
	public static final RegistryObject<MenuType<DiamondBuyGUIMenu>> DIAMOND_BUY_GUI = REGISTRY.register("diamond_buy_gui", () -> IForgeMenuType.create(DiamondBuyGUIMenu::new));
	public static final RegistryObject<MenuType<NetheriteGUIMenu>> NETHERITE_GUI = REGISTRY.register("netherite_gui", () -> IForgeMenuType.create(NetheriteGUIMenu::new));
	public static final RegistryObject<MenuType<NetheriteScrapGUIMenu>> NETHERITE_SCRAP_GUI = REGISTRY.register("netherite_scrap_gui", () -> IForgeMenuType.create(NetheriteScrapGUIMenu::new));
	public static final RegistryObject<MenuType<NetheriteScrapBuyGUIMenu>> NETHERITE_SCRAP_BUY_GUI = REGISTRY.register("netherite_scrap_buy_gui", () -> IForgeMenuType.create(NetheriteScrapBuyGUIMenu::new));
	public static final RegistryObject<MenuType<NetheriteIngotGUIMenu>> NETHERITE_INGOT_GUI = REGISTRY.register("netherite_ingot_gui", () -> IForgeMenuType.create(NetheriteIngotGUIMenu::new));
	public static final RegistryObject<MenuType<NetheriteIngotBuyGUIMenu>> NETHERITE_INGOT_BUY_GUI = REGISTRY.register("netherite_ingot_buy_gui", () -> IForgeMenuType.create(NetheriteIngotBuyGUIMenu::new));
}
