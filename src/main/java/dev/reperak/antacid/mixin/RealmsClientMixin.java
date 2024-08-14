package dev.reperak.antacid.mixin;

import dev.reperak.antacid.Antacid;
import net.minecraft.client.realms.RealmsClient;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = RealmsClient.class)
public class RealmsClientMixin
{
	@Inject(
		method      = "execute",
		at          = @At("HEAD"),
		cancellable = true
	)
	private void Antacid$KillRealmsNetworking(
		final CallbackInfoReturnable<String> cir)
	{
		Antacid.LOGGER.info("Blocking an attempt to connect to Realms (there will likely be an exception below, but the client will recover).");
		cir.setReturnValue("");
	}
}
