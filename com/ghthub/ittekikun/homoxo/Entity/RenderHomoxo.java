package com.ghthub.ittekikun.Homoxo.Entity;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHomoxo extends RenderLiving
{
    private static final ResourceLocation field_110833_a = new ResourceLocation("textures/entity/Entity_Homoxo.png");

    public RenderHomoxo(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation func_110832_a(EntityHomoxo par1EntityCow)
    {
        return field_110833_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110832_a((EntityHomoxo)par1Entity);
    }
}
