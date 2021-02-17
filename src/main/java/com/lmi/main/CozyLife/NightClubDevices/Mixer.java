package com.lmi.main.CozyLife.NightClubDevices;

import com.lmi.main.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class Mixer extends HorizontalFacingBlock {

    private double pixelBit;
    private int west;
    private int east;
    private int north;
    private int south;
    private int bottom;
    private int top;

    Item itemMixer = null;
    BooleanProperty showPanel = null;

    public Mixer(int west, int east, int north, int south, int bottom, int top, double pixelBit, ItemGroup itemGroup){
        super(FabricBlockSettings.of(Material.WOOD)
                .strength(1.0f)
                .resistance(4.0f)
                .breakByHand(true));
        itemMixer = new BlockItem(this,new Item.Settings().group(itemGroup)
                .maxCount(1));
        showPanel = BooleanProperty.of("show_panel");

        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));

        this.west = west;this.east = east;this.north = north;this.south = south;this.bottom = bottom;this.top = top;this.pixelBit = pixelBit;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(Main.calculateV(west,pixelBit),//west
                Main.calculateV(bottom,pixelBit),//bottom
                Main.calculateV(north,pixelBit),//north
                Main.calculateV(east,pixelBit),//east
                Main.calculateV(top,pixelBit),//top
                Main.calculateV(south,pixelBit));//south
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
}
