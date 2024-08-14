package dev.reperak.antacid.mixin;

import dev.reperak.antacid.Antacid;
import net.minecraft.network.packet.BrandCustomPayload;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = BrandCustomPayload.class)
public class BrandCustomPayloadMixin
{
	@ModifyArg(
		method = "write",
		at     = @At(
			value  = "INVOKE",
			target = "Lnet/minecraft/network/PacketByteBuf;writeString(Ljava/lang/String;)Lnet/minecraft/network/PacketByteBuf;"
		),
		index  = 0
	)
	private String Antacid$HijackClientBrandPacket(
		final String brand)
	{
		Antacid.LOGGER.info("Hijacking the client brand packet (fabric -> vanilla).");
		return "vanilla";
	}
}
