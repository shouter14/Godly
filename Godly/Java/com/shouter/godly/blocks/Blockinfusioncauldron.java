package com.shouter.godly.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.shouter.godly.godly;
import com.shouter.godly.help.reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class Blockinfusioncauldron extends Block 
{
	 @SideOnly(Side.CLIENT)
	    private static IIcon innertexture; //field_150029_a
	    @SideOnly(Side.CLIENT)
	    private static IIcon toptexture; //field_150028_b;
	    @SideOnly(Side.CLIENT)
	    private static IIcon bottomtexture; //field_150030_M;
	    private static final String __OBFID = "CL_00000213";
	    int CauldronRender;
	
	public Blockinfusioncauldron()
	{
		super(Material.iron);
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.toptexture : (side == 0 ? this.bottomtexture : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister sidetexture)
    {
    	
    	this.innertexture = sidetexture.registerIcon(reference.MODID + ":" + "infusioncauldron" + "_inner"); //this.getTextureName() + "_" + "inner");
        this.toptexture = sidetexture.registerIcon(reference.MODID + ":" + "infusioncauldron" + "_top"); //(this.getTextureName() + "_top");
        this.bottomtexture = sidetexture.registerIcon(reference.MODID + ":" + "infusioncauldron" + "_bottom"); //(this.getTextureName() + "_" + "bottom");
        this.blockIcon = sidetexture.registerIcon(reference.MODID + ":" + "infusioncauldron" + "_side"); //(this.getTextureName() + "_side");
    }
    
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
        float f = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
        this.setBlockBoundsForItemRender();
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getCauldronIcon(String blockside)
    {
        return blockside.equals("inner") ? com.shouter.godly.blocks.Blockinfusioncauldron.innertexture : (blockside.equals("bottom") ? com.shouter.godly.blocks.Blockinfusioncauldron.bottomtexture : null);
    }
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    
    public int getRenderType()
    {
        return Blockinfusioncauldronrender.CauldronRender;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        int l = waterlevelcomparator(world.getBlockMetadata(x, y, z));
        float f = (float)y + (6.0F + (float)(3 * l)) / 16.0F;

        if (!world.isRemote && entity.isBurning() && l > 0 &&entity.boundingBox.minY <= (double)f)
        {
           entity.extinguish();
            this.waterlevel(world, x, y, z, l - 1);
        }
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                int i1 =world.getBlockMetadata(x, y, z);
                int j1 = waterlevelcomparator(i1);

                if (itemstack.getItem() == Items.water_bucket)
                {
                    if (j1 < 3)
                    {
                        if (!player.capabilities.isCreativeMode)
                        {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(Items.bucket));
                        }

                        this.waterlevel(world, x, y, z, 3);
                    }

                    return true;
                }
                else
                {
                    if (itemstack.getItem() == Items.glass_bottle)
                    {
                        if (j1 > 0)
                        {
                            if (!player.capabilities.isCreativeMode)
                            {
                                ItemStack itemstack1 = new ItemStack(Items.potionitem, 1, 0);

                                if (!player.inventory.addItemStackToInventory(itemstack1))
                                {
                                    world.spawnEntityInWorld(new EntityItem(world, (double)x + 0.5D, (double)y + 1.5D, (double)z + 0.5D, itemstack1));
                                }
                                else if (player instanceof EntityPlayerMP)
                                {
                                    ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
                                }

                                --itemstack.stackSize;

                                if (itemstack.stackSize <= 0)
                                {
                                    player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                                }
                            }

                            this.waterlevel(world, x, y, z, j1 - 1);
                        }
                    }
                    else if (j1 > 0 && itemstack.getItem() instanceof ItemArmor && ((ItemArmor)itemstack.getItem()).getArmorMaterial() == ItemArmor.ArmorMaterial.CLOTH)
                    {
                        ItemArmor itemarmor = (ItemArmor)itemstack.getItem();
                        itemarmor.removeColor(itemstack);
                        this.waterlevel(world, x, y, z, j1 - 1);
                        return true;
                    }

                    return false;
                }
            }
        }
    }

    public void waterlevel(World world, int x, int y, int z, int waterlevelnumber)
    {
        world.setBlockMetadataWithNotify(x, y, z, MathHelper.clamp_int(waterlevelnumber, 0, 3), 2);
        world.func_147453_f(x, y, z, this);
    }
    
    public void fillWithRain(World world, int x, int y, int z)
    {
        if (world.rand.nextInt(20) == 1)
        {
            int l = world.getBlockMetadata(x, y, z);

            if (l < 3)
            {
                world.setBlockMetadataWithNotify(x, y, z, l + 1, 2);
            }
        }
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return godly.infusioncauldronitem;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return godly.infusioncauldronitem;
    }
    
    public boolean hasComparatorInputOverride()
    {
        return true;
    }
    
    public int getComparatorInputOverride(World world, int x, int y, int z, int p_149736_5_)
    {
        int i1 = world.getBlockMetadata(x, y, z);
        return waterlevelcomparator(i1);
    }

    public static int waterlevelcomparator(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    public static float getRenderLiquidLevel(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, 3);
        return (float)(6 + 3 * j) / 16.0F;
    }
}
