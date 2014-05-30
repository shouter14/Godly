package com.shouter.godly.items;

import com.shouter.godly.godly;
import com.shouter.godly.help.reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Iteminfusioncauldron extends Item
{

	public boolean onItemUse (ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
	{
		if(!world.isRemote)
		{
			if (side==3)
				world.setBlock(x, y, z+1, godly.godlyore);
			if (side==4)
				world.setBlock(x-1, y, z, godly.godlyore);
			if (side==5)
				world.setBlock(x+1, y, z, godly.godlyore);
			if (side==2)
				world.setBlock(x, y, z-1, godly.godlyore);
			if (side==1)
				world.setBlock(x, y+1, z, godly.godlyore);
			if (side==0)
				world.setBlock(x, y-1, z, godly.godlyore);
				
				return true;
			
		}
		return false;
	}
	
	public Iteminfusioncauldron()
		{
			super();
			setUnlocalizedName("Iteminfusioncauldron");
			setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));		
			setCreativeTab(CreativeTabs.tabBrewing);
	}

}