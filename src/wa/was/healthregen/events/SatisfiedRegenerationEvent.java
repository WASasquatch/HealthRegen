package wa.was.healthregen.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class SatisfiedRegenerationEvent implements Listener {

	@EventHandler(priority=EventPriority.HIGH)
	public void onSatisfiedHealthRegen(EntityRegainHealthEvent event) {
		if ( event.getEntity() instanceof Player 
				&& event.getRegainReason().equals(RegainReason.SATIATED) ) {
			Player player =  (Player) event.getEntity();
			if ( player.hasPermission("healthregen.allow") ) {
				event.setCancelled(true);
			}
		}
	}
	
}
