package com.lmi.main.CozyLife.NightClubDevices.entity;

import com.lmi.main.CozyLife.NightClubDevices.NightClubDevicesGroup;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class VinylTurntableEntity extends BlockEntity implements BlockEntityClientSerializable {

    private boolean isPlaying = false;

    public VinylTurntableEntity(){
        super(NightClubDevicesGroup.vinylTurntableEntity);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putBoolean("isPlaying", isPlaying);
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        isPlaying = tag.getBoolean("isPlaying");
    }

    @Override
    public void fromClientTag(CompoundTag compoundTag) {

    }

    @Override
    public CompoundTag toClientTag(CompoundTag compoundTag) {
        return null;
    }
}
