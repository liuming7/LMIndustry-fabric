package com.lmi.main.CozyLife.common;

import com.lmi.main.Main;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SmokerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class AbstractElectricAppliances extends HorizontalFacingBlock implements BlockEntityProvider{

    private double pixelBit;
    private int west;
    private int east;
    private int north;
    private int south;
    private int bottom;
    private int top;

    protected AbstractElectricAppliances(Settings settings,int west,int east,int north,int south,int bottom,int top,double pixelBit) {
        super(settings);

        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
        this.west = west;this.east = east;this.north = north;this.south = south;this.bottom = bottom;this.top = top;this.pixelBit = pixelBit;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        if(dir.getName().equals("north")){
            return VoxelShapes.cuboid(Main.calculateV(west,pixelBit),//west
                    Main.calculateV(bottom,pixelBit),//bottom
                    Main.calculateV(north,pixelBit),//north
                    Main.calculateV(east,pixelBit),//east
                    Main.calculateV(top,pixelBit),//top
                    Main.calculateV(south,pixelBit));//south
        }else if(dir.getName().equals("south")){
            return VoxelShapes.cuboid(Main.calculateV(16-east,pixelBit),//west
                    Main.calculateV(bottom,pixelBit),//bottom
                    Main.calculateV(16-south,pixelBit),//north
                    Main.calculateV(16-west,pixelBit),//east
                    Main.calculateV(top,pixelBit),//top
                    Main.calculateV(16-north,pixelBit));//south
        }else if(dir.getName().equals("east")) {
            return VoxelShapes.cuboid(Main.calculateV(16-south, pixelBit),//west
                    Main.calculateV(bottom, pixelBit),//bottom
                    Main.calculateV(16-west, pixelBit),//north
                    Main.calculateV(16-north, pixelBit),//east
                    Main.calculateV(top, pixelBit),//top
                    Main.calculateV(16-east, pixelBit));//south
        }else if(dir.getName().equals("west")){
            return VoxelShapes.cuboid(Main.calculateV(south, pixelBit),//west
                    Main.calculateV(bottom, pixelBit),//bottom
                    Main.calculateV(east, pixelBit),//north
                    Main.calculateV(north, pixelBit),//east
                    Main.calculateV(top, pixelBit),//top
                    Main.calculateV(west, pixelBit));//south
        }else{
            return null;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    public boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data) {
        super.onSyncedBlockEvent(state, world, pos, type, data);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.onSyncedBlockEvent(type, data);
    }

    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)blockEntity : null;
    }
}
