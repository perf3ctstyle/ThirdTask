package com.epam.task.third.repository;

import com.epam.task.third.entities.Quadrangle;
import com.epam.task.third.specifications.QuadrangleSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuadrangleRepositoryImpl implements QuadrangleRepository {

    private final Map<Integer, Quadrangle> quadrangleRepository;

    public QuadrangleRepositoryImpl() {
        this.quadrangleRepository = new HashMap<>();
    }

    @Override
    public void addQuadrangle(Quadrangle quadrangle) {
        int quadrangleId = quadrangle.getId();
        quadrangleRepository.put(quadrangleId, quadrangle);
    }

    @Override
    public void removeQuadrangle(Integer id) {
        quadrangleRepository.remove(id);
    }

    @Override
    public void updateQuadrangle(Integer id, Quadrangle quadrangle) {
        quadrangleRepository.replace(id, quadrangle);
    }

    @Override
    public List<Quadrangle> query(QuadrangleSpecification specification) {
        List<Quadrangle> specifiedQuadrangles = new ArrayList<>();
        List<Quadrangle> quadrangles = new ArrayList<>(quadrangleRepository.values());
        for (Quadrangle quadrangle : quadrangles) {
            if (specification.isSpecified(quadrangle)) {
                specifiedQuadrangles.add(quadrangle);
            }
        }
        return specifiedQuadrangles;
    }
}
