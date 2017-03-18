package wa.was.healthregen;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import wa.was.healthregen.events.SatisfiedRegenerationEvent;
import wa.was.healthregen.tasks.Regeneration;

public class HealthRegen extends JavaPlugin {
	
	@Override
	public void onEnable() {
		createConfig();
		getServer().getPluginManager().registerEvents(new SatisfiedRegenerationEvent(), this);
		Regeneration regenTask = new Regeneration(this);
		regenTask.runTaskTimer(this, 0L, getConfig().getLong("regen-interval"));
	}
	
    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating it for you!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
