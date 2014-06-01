package com.shouter.godly.items;

import com.shouter.godly.godly;
import com.shouter.godly.blocks.Blockinfusioncauldron;
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
	
	public Iteminfusioncauldron()
	{
		super();
		setUnlocalizedName("infusioncauldronitem");
		setTextureName(reference.MODID + ":" + getUnlocalizedName().substring(5));		
		setCreativeTab(CreativeTabs.tabBrewing);
}
	public static Block infusioncauldron;
	
	public boolean onItemUse (ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float x2, float y2, float z2)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block == Blocks.snow_layer && (world.getBlockMetadata(x, y, z) & 7) < 1)
        {
            side = 1;
        }
        else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(world, x, y, z))
        {
            if (side == 0)
            {
                --y;
            }

            if (side == 1)
            {
                ++y;
            }

            if (side == 2)
            {
                --z;
            }

            if (side == 3)
            {
                ++z;
            }

            if (side == 4)
            {
                --x;
            }

            if (side == 5)
            {
                ++x;
            }
        }
		
		 if (itemstack.stackSize == 0)
	        {
	            return false;
	        }
	        else if (!player.canPlayerEdit(x, y, z, side, itemstack))
	        {
	            return false;
	        }
	        else if (y == 255 && this.infusioncauldron.getMaterial().isSolid())
	        {
	            return false;
	        }
	        else if(!world.isRemote)
	        {
	        	world.setBlock(x, y, z, godly.infusioncauldron);
	        }
		 return true;
	}
}
		 
/*
		 	 if (world.canPlaceEntityOnSide(this.infusioncauldron, x, y, z, false, side, (Entity)null, itemstack))
		 		{	
		 		int i1 = this.infusioncauldron.onBlockPlaced(world, x, y, z, side, x2, y2, z2, 0);

                if (world.setBlock(x, y, z, this.infusioncauldron, i1, 3))
                {
                    if (world.getBlock(x, y, z) == this.infusioncauldron)
                    {
                        this.infusioncauldron.onBlockPlacedBy(world, x, y, z, player, itemstack);
                        this.infusioncauldron.onPostBlockPlaced(world, x, y, z, i1);
                    }

                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.infusioncauldron.stepSound.func_150496_b(), (this.infusioncauldron.stepSound.getVolume() + 1.0F) / 2.0F, this.infusioncauldron.stepSound.getPitch() * 0.8F);
                    --itemstack.stackSize;/*
                }
		 		
		 	}
		 	return true;
	}
	
}
*/