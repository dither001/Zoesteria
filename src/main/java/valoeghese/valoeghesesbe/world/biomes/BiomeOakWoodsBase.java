package valoeghese.valoeghesesbe.world.biomes;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class BiomeOakWoodsBase extends Biome
{
	
	public BiomeOakWoodsBase(String name, float HeightVariation, float Temperature, int TreesPChunk, float pRandom)
	{
		
		this(name, HeightVariation, Temperature, TreesPChunk, pRandom, 0.3F);
		
	}
	
	public BiomeOakWoodsBase(String name, float HeightVariation, float Temperature, int TreesPChunk, float pRandom, float BaseHeight)
	{
		
		super( new BiomeProperties(name).setHeightVariation(HeightVariation).setTemperature(Temperature).setRainfall(0.68F).setBaseHeight(BaseHeight) );
		
		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.decorator.treesPerChunk = TreesPChunk;
		this.decorator.extraTreeChance = pRandom;
	}
	
	/**
	 * Alpha 1.2 +
	 */
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	{
		byte randomTreeCode = (byte)rand.nextInt(24);
		
		if (randomTreeCode > 0)
		{
			
			return TREE_FEATURE;
			
		} else {
			
			return (WorldGenAbstractTree)new WorldGenBigTree(false);
			
		}
	}
	
}
