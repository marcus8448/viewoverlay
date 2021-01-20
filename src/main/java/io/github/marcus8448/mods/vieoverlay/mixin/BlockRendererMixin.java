package io.github.marcus8448.mods.vieoverlay.mixin;

import arc.struct.Seq;
import io.github.marcus8448.mods.vieoverlay.ViewOverlay;
import mindustry.gen.Building;
import mindustry.graphics.BlockRenderer;
import mindustry.world.Tile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockRenderer.class)
public abstract class BlockRendererMixin {
	@Shadow(remap = false) private Seq<Tile> tileview;

	@Inject(at = @At(value = "INVOKE", target = "Lmindustry/graphics/LightRenderer;enabled()Z", remap = false, shift = At.Shift.BEFORE), method = "drawBlocks", remap = false)
	private void draw(CallbackInfo ci) {
		if (ViewOverlay.drawOverlay) {
			for (Tile t : tileview) {
				Building entity = t.build;
				if (entity != null) entity.drawSelect();
			}
		}
	}
}
