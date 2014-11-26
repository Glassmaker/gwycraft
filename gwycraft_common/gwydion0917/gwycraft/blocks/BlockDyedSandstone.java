package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDyedSandstone extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	private IIcon[] iconArray1;
	private IIcon[] iconArray2;

	public BlockDyedSandstone(Material mat ) {
		super(mat);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
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
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		for (int j = 0; j < 16; ++j) {
			par3List.add(new ItemStack(this, 1, j));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[16];
		this.iconArray1 = new IIcon[16];
		this.iconArray2 = new IIcon[16];

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
