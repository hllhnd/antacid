package dev.reperak.antacid.integration.sodium.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.Mixin;

import me.jellysquid.mods.sodium.client.gui.SodiumGameOptions.NotificationSettings;
import me.jellysquid.mods.sodium.client.gui.SodiumOptionsGUI;

@Mixin(value = SodiumOptionsGUI.class, remap = false)
public class SodiumOptionsGUIMixin
{
	@Redirect(
		method = "rebuildGUI()V",
		at     = @At(
			value  = "FIELD",
			target = "Lme/jellysquid/mods/sodium/client/gui/SodiumGameOptions$NotificationSettings;hasClearedDonationButton:Z",
			opcode = Opcodes.GETFIELD
		)
	)
	private boolean Antacid$ForceHideSodiumDonationButton(
		final NotificationSettings notificationSettings)
	{
		return true;
	}

	@Redirect(
		method = "checkPromptTimers()V",
		at     = @At(
			value  = "FIELD",
			target = "Lme/jellysquid/mods/sodium/client/gui/SodiumGameOptions$NotificationSettings;hasSeenDonationPrompt:Z",
			opcode = Opcodes.GETFIELD
		)
	)
	private boolean Antacid$ForceHideSodiumDonationPrompt(
		final NotificationSettings notificationSettings)
	{
		return true;
	}
}
