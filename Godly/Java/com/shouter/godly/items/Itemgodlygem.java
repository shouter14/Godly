package com.shouter.godly.items;

import com.shouter.godly.help.reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Itemgodlygem extends Item 
{
	public Itemgodlygem()
	{
		super();
		setUnlocalizedName("godlygem");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
}
