package com.shouter.godly.help;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class registerhelper 
{
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, reference.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, reference.MODID + "_" + item.getUnlocalizedName().substring(5));
	}

}
