package dev.tenseiyt.quartz.features;


import dev.tenseiyt.quartz.Main;
import dev.tenseiyt.quartz.utils.utils;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.jetbrains.annotations.NotNull;

import java.security.Key;

public class NetherWart {

         public static boolean left = true;
         public static boolean forward = false;

         private static long currentTimeMillisSetSpawn = utils.currentTimeMillis();

         private static long getCurrentTimeMillisSwitch = utils.currentTimeMillis();

         @SubscribeEvent
         public void farmRow(@NotNull TickEvent.ClientTickEvent event) {
             if (MacroHandler.isMacroOn && MacroHandler.isNetherWart) {
                 KeyBinding.setKeyBindState(Main.mc.gameSettings.keyBindAttack.getKeyCode(), true );
                 KeyBinding.setKeyBindState(Main.mc.gameSettings.keyBindLeft.getKeyCode(), left);
                 KeyBinding.setKeyBindState(Main.mc.gameSettings.keyBindRight.getKeyCode(), !left);
                 KeyBinding.setKeyBindState(Main.mc.gameSettings.keyBindForward.getKeyCode(), forward);

             }
         }


}
