package dev.reperak.antacid;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Antacid
	implements ModInitializer
{
	public static final Logger LOGGER = LoggerFactory.getLogger("antacid");

	@Override
	public void onInitialize()
	{
		LOGGER.info("Antacid has been initialized.");
	}
}
