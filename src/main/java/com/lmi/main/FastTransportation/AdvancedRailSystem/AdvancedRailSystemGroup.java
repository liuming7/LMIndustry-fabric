package com.lmi.main.FastTransportation.AdvancedRailSystem;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class AdvancedRailSystemGroup {

    private static final double PIXEL_BIT = 16D;

    private static final ItemGroup ADVANCED_RAIL_SYSTEM_GROUP = FabricItemGroupBuilder.build(new Identifier("lmindustry", "advanced_rail_system_group"), () -> new ItemStack(null));

    public static void onInitialize(String MODID){

    }
}
