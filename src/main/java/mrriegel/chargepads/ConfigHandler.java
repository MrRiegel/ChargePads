package mrriegel.chargepads;

import java.io.File;

import mrriegel.chargepads.tile.TilePad.Pad;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;

public class ConfigHandler {

	public static Configuration config;

	public static boolean RF, TESLA, FE;

	public static void refreshConfig(File file) {
		config = new Configuration(file);
		config.load();

		RF = config.getBoolean("rf", Pad.ENERGY.name(), true, "Enable RF.");
		TESLA = config.getBoolean("tesla", Pad.ENERGY.name(), Loader.isModLoaded("tesla"), "Enable Tesla.");
		FE = config.getBoolean("fe", Pad.ENERGY.name(), true, "Enable Forge Energy.");

		if (config.hasChanged()) {
			config.save();
		}
	}

}
