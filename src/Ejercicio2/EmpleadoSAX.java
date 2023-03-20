package Ejercicio2;

public class EmpleadoSAX {
    private int id;
    private String apellido;
    private int dep;
    private double salario;

    public EmpleadoSAX(int id, String apellido, int dep, double salario) {
        this.id = id;
        this.apellido = apellido;
        this.dep = dep;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Ejercicio1.Empleado = Id : " + id + " | Apellido : " + apellido + " | Dep : " + dep + " | Salario : " + salario + ".";
    }
}
