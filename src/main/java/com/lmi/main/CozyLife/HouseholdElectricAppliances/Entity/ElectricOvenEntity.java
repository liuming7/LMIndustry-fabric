package com.lmi.main.CozyLife.HouseholdElectricAppliances.Entity;

import com.lmi.main.CozyLife.HouseholdElectricAppliances.HouseholdElectricAppliancesGroup;
import com.lmi.main.CozyLife.HouseholdElectricAppliances.ScreenHandler.ElectricOvenScreenHandler;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.SmokerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ElectricOvenEntity extends AbstractFurnaceBlockEntity {

    public ElectricOvenEntity() {
        super(HouseholdElectricAppliancesGroup.ELECTRIC_OVEN_ENTITY, RecipeType.SMOKING);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.electric_oven");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ElectricOvenScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
