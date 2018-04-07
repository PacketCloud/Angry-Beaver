package force;

import entities.AbstractEntity;

/**
 * Class TimedForce is a Force which will translate entities 
 * for a limited duration of time. Once the timer has passed,
 * the translation will not occur.
 */
public class TimedForce extends Force{
	long startTime;
	int time; // Number of milliseconds
	
	public TimedForce(int dx, int dy, int time) {
		super(dx, dy);
		startTime = System.nanoTime() / 1000000;
		this.time = time;
	}

	@Override
	public void update(AbstractEntity e) {
		super.update(e);
		
		long endTime = System.nanoTime() / 1000000 - startTime;
		
		if(endTime > time){
			this.expired = true;
		}
	}
}
