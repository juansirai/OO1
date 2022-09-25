package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

import java.util.List;

public class FIFO implements Strategy{

	@Override
	public JobDescription next(List<JobDescription> tasks) {
		// TODO Auto-generated method stub
		return tasks.get(0);
	}

}
