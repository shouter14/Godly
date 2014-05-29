package com.shouter.godly.tools;

import com.shouter.godly.help.reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Itemgodlysword extends ItemSword 
{
	public Itemgodlysword(ToolMaterial material)
	{
		super(material);
		setUnlocalizedName("godlysword");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3)
	{
		par3.addPotionEffect((new PotionEffect(Potion.damageBoost.getId(), 500, 1)));
		par1.damageItem(50, par3);
		
		return par1;
	}

	
}
