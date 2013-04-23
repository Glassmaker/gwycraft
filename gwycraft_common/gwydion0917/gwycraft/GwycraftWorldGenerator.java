package gwydion0917.gwycraft;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class GwycraftWorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

    	// world.setBlock(x,y,z,ID)
        for (int i = 0; i < 16; ++i) {
            world.setBlock(chunkX*16 + random.nextInt(16), 100 + random.nextInt(16), chunkZ*16 + random.nextInt(16), ConfigGwycraft.blockGemOreID, i, 12);

        }	
    }
}