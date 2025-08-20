package com.example.API.MODELO.MIERCOLES.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table ( name =  "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "promedio", nullable = false,unique = false)
    private Double promedio;

    @Column (name = "fechaNacimiento", nullable = false, unique = false)
    private LocalDate fechaNacimiento;

    // Declaración de Relaciones
    // 3. Configurar relación con tabla Usuario
    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonManagedReference(value = "RelacionUsuarioEstudiante")
    private Usuario usuario;

    // Declaración de Relación 1:M
    // 1. Crear Array (Usando ArrayList), nombre en plural por ser varios elementos.
    // 2. Usar @JsonManagedReference para conectar a tabla Usuario
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference(value = "RelacionEstudianteAsistencia")
    private ArrayList<Asistencia> asistencias;

    public Estudiante() {
    }

    public Estudiante(Integer id, Double promedio, LocalDate fechaNacimiento) {
        this.id = id;
        this.promedio = promedio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
