package com.lmi.main.CozyLife.HouseholdElectricAppliances;

import com.lmi.main.CozyLife.HouseholdElectricAppliances.Entity.RadioEntity;
import com.lmi.main.CozyLife.common.AbstractElectricAppliances;
import com.lmi.main.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class Radio extends AbstractElectricAppliances {

    public Radio(int west,int east,int north,int south,int bottom,int top,double pixelBit){
        super(FabricBlockSettings.of(Material.WOOD)
                .strength(1.0f)
                .resistance(4.0f)
                .breakByHand(true),west,east,north,south,bottom,top,pixelBit);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new RadioEntity();
    }
}
