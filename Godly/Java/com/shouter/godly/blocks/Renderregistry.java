package com.shouter.godly.blocks;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class Renderregistry {
    
	@SideOnly(Side.CLIENT)
	public void registerRender () 
    {
    RenderingRegistry.registerBlockHandler(new Blockinfusioncauldronrender());
    }
}
