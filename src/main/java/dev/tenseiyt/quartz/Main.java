package dev.tenseiyt.quartz;

import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import cc.polyfrost.oneconfig.libs.checker.units.qual.A;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import dev.tenseiyt.quartz.config.QuartzOneConfig;
import dev.tenseiyt.quartz.features.AutoSell;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import dev.tenseiyt.quartz.config.QuartzOneConfig;
import scala.collection.parallel.ParIterableLike;

@Mod(modid = "quartz", useMetadata=true)


public class Main {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());

                MinecraftForge.EVENT_BUS.register(new AutoSell());
                MinecraftForge.EVENT_BUS.register(this);
    }



    @Instance("quartz")
    public static Main instance;

    public static Minecraft mc = Minecraft.getMinecraft();
    public static EntityPlayerSP mcPlayer = mc.thePlayer;
    public static WorldClient mcWorld = mc.theWorld;
    public static boolean notNull = false;

    public static boolean remindToUpdate = false;
    public static boolean sentUpdateReminder = false;




    @SubscribeEvent
    public final void onJoinWorld(@NotNull EntityJoinWorldEvent e) {
        if (mcWorld != null && mcPlayer != null && !sentUpdateReminder && remindToUpdate) {

            ChatStyle style = new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/TenseiYT/Quartz/releases/"));
            HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText("Click To Open the Quartz Github"));
            ChatComponentText linkMessage = new ChatComponentText(("https://github.com/TenseiYT/Quartz/releases/"));

            linkMessage.setChatStyle(style.setChatHoverEvent(hoverEvent));

            mcPlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "[" + EnumChatFormatting.LIGHT_PURPLE + "QUARTZ" + EnumChatFormatting.DARK_PURPLE + "]" + EnumChatFormatting.RESET + "A New Update Is Available! You could be missing out on new features or bugfixes!"));
            mcPlayer.addChatMessage(linkMessage);
            sentUpdateReminder = true;
        }

    }
        public static Main INSTANCE;



        public static QuartzOneConfig config = new QuartzOneConfig();

        @Subscribe
        public void onInit(InitializationEvent event) {
            config = new QuartzOneConfig();

    }


}


