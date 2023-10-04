package br.com.jlgregorio.rentacar.services;

import br.com.jlgregorio.rentacar.dto.VehicleDTO;
import br.com.jlgregorio.rentacar.exceptions.ResourceNotFoundException;
import br.com.jlgregorio.rentacar.mapper.CustomModelMapper;
import br.com.jlgregorio.rentacar.model.Vehicle;
import br.com.jlgregorio.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    /*(public VehicleDTO create(VehicleDTO dto) {
        Vehicle model = CustomModelMapper.parseObject(dto, Vehicle.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }
    */
    public VehicleDTO create(VehicleDTO dto){
        Vehicle model = CustomModelMapper.parseObject(dto, Vehicle.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }

    public VehicleDTO findById(int id) {
        Vehicle model = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(null));
        return CustomModelMapper.parseObject(model, VehicleDTO.class);
    }

    public List<VehicleDTO> findAll(){
        List<Vehicle> list = repository.findAll();
        return CustomModelMapper.parseObjectList(list, VehicleDTO.class);
    }

    public VehicleDTO update(VehicleDTO dto){
        Vehicle model = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        model = CustomModelMapper.parseObject(dto, Vehicle.class);
        return CustomModelMapper.parseObject(repository.save(model), VehicleDTO.class);
    }

    public void delete(VehicleDTO dto) {
        Vehicle model = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        repository.delete(model);
    }
}
