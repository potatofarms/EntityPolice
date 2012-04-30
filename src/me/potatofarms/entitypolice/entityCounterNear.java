package me.potatofarms.entitypolice;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

public class entityCounterNear {
	public String countEntitiesNear(Player playerC, double x, double y,
			double z, String entityName, String pluginName) {
		Integer all = 0;

		Boolean validEntityName = false;
		for (EntityNames en : EntityNames.values()) {
			String theName = en.getName();
			if (theName.equalsIgnoreCase(entityName)) {
				validEntityName = true;
			} else {
				continue;
			}
			continue;
		}
		if (validEntityName == true && !entityName.equalsIgnoreCase("monster")
				&& !entityName.equalsIgnoreCase("animal")
				&& !entityName.equalsIgnoreCase("mob")
				&& !entityName.equalsIgnoreCase("squid")
				&& !entityName.equalsIgnoreCase("PigZombie")
				&& !entityName.equalsIgnoreCase("MagmaCube")
				&& !entityName.equalsIgnoreCase("MushroomCow")
				&& !entityName.equalsIgnoreCase("IronGolem")
				&& !entityName.equalsIgnoreCase("Golem")
				&& !entityName.equalsIgnoreCase("Enderman")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if (f.getType().toString().equalsIgnoreCase(entityName)) {
					all++;
					continue;
				}
			}
		} else if (validEntityName == true
				&& entityName.equalsIgnoreCase("monster")) {
			for (Entity f : playerC.getNearbyEntities(x, y, z)) {
				if(f instanceof Monster) {
					all++;
				}
			}
		}

		else {
			return ChatColor.RED + "Invalid Entity.";
		}

		return ChatColor.GOLD + "[" + pluginName + "]" + ChatColor.GREEN
				+ " There are " + ChatColor.WHITE + all.toString()
				+ ChatColor.GREEN + " " + entityName + "s near "
				+ playerC.getName();

	}
}
