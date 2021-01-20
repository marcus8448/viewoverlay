package io.github.marcus8448.mods.vieoverlay.mixin;

import arc.func.Cons;
import mindustry.net.CrashSender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(CrashSender.class)
public abstract class CrashSenderMixin {
    @Inject(method = "send", at = @At(value = "HEAD", remap = false), remap = false)
    private static void noSendThank(Throwable exception, Cons<File> writeListener, CallbackInfo ci) throws Throwable {
        throw exception;
    }
}
