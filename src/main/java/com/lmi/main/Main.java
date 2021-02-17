package com.lmi.main;

import com.lmi.main.CozyLife.HouseholdElectricAppliances.HouseholdElectricAppliancesGroup;
import com.lmi.main.CozyLife.NightClubDevices.NightClubDevicesGroup;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {

    public static final String MODID = "lmindustry";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @Override
    public void onInitialize() {
        LOGGER.info("Mod(LMIndustry) is loaded!");
        HouseholdElectricAppliancesGroup.onInitialize(MODID);
        NightClubDevicesGroup.onInitialize(MODID);
    }

    public static double calculateV(int position,double pixel){
        return position/pixel;
    }
}
