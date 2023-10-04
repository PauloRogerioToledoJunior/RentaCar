package br.com.jlgregorio.rentacar.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomModelMapper {
    private static ModelMapper mapper = new ModelMapper();
    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destinationClass) {
        return mapper.map(origin, destinationClass);
    }

    public static <Origin, Destination>List<Destination> parseObjectList(List<Origin> origins, Class<Destination> destinationClass) {
        List<Destination> destinationList = new ArrayList<>();
        for (Origin o : origins)
            destinationList.add(mapper.map(o, destinationClass));
        return destinationList;
    }
}
