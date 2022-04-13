package com.nazismhub.laotan.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Items {
    /*
    * 这里为了达到滑稽讽刺的效果，故意使用了拼音命名
    */
    public static final Item LAO_TAN_SUAN_CAI = new LaoTanSuanCai(
            new FabricItemSettings()
                    .group(ItemGroup.FOOD)
                    .maxCount(16)
                    .food(createStew(1)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 3), 0.9f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 6), 0.9f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 5), 0.9f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 10), 0.9f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA , 100, 3), 0.9f)
                            .build())
    );
    /*
     * 其实这里百度机翻翻译成‘The old altar pickled beef noodles’
     * 这里为了达到滑稽讽刺的效果，故意采用了拼音命名
     */
    public static final Item LAO_TAN_NOODLES = new LaoTanSuanCaiNoodles(
            new FabricItemSettings()
                    .group(ItemGroup.FOOD)
                    .maxCount(1)
                    .food(createStew(4)
                            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 2000, 3), 0.7f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 2000, 6), 0.8f)
                            //.statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 3000, 5), 0.8f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1000, 10), 0.9f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 5000, 5), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS , 5000, 3), 0.6f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA , 5000, 10), 0.9f)
                            .build())
    );
    public static final Item PICKLED_CABBAGE = new PickledCabbage(
            new FabricItemSettings()
                    .group(ItemGroup.FOOD)
                    .maxCount(16)
                    .food(createStew(2).build())
    );
    public static final Item CIGARETTE_ENDS = new Item(
            new FabricItemSettings()
                    .group(ItemGroup.MISC)
                    .maxCount(64)
    );

    public static final Item SALT = new Item(
            new FabricItemSettings().maxCount(64).group(ItemGroup.MISC)
    );

    public static final Item CRUDE_SALT = new Item(
            new FabricItemSettings().maxCount(64).group(ItemGroup.MISC)
    );

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("laotan", "pickled_cabbage"), PICKLED_CABBAGE);
        Registry.register(Registry.ITEM, new Identifier("laotan", "suancai"), LAO_TAN_SUAN_CAI);
        Registry.register(Registry.ITEM, new Identifier("laotan", "noodles"), LAO_TAN_NOODLES);

        Registry.register(Registry.ITEM, new Identifier("laotan", "cigarette_ends"), CIGARETTE_ENDS);
        Registry.register(Registry.ITEM, new Identifier("laotan", "crude_salt"), CRUDE_SALT);
        Registry.register(Registry.ITEM, new Identifier("laotan", "salt"), SALT);
    }

    private static FoodComponent.Builder createStew(int hunger) {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(0.6f);
    }
}
