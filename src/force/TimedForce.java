package force;

import entities.AbstractEntity;

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
		// TODO Auto-generated method stub
		super.update(e);
		
		long endTime = System.nanoTime() / 1000000 - startTime;
		
		if(endTime > time){
			this.expired = true;
		}
	}
}
