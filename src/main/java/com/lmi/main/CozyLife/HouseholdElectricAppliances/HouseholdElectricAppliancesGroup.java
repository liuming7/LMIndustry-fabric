package com.lmi.main.CozyLife.HouseholdElectricAppliances;

import com.lmi.main.CozyLife.HouseholdElectricAppliances.Entity.ElectricOvenEntity;
import com.lmi.main.CozyLife.HouseholdElectricAppliances.Entity.RadioEntity;
import com.mojang.datafixers.DSL;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class HouseholdElectricAppliancesGroup {

    private static final double PIXEL_BIT = 16D;

    private static final ItemGroup HOUSEHOLD_ELECTRIC_APPLIANCES = FabricItemGroupBuilder.build(new Identifier("lmindustry", "household_electric_appliances"), () -> new ItemStack(HouseholdElectricAppliancesGroup.RADIO_ITEM));

    private static final Radio RADIO_BLOCK = new Radio(2,14,5,11,0,12,PIXEL_BIT);
    private static final Item RADIO_ITEM = new BlockItem(RADIO_BLOCK,new Item.Settings().group(HOUSEHOLD_ELECTRIC_APPLIANCES).maxCount(1));
    public static final BlockEntityType<RadioEntity> RADIO_ENTITY = BlockEntityType.Builder.create(RadioEntity::new,RADIO_BLOCK).build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY,"lmindustry:radio"));

    private static final ElectricOven ELECTRIC_OVEN_BLOCK = new ElectricOven(0,16,0,13,0,13,PIXEL_BIT);
    private static final Item ELECTRIC_OVEN_ITEM = new BlockItem(ELECTRIC_OVEN_BLOCK,new Item.Settings().group(HOUSEHOLD_ELECTRIC_APPLIANCES).maxCount(1));
    public static final BlockEntityType<ElectricOvenEntity> ELECTRIC_OVEN_ENTITY = BlockEntityType.Builder.create(ElectricOvenEntity::new,ELECTRIC_OVEN_BLOCK).build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, "lmindustry:electric_oven"));

    public static void onInitialize(String MODID){
        Registry.register(Registry.BLOCK, new Identifier(MODID, "radio"), HouseholdElectricAppliancesGroup.RADIO_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MODID, "radio"), HouseholdElectricAppliancesGroup.RADIO_ITEM);
        Registry.register(Registry.BLOCK_ENTITY_TYPE,"lmindustry:radio",HouseholdElectricAppliancesGroup.RADIO_ENTITY);

        Registry.register(Registry.BLOCK, new Identifier(MODID, "electric_oven"), HouseholdElectricAppliancesGroup.ELECTRIC_OVEN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MODID, "electric_oven"), HouseholdElectricAppliancesGroup.ELECTRIC_OVEN_ITEM);
        Registry.register(Registry.BLOCK_ENTITY_TYPE,"lmindustry:electric_oven",HouseholdElectricAppliancesGroup.ELECTRIC_OVEN_ENTITY);

    }
}
