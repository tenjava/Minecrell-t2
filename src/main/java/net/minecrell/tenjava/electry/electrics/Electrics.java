package net.minecrell.tenjava.electry.electrics;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public enum Electrics {
    SOLAR_CELL ("Solar Cell", SolarCell.class) {
        @Override
        protected ItemStack createItem() {
            return setItemName(new ItemStack(Material.DAYLIGHT_DETECTOR));
        }

        @Override
        protected Recipe createRecipe(ItemStack item) {
            return new ShapedRecipe(item).shape(
                    "GGG", //   GLASS   |   GLASS   |   GLASS
                    "DRD", //  DIAMOND  | REDSTONE  |  DIAMOND
                    "WWW"  // WOOD SLAB | WOOD SLAB | WOOD SLAB
            )
                    .setIngredient('G', Material.GLASS)
                    .setIngredient('D', Material.DIAMOND).setIngredient('R', Material.REDSTONE)
                    .setIngredient('W', Material.WOOD_STEP);
        }
    },

    ELECTRIC_FURNACE ("Electric Furnace", ElectricFurnace.class) {
        @Override
        protected ItemStack createItem() {
            return setItemName(new ItemStack(Material.FURNACE));
        }

        @Override
        protected Recipe createRecipe(ItemStack item) {
            return new ShapedRecipe(item).shape(
                    "III", // IRON |   IRON   | IRON
                    "IRI", // IRON | REDSTONE | IRON
                    "III"  // IRON |   IRON   | IRON
            )
                    .setIngredient('I', Material.IRON_INGOT)
                    .setIngredient('R', Material.REDSTONE);
        }
    };

    private final String name;
    private final Class<? extends Electric> electric;

    private final ItemStack item;
    private final Recipe recipe;

    Electrics(String name, Class<? extends Electric> electric) {
        this.name = name;
        this.electric = electric;
        this.item = this.createItem();
        this.recipe = this.createRecipe(item);
    }

    protected abstract ItemStack createItem();

    protected ItemStack setItemName(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.getName());
        item.setItemMeta(meta);
        return item;
    }


    protected abstract Recipe createRecipe(ItemStack item);

    public String getName() {
        return name;
    }

    public Class<? extends Electric> getElectric() {
        return electric;
    }

    public ItemStack getItem() {
        return item;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
