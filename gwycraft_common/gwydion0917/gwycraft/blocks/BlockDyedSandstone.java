package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDyedSandstone extends Block {

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	private Icon[] iconArray1;
	private Icon[] iconArray2;

	public BlockDyedSandstone(int id, Material mat ) {
		super(id, mat);
	}

	@Override
	public Icon getIcon(int side, int meta) {
		int l = meta & 15;
		if(side == 0) {
			return iconArray2[l]; // bottom
			} else if(side == 1) {
			return iconArray1[l]; // top
			} else {
			return iconArray[l]; // side
			}
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int j = 0; j < 16; ++j) {
			par3List.add(new ItemStack(par1, 1, j));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[16];
		this.iconArray1 = new Icon[16];
		this.iconArray2 = new Icon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray2[i] = par1IconRegister
					.registerIcon("gwycraft:sandstonebottom_" + i);
			this.iconArray1[i] = par1IconRegister
					.registerIcon("gwycraft:sandstonetop_" + i);
			this.iconArray[i] = par1IconRegister
					.registerIcon("gwycraft:sandstoneside_" + i);
		}
	}

}
