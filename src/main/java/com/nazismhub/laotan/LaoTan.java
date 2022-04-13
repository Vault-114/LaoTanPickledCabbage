package com.nazismhub.laotan;

import com.nazismhub.laotan.item.Items;
import net.fabricmc.api.ModInitializer;

public class LaoTan implements ModInitializer {
    @Override
    public void onInitialize() {
        Items.register();
    }
}
