package io.github.marcus8448.mods.vieoverlay.mixin;

import arc.Core;
import io.github.marcus8448.mods.vieoverlay.ViewOverlay;
import mindustry.input.DesktopInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DesktopInput.class)
public abstract class DesktopInputMixin {
    @Inject(method = "update", remap = false, at = @At(value = "RETURN", remap = false))
    private void update(CallbackInfo ci) {
        if (ViewOverlay.timeSincePress > 0) ViewOverlay.timeSincePress--;
        if (Core.input.keyDown(ViewOverlay.OVERLAY_TOGGLE) && ViewOverlay.timeSincePress == 0) {
            ViewOverlay.drawOverlay = !ViewOverlay.drawOverlay;
            ViewOverlay.timeSincePress = 5;
        }
    }
}
