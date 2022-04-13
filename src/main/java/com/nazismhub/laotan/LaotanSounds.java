package com.nazismhub.laotan;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;

public class LaotanSounds {

    public static final SoundEvent EAT = of("laotan.eat");

    public static final SoundEvent FINISH_EAT = of("laotan.finish_eat");

    static SoundEvent of(String id) {
        SoundEvent sound = new SoundEvent(new Identifier("laotan", id));
        //Registry.register(Registry.SOUND_EVENT, new Identifier("laotan", id), sound);
        return sound;
    }
}
