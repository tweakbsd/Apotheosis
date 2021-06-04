package shadows.apotheosis.ench.replacements;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class BaneEnchant extends DamageEnchantment {

	protected final CreatureAttribute attrib;

	public BaneEnchant(Enchantment.Rarity rarity, CreatureAttribute attrib, EquipmentSlotType... slots) {
		super(rarity, 0, slots);
		this.attrib = attrib;
	}

	@Override
	public int getMinEnchantability(int level) {
		if (this.attrib == CreatureAttribute.UNDEFINED) return 1 + (level - 1) * 11;
		return 5 + (level - 1) * 8;
	}

	@Override
	public int getMaxEnchantability(int level) {
		return this.getMinEnchantability(level) + 20;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public float calcDamageByCreature(int level, CreatureAttribute attrib) {
		// NOTE: tweakbsd restored vanilla calc
		if (this.damageType == 0) {
			return 1.0F + (float)Math.max(0, level - 1) * 0.5F;
		} else if (this.damageType == 1 && attrib == CreatureAttribute.UNDEAD) {
			return (float)level * 2.5F;
		} else {
			return this.damageType == 2 && attrib == CreatureAttribute.ARTHROPOD ? (float)level * 2.5F : 0.0F;
		}


		/*
		if (this.attrib == CreatureAttribute.UNDEFINED) return 1 + level * 0.5F;
		if (this.attrib == attrib) return level * 1.5F;
			return 0;
		 */

	}

	@Override
	public boolean canApplyTogether(Enchantment ench) {

		// NOTE: tweakbsd added only 1 BaneEnchant allowed!
		//return !(ench instanceof BaneEnchant);

		// NOTE: Apoth original code
		if (this.attrib == CreatureAttribute.UNDEFINED) return ench != this;
		return ench == Enchantments.SHARPNESS ? ench != this : !(ench instanceof BaneEnchant);
	}

	/**
	* Called whenever a mob is damaged with an item that has this enchantment on it.
	*/
	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		// NOTE: removed slowness effect when dealing damage! Btw, it's mentionend nowhere in the mod description.
		/*
		if (target instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) target;
			if (this.attrib != CreatureAttribute.UNDEFINED && livingentity.getCreatureAttribute() == this.attrib) {
				int i = 20 + user.getRNG().nextInt(10 * level);
				livingentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, i, 3));
			}
		}
		*/



	}
}