package Ejercicio3;

public class Biblioteca {



    private int codigo;
    private String titulo;
    private int annoPublicacion;



    public Biblioteca(int codigo, String titulo, int annoPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.annoPublicacion = annoPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCodigo() {
        return codigo;
    }


    public int getAnnoPublicacion() {
        return annoPublicacion;
    }


    @Override
    public String toString() {

        return
                "codigo: " + codigo +
                        "\ntitulo: " + titulo +
                        "\naño de publicación: " + annoPublicacion;
    }
}
