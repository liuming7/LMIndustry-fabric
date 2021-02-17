package com.lmi.main.CozyLife.NightClubDevices;

import com.lmi.main.CozyLife.NightClubDevices.entity.VinylTurntableEntity;
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
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class VinylTurntable extends HorizontalFacingBlock implements BlockEntityProvider{

    private double pixelBit;
    private int west;
    private int east;
    private int north;
    private int south;
    private int bottom;
    private int top;

    Item itemVinylTurntable = null;

    public static final BooleanProperty showPanel = BooleanProperty.of("show_panel");

    public VinylTurntable(int west, int east, int north, int south, int bottom, int top, double pixelBit, ItemGroup itemGroup){
        super(FabricBlockSettings.of(Material.WOOD)
                .strength(1.0f)
                .resistance(4.0f)
                .breakByHand(true));
        itemVinylTurntable = new BlockItem(this,new Item.Settings().group(itemGroup)
                .maxCount(1));

        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(showPanel,false));

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
        builder.add(Properties.HORIZONTAL_FACING)
                .add(showPanel);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.setBlockState(pos,state.with(showPanel,true));

        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new VinylTurntableEntity();
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
}
