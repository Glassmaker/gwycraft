package gwydion0917.gwycraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DyedSand extends BlockSand {

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public DyedSand(int id) {
		super(id, Material.sand);
		setUnlocalizedName("dyedSand");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(0.5F);
		setStepSound(Block.sand.stepSound);

	}

	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("Gwycraft:sand_" + i);
		}
	}

}
