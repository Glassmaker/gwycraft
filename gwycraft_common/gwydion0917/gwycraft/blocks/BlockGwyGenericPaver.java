package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.BlockCarpet;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGwyGenericPaver extends BlockCarpet {
	// textureName from constructor, ie: stonecobble
	private String tName;

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public BlockGwyGenericPaver(int id, String textureName) {
		super(id);
		tName = textureName;
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("gwycraft:"
					+ tName + "_" + i);
		}
	}

}