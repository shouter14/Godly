package com.shouter.godly.blocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class Blockinfusioncauldronrender extends RenderBlocks implements ISimpleBlockRenderingHandler {
	
    public static int CauldronRender = RenderingRegistry.getNextAvailableRenderId();
    
    public void renderInventoryBlock(Block block, int metadata, int modelId,
			RenderBlocks renderer) {
		
	}

    public boolean renderWorldBlock(IBlockAccess blockaccess, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) 
	{
		 renderer.renderStandardBlock(block, x, y, z);
	        Tessellator tessellator = Tessellator.instance;
	        tessellator.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));
	        int l =block.colorMultiplier(renderer.blockAccess, x, y, z);
	        float f = (float)(l >> 16 & 255) / 255.0F;
	        float f1 = (float)(l >> 8 & 255) / 255.0F;
	        float f2 = (float)(l & 255) / 255.0F;
	        float f4;

	        if (EntityRenderer.anaglyphEnable)
	        {
	            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
	            f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
	            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
	            f = f3;
	            f1 = f4;
	            f2 = f5;
	        }

	        tessellator.setColorOpaque_F(f, f1, f2);
	        IIcon iicon1 = block.getBlockTextureFromSide(2);
	        f4 = 0.125F;
	        renderer.renderFaceXPos(block, (double)((float)x - 1.0F + f4), (double)y, (double)z, iicon1);
	        renderer.renderFaceXNeg(block, (double)((float)x + 1.0F - f4), (double)y, (double)z, iicon1);
	        renderer.renderFaceZPos(block, (double)x, (double)y, (double)((float)z - 1.0F + f4), iicon1);
	        renderer.renderFaceZNeg(block, (double)x, (double)y, (double)((float)z + 1.0F - f4), iicon1);
	        IIcon iicon2 = Blockinfusioncauldron.getCauldronIcon("inner");
	        renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + 0.25F), (double)z, iicon2);
	        renderer.renderFaceYNeg(block, (double)x, (double)((float)y + 1.0F - 0.75F), (double)z, iicon2);
	        int i1 = renderer.blockAccess.getBlockMetadata(x, y, z);

	        if (i1 > 0)
	        {
	            IIcon iicon = BlockLiquid.getLiquidIcon("water_still");
	            renderer.renderFaceYPos(block, (double)x, (double)((float)y - 1.0F + BlockCauldron.getRenderLiquidLevel(i1)), (double)z, iicon);
	        }

	        return true;

		
	}

	public boolean shouldRender3DInInventory(int modelId) {
	
		return false;
	}

	public int getRenderId() {
		
		return CauldronRender;
	}

}
