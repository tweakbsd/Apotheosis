package shadows.apotheosis.ench.replacements;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;
import shadows.apotheosis.ApotheosisObjects;

public class DefenseEnchant extends ProtectionEnchantment {

	public DefenseEnchant(Rarity rarity, Type type, EquipmentSlotType... slots) {
		super(rarity, type, slots);
	}

	@Override
	public int calcModifierDamage(int level, DamageSource source) {
		if (source.canHarmInCreative()) {
			return 0;
		} else if (this.protectionType == ProtectionEnchantment.Type.ALL) {
			return level;
		} else if (this.protectionType == ProtectionEnchantment.Type.FIRE && source.isFireDamage()) {
			return level;
		} else if (this.protectionType == ProtectionEnchantment.Type.FALL && source == DamageSource.FALL) {
			return level * 3;
		} else if (this.protectionType == ProtectionEnchantment.Type.EXPLOSION && source.isExplosion()) {
			return level * 2;
		} else {
			return this.protectionType == ProtectionEnchantment.Type.PROJECTILE && source.isProjectile() ? level : 0;
		}
	}

	/**
	 * Determines if the enchantment passed can be applyied together with this enchantment.
	 */
	@Override
	public boolean canApplyTogether(Enchantment ench) {
		if (this == Enchantments.FEATHER_FALLING) return ench != this;
		if (this == Enchantments.PROTECTION) return ench != this;
		if (ench instanceof ProtectionEnchantment) {
			if (ench == this) return false;

			ProtectionEnchantment pEnch = (ProtectionEnchantment) ench;
			if (pEnch.protectionType == Type.FALL) return true;
			if (this.protectionType == pEnch.protectionType) return false;  // NOTE:
			// NOTE: Apotheosis original value
			//return pEnch.protectionType == Type.ALL || pEnch.protectionType == Type.FALL;

			return false;
		}
		if (ench == ApotheosisObjects.MAGIC_PROTECTION) return false;
		return ench != this;
	}

}