package walton.springboot.controller;

import lombok.Data;

@Data
public class CommonResponse  {


    private boolean status;

    private String message;

    private String messageBn;

    private Object data;




}
