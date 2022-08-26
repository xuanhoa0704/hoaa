package ntthanh.project.service.impl;

import ntthanh.project.entity.Position;
import ntthanh.project.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntthanh.project.repository.PositionRepository;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> finAll() {
        return this.positionRepository.findAll();
    }
}
