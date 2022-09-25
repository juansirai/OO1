package ar.edu.unlp.info.oo1.ejercicio10_jobScheduler;

import java.util.List;

public interface Strategy {

	abstract JobDescription next(List<JobDescription> tasks);
}
