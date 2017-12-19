package hitbox;

import java.awt.Point;

public class HitboxFactory {
	
	public Hitbox createHitbox(String s){
		String[] split = s.split("\\|");
		String[] params = split[0].split(",");
		Hitbox h = new Hitbox(new Point(Integer.parseInt(params[0]), Integer.parseInt(params[1])), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
		for (String property : split) {
			switch (property) {
			case "Solid":
				h.setSolid(true);
				break;
			case "Body":
				h.setBody(true);
				break;
			case "Trigger":
				h.setTrigger(true);
				break;
			default:
				// Do nothing
			}
		}
		return h;
	}
}
