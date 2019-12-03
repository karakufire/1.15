package cofh.thermal.foundation.init;

import cofh.lib.item.CoinItem;
import cofh.lib.item.CountedItem;
import cofh.lib.item.ItemCoFH;
import cofh.thermal.core.init.TCoreItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;

import static cofh.thermal.core.ThermalCore.ITEMS;

public class TFndItems {

    private TFndItems() {

    }

    public static void register() {

        ItemGroup group = TCoreItemGroups.THERMAL_ITEMS;

        registerMetalSet("copper", group);
        registerMetalSet("tin", group);
        registerMetalSet("silver", group);
        registerMetalSet("lead", group);
        registerMetalSet("aluminum", group);
        registerMetalSet("nickel", group);
        registerMetalSet("platinum", group);
        registerMetalSet("iridium", group);

        registerMetalSet("steel", group);
        registerMetalSet("bronze", group);
        registerMetalSet("electrum", group);
        registerMetalSet("invar", group);
        registerMetalSet("constantan", group);

        registerGemSet("ruby", group);
        registerGemSet("sapphire", group);
    }

    // region HELPERS
    private static RegistryObject<Item> register(String name, ItemGroup group) {

        return ITEMS.register(name, () -> new ItemCoFH(new Item.Properties().group(group)));
    }

    private static RegistryObject<Item> register(String name, ItemGroup group, Rarity rarity) {

        return ITEMS.register(name, () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
    }

    private static void registerMetalSet(String prefix, ItemGroup group) {

        registerMetalSet(prefix, group, Rarity.COMMON);
    }

    private static void registerGemSet(String prefix, ItemGroup group) {

        registerGemSet(prefix, group, Rarity.COMMON);
    }

    private static void registerMetalSet(String prefix, ItemGroup group, Rarity rarity) {

        ITEMS.register(prefix + "_ingot", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_nugget", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_dust", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_gear", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_plate", () -> new CountedItem(new Item.Properties().group(group).rarity(rarity)));

        ITEMS.register(prefix + "_coin", () -> new CoinItem(new Item.Properties().group(group).rarity(rarity)));
    }

    private static void registerGemSet(String prefix, ItemGroup group, Rarity rarity) {

        ITEMS.register(prefix + "_gem", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_nugget", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_dust", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_gear", () -> new ItemCoFH(new Item.Properties().group(group).rarity(rarity)));
        ITEMS.register(prefix + "_plate", () -> new CountedItem(new Item.Properties().group(group).rarity(rarity)));

        ITEMS.register(prefix + "_coin", () -> new CoinItem(new Item.Properties().group(group).rarity(rarity)));
    }
    // endregion
}
