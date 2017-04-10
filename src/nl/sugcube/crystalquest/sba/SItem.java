package nl.sugcube.crystalquest.sba;

import org.bukkit.Material;

import java.util.Arrays;

/**
 * @author SugarCaney
 */
public final class SItem {

    private static final Material[] MATERIALS = Material.values();

    /**
     * Get the material that corresponds to the given block ID.
     *
     * @param blockId
     *         The material ID of the material to get.
     * @return The material that has the given {@code blockId}, or {@link Material#AIR} when the
     * blockID doesn't exist.
     */
    public static Material toMaterial(int blockId) {
        return Arrays.stream(MATERIALS)
                .filter(material -> material.getId() == blockId)
                .findFirst()
                .orElse(Material.AIR);
    }

    /**
     * Get the material that has the given name.
     * <p>
     * When the name could not be found, {@link SItem#legacyToMaterial(String)} will be used to
     * preserve backwards compatibility.
     *
     * @param trivialName
     *         The name of the material. Is the enum-name in all lower case with underscores. Will
     *         also work without underscores. You could also emit underscores (so stationarylava
     *         will work).
     * @return The material that corresponds to the given name.
     */
    public static Material toMaterial(String trivialName) {
        String name = trivialName.replace("_", "");
        return Arrays.stream(MATERIALS)
                .filter(material -> material.name().replace("_", "")
                        .equalsIgnoreCase(name))
                .findFirst()
                .orElse(legacyToMaterial(trivialName));
    }

