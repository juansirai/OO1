package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

import java.util.List;

public class LIFO implements Strategy{

	@Override
	public JobDescription next(List<JobDescription> tasks) {
		return tasks.get(tasks.size()-1);
	}
	
}
