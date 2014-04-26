package gwydion0917.gwycraft.blocks;

import java.util.List;

import net.minecraft.block.BlockBookshelf;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDyedBookcase extends BlockBookshelf {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	private IIcon[] iconArray1;

	public BlockDyedBookcase(Material wood) {
		super();
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		int l = par2 & 15;
		return (par1 == 1 || par1 == 0) ? this.iconArray1[l]
				: this.iconArray[l];

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
	// TODO: Broke @Override
	public void registerIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[16];
		this.iconArray1 = new IIcon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray1[i] = par1IconRegister
					.registerIcon("gwycraft:plank_" + i);
			this.iconArray[i] = par1IconRegister
					.registerIcon("gwycraft:bookcase_" + i);
		}
	}
	
    /**
     * Determines the amount of enchanting power this block can provide to an enchanting table.
     * @param world The World
     * @param x X position
     * @param y Y position
     * @param z Z position
     * @return The amount of enchanting power this block produces.
     */

	@Override
    public float getEnchantPowerBonus(World world, int x, int y, int z)
    {
        return 1f;
    }

}
