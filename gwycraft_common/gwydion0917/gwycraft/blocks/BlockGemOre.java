package gwydion0917.gwycraft.blocks;

import gwydion0917.gwycraft.ConfigGwycraft;
import gwydion0917.gwycraft.GwycraftWorldGenerator;
import gwydion0917.gwycraft.Gwycraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class BlockGemOre extends Block {
	/** The type of tree this log came from. */
	public static final String[] gemBlockTextures = new String[] {
			"Gwycraft:ore_agate", "Gwycraft:ore_amethyst",
			"Gwycraft:ore_aquamarine", "Gwycraft:ore_citrine",
			"Gwycraft:ore_emerald", "Gwycraft:ore_garnet",
			"Gwycraft:ore_hematite", "Gwycraft:ore_lapis_lazuli",
			"Gwycraft:ore_onyx", "Gwycraft:ore_quartz", "Gwycraft:ore_ruby",
			"Gwycraft:ore_sapphire", "Gwycraft:ore_tanzanite",
			"Gwycraft:ore_tigerseye", "Gwycraft:ore_topaz",
			"Gwycraft:ore_moonstone" };

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public BlockGemOre(int id, Material mat) {
		super(id, mat);
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
	return ConfigGwycraft.itemFlawedGemsID;
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

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[gemBlockTextures.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister
					.registerIcon(gemBlockTextures[i]);
		}
	}
}