    /**
     * @deprecated Use {@link SItem#toMaterial(String)} instead.
     */
    @Deprecated
    public static Material legacyToMaterial(String trivialName) {
        switch (trivialName.toLowerCase()) {
            case "stone":
                return Material.STONE;
            case "grass":
                return Material.GRASS;
            case "dirt":
                return Material.DIRT;
            case "cobblestone":
                return Material.COBBLESTONE;
            case "woodenplanks":
                return Material.WOOD;
            case "sapling":
                return Material.SAPLING;
            case "bedrock":
                return Material.BEDROCK;
            case "water":
                return Material.WATER;
            case "stationarywater":
                return Material.STATIONARY_WATER;
            case "lava":
                return Material.LAVA;
            case "stationarylava":
                return Material.STATIONARY_LAVA;
            case "sand":
                return Material.SAND;
            case "gravel":
                return Material.GRAVEL;
            case "goldore":
                return Material.GOLD_ORE;
            case "ironore":
                return Material.IRON_ORE;
            case "coalore":
                return Material.COAL_ORE;
            case "log":
                return Material.LOG;
            case "leaves":
                return Material.LEAVES;
            case "sponge":
                return Material.SPONGE;
            case "glass":
                return Material.GLASS;
            case "lapisore":
                return Material.LAPIS_ORE;
            case "lapisblock":
                return Material.LAPIS_BLOCK;
            case "dispenser":
                return Material.DISPENSER;
            case "sandstone":
                return Material.SANDSTONE;
            case "noteblock":
                return Material.NOTE_BLOCK;
            case "bedblock":
                return Material.BED_BLOCK;
            case "poweredrail":
                return Material.POWERED_RAIL;
            case "detectorrail":
                return Material.DETECTOR_RAIL;
            case "stickypiston":
                return Material.PISTON_STICKY_BASE;
            case "cobweb":
                return Material.WEB;
            case "tallgrass":
                return Material.LONG_GRASS;
            case "deadbush":
                return Material.DEAD_BUSH;
            case "piston":
                return Material.PISTON_BASE;
            case "pistonextension":
                return Material.PISTON_EXTENSION;
            case "wool":
                return Material.WOOL;
            case "pistonmovingpiece":
                return Material.PISTON_MOVING_PIECE;
            case "dandelion":
                return Material.YELLOW_FLOWER;
            case "rose":
                return Material.RED_ROSE;
            case "browmushroom":
                return Material.BROWN_MUSHROOM;
            case "redmushroom":
                return Material.RED_MUSHROOM;
            case "goldblock":
                return Material.GOLD_BLOCK;
            case "ironblock":
                return Material.IRON_BLOCK;
            case "doubleslab":
                return Material.DOUBLE_STEP;
            case "slab":
                return Material.STEP;
            case "brickblock":
                return Material.BRICK;
            case "tnt":
                return Material.TNT;
            case "bookshelf":
                return Material.BOOKSHELF;
            case "mossycobblestone":
                return Material.MOSSY_COBBLESTONE;
            case "obsidian":
                return Material.OBSIDIAN;
            case "torch":
                return Material.TORCH;
            case "fire":
                return Material.FIRE;
            case "mobspawner":
                return Material.MOB_SPAWNER;
            case "woodenstairs":
                return Material.WOOD_STAIRS;
            case "chest":
                return Material.CHEST;
            case "redstonewire":
                return Material.REDSTONE_WIRE;
            case "diamondore":
                return Material.DIAMOND_ORE;
            case "diamondblock":
                return Material.DIAMOND_BLOCK;
            case "craftingtable":
                return Material.WORKBENCH;
            case "crops":
                return Material.CROPS;
            case "farmland":
                return Material.SOIL;
            case "furnace":
                return Material.FURNACE;
            case "burningfurnace":
                return Material.BURNING_FURNACE;
            case "signpost":
                return Material.SIGN_POST;
            case "woodendoorblock":
                return Material.WOODEN_DOOR;
            case "ladder":
                return Material.LADDER;
            case "rails":
                return Material.RAILS;
            case "cobblestonestairs":
                return Material.COBBLESTONE_STAIRS;
            case "wallsign":
                return Material.WALL_SIGN;
            case "lever":
                return Material.LEVER;
            case "stonepressureplate":
                return Material.STONE_PLATE;
            case "irondoorblock":
                return Material.IRON_DOOR_BLOCK;
            case "woodenpressureplate":
                return Material.WOOD_PLATE;
            case "redstoneore":
                return Material.REDSTONE_ORE;
            case "glowingredstoneore":
                return Material.GLOWING_REDSTONE_ORE;
            case "redstonetorchoff":
                return Material.REDSTONE_TORCH_OFF;
            case "redstonetorch":
                return Material.REDSTONE_TORCH_ON;
            case "stonebutton":
                return Material.STONE_BUTTON;
            case "snow":
                return Material.SNOW;
            case "ice":
                return Material.ICE;
            case "snowblock":
                return Material.SNOW_BLOCK;
            case "cactus":
                return Material.CACTUS;
            case "clayblock":
                return Material.CLAY;
            case "sugarcaneblock":
                return Material.SUGAR_CANE_BLOCK;
            case "jukebox":
                return Material.JUKEBOX;
            case "fence":
                return Material.FENCE;
            case "pumpkin":
                return Material.PUMPKIN;
            case "netherrack":
                return Material.NETHERRACK;
            case "soulsand":
                return Material.SOUL_SAND;
            case "glowstone":
                return Material.GLOWSTONE;
            case "netherportal":
                return Material.PORTAL;
            case "jackolantern":
                return Material.JACK_O_LANTERN;
            case "cakeblock":
                return Material.CAKE_BLOCK;
            case "repeateroff":
                return Material.DIODE_BLOCK_OFF;
            case "repeateron":
                return Material.DIODE_BLOCK_ON;
            case "trapdoor":
                return Material.TRAP_DOOR;
            case "monsteregg":
                return Material.MONSTER_EGGS;
            case "smoothstonebrick":
                return Material.SMOOTH_BRICK;
            case "mushroom":
                return Material.HUGE_MUSHROOM_1;
            case "mushroom2":
                return Material.HUGE_MUSHROOM_2;
            case "ironbars":
                return Material.IRON_BARDING;
            case "thinglass":
                return Material.THIN_GLASS;
            case "melonblock":
                return Material.MELON_BLOCK;
            case "melonstem":
                return Material.MELON_STEM;
            case "pumpkinstem":
                return Material.PUMPKIN_STEM;
            case "vine":
                return Material.VINE;
            case "gate":
                return Material.FENCE_GATE;
            case "brickstairs":
                return Material.BRICK_STAIRS;
            case "smoothbrickstairs":
                return Material.SMOOTH_STAIRS;
            case "mycelium":
                return Material.MYCEL;
            case "lilypad":
                return Material.WATER_LILY;
            case "netherbrickblock":
                return Material.NETHER_BRICK;
            case "netherfence":
                return Material.NETHER_FENCE;
            case "netherbrickstairs":
                return Material.NETHER_BRICK_STAIRS;
            case "netherwartblock":
                return Material.NETHER_WARTS;
            case "enchantmenttable":
                return Material.ENCHANTMENT_TABLE;
            case "brewingstandblock":
                return Material.BREWING_STAND;
            case "cauldronblock":
                return Material.CAULDRON;
            case "endportal":
                return Material.ENDER_PORTAL;
            case "endportalframe":
                return Material.ENDER_PORTAL_FRAME;
            case "endstone":
                return Material.ENDER_STONE;
            case "dragonegg":
                return Material.DRAGON_EGG;
            case "redstonelamp":
                return Material.REDSTONE_LAMP_OFF;
            case "redstonelampon":
                return Material.REDSTONE_LAMP_ON;
            case "woodendoubleslab":
                return Material.WOOD_DOUBLE_STEP;
            case "woodenslab":
                return Material.WOOD_STEP;
            case "cocoablock":
                return Material.COCOA;
            case "sandstonestairs":
                return Material.SANDSTONE_STAIRS;
            case "emeraldore":
                return Material.EMERALD_ORE;
            case "enderchest":
                return Material.ENDER_CHEST;
            case "tripwirehook":
                return Material.TRIPWIRE_HOOK;
            case "tripwire":
                return Material.TRIPWIRE;
            case "emeraldblock":
                return Material.EMERALD_BLOCK;
            case "sprucewoodstairs":
                return Material.SPRUCE_WOOD_STAIRS;
            case "birchwoodstairs":
                return Material.BIRCH_WOOD_STAIRS;
            case "junglewoodstairs":
                return Material.JUNGLE_WOOD_STAIRS;
            case "commandblock":
                return Material.COMMAND;
            case "beacon":
                return Material.BEACON;
            case "cobblestonewall":
                return Material.COBBLE_WALL;
            case "flowerpotblock":
                return Material.FLOWER_POT;
            case "carrotcrops":
                return Material.CARROT;
            case "potatocrops":
                return Material.POTATO;
            case "woodenbutton":
                return Material.WOOD_BUTTON;
            case "headblock":
                return Material.SKULL;
            case "anvil":
                return Material.ANVIL;
            case "trappedchest":
                return Material.TRAPPED_CHEST;
            case "goldenpressureplate":
                return Material.GOLD_PLATE;
            case "ironpressureplate":
                return Material.IRON_PLATE;
            case "comparatoroff":
                return Material.REDSTONE_COMPARATOR_OFF;
            case "comparatoron":
                return Material.REDSTONE_COMPARATOR_ON;
            case "daylightdetector":
                return Material.DAYLIGHT_DETECTOR;
            case "redstoneblock":
                return Material.REDSTONE_BLOCK;
            case "quartzore":
                return Material.QUARTZ_ORE;
            case "hopper":
                return Material.HOPPER;
            case "quartzblock":
                return Material.QUARTZ_BLOCK;
            case "quartzstairs":
                return Material.QUARTZ_STAIRS;
            case "activatorrail":
                return Material.ACTIVATOR_RAIL;
            case "dropper":
                return Material.DROPPER;
            case "stainedclay":
                return Material.STAINED_CLAY;
            case "hay":
                return Material.HAY_BLOCK;
            case "carpet":
                return Material.CARPET;
            case "hardenedclay":
                return Material.HARD_CLAY;
            case "coalblock":
                return Material.COAL_BLOCK;
            case "ironshovel":
                return Material.IRON_SPADE;
            case "ironpickaxe":
                return Material.IRON_PICKAXE;
            case "ironaxe":
                return Material.IRON_AXE;
            case "flintandsteel":
                return Material.FLINT_AND_STEEL;
            case "apple":
                return Material.APPLE;
            case "bow":
                return Material.BOW;
            case "arrow":
                return Material.ARROW;
            case "coal":
                return Material.COAL;
            case "diamond":
                return Material.DIAMOND;
            case "ironingot":
                return Material.IRON_INGOT;
            case "goldingot":
                return Material.GOLD_INGOT;
            case "ironsword":
                return Material.IRON_SWORD;
            case "woodsword":
                return Material.WOOD_SWORD;
            case "woodspade":
                return Material.WOOD_SPADE;
            case "woodpickaxe":
                return Material.WOOD_PICKAXE;
            case "woodaxe":
                return Material.WOOD_AXE;
            case "stonesword":
                return Material.STONE_SWORD;
            case "stoneshovel":
                return Material.STONE_SPADE;
            case "stonepickaxe":
                return Material.STONE_PICKAXE;
            case "stoneaxe":
                return Material.STONE_AXE;
            case "diamondsword":
                return Material.DIAMOND_SWORD;
            case "diamondshovel":
                return Material.DIAMOND_SPADE;
            case "diamondpickaxe":
                return Material.DIAMOND_PICKAXE;
            case "diamondaxe":
                return Material.DIAMOND_AXE;
            case "stick":
                return Material.STICK;
            case "bowl":
                return Material.BOWL;
            case "mushroomsoup":
                return Material.MUSHROOM_SOUP;
            case "goldensword":
                return Material.GOLD_SWORD;
            case "goldenshovel":
                return Material.GOLD_SPADE;
            case "goldenpickaxe":
                return Material.GOLD_PICKAXE;
            case "goldaxe":
                return Material.GOLD_AXE;
            case "string":
                return Material.STRING;
            case "feather":
                return Material.FEATHER;
            case "gunpowder":
                return Material.SULPHUR;
            case "woodenhoe":
                return Material.WOOD_HOE;
            case "stonehoe":
                return Material.STONE_HOE;
            case "ironhoe":
                return Material.IRON_HOE;
            case "diamondhoe":
                return Material.DIAMOND_HOE;
            case "goldenhoe":
                return Material.GOLD_HOE;
            case "seeds":
                return Material.SEEDS;
            case "wheat":
                return Material.WHEAT;
            case "bread":
                return Material.BREAD;
            case "leatherhelmet":
                return Material.LEATHER_HELMET;
            case "leatherchestplate":
                return Material.LEATHER_CHESTPLATE;
            case "leatherleggings":
                return Material.LEATHER_LEGGINGS;
            case "leatherboots":
                return Material.LEATHER_BOOTS;
            case "chainmailhelmet":
                return Material.CHAINMAIL_HELMET;
            case "chainmailchestplate":
                return Material.CHAINMAIL_CHESTPLATE;
            case "chainmailleggings":
                return Material.CHAINMAIL_LEGGINGS;
            case "chainmailboots":
                return Material.CHAINMAIL_BOOTS;
            case "ironhelmet":
                return Material.IRON_HELMET;
            case "ironchestplate":
                return Material.IRON_CHESTPLATE;
            case "ironleggings":
                return Material.IRON_LEGGINGS;
            case "ironboots":
                return Material.IRON_BOOTS;
            case "diamondhelmet":
                return Material.DIAMOND_HELMET;
            case "diamondchestplate":
                return Material.DIAMOND_CHESTPLATE;
            case "diamondleggings":
                return Material.DIAMOND_LEGGINGS;
            case "diamondboots":
                return Material.DIAMOND_BOOTS;
            case "goldenhelmet":
                return Material.GOLD_HELMET;
            case "goldenchestplate":
                return Material.GOLD_CHESTPLATE;
            case "goldenleggings":
                return Material.GOLD_LEGGINGS;
            case "goldenboots":
                return Material.GOLD_BOOTS;
            case "flint":
                return Material.FLINT;
            case "rawpork":
                return Material.PORK;
            case "cookedpork":
                return Material.GRILLED_PORK;
            case "painting":
                return Material.PAINTING;
            case "goldenapple":
                return Material.GOLDEN_APPLE;
            case "sign":
                return Material.SIGN;
            case "woodendoor":
                return Material.WOOD_DOOR;
            case "bucket":
                return Material.BUCKET;
            case "waterbucket":
                return Material.WATER_BUCKET;
            case "lavabucket":
                return Material.LAVA_BUCKET;
            case "minecart":
                return Material.MINECART;
            case "saddle":
                return Material.SADDLE;
            case "irondoor":
                return Material.IRON_DOOR;
            case "redstone":
                return Material.REDSTONE;
            case "snowball":
                return Material.SNOW_BALL;
            case "boat":
                return Material.BOAT;
            case "leather":
                return Material.LEATHER;
            case "milkbucket":
                return Material.MILK_BUCKET;
            case "brick":
                return Material.CLAY_BRICK;
            case "clay":
                return Material.CLAY_BALL;
            case "sugarcane":
                return Material.SUGAR_CANE;
            case "paper":
                return Material.PAPER;
            case "book":
                return Material.BOOK;
            case "slimeball":
                return Material.SLIME_BALL;
            case "storageminecart":
                return Material.STORAGE_MINECART;
            case "poweredminecart":
                return Material.POWERED_MINECART;
            case "egg":
                return Material.EGG;
            case "compass":
                return Material.COMPASS;
            case "fishingrod":
                return Material.FISHING_ROD;
            case "watch":
                return Material.WATCH;
            case "glowstonedust":
                return Material.GLOWSTONE_DUST;
            case "rawfish":
                return Material.RAW_FISH;
            case "cookedfish":
                return Material.COOKED_FISH;
            case "dye":
                return Material.INK_SACK;
            case "bone":
                return Material.BONE;
            case "sugar":
                return Material.SUGAR;
            case "cake":
                return Material.CAKE;
            case "bed":
                return Material.BED;
            case "repeater":
                return Material.DIODE;
            case "cookie":
                return Material.COOKIE;
            case "map":
                return Material.MAP;
            case "shears":
                return Material.SHEARS;
            case "melon":
                return Material.MELON;
            case "pumpkinseeds":
                return Material.PUMPKIN_SEEDS;
            case "melonseeds":
                return Material.MELON_SEEDS;
            case "rawbeef":
                return Material.RAW_BEEF;
            case "cookedbeef":
                return Material.COOKED_BEEF;
            case "rawchicken":
                return Material.RAW_CHICKEN;
            case "cookedchicken":
                return Material.COOKED_CHICKEN;
            case "rottenflesh":
                return Material.ROTTEN_FLESH;
            case "enderpearl":
                return Material.ENDER_PEARL;
            case "blazerod":
                return Material.BLAZE_ROD;
            case "ghasttear":
                return Material.GHAST_TEAR;
            case "goldennugget":
                return Material.GOLD_NUGGET;
            case "netherwart":
                return Material.NETHER_STALK;
            case "potion":
                return Material.POTION;
            case "glassbottle":
                return Material.GLASS_BOTTLE;
            case "spidereye":
                return Material.SPIDER_EYE;
            case "fermentedspidereye":
                return Material.FERMENTED_SPIDER_EYE;
            case "blazepowder":
                return Material.BLAZE_POWDER;
            case "magmacream":
                return Material.MAGMA_CREAM;
            case "brewingstand":
                return Material.BREWING_STAND_ITEM;
            case "cauldron":
                return Material.CAULDRON_ITEM;
            case "eyeofender":
                return Material.EYE_OF_ENDER;
            case "speckledmelon":
                return Material.SPECKLED_MELON;
            case "spawnegg":
                return Material.MONSTER_EGG;
            case "bottleoenchanting":
                return Material.EXP_BOTTLE;
            case "fireball":
                return Material.FIREBALL;
            case "bookandquill":
                return Material.BOOK_AND_QUILL;
            case "writtenbook":
                return Material.WRITTEN_BOOK;
            case "emerald":
                return Material.EMERALD;
            case "itemframe":
                return Material.ITEM_FRAME;
            case "flowerpot":
                return Material.FLOWER_POT_ITEM;
            case "carrot":
                return Material.CARROT_ITEM;
            case "potato":
                return Material.POTATO_ITEM;
            case "bakedpotato":
                return Material.BAKED_POTATO;
            case "poisonouspotato":
                return Material.POISONOUS_POTATO;
            case "emptymap":
                return Material.EMPTY_MAP;
            case "goldencarrot":
                return Material.GOLDEN_CARROT;
            case "head":
                return Material.SKULL_ITEM;
            case "carrotstick":
                return Material.CARROT_STICK;
            case "netherstar":
                return Material.NETHER_STAR;
            case "pumpkinpie":
                return Material.PUMPKIN_PIE;
            case "firework":
                return Material.FIREWORK;
            case "fireworkstar":
                return Material.FIREWORK_CHARGE;
            case "enchantedbook":
                return Material.ENCHANTED_BOOK;
            case "comparator":
                return Material.REDSTONE_COMPARATOR;
            case "netherbrick":
                return Material.NETHER_BRICK_ITEM;
            case "netherquartz":
                return Material.QUARTZ;
            case "tntcart":
                return Material.EXPLOSIVE_MINECART;
            case "hopperminecart":
                return Material.HOPPER_MINECART;
            case "ironhorsearmour":
                return Material.IRON_BARDING;
            case "goldenhorsearmour":
                return Material.GOLD_BARDING;
            case "diamondhorsearmour":
                return Material.DIAMOND_BARDING;
            case "lead":
                return Material.LEASH;
            case "nametag":
                return Material.NAME_TAG;
            case "record13":
                return Material.GOLD_RECORD;
            case "recordcat":
                return Material.GREEN_RECORD;
            case "recordblocks":
                return Material.RECORD_3;
            case "recordchirp":
                return Material.RECORD_4;
            case "recordfar":
                return Material.RECORD_5;
            case "recordmall":
                return Material.RECORD_6;
            case "recordmellohi":
                return Material.RECORD_7;
            case "recordstal":
                return Material.RECORD_8;
            case "recordstrad":
                return Material.RECORD_9;
            case "recordward":
                return Material.RECORD_10;
            case "record11":
                return Material.RECORD_11;
            case "recordwait":
                return Material.RECORD_12;
            case "stainedglass":
                return Material.STAINED_GLASS;
            case "stainedglasspane":
                return Material.STAINED_GLASS_PANE;
            case "leaves2":
                return Material.LEAVES_2;
            case "log2":
                return Material.LOG_2;
            case "packedice":
                return Material.PACKED_ICE;
            case "doubleplant":
                return Material.DOUBLE_PLANT;
            case "commandminecart":
                return Material.COMMAND_MINECART;
            default:
                return Material.AIR;
        }
    }

    /**
     * @deprecated Use {@link Material#getId()} instead. Even though it's deprecated as well...
     */
    @Deprecated
    public static int toId(Material material) {
        return material.getId();
    }

    private SItem() {
        throw new AssertionError("Noop");
    }
}