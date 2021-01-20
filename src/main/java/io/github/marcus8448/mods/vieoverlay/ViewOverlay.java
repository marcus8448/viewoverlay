package io.github.marcus8448.mods.vieoverlay;

import arc.KeyBinds;
import arc.input.InputDevice;
import arc.input.KeyCode;
import net.fabricmc.api.ModInitializer;

public class ViewOverlay implements ModInitializer {
	public static boolean drawOverlay = false;
	public static byte timeSincePress = 0;
	public static final KeyBinds.KeyBind OVERLAY_TOGGLE = new KeyBinds.KeyBind() {
		@Override
		public String name() {
			return "force_overlay_toggle";
		}

		@Override
		public String category() {
			return "custom";
		}

		@Override
		public KeyBinds.KeybindValue defaultValue (InputDevice.DeviceType deviceType){
			return KeyCode.h;
		}
	};

	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric-Mindustry world!");
	}
}
