package com.lmi.main.CozyLife.NightClubDevices;

import com.lmi.main.CozyLife.NightClubDevices.entity.VinylTurntableEntity;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NightClubDevicesGroup {

    private static final double PIXEL_BIT = 16D;

    private static final ItemGroup NIGHT_CLUB_DEVICES = FabricItemGroupBuilder.build(new Identifier("lmindustry", "night_club_devices"), () -> new ItemStack(NightClubDevicesGroup.ITEM_VINYL_TURNTABLE));

    private static final VinylTurntable BLOCK_VINYL_TURNTABLE = new VinylTurntable(1,15,1,15,0,6,PIXEL_BIT,NIGHT_CLUB_DEVICES);
    private static final Item ITEM_VINYL_TURNTABLE = BLOCK_VINYL_TURNTABLE.itemVinylTurntable;
    public static BlockEntityType<VinylTurntableEntity> vinylTurntableEntity = null;

    private static final Mixer BLOCK_MIXER = new Mixer(1,15,1,15,0,4,PIXEL_BIT,NIGHT_CLUB_DEVICES);
    private static final Item ITEM_MIXER = BLOCK_MIXER.itemMixer;

    public static void onInitialize(String MODID){
        Registry.register(Registry.BLOCK, new Identifier(MODID, "vinyl_turntable"), BLOCK_VINYL_TURNTABLE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "vinyl_turntable"), ITEM_VINYL_TURNTABLE);
        vinylTurntableEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE,"lmindustry:vinyl_turntable",BlockEntityType.Builder.create(VinylTurntableEntity::new,BLOCK_VINYL_TURNTABLE).build(null));

        Registry.register(Registry.BLOCK, new Identifier(MODID, "mixer"), BLOCK_MIXER);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mixer"), ITEM_MIXER);
    }
}
