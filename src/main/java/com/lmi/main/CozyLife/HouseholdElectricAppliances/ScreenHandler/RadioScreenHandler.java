package com.lmi.main.CozyLife.HouseholdElectricAppliances.ScreenHandler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class RadioScreenHandler extends ScreenHandler {

    protected RadioScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
