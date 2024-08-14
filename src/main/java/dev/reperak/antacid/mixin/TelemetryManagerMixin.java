package dev.reperak.antacid.mixin;

import dev.reperak.antacid.Antacid;
import net.minecraft.client.session.telemetry.TelemetryManager;
import net.minecraft.client.session.telemetry.TelemetrySender;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = TelemetryManager.class)
public class TelemetryManagerMixin
{
	@Inject(
		method      = "computeSender",
		at          = @At("HEAD"),
		cancellable = true
	)
	private void Antacid$KillMandatoryTelemetry(
		final CallbackInfoReturnable<TelemetrySender> cir)
	{
		Antacid.LOGGER.info("Blocking an attempt to send telemetry data to Mojang.");
		cir.setReturnValue(TelemetrySender.NOOP);
	}
}
