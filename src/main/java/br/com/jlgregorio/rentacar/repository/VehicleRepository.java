package br.com.jlgregorio.rentacar.repository;

import br.com.jlgregorio.rentacar.model.Customer;
import br.com.jlgregorio.rentacar.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
