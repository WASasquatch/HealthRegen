package wa.was.healthregen.tasks;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Regeneration extends BukkitRunnable {
	
	private static JavaPlugin plugin;
	
	public Regeneration(JavaPlugin plug) {
		plugin =  plug;
	}

	@Override
	public void run() {
		for( Player player : Bukkit.getServer().getOnlinePlayers() ) {
			if ( player.hasPermission("healthregen.allow") ) {
				AttributeInstance pa = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
				double health = player.getHealth();
				double maxHealth = pa.getBaseValue();
				double newHealth = (health + plugin.getConfig().getLong("regen-amount"));
				if ( health < maxHealth ) {
					if ( newHealth > maxHealth ) {
						player.setHealth(maxHealth);
					} else {
						player.setHealth(newHealth);
					}
				}
			}
		}
	}
	
}
