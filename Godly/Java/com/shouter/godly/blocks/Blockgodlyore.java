package com.shouter.godly.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.shouter.godly.godly;
import com.shouter.godly.help.reference;

public class Blockgodlyore extends Block
{
	public Blockgodlyore()
	{
		super(Material.rock);
		setBlockName("godlyore");
		setBlockTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setLightLevel(0.5F);
		setHarvestLevel("pickaxe", 3);
	}
	
	
	private Random rand = new Random(); 
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
	    {
	        if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
	        {
	            int j1 = 0;

	            if (this == godly.godlyore)
	            {
	            	j1 = MathHelper.getRandomIntegerInRange(rand, 40, 50);
	            }
	            
	            return j1;
	        }
	        return 0;
	    }
	
	@Override
	
	public Item getItemDropped(int metdadata, Random rand, int fortune)
	{
		return godly.godlygem;
	}
}