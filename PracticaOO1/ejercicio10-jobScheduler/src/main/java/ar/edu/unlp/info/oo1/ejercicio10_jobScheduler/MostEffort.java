package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

import java.util.List;

public class MostEffort implements Strategy{

	@Override
	public JobDescription next(List<JobDescription> tasks) {
		// TODO Auto-generated method stub
		return tasks.stream()
     			.max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
     			.orElse(null);
	}

}
