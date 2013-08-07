package com.ghthub.ittekikun.Homoxo.Entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelHomoxo extends ModelBase
{
    ModelRenderer armRight = new ModelRenderer(this, 0, 26);
    ModelRenderer armLeft;
    ModelRenderer legRight;
    ModelRenderer legLeft;
    ModelRenderer body;
    ModelRenderer arm1;
    ModelRenderer arm2;
    ModelRenderer leg1;
    ModelRenderer leg2;

    public ModelHomoxo()
    {
        this.armRight.addBox(-4.0F, -1.0F, -1.0F, 4, 2, 2);
        this.armRight.setRotationPoint(-5.0F, 16.0F, -4.0F);
        this.armLeft = new ModelRenderer(this, 0, 26);
        this.armLeft.addBox(0.0F, -1.0F, -1.0F, 4, 2, 2);
        this.armLeft.setRotationPoint(5.0F, 16.0F, -4.0F);
        this.armLeft.mirror = false;
        this.legRight = new ModelRenderer(this, 0, 26);
        this.legRight.addBox(-4.0F, -1.0F, -1.0F, 4, 2, 2);
        this.legRight.setRotationPoint(-5.0F, 16.0F, 4.0F);
        this.legLeft = new ModelRenderer(this, 0, 26);
        this.legLeft.addBox(0.0F, -1.0F, -1.0F, 4, 2, 2);
        this.legLeft.setRotationPoint(5.0F, 16.0F, 4.0F);	
        this.legLeft.mirror = false;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-5.0F, -5.0F, -8.0F, 10, 10, 16);
        this.body.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.arm1 = new ModelRenderer(this, 54, 0);
        this.arm1.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.arm1.setRotationPoint(-3.0F, 1.0F, -0.0F);
        this.armRight.addChild(this.arm1);
        this.arm2 = new ModelRenderer(this, 54, 0);
        this.arm2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.arm2.setRotationPoint(3.0F, 1.0F, -0.0F);
        this.arm2.mirror = false;
        this.armLeft.addChild(this.arm2);
        this.leg1 = new ModelRenderer(this, 54, 0);
        this.leg1.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.leg1.setRotationPoint(-3.0F, 1.0F, 0.0F);
        this.legRight.addChild(this.leg1);
        this.leg2 = new ModelRenderer(this, 54, 0);
        this.leg2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        this.leg2.setRotationPoint(3.0F, 1.0F, 0.0F);
        this.leg2.mirror = false;
        this.legLeft.addChild(this.leg2);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7);
        this.armRight.render(var7);
        this.armLeft.render(var7);
        this.legRight.render(var7);
        this.legLeft.render(var7);
        this.body.render(var7);
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, null);
        this.armRight.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.armLeft.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.legRight.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.legLeft.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.armRight.rotateAngleY = MathHelper.cos(var3 * 0.6662F + 0.047123894F) * (float)Math.PI * 0.05F * (float)(1 + Math.abs(1));
        this.armLeft.rotateAngleY = -(MathHelper.cos(var3 * 0.6662F + 0.047123894F) * (float)Math.PI * 0.05F * (float)(1 + Math.abs(1)));
        this.legRight.rotateAngleY = MathHelper.cos(var3 * 0.6662F + 0.047123894F) * (float)Math.PI * 0.05F * (float)(1 + Math.abs(1));
        this.legLeft.rotateAngleY = -(MathHelper.cos(var3 * 0.6662F + 0.047123894F) * (float)Math.PI * 0.05F * (float)(1 + Math.abs(1)));
        this.armRight.rotateAngleZ = MathHelper.sin(var1 * 0.6662F / 2.0F + (float)Math.PI) * 1.24F * var2 / 2.0F;
        this.armLeft.rotateAngleZ = -MathHelper.sin(var1 * 0.6662F / 2.0F) * 1.24F * var2 / 2.0F;
        this.legRight.rotateAngleZ = -MathHelper.sin(var1 * 0.6662F / 2.0F + (float)Math.PI) * 1.24F * var2 / 2.0F;
        this.legLeft.rotateAngleZ = MathHelper.sin(var1 * 0.6662F / 2.0F) * 1.24F * var2 / 2.0F;
    }
}
