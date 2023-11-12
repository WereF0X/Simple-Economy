package net.mcreator.simpleeconomy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.village.VillageSiegeEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DisableProcedure {
	@SubscribeEvent
	public static void onVillageSiege(VillageSiegeEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (event != null && event.isCancelable()) {
			event.setCanceled(true);
		}
	}
}
