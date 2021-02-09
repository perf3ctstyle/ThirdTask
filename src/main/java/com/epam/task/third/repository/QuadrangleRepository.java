package com.epam.task.third.repository;

import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.specifications.QuadrangleSpecification;

import java.util.List;

public interface QuadrangleRepository {

    void addQuadrangle(Quadrangle quadrangle);
    void removeQuadrangle(Integer id);
    void updateQuadrangle(Integer id, Quadrangle quadrangle);

    List<Quadrangle> query(QuadrangleSpecification specification);
}
