package dev.reperak.antacid.mixin;

import java.util.List;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = TitleScreen.class)
public class TitleScreenMixin
{
	@Mixin(value = Screen.class)
	private static interface ScreenMixin
	{
		@Accessor(value = "drawables")
		public List<Drawable> getDrawables();
	}

	@Inject(
		method = "initWidgetsNormal",
		at     = @At("TAIL")
	)
	private void Antacid$DisableRealmsTitleScreenButton(
		final CallbackInfo ci)
	{
		((ScreenMixin) (Object) this).getDrawables()
			.stream()
			.filter(drawable -> drawable instanceof ButtonWidget)
			.map(drawable -> ((ButtonWidget) drawable))
			.filter(button -> button.getMessage().getString().equals(Text.translatable("menu.online").getString()))
			.forEach(button -> {
				button.active = false;
				if (MinecraftClient.getInstance().getLanguageManager().getLanguage().equals("en_us"))
					button.setTooltip(Tooltip.of(Text.of("Minecraft Realms is disabled by Antacid.")));
			});
	}
}
