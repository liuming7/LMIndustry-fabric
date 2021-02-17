package com.lmi.main.CozyLife.HouseholdElectricAppliances.Entity;

import com.lmi.main.CozyLife.HouseholdElectricAppliances.HouseholdElectricAppliancesGroup;
import com.lmi.main.Main;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.util.Util;

public class RadioEntity extends BlockEntity {

    public RadioEntity() {
        super(HouseholdElectricAppliancesGroup.RADIO_ENTITY);
        Main.LOGGER.info("entity!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }


}
