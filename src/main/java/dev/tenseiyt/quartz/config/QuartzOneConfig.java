package dev.tenseiyt.quartz.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.annotations.KeyBind;
import cc.polyfrost.oneconfig.config.annotations.Number;
import cc.polyfrost.oneconfig.config.annotations.Slider;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;
import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import dev.tenseiyt.quartz.features.AutoSell;
import gg.essential.universal.UKeyboard;

public class QuartzOneConfig extends Config {

    public QuartzOneConfig() {
        super(new Mod("Quartz", ModType.SKYBLOCK, "C:\\Users\\bkyt0\\OneDrive\\Desktop\\x\\nether_quartz.png"), "quartz.json");
        initialize();
    }


    @Switch(
            category = "QOL",
            subcategory = "Dungeons",
            name = "CryptESP",
            size = OptionSize.SINGLE

    )
    public static boolean bob = false;

    @Switch(
            category = "QOL",
            subcategory = "Dungeons",
            name = "Auto Chest Close (in Dungeons)",
            size = OptionSize.SINGLE
    )
    public static boolean rob = false;

    @Switch(
            category = "QOL",
            subcategory = "Dungeons",
            name = "Dungeon Door ESP",
            size = OptionSize.SINGLE
    )
    public static boolean tob = false;


    @Dropdown(
            category = "Macros",
            subcategory = "Farming",
            name = "Macro Options",
            options = {"Nether Wart (S)", "Sugar Cane", "Vertical Farms"}
    )
    public static int value = 1;

    @KeyBind(
            category = "Macros",
            subcategory = "Farming",
            name = "Macro Keybind"
    )
    public static OneKeyBind keybind = new OneKeyBind(UKeyboard.KEY_LSHIFT, UKeyboard.KEY_S);

    @Switch(
            category = "Macros",
            subcategory = "Farming",
            name = "Bedrock Failsafe",
            size = OptionSize.SINGLE
    )
    public static boolean pop = false;

    @Switch(
            category = "Macros",
            subcategory = "Farming",
            name = "Island Failsafe",
            size = OptionSize.SINGLE
    )
    public static boolean cop = false;

    @Switch(
            category = "Macros",
            subcategory = "Farming",
            name = "Jacob Failsafe",
            size = OptionSize.SINGLE
    )
    public static boolean fop = false;

    @Switch(
            category = "QOL",
            subcategory = "Farming",
            name = "Farming HUD",
            size = OptionSize.SINGLE
    )
    public static boolean iop = false;

    @Switch(
            category = "QOL",
            subcategory = "Slayers",
            name = "Hide Summons",
            size = OptionSize.SINGLE
    )
    public static boolean dpe = false;

    @Slider(
            category = "Macros",
            subcategory = "Farming",
            name = "Pitch",
            min = -90f, max = 90f

    )
    public static float slideyboi = 0f;

    @Slider(
            category = "Macros",
            subcategory = "Farming",
            name = "Yaw",
            min = -180f, max = 180f

    )
    public static float slideyboi2 = 0f;

    @Switch(
            category = "Macros",
            subcategory = "Farming",
            name = "Anti-Stuck",
            size = OptionSize.SINGLE
    )
    public static boolean tps = false;

    @Number(
        category = "Macros",
        subcategory = "Farming",
        name = "AutoSell",
        min = 1, max = 10,
        step = 5
    )
    public static int num = 5;


    @Dropdown(
            category = "Macros",
            subcategory = "Overworld",
            name = "Macro Options",
            options = {"Bazaar Flipper", "Jerry Box", "Rune Combine"}
    )
    public static int value2 = 1;

    @KeyBind(
            category = "Macros",
            subcategory = "Overworld",
            name = "Bazaar Keybind"
    )
    public static OneKeyBind bazarkey = new OneKeyBind(UKeyboard.KEY_LSHIFT, UKeyboard.KEY_D);

    @Switch(
            category = "QOL",
            subcategory = "Overworld",
            name = "FairySoul Aura",
            size = OptionSize.SINGLE
    )
    public static boolean ikf = false;




}


