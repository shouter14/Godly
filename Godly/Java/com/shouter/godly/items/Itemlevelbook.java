package com.shouter.godly.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.shouter.godly.help.reference;

public class Itemlevelbook extends Item
{
	public Itemlevelbook()
	{
		super();
		setUnlocalizedName("levelbook");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        par3EntityPlayer.displayGUIWorkbench(1, 1, 1);
	        System.out.println("right click");
	        return par1ItemStack;
	    }
}

