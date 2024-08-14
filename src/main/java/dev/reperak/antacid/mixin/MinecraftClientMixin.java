package dev.reperak.antacid.mixin;

import dev.reperak.antacid.Antacid;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = MinecraftClient.class)
public class MinecraftClientMixin
{
	@Inject(
		method      = "isTelemetryEnabledByApi",
		at          = @At("HEAD"),
		cancellable = true
	)
	private void Antacid$KillMandatoryTelemetry(
		final CallbackInfoReturnable<Boolean> cir)
	{
		Antacid.LOGGER.info(
			"Disabling telemetry using the development profile exemption. The telemetry UI button will be disabled, "
			+ "and neither mandatory nor optional telemetry will ever be sent.");
		cir.setReturnValue(false);
	}
}
