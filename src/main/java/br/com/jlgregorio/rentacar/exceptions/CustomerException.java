package br.com.jlgregorio.rentacar.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerException
{
    private Date timeStamp;
    private String message;
    private String details;
}
