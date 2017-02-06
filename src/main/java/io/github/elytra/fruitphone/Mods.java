package io.github.elytra.fruitphone;

import com.google.common.base.Objects;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;

public class Mods {

	public static ModContainer getOwningMod(Entity entity) {
		EntityRegistration reg = EntityRegistry.instance().lookupModSpawn(entity.getClass(), true);
		if (reg == null) {
			return Loader.instance().getMinecraftModContainer();
		}
		return Objects.firstNonNull(reg.getContainer(), Loader.instance().getMinecraftModContainer());
	}
	
	public static ModContainer getOwningMod(Block block) {
		return Objects.firstNonNull(Loader.instance().getIndexedModList().get(block.getRegistryName().getResourceDomain()), Loader.instance().getMinecraftModContainer());
	}

}