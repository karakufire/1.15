package cofh.test.init;

import cofh.lib.block.crops.CropsBlockCoFH;
import cofh.lib.block.crops.CropsBlockPerennial;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;

import static cofh.test.CoFHTest.BLOCKS;
import static cofh.test.init.ItemsTCultivation.*;
import static net.minecraft.block.Block.Properties.create;

public class BlocksTCultivation {

    private BlocksTCultivation() {

    }

    public static void register() {

        plantBarley = BLOCKS.register("plant_barley", () -> new CropsBlockCoFH(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropBarley).setSeed(seedBarley));
        plantOnion = BLOCKS.register("plant_onion", () -> new CropsBlockCoFH(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropOnion).setSeed(seedOnion));
        plantRice = BLOCKS.register("plant_rice", () -> new CropsBlockCoFH(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropRice).setSeed(seedRice));
        plantSadiroot = BLOCKS.register("plant_sadiroot", () -> new CropsBlockCoFH(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropSadiroot).setSeed(seedSadiroot));
        plantSpinach = BLOCKS.register("plant_spinach", () -> new CropsBlockCoFH(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropSpinach).setSeed(seedSpinach));

        plantBellPepper = BLOCKS.register("plant_bell_pepper", () -> new CropsBlockPerennial(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropBellPepper).setSeed(seedBellPepper));
        plantGreenBean = BLOCKS.register("plant_green_bean", () -> new CropsBlockPerennial(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropGreenBean).setSeed(seedGreenBean));
        plantPeanut = BLOCKS.register("plant_peanut", () -> new CropsBlockPerennial(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropPeanut).setSeed(seedPeanut));
        plantStrawberry = BLOCKS.register("plant_strawberry", () -> new CropsBlockPerennial(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropStrawberry).setSeed(seedStrawberry));
        plantTomato = BLOCKS.register("plant_tomato", () -> new CropsBlockPerennial(create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.0F, 0.0F).sound(SoundType.CROP)).setCrop(cropTomato).setSeed(seedTomato));
    }

    public static RegistryObject<Block> plantBarley;
    public static RegistryObject<Block> plantOnion;
    public static RegistryObject<Block> plantRice;
    public static RegistryObject<Block> plantSadiroot;
    public static RegistryObject<Block> plantSpinach;

    public static RegistryObject<Block> plantBellPepper;
    public static RegistryObject<Block> plantGreenBean;
    public static RegistryObject<Block> plantPeanut;
    public static RegistryObject<Block> plantStrawberry;
    public static RegistryObject<Block> plantTomato;

}
