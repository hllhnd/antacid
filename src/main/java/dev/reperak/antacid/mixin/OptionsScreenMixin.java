package dev.reperak.antacid.mixin;

import dev.reperak.antacid.Antacid;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.text.Text;

@Mixin(value = OptionsScreen.class)
public class OptionsScreenMixin
{
	@Shadow @Final
	private static final Tooltip TELEMETRY_DISABLED_TOOLTIP =
		Antacid.isMinecraftLanguageEnglish()
			? Tooltip.of(Text.of("Telemetry has been disabled by Antacid."))
			: Tooltip.of(Text.translatable("options.telemetry.disabled"));
}
