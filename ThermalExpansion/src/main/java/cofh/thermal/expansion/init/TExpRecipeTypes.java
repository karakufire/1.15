package cofh.thermal.expansion.init;

import cofh.core.util.recipes.SerializableRecipeType;
import cofh.thermal.expansion.util.recipes.dynamo.*;
import cofh.thermal.expansion.util.recipes.machine.*;
import net.minecraft.util.ResourceLocation;

import static cofh.core.util.constants.Constants.ID_THERMAL;

public class TExpRecipeTypes {

    private TExpRecipeTypes() {

    }

    public static void register() {

        // TODO: Convert when a ForgeRegistry is added.
        // Recipes are self-registered as they do not currently have a proper Forge Registry.
        RECIPE_FURNACE.register();
        RECIPE_SAWMILL.register();
        RECIPE_PULVERIZER.register();
        RECIPE_INSOLATOR.register();
        RECIPE_CENTRIFUGE.register();
        RECIPE_PRESS.register();
        RECIPE_CRUCIBLE.register();
        RECIPE_CHILLER.register();
        RECIPE_REFINERY.register();
        RECIPE_BREWER.register();
        RECIPE_BOTTLER.register();

        CATALYST_PULVERIZER.register();
        CATALYST_INSOLATOR.register();

        FUEL_STIRLING.register();
        FUEL_COMPRESSION.register();
        FUEL_MAGMATIC.register();
        FUEL_NUMISMATIC.register();
        FUEL_LAPIDARY.register();
    }

    // region RECIPES
    public static final ResourceLocation ID_RECIPE_FURNACE = new ResourceLocation(ID_THERMAL, "furnace");
    public static final ResourceLocation ID_RECIPE_SAWMILL = new ResourceLocation(ID_THERMAL, "sawmill");
    public static final ResourceLocation ID_RECIPE_PULVERIZER = new ResourceLocation(ID_THERMAL, "pulverizer");
    public static final ResourceLocation ID_RECIPE_SMELTER = new ResourceLocation(ID_THERMAL, "smelter");
    public static final ResourceLocation ID_RECIPE_INSOLATOR = new ResourceLocation(ID_THERMAL, "insolator");
    public static final ResourceLocation ID_RECIPE_CENTRIFUGE = new ResourceLocation(ID_THERMAL, "centrifuge");
    public static final ResourceLocation ID_RECIPE_PRESS = new ResourceLocation(ID_THERMAL, "press");
    public static final ResourceLocation ID_RECIPE_CRUCIBLE = new ResourceLocation(ID_THERMAL, "crucible");
    public static final ResourceLocation ID_RECIPE_CHILLER = new ResourceLocation(ID_THERMAL, "chiller");
    public static final ResourceLocation ID_RECIPE_REFINERY = new ResourceLocation(ID_THERMAL, "refinery");
    public static final ResourceLocation ID_RECIPE_BREWER = new ResourceLocation(ID_THERMAL, "brewer");
    public static final ResourceLocation ID_RECIPE_BOTTLER = new ResourceLocation(ID_THERMAL, "bottler");

    public static final ResourceLocation ID_CATALYST_PULVERIZER = new ResourceLocation(ID_THERMAL, "pulverizer_catalyst");
    public static final ResourceLocation ID_CATALYST_SMELTER = new ResourceLocation(ID_THERMAL, "smelter_catalyst");
    public static final ResourceLocation ID_CATALYST_INSOLATOR = new ResourceLocation(ID_THERMAL, "insolator_catalyst");

    public static final SerializableRecipeType<FurnaceRecipe> RECIPE_FURNACE = new SerializableRecipeType<>(ID_RECIPE_FURNACE);
    public static final SerializableRecipeType<SawmillRecipe> RECIPE_SAWMILL = new SerializableRecipeType<>(ID_RECIPE_SAWMILL);
    public static final SerializableRecipeType<PulverizerRecipe> RECIPE_PULVERIZER = new SerializableRecipeType<>(ID_RECIPE_PULVERIZER);
    public static final SerializableRecipeType<SmelterRecipe> RECIPE_SMELTER = new SerializableRecipeType<>(ID_RECIPE_SMELTER);
    public static final SerializableRecipeType<InsolatorRecipe> RECIPE_INSOLATOR = new SerializableRecipeType<>(ID_RECIPE_INSOLATOR);
    public static final SerializableRecipeType<CentrifugeRecipe> RECIPE_CENTRIFUGE = new SerializableRecipeType<>(ID_RECIPE_CENTRIFUGE);
    public static final SerializableRecipeType<PressRecipe> RECIPE_PRESS = new SerializableRecipeType<>(ID_RECIPE_PRESS);
    public static final SerializableRecipeType<CrucibleRecipe> RECIPE_CRUCIBLE = new SerializableRecipeType<>(ID_RECIPE_CRUCIBLE);
    public static final SerializableRecipeType<ChillerRecipe> RECIPE_CHILLER = new SerializableRecipeType<>(ID_RECIPE_CHILLER);
    public static final SerializableRecipeType<RefineryRecipe> RECIPE_REFINERY = new SerializableRecipeType<>(ID_RECIPE_REFINERY);
    public static final SerializableRecipeType<BrewerRecipe> RECIPE_BREWER = new SerializableRecipeType<>(ID_RECIPE_BREWER);
    public static final SerializableRecipeType<BottlerRecipe> RECIPE_BOTTLER = new SerializableRecipeType<>(ID_RECIPE_BOTTLER);

    public static final SerializableRecipeType<PulverizerCatalyst> CATALYST_PULVERIZER = new SerializableRecipeType<>(ID_CATALYST_PULVERIZER);
    public static final SerializableRecipeType<PulverizerCatalyst> CATALYST_SMELTER = new SerializableRecipeType<>(ID_CATALYST_SMELTER);
    public static final SerializableRecipeType<InsolatorCatalyst> CATALYST_INSOLATOR = new SerializableRecipeType<>(ID_CATALYST_INSOLATOR);
    // endregion

    // region FUELS
    public static final ResourceLocation ID_FUEL_STIRLING = new ResourceLocation(ID_THERMAL, "stirling_fuel");
    public static final ResourceLocation ID_FUEL_COMPRESSION = new ResourceLocation(ID_THERMAL, "compression_fuel");
    public static final ResourceLocation ID_FUEL_MAGMATIC = new ResourceLocation(ID_THERMAL, "magmatic_fuel");
    public static final ResourceLocation ID_FUEL_NUMISMATIC = new ResourceLocation(ID_THERMAL, "numismatic_fuel");
    public static final ResourceLocation ID_FUEL_LAPIDARY = new ResourceLocation(ID_THERMAL, "lapidary_fuel");

    public static final SerializableRecipeType<StirlingFuel> FUEL_STIRLING = new SerializableRecipeType<>(ID_FUEL_STIRLING);
    public static final SerializableRecipeType<CompressionFuel> FUEL_COMPRESSION = new SerializableRecipeType<>(ID_FUEL_COMPRESSION);
    public static final SerializableRecipeType<MagmaticFuel> FUEL_MAGMATIC = new SerializableRecipeType<>(ID_FUEL_MAGMATIC);
    public static final SerializableRecipeType<NumismaticFuel> FUEL_NUMISMATIC = new SerializableRecipeType<>(ID_FUEL_NUMISMATIC);
    public static final SerializableRecipeType<LapidaryFuel> FUEL_LAPIDARY = new SerializableRecipeType<>(ID_FUEL_LAPIDARY);
    // endregion
}
