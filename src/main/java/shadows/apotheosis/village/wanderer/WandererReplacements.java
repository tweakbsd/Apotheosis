package shadows.apotheosis.village.wanderer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import shadows.placebo.config.Configuration;
import shadows.placebo.util.json.ItemAdapter;
import shadows.placebo.util.json.NBTAdapter;

/**
 * The wandering merchant sucks.  Trades are totally underwhelming and are borderline garbage 99% of the time.
 * @author Shadows
 *
 */
public class WandererReplacements {

	@SubscribeEvent
	public static void replaceWandererArrays(WandererTradesEvent e) {
		if (!VillageModule.enableNewTrades) return;
		List<ITrade> randTrades = e.getGenericTrades();
		randTrades.add(new BasicTrade(2, new ItemStack(Items.ENDER_EYE), 3, 5));
		randTrades.add(new BasicTrade(1, new ItemStack(Items.BLAZE_POWDER), 5, 5));
		randTrades.add(new BasicTrade(1, new ItemStack(Items.IRON_INGOT, 3), 15, 5));
		randTrades.add(new BasicTrade(2, new ItemStack(Items.GOLD_INGOT), 8, 5));
		randTrades.add(new BasicTrade(3, new ItemStack(Items.DIAMOND), 5, 5));
		randTrades.add(new BasicTrade(5, new ItemStack(Items.WITHER_SKELETON_SKULL), 5, 5));
		randTrades.add(new BasicTrade(4, new ItemStack(Items.SKELETON_SKULL), 5, 5));
		randTrades.add(new BasicTrade(2, new ItemStack(Items.ZOMBIE_HEAD), 5, 5));
		randTrades.add(new BasicTrade(4, new ItemStack(Items.PRISMARINE_SHARD, 5), 5, 5));
		randTrades.add(new BasicTrade(2, new ItemStack(Items.SADDLE), 2, 5));
		randTrades.add(new BasicTrade(6, new ItemStack(Items.DIAMOND_HORSE_ARMOR), 5, 7));
		randTrades.add(new BasicTrade(4, new ItemStack(Items.GOLDEN_HORSE_ARMOR), 4, 6));
		randTrades.add(new BasicTrade(2, new ItemStack(Items.IRON_HORSE_ARMOR), 3, 5));

		List<ITrade> goodTrades = e.getRareTrades();
		ItemStack stack = new ItemStack(Items.DIAMOND_SWORD);
		stack.addEnchantment(Enchantments.SHARPNESS, 6);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.LOOTING, 4);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		//stack.addEnchantment(ApotheosisObjects.CAPTURING, 3);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_sword"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_SWORD), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_PICKAXE);
		stack.addEnchantment(Enchantments.EFFICIENCY, 5);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.FORTUNE, 4);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		//stack.addEnchantment(ApotheosisObjects.DEPTH_MINER, 4);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_pick"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_PICKAXE), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_AXE);
		stack.addEnchantment(Enchantments.EFFICIENCY, 6);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_axe"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_AXE), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_AXE);
		stack.addEnchantment(Enchantments.SHARPNESS, 6);
		stack.addEnchantment(Enchantments.MENDING, 1);
		//stack.addEnchantment(ApotheosisObjects.HELL_INFUSION, 5);
		stack.addEnchantment(Enchantments.SILK_TOUCH, 1);
		stack.addEnchantment(Enchantments.LOOTING, 3);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_axe2"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_AXE), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_SWORD);
		stack.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 5);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.LOOTING, 5);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		stack.addEnchantment(Enchantments.FIRE_ASPECT, 2);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_spider_sword"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_SWORD), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_HELMET);
		stack.addEnchantment(Enchantments.PROTECTION, 5);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		stack.addEnchantment(Enchantments.RESPIRATION, 3);
		stack.addEnchantment(Enchantments.AQUA_AFFINITY, 3);
		//stack.addEnchantment(ApotheosisObjects.REBOUNDING, 3);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_helm"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_HELMET), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_CHESTPLATE);
		stack.addEnchantment(Enchantments.PROTECTION, 5);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		//stack.addEnchantment(ApotheosisObjects.BERSERK, 2);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_chest"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_LEGGINGS);
		stack.addEnchantment(Enchantments.PROTECTION, 5);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.UNBREAKING, 5);
		//stack.addEnchantment(ApotheosisObjects.BERSERK, 2);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_legs"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_LEGGINGS), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		stack = new ItemStack(Items.DIAMOND_BOOTS);
		stack.addEnchantment(Enchantments.PROTECTION, 5);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		stack.addEnchantment(ApotheosisObjects.STABLE_FOOTING, 1);
		stack.addEnchantment(Enchantments.FEATHER_FALLING, 5);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.merch_boots"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND_BOOTS), new ItemStack(Items.EMERALD, 64), stack, 1, 20, 1));

		goodTrades.add(new BasicTrade(64, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 1, 15));
		goodTrades.add(new BasicTrade(64, new ItemStack(Blocks.BEACON), 1, 20));
		goodTrades.add(new BasicTrade(64, new ItemStack(Items.TOTEM_OF_UNDYING), 1, 10));

		stack = new ItemStack(Items.DIAMOND_SWORD);
		stack.addEnchantment(Enchantments.SHARPNESS, 6);
		stack.addEnchantment(Enchantments.MENDING, 1);
		stack.addEnchantment(Enchantments.LOOTING, 3);
		stack.addEnchantment(Enchantments.UNBREAKING, 3);
		//stack.addEnchantment(ApotheosisObjects.SCAVENGER, 3);
		stack.setDisplayName(new TranslationTextComponent("name.apotheosis.vigilance"));
		goodTrades.add(new BasicTrade(new ItemStack(Items.DIAMOND, 64), new ItemStack(Items.PHANTOM_MEMBRANE, 32), stack, 1, 20, 0));

	public static boolean clearNormTrades = false;
	public static boolean clearRareTrades = false;
	public static boolean affixTrades = true;

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(BasicTrade.class, BasicTradeAdapter.INSTANCE).registerTypeAdapter(ItemStack.class, ItemAdapter.INSTANCE).registerTypeAdapter(CompoundNBT.class, NBTAdapter.INSTANCE).create();

	@SubscribeEvent
	public static void replaceWandererArrays(WandererTradesEvent e) {
		if (clearNormTrades) e.getGenericTrades().clear();
		if (clearRareTrades) e.getRareTrades().clear();
		e.getGenericTrades().addAll(WandererTradeManager.INSTANCE.getNormalTrades());
		e.getRareTrades().addAll(WandererTradeManager.INSTANCE.getRareTrades());
	}


	public static void load(Configuration cfg) {
		clearNormTrades = cfg.getBoolean("Clear Generic Trades", "wanderer", false, "If the generic trade list will be cleared before datapack loaded trades are added.");
		clearRareTrades = cfg.getBoolean("Clear Rare Trades", "wanderer", false, "If the rare trade list will be cleared before datapack loaded trades are added.");
	}
}