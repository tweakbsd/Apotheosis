package shadows.apotheosis.ench.anvil;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import shadows.apotheosis.ApotheosisObjects;

public class AnvilTile extends TileEntity {

	public AnvilTile() {
		super(ApotheosisObjects.ANVIL);
	}

	int unbreaking = 0;
	int splitting = 0;

	@Override
	public CompoundNBT write(CompoundNBT tag) {
		tag.putInt("ub", unbreaking);
		tag.putInt("splitting", splitting);
		return super.write(tag);
	}

	@Override
	public void fromTag(BlockState state, CompoundNBT tag) {
		super.fromTag(state, tag);
		unbreaking = tag.getInt("ub");
		splitting = tag.getInt("splitting");
	}

	public void setUnbreaking(int level) {
		unbreaking = level;
	}

	public int getUnbreaking() {
		return unbreaking;
	}

	public void setSplitting(int level) {
		splitting = level;
	}

	public int getSplitting() {
		return splitting;
	}

	@Override
	public TileEntityType<?> getType() {
		return ApotheosisObjects.ANVIL;
	}

}