package resourceHandling;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;

// TODO: Clean up ResourceTint correctness
public class ResourceTint {

	public Image getTintedResource(Image imageToTint, Color tint, float alpha) {
		int width = imageToTint.getWidth(null);
		int height = imageToTint.getHeight(null);
		GraphicsConfiguration ge = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image mask = ge.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		
		Graphics2D g2 = (Graphics2D) mask.getGraphics();
		g2.drawImage(imageToTint, 0, 0, null);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, alpha));
		g2.setColor(tint);
		g2.fillRect(0, 0, imageToTint.getWidth(null), imageToTint.getHeight(null));
		g2.dispose();
		
	    return mask;
	}
}
