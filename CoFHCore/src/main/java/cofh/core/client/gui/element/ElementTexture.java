package cofh.core.client.gui.element;

import cofh.core.client.gui.IGuiAccess;
import cofh.lib.util.helpers.RenderHelper;

/**
 * Basic element which can render an arbitrary texture.
 *
 * @author King Lemming
 */
public class ElementTexture extends ElementBase {

    protected int texU = 0;
    protected int texV = 0;

    public ElementTexture(IGuiAccess gui, int posX, int posY) {

        super(gui, posX, posY);
    }

    public ElementTexture setTextureOffsets(int u, int v) {

        texU = u;
        texV = v;
        return this;
    }

    @Override
    public void drawBackground(int mouseX, int mouseY) {

        RenderHelper.bindTexture(texture);
        drawTexturedModalRect(posX(), posY(), texU, texV, width, height);
    }

}