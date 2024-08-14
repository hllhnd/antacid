package dev.reperak.antacid.integration.sodium.mixin;

import java.lang.reflect.Type;

import dev.reperak.antacid.Antacid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import me.jellysquid.mods.sodium.client.gui.SodiumGameOptions;
import me.jellysquid.mods.sodium.client.gui.SodiumGameOptions.NotificationSettings;

@Mixin(value = SodiumGameOptions.class, remap = false)
public class SodiumGameOptionsMixin
{
	/**
	 * Custom {@link JsonDeserializer} that hijacks loading of {@link NotificationSettings} to always make the {@code has_cleared_donation_button} and
	 * {@code has_seen_donation_prompt} fields true.
	 */
	private static final class NotificationSettingsJsonDeserializer
		implements JsonDeserializer<NotificationSettings>
	{
		@Override
		public NotificationSettings deserialize(
			final JsonElement                json,
			final Type                       typeOfT,
			final JsonDeserializationContext context)
				throws JsonParseException
		{
			Antacid.LOGGER.info("Overriding Sodium's configuration for donationware.");
			// Creating a new instance is good enough since the default constructor is patched to set these fields to true.
			return new NotificationSettings();
		}
	}

	@Mixin(value = SodiumGameOptions.NotificationSettings.class, remap = false)
	public static class NotificationSettingsMixin
	{
		// These two shadowed variables are enough to disable donationware on *fresh installs*, but it won't fix existing installs, since GSON
		// exclusively uses reflection to deserialize into classes, which will ignore the implicit constructor that sets these fields.
		@Shadow public boolean hasClearedDonationButton = true;
		@Shadow public boolean hasSeenDonationPrompt    = true;
	}

	/**
	 * Injects into {@link SodiumGameOptions}'s static initializer to insert custom deserialization "logic" (literally just returning true) for the
	 * donation related options.
	 */
	@Redirect(
		method = "<clinit>",
		at     = @At(
			value  = "INVOKE",
			target = "Lcom/google/gson/GsonBuilder;create()Lcom/google/gson/Gson;"
		)
	)
	private static Gson Antacid$HijackSodiumNotificationSettingsDeserializer(
		final GsonBuilder builder)
	{
		builder.registerTypeAdapter(
			SodiumGameOptions.NotificationSettings.class,
			new NotificationSettingsJsonDeserializer());
		return builder.create();
	}
}
