package dev.reperak.antacid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Antacid
	implements ModInitializer
{
	public static final Logger LOGGER = LoggerFactory.getLogger("antacid");

	public static boolean isMinecraftLanguageEnglish()
	{
		return MinecraftClient
			.getInstance()
			.getLanguageManager()
			.getLanguage()
			.startsWith("en_");
	}

	@Override
	public void onInitialize()
	{
		LOGGER.info("Antacid has been initialized.");
	}
}
