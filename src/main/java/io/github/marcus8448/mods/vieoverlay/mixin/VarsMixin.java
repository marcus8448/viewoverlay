package io.github.marcus8448.mods.vieoverlay.mixin;

import arc.KeyBinds;
import io.github.marcus8448.mods.vieoverlay.ViewOverlay;
import mindustry.Vars;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Vars.class)
public abstract class VarsMixin {
    @Redirect(method = "loadSettings", at = @At(value = "INVOKE", target = "Larc/KeyBinds;setDefaults([Larc/KeyBinds$KeyBind;[Larc/KeyBinds$Section;)V", remap = false), remap = false)
    private static void loadSettings_VO(KeyBinds keyBinds, KeyBinds.KeyBind[] defs, KeyBinds.Section[] sectionArr) {
        KeyBinds.KeyBind[] def2 = new KeyBinds.KeyBind[defs.length + 1];
        System.arraycopy(defs, 0, def2, 0, defs.length);
        def2[defs.length] = ViewOverlay.OVERLAY_TOGGLE;
        keyBinds.setDefaults(def2, sectionArr);
    }
}
