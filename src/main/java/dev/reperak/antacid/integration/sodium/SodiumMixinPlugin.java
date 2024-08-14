package dev.reperak.antacid.integration.sodium;

import java.util.List;
import java.util.Set;

import dev.reperak.antacid.Antacid;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.fabricmc.loader.api.FabricLoader;

public final class SodiumMixinPlugin
	implements IMixinConfigPlugin
{
	@Override
	public void onLoad(String mixinPackage)
	{
	}

	@Override
	public String getRefMapperConfig()
	{
		return null;
	}

	@Override
	public boolean shouldApplyMixin(
		final String targetClassName,
		final String mixinClassName)
	{
		if (FabricLoader.getInstance().isModLoaded("sodium")) {
			Antacid.LOGGER.info("Detected Sodium, applying Sodium-specific patches.");
			return true;
		}
		return false;
	}

	@Override
	public void acceptTargets(
		final Set<String> myTargets,
		final Set<String> otherTargets)
	{
	}

	@Override
	public List<String> getMixins() { return null; }

	@Override
	public void preApply(
		final String     targetClassName,
		final ClassNode  targetClass,
		final String     mixinClassName,
		final IMixinInfo mixinInfo)
	{
	}

	@Override
	public void postApply(
		final String     targetClassName,
		final ClassNode  targetClass,
		final String     mixinClassName,
		final IMixinInfo mixinInfo)
	{
	}
}
