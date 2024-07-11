package dev.tenseiyt.quartz.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;

public class QuartzOneConfig extends Config {

    public QuartzOneConfig() {
        super(new Mod("Quartz", ModType.SKYBLOCK, ""), "quartz.json");
        initialize();
    }


}

