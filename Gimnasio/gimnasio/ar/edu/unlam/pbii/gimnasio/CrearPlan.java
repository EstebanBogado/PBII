package ar.edu.unlam.pbii.gimnasio;

public class CrearPlan {

	public static Plan crearPlan(Double precioBase, Intensidad intensidad, Integer sesionesSemanales,
			Integer duracion) {
		if (intensidad.equals(Intensidad.ALTA) && sesionesSemanales >= 5) 
			return new PlanIntensivo(precioBase, intensidad, sesionesSemanales, duracion);
		if (!intensidad.equals(Intensidad.ALTA) && duracion > 8) 
			return new PlanPersonalizdo(precioBase, intensidad, sesionesSemanales, duracion);
		return new PlanGenerico(precioBase, intensidad, sesionesSemanales, duracion);
	}
}
