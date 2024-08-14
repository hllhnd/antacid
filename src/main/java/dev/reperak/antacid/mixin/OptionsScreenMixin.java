package dev.reperak.antacid.mixin;

import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = OptionsScreen.class)
public class OptionsScreenMixin
{
	@Shadow @Final
	private static final Tooltip TELEMETRY_DISABLED_TOOLTIP =
		MinecraftClient.getInstance().getLanguageManager().getLanguage().equals("en_us")
			? Tooltip.of(Text.of("Telemetry has been disabled by Antacid."))
			: Tooltip.of(Text.translatable("options.telemetry.disabled"));
}